package com.eroticsniper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LandingActivity extends DemoSniper {
    LinearLayout guest, Signin, Registration;
    TextView txt_TermAndConditions, txt_PrivacyPolicy, txt_Contact, txt_disclarmer, txt_Prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        //=====Register Linear Layouts======//
        guest = (LinearLayout) findViewById(R.id.Ll_guest);
        Signin = (LinearLayout) findViewById(R.id.Ll_signin);
        Registration = (LinearLayout) findViewById(R.id.Ll_registration);

        //=====Register Txt Views======//
        txt_TermAndConditions = (TextView) findViewById(R.id.txt_TermAndConditions);
        txt_PrivacyPolicy = (TextView) findViewById(R.id.txt_PrivacyPolicy);
        txt_Contact = (TextView) findViewById(R.id.txt_Contact);
        txt_disclarmer = (TextView) findViewById(R.id.txt_disclarmer);
        txt_Prices = (TextView) findViewById(R.id.txt_Prices);

        //===========Add click Listeners==============//
        txt_TermAndConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("Terms and condition");
            }
        });

        txt_PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("PrivacyPolicy");
            }
        });

        txt_Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("Contact");
            }
        });

        txt_disclarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("disclaimer");
            }
        });

        txt_Prices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("Prices");
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowToast("This section is part of user Section");
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LandingActivity.this, Signin_as_Activity.class);
                startActivity(i);
                finish();
            }
        });

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent().setClass(LandingActivity.this, RegisterAsActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
