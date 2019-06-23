package com.mir.dovizim.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Rates {
    @SerializedName("movies")
    private Map<String, String> rates;

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "rates=" + rates +
                '}';
    }
}
