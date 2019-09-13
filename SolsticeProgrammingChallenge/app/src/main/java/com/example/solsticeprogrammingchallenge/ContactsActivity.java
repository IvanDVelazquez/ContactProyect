package com.example.solsticeprogrammingchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;

import static com.example.solsticeprogrammingchallenge.ContactDetailActivity.EXTRA_CONTACT_CHANGED;

//contact listener helps Me to start the detail activity
public class ContactsActivity extends ButterBind implements ContactAdapter.Contactlistener {

    //I used ButterKnife to declare the layout components
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.favouriteContactsTV)
    TextView favouriteContactsTV;
    @BindView(R.id.contactsTV)
    TextView otherContactsTV;
    @BindView(R.id.favouriteContactsListView)
    ListView favouriteListView;
    @BindView(R.id.contactsListView)
    ListView otherContactsListView;

    //variable declaration
    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";
    public static final int FAV_REQUEST_CODE = 20;
    public ContactAdapter favouriteContactAdapter;
    public ContactAdapter otherContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //declaration of variables and init them
        ArrayList<Contact> favouriteContacts = new ArrayList<>();
        ArrayList<Contact> otherContacts = new ArrayList<>();
        favouriteContactAdapter = new ContactAdapter(getApplicationContext(), favouriteContacts, this);
        otherContactAdapter = new ContactAdapter(getApplicationContext(), otherContacts, this);
        bringJson(favouriteContactAdapter, otherContactAdapter, favouriteContacts, otherContacts);

        //set the toolbar
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.contacts));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


    }
    //inherited method from superclass
    public int getContentView() {
        return R.layout.activity_contacts;
    }

    //bring the json from the web page
    private void bringJson(ContactAdapter favouriteContactAdapter, ContactAdapter otherContactAdapter, ArrayList<Contact> favouriteContacts, ArrayList<Contact> otherContacts) {
        RequestQueue queue;
        String url = "https://s3.amazonaws.com/technical-challenge/v3/contacts.json";

        queue = Volley.newRequestQueue(this);


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        Contact contact = null;
                        //bring each object of the json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonContact = response.getJSONObject(i);
                                String jsonString = jsonContact.toString();
                                Gson gson = new Gson();
                                //using Google Json to transform the json string to a contact Object
                                contact = gson.fromJson(jsonString, Contact.class);
                                //evaluate favourite variable
                                if (contact.isFavourite()) {
                                    favouriteContacts.add(contact);
                                } else {

                                    otherContacts.add(contact);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        //sort both colections of Contacts Alphabetically
                        Collections.sort(favouriteContacts, new Comparator<Contact>() {
                            @Override
                            public int compare(Contact contact, Contact nextContact) {
                                String name1 = contact.getName();
                                String name2 = nextContact.getName();
                                return name1.compareTo(name2);

                            }
                        });
                        Collections.sort(otherContacts, new Comparator<Contact>() {
                            @Override
                            public int compare(Contact contact, Contact nextContact) {
                                String name1 = contact.getName();
                                String name2 = nextContact.getName();
                                return name1.compareTo(name2);

                            }
                        });
                        //adding the adapter to the listView
                        favouriteListView.setAdapter(favouriteContactAdapter);
                        otherContactsListView.setAdapter(otherContactAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    @Override
    //Start Detail Activity for result, this is a interface implementation
    public void onclick(Contact c) {
        Intent detailview = new Intent(this, ContactDetailActivity.class);
        detailview.putExtra(EXTRA_CONTACT, c);

        startActivityForResult(detailview, FAV_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //if the user touch the back arrow
        if (requestCode == FAV_REQUEST_CODE && requestCode == RESULT_OK) {
            int id = data.getIntExtra(EXTRA_CONTACT_CHANGED, -1);
            updateContact(favouriteContactAdapter, otherContactAdapter, id);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //finds the user with the id provided in both collections
    public void updateContact(ContactAdapter favouriteContactAdapter, ContactAdapter otherContactAdapter, int id) {
        int i = 0;
        boolean isTheContact = false;

        while (i < favouriteContactAdapter.getContacts().size() || isTheContact) {
            if (id == favouriteContactAdapter.getContacts().get(i).getId()) {
                isTheContact = true;
                favouriteContactAdapter.getContacts().get(i).setFavourite(!favouriteContactAdapter.getContacts().get(i).isFavourite());
                favouriteContactAdapter.notifyDataSetChanged();
            } else {
                i++;
            }
        }
        if (isTheContact) {
            while (i < otherContactAdapter.getContacts().size() || isTheContact) {
                if (id == favouriteContactAdapter.getContacts().get(i).getId()) {
                    isTheContact = true;
                    otherContactAdapter.getContacts().get(i).setFavourite(!otherContactAdapter.getContacts().get(i).isFavourite());
                    otherContactAdapter.notifyDataSetChanged();
                } else {
                    i++;
                }
            }
        }
    }


}
