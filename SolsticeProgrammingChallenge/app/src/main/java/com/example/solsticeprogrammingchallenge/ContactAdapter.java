package com.example.solsticeprogrammingchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ContactAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Contact> contacts;
    private Contactlistener contactlistener;


    public ContactAdapter(Context context, ArrayList<Contact> contacts, Contactlistener contactlistener) {
        this.contactlistener = contactlistener;
        this.context = context;
        this.contacts = contacts;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        Contact contact = contacts.get(position);

        final View contactview = inflater.inflate(R.layout.contactview, null);

        LinearLayout parent = contactview.findViewById(R.id.itemList);
        ImageView contactimage = contactview.findViewById(R.id.contactiv);

        ImageView favouritestar = contactview.findViewById(R.id.favouritestariv);
        TextView nametv = contactview.findViewById(R.id.nametv);
        TextView companyNametv = contactview.findViewById(R.id.companyNametv);
        loadImageFromURL(context, contact.getSmallImageURL(), contactimage);
        if (contact.isFavourite()) {
            favouritestar.setImageResource(R.mipmap.favouritestar);
        }
        nametv.setText(contact.getName());
        companyNametv.setText(contact.getCompanyName());


        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactlistener.onclick(contact);
            }
        });
        return contactview;

    }
    //download and resize the image from the url provided
    public void loadImageFromURL(Context context, String url, ImageView imageView) {
        Picasso.with(context).load(url).placeholder(R.mipmap.usersmall).resize(120, 120).into(imageView, new com.squareup.picasso.Callback() {

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }
    //interface OnClick
    public interface Contactlistener {
        void onclick(Contact c);
    }

}
