package com.eroticsniper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.eroticsniper.Adapters.AdvanceServiceAdapter;
import com.eroticsniper.Adapters.ServicesAdapter;
import com.eroticsniper.Beans.AdvCategoryResp;
import com.eroticsniper.Beans.Retroresponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AdvanceCategory extends AppCompatActivity {
    RecyclerView rv_advance_service;
    AdvCategoryResp advCategoryResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_category);
        rv_advance_service = (RecyclerView) findViewById(R.id.rv_advance_service);
        retrofit();
    }

    public void retrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Global.BaseUrl).client(client).addConverterFactory(GsonConverterFactory.create(gson)).addConverterFactory(ScalarsConverterFactory.create()).build();
        RetroInterface retroInterface = retrofit.create(RetroInterface.class);
        Call<AdvCategoryResp> call = retroInterface.getAdvCat("12");
        call.enqueue(new Callback<AdvCategoryResp>() {
            @Override
            public void onResponse(Call<AdvCategoryResp> call, retrofit2.Response<AdvCategoryResp> response) {
                advCategoryResp = response.body();
                if (advCategoryResp != null) {
                    AdvanceServiceAdapter servicesAdapter = new AdvanceServiceAdapter(AdvanceCategory.this, advCategoryResp);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    rv_advance_service.setLayoutManager(mLayoutManager);
                    rv_advance_service.setItemAnimator(new DefaultItemAnimator());
                    rv_advance_service.setAdapter(servicesAdapter);
                }
            }

            @Override
            public void onFailure(Call<AdvCategoryResp> call, Throwable t) {
                Log.d("RETOFIT_RESPONSE", "fail " + t);
            }
        });

    }
}
