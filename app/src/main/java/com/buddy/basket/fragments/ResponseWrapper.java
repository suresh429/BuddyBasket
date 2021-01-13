package com.buddy.basket.fragments;

import com.google.gson.annotations.SerializedName;

public class ResponseWrapper  {

    @SerializedName("qty")
    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
