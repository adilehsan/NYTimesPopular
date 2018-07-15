package com.example.nytime.adilehsan.mainview;

import com.example.nytime.adilehsan.interfaces.MainContract;
import com.example.nytime.adilehsan.models.ResponseModel;

public class MainPresenter implements MainContract.presenter,MainContract.GetResultIntractor.OnFinishedListener {
    private MainContract.MainView mainView;
    private MainContract.GetResultIntractor getResultIntractor;
    public MainPresenter(MainContract.MainView mainView,MainContract.GetResultIntractor getResultIntractor){
        this.mainView=mainView;
        this.getResultIntractor =getResultIntractor;
    }
    @Override
    public void onDestroy() {
       mainView=null;
    }



    @Override
    public void requestDataFromServer() {
       getResultIntractor.getResultArrayList(this);
    }

    @Override
    public void onFinished(ResponseModel responseModel) {
        if(mainView != null){
            mainView.setDataToRecyclerView(responseModel);

        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }
}
