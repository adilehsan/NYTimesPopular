package com.example.nytime.adilehsan.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseModel {
    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private ArrayList<ResultDataModel> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ResultDataModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultDataModel> results) {
        this.results = results;
    }
}
