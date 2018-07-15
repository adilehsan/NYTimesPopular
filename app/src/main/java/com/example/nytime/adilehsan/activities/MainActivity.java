package com.example.nytime.adilehsan.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.nytime.adilehsan.R;
import com.example.nytime.adilehsan.adapter.ArticalsResultAdapter;
import com.example.nytime.adilehsan.interfaces.RecycleViewItemClick;
import com.example.nytime.adilehsan.models.ResponseModel;
import com.example.nytime.adilehsan.models.ResultDataModel;
import com.roger.catloadinglibrary.CatLoadingView;

import com.example.nytime.adilehsan.interfaces.MainContract;
import com.example.nytime.adilehsan.mainview.GetResultInteractorImp;
import com.example.nytime.adilehsan.mainview.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.MainView,RecycleViewItemClick {
   CatLoadingView catLoadingView;
    private RecyclerView recyclerView;
    private MainContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeToolbarAndRecyclerView();
        presenter = new MainPresenter(this, new GetResultInteractorImp());
        if (isNetworkAvailable()){
            catLoadingView= new CatLoadingView();
            catLoadingView.setCanceledOnTouchOutside(true);
            catLoadingView.show(getSupportFragmentManager(),"");
            presenter.requestDataFromServer();
        }else {
            Toast.makeText(MainActivity.this,
                    "Please Connect To Network...",
                    Toast.LENGTH_LONG).show();
        }

    }
    private void initializeToolbarAndRecyclerView() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);



    }




    @Override
    public void setDataToRecyclerView(ResponseModel responseModel) {
        catLoadingView.dismiss();
        if (responseModel.getStatus().equalsIgnoreCase("ok")){
            if (responseModel.getResults().isEmpty()){
                Toast.makeText(MainActivity.this,
                        "Something went wrong...",
                        Toast.LENGTH_LONG).show();
            }else {
                ArticalsResultAdapter adapter = new ArticalsResultAdapter(responseModel.getResults(),this);
                recyclerView.setAdapter(adapter);

            }
        }else {
            Toast.makeText(MainActivity.this,
                    "Wrong Param Passed...",
                    Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        if (catLoadingView.isVisible()){
            catLoadingView.dismiss();
        }
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (catLoadingView.isVisible()){
            catLoadingView.dismiss();
        }
        presenter.onDestroy();

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(ResultDataModel resultDataModel) {
        Intent intent = new Intent(MainActivity.this,ArticalDetailActivity.class);
        intent.putExtra("detail",resultDataModel);
        startActivity(intent);
    }
}
