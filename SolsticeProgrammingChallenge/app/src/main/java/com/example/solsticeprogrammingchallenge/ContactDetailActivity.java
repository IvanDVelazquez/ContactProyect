package com.example.solsticeprogrammingchallenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.solsticeprogrammingchallenge.ContactsActivity.EXTRA_CONTACT;

public class ContactDetailActivity extends ButterBind {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.largeImageView)
    ImageView contactImageView;
    @BindView(R.id.nametv)
    TextView nametv;
    @BindView(R.id.companytv)
    TextView companytv;
    @BindView(R.id.infoListView)
    ListView infoListView;
    @BindView(R.id.starfav)
    ImageView starfav;

    //variable declaration
    public static final String EXTRA_CONTACT_CHANGED="EXTRA_CONTACT_CHANGED";
    public int id;
    public boolean isFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //declaration of variables and init them
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Contact contact = (Contact) intent.getSerializableExtra(EXTRA_CONTACT);
        this.id=contact.getId();
        fillElements(contact);
        isFav=contact.isFavourite();
        ArrayList<Info> userinfo = fillInfoArraylist(contact);
        infoListView.setAdapter(new InfoAdapter(getApplicationContext(), userinfo));
        initializeToolbar(contact);

    }
    //on click of the toolbar's star
    @OnClick(R.id.starfav)
    public void changeStar(){
        starfav.setImageResource(isFav ? R.mipmap.favouritestar : R.mipmap.favouritestarfalse);
        isFav=!isFav;
    }
    //init the toolbar
    public void initializeToolbar(Contact contact){
        if(contact.isFavourite()){
            starfav.setImageResource(R.mipmap.favouritestar);
        }else{
            starfav.setImageResource(R.mipmap.favouritestarfalse);
        }

        setSupportActionBar(toolbar);
        setTitle(getString(R.string.contacts));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    //save the contact id to pass it to ContactsActivity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_CONTACT_CHANGED,id);
        setResult(RESULT_OK,returnIntent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    //create a collection of Info class, this collection is made to fill the listview of the contact info
    private ArrayList<Info> fillInfoArraylist(Contact contact) {
        ArrayList<Info> filledArray = new ArrayList<>();
        if(contact.getPhone()!=null){
            if(contact.getPhone().getHome()!=null || TextUtils.isEmpty(contact.getPhone().getHome())){
                Info homeInfo = new Info(getString(R.string.phone), contact.getPhone().getHome(),getString(R.string.home));
                filledArray.add(homeInfo);
            }
            if(contact.getPhone().getMobile()!=null || TextUtils.isEmpty(contact.getPhone().getHome())){
                Info mobileInfo = new Info(getString(R.string.phone), contact.getPhone().getMobile(),getString(R.string.mobile));
                filledArray.add(mobileInfo);
            }
            if(contact.getPhone().getMobile()!=null || TextUtils.isEmpty(contact.getPhone().getHome())){
                Info workInfo = new Info(getString(R.string.phone), contact.getPhone().getWork(),getString(R.string.work));
                filledArray.add(workInfo);
            }
        }
        if(contact.getAdress()!=null){
            Info adressInfo = new Info(getString(R.string.adress),contact.getAdress().toString(),getString(R.string.empty));
            filledArray.add(adressInfo);
        }
        if(contact.getBirthdateFormatted()!=null){
            Info dateInfo = new Info(getString(R.string.birthdate),contact.getBirthdateFormatted(),getString(R.string.empty));
            filledArray.add(dateInfo);
        }
        if(contact.getEmailAdress()!=null || TextUtils.isEmpty(contact.getPhone().getHome())){
            Info emailInfo = new Info(getString(R.string.email),contact.getEmailAdress(),getString(R.string.empty));
            filledArray.add(emailInfo);
        }
        return filledArray;

    }

    //set the value of the layout objects
    public void fillElements(Contact contact){
        loadImageFromURL(this,contact.getLargeImgaeURL(),contactImageView);
        nametv.setText(contact.getName());
        companytv.setText(contact.getCompanyName());
    }
    //download the large image
    public void loadImageFromURL(Context context, String url, ImageView imageView){
        Picasso.with(context).load(url).placeholder(R.mipmap.usersmall).into(imageView,new com.squareup.picasso.Callback(){

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }


    @Override
    //inherited method
    protected int getContentView() {
        return R.layout.activity_contact_detail;
    }

}
