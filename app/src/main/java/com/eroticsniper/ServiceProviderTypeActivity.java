package com.eroticsniper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ServiceProviderTypeActivity extends DemoSniper {

    LinearLayout Back;
    Button btn_Place, btn_Person, btn_EscortServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_type);
        Back = (LinearLayout) findViewById(R.id.back);

        btn_Place = (Button) findViewById(R.id.btn_Place);
        btn_Person = (Button) findViewById(R.id.btn_Person);
        btn_EscortServices = (Button) findViewById(R.id.btn_EscortServices);


        btn_Place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_Person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_EscortServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
