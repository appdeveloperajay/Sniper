package com.eroticsniper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.eroticsniper.Adapters.ServicesAdapter;
import com.eroticsniper.Beans.Retroresponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Services extends AppCompatActivity {

    RecyclerView rv_service;
    String CatId = "0";
    String have_advance_services;
    ArrayList<String> ServicesName = new ArrayList<String>();
    ArrayList<String> ServiceId = new ArrayList<String>();
    Retroresponse response1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        rv_service = (RecyclerView) findViewById(R.id.rv_service);
        Intent i = new Intent();
        CatId = i.getStringExtra("CID");
        have_advance_services = i.getStringExtra("adv_service");
        Toast.makeText(Services.this, "a1" +have_advance_services, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        retrofit();

    }

    public void retrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Global.BaseUrl).client(client).addConverterFactory(GsonConverterFactory.create(gson)).addConverterFactory(ScalarsConverterFactory.create()).build();
        RetroInterface retroInterface = retrofit.create(RetroInterface.class);
        Call<Retroresponse> call = retroInterface.getResponse("12");
        call.enqueue(new Callback<Retroresponse>() {
            @Override
            public void onResponse(Call<Retroresponse> call, retrofit2.Response<Retroresponse> response) {
                response1 = response.body();
                if (response1 != null) {
                    for (int i = 0; i < response1.getServices().size(); i++) {
                        ServiceId.add(response1.getServices().get(i).getService_id());
                        ServicesName.add(response1.getServices().get(i).getService_name());
                    }
                }
                Toast.makeText(Services.this, "a" +have_advance_services, Toast.LENGTH_SHORT).show();
                ServicesAdapter servicesAdapter = new ServicesAdapter(Services.this, ServiceId, ServicesName, have_advance_services);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                rv_service.setLayoutManager(mLayoutManager);
                rv_service.setItemAnimator(new DefaultItemAnimator());
                rv_service.setAdapter(servicesAdapter);

            }

            @Override
            public void onFailure(Call<Retroresponse> call, Throwable t) {
                Log.d("RETOFIT_RESPONSE", "fail " + t);
            }
        });

    }

}
