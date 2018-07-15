package com.example.nytime.adilehsan.interfaces;

import com.example.nytime.adilehsan.models.ResponseModel;

public interface MainContract {

    interface presenter{
        void onDestroy();


        void requestDataFromServer();

    }

    interface MainView {



        void setDataToRecyclerView(ResponseModel responseModel);

        void onResponseFailure(Throwable throwable);

    }
    interface GetResultIntractor {

        interface OnFinishedListener {
            void onFinished(ResponseModel responseModel);
            void onFailure(Throwable t);
        }

        void getResultArrayList(OnFinishedListener onFinishedListener);
    }

}
