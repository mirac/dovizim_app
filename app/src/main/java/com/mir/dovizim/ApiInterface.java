package com.mir.dovizim;

import com.mir.dovizim.service.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("latest?symbols=USD,TRY,GBP")
    Call<CurrencyResponse> getLastCurrencies(@Query("access_key") String api_key);
}