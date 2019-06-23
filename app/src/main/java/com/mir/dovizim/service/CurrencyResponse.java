package com.mir.dovizim.service;

import com.google.gson.annotations.SerializedName;
import com.mir.dovizim.model.Rates;

import java.util.Map;

public class CurrencyResponse {

    @SerializedName("rates")
    private Map<String, String> rates;

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }
}
