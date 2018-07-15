package com.example.nytime.adilehsan.mainview;

import com.example.nytime.adilehsan.interfaces.GetResultDataService;
import com.example.nytime.adilehsan.interfaces.MainContract;
import com.example.nytime.adilehsan.models.ResponseModel;
import com.example.nytime.adilehsan.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetResultInteractorImp implements MainContract.GetResultIntractor {
    @Override
    public void getResultArrayList(final OnFinishedListener onFinishedListener) {
        GetResultDataService resultDataService = RetrofitInstance.getRetrofitInstance().create(GetResultDataService.class);
        final Call<ResponseModel> responseModelCall = resultDataService.getData();
        responseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
onFinishedListener.onFailure(t);
            }
        });
    }
}
