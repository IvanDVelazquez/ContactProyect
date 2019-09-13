package com.example.solsticeprogrammingchallenge;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class phone implements Serializable {
    @SerializedName("home")
    private String home;
    @SerializedName("work")
    private String work;
    @SerializedName("mobile")
    private String mobile;


    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
