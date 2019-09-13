package com.example.solsticeprogrammingchallenge;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class adress implements Serializable {

    @SerializedName("street")
    private String street;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("zipCode")
    private String zipCode;

    public adress(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {
        if(street!=null){
            this.street = street;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city!=null){
            this.city = city;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(state!=null) {
            this.state = state;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country!=null) {
            this.country = country;
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if(zipCode!=null){
            this.zipCode = zipCode;
        }
    }

    @Override
    public String toString() {
        return street+"\n"+city+", "+state+", "+zipCode+", "+country;
    }
}
