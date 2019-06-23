package com.mir.dovizim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mir.dovizim.adapters.RatesAdapter;
import com.mir.dovizim.model.Rates;
import com.mir.dovizim.service.CurrencyResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView lastUpdate;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        recyclerView = findViewById(R.id.rates_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lastUpdate = findViewById(R.id.lastUpdate);

        // İlk çalıştırma
        updateCurrencyInfo();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();

                lastUpdate.setText("Son Güncelleme: " + dateFormat.format(date));
                updateCurrencyInfo();
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 100);
    }

    private void updateCurrencyInfo() {
        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        Call<CurrencyResponse> call = apiInterface.getLastCurrencies("9a92943a88a9d52fe8198c2c32637e12");
        call.enqueue(new Callback<CurrencyResponse>() {
            @Override
            public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                Map<String, String> rates = response.body().getRates();

                recyclerView.setAdapter(new RatesAdapter(rates, R.layout.list_rates_item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<CurrencyResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        // Güncellendi mesajı
        //Toast.makeText(getApplicationContext(), "Güncellendi!", Toast.LENGTH_SHORT).show();
    }

}
