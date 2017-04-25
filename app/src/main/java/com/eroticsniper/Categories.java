package com.eroticsniper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.eroticsniper.Adapters.CategoryAdapter;
import com.eroticsniper.Beans.Category;
import com.eroticsniper.Beans.CategoryResp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Categories extends AppCompatActivity {
    String TAG = "Catrgory_Log";
    RecyclerView rv_category;
    CategoryResp category;
    ArrayList<String> RESCategory = new ArrayList<String>();
    ArrayList<String> RESCategoryId = new ArrayList<String>();
    ArrayList<String> Cat_type = new ArrayList<String>();
    ArrayList<String> Have_services = new ArrayList<String>();
    ArrayList<String> Have_advanceservices = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.BaseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RetroInterface retrofitService = retrofit.create(RetroInterface.class);
        //====================== Callbnack Methods ===========================//
        Call<CategoryResp> getReviews = retrofitService.postSignup();
        getReviews.enqueue(new Callback<CategoryResp>() {
                               @Override
                               public void onResponse(Call<CategoryResp> call, Response<CategoryResp> response) {
                                   if (response != null) {
                                       category = response.body();
                                       Log.d(TAG, "" + category);

                                       if (category != null) {
                                           for (int i = 0; i < category.getCategory().size(); i++) {
                                               RESCategory.add(category.getCategory().get(i).getCat_name());
                                               RESCategoryId.add(category.getCategory().get(i).getCat_id().toString());
                                               Cat_type.add(category.getCategory().get(i).getCat_type().toString());
                                               Have_services.add(category.getCategory().get(i).getHave_services().toString());
                                               Have_advanceservices.add(category.getCategory().get(i).getHave_services().toString());
                                           }

                                           CategoryAdapter categoryAdapter = new CategoryAdapter(Categories.this, RESCategory, RESCategoryId, Cat_type, Have_services, Have_advanceservices);
                                           rv_category = (RecyclerView) findViewById(R.id.rv_category);
                                           RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                           rv_category.setLayoutManager(mLayoutManager);
                                           rv_category.setItemAnimator(new DefaultItemAnimator());
                                           rv_category.setAdapter(categoryAdapter);
                                       }
                                   }
                               }

                               @Override
                               public void onFailure(Call<CategoryResp> call, Throwable t) {
                                   Toast.makeText(Categories.this, "fail", Toast.LENGTH_SHORT).show();
                               }

                           }
        );



    }
}
