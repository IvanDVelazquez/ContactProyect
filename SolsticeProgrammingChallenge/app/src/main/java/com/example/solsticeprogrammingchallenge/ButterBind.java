package com.example.solsticeprogrammingchallenge;

import android.os.Bundle;

import butterknife.ButterKnife;

import androidx.appcompat.app.AppCompatActivity;

//ButterBind is a class that help to bind the activity, and sent the content view
public abstract class ButterBind extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
    }

    protected abstract int getContentView();
}
