package com.mir.dovizim.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Rate {

    @SerializedName("USD")
    private String USD;

    @SerializedName("TRY")
    private String TRY;

    @SerializedName("GBP")
    private String GBP;

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getTRY() {
        return TRY;
    }

    public void setTRY(String TRY) {
        this.TRY = TRY;
    }

    public String getGBP() {
        return GBP;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }
}
