package com.example.nytime.adilehsan.interfaces;

import com.example.nytime.adilehsan.models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetResultDataService {
    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=fdd898cc16094289b0ef53fb11d5b9af")
    Call<ResponseModel> getData();
}
