package com.eroticsniper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RegisterAsActivity extends DemoSniper {

    LinearLayout Back, Ll_AsCustomer, Ll_As_Service_Provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as);

        Back = (LinearLayout) findViewById(R.id.back);
        Ll_AsCustomer = (LinearLayout) findViewById(R.id.Ll_AsCustomer);
        Ll_As_Service_Provider = (LinearLayout) findViewById(R.id.Ll_As_Service_Provider);


        Ll_AsCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent().setClass(RegisterAsActivity.this, RegistrationActivity.class);
                i.putExtra("RegisterAs", "Customer");
                startActivity(i);
                finish();

            }
        });

        Ll_As_Service_Provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent().setClass(RegisterAsActivity.this, RegistrationActivity.class);
                i.putExtra("RegisterAs", "ServiceProvider");
                startActivity(i);
                finish();

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent().setClass(RegisterAsActivity.this, LandingActivity.class);
        startActivity(i);
        finish();
    }
}
