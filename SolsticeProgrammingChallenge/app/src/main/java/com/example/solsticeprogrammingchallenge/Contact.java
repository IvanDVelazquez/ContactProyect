package com.example.solsticeprogrammingchallenge;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("companyName")
    private String companyName;
    @SerializedName("smallImageURL")
    private String smallImageURL;
    @SerializedName("largeImageURL")
    private String largeImgaeURL;
    @SerializedName("emailAddress")
    private String emailAdress;
    @SerializedName("birthdate")
    private String birthDate;
    @SerializedName("phone")
    private phone phone;
    @SerializedName("address")
    private adress adress;
    @SerializedName("isFavorite")
    private boolean isFavourite;

    public Contact(int id, String name, String companyName, String smallImageURL, String largeImgaeURL, String emailAdress, String birthDate, com.example.solsticeprogrammingchallenge.phone phone, com.example.solsticeprogrammingchallenge.adress adress, boolean isFavourite) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.smallImageURL = smallImageURL;
        this.largeImgaeURL = largeImgaeURL;
        this.emailAdress = emailAdress;
        this.birthDate = birthDate;
        this.phone = phone;
        this.adress = adress;
        this.isFavourite = isFavourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getLargeImgaeURL() {
        return largeImgaeURL;
    }

    public void setLargeImgaeURL(String largeImgaeURL) {
        this.largeImgaeURL = largeImgaeURL;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public com.example.solsticeprogrammingchallenge.phone getPhone() {
        return phone;
    }

    public void setPhone(com.example.solsticeprogrammingchallenge.phone phone) {
        this.phone = phone;
    }

    public com.example.solsticeprogrammingchallenge.adress getAdress() {
        return adress;
    }

    public void setAdress(com.example.solsticeprogrammingchallenge.adress adress) {
        this.adress = adress;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getBirthdateFormatted() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat correctFormat = new SimpleDateFormat("dd MM, YYYY");
        Date convertedDate = new Date();
        String dateformatted = null;
        try {
            convertedDate = dateFormat.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateformatted;
        }
        dateformatted = correctFormat.format(convertedDate);
        return dateformatted;
    }


}
