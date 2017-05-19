package com.eroticsniper;

import com.eroticsniper.Beans.AdvCategoryResp;
import com.eroticsniper.Beans.CategoryResp;
import com.eroticsniper.Beans.Retroresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by joshi on 4/10/2017.
 */

public interface RetroInterface {

    @POST("/fetch_all_categories.php")
    Call<CategoryResp> postSignup();

    @GET("/fetch_category_services.php")
    Call<Retroresponse> getResponse(@Query("C_ID") String cid);

    @GET("/fetch_category_advance_services.php")
    Call<AdvCategoryResp> getAdvCat(@Query("C_ID") String cid);



}
