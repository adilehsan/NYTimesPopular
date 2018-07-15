package com.example.nytime.adilehsan.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.nytime.adilehsan.R;
import com.example.nytime.adilehsan.models.ResultDataModel;

public class ArticalDetailActivity extends AppCompatActivity {
    ResultDataModel resultDataModel;
    TextView byTextView,sectionTextView,dateTextView,titleTextView,sourceTextView,viewsTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artical_detail);
        inIT();
    }
    public void inIT(){
        byTextView = (TextView)findViewById(R.id.byText);
        viewsTextView = (TextView)findViewById(R.id.viewsText);
        sectionTextView = (TextView)findViewById(R.id.sectionText);
        dateTextView = (TextView)findViewById(R.id.dateText);
        titleTextView = (TextView)findViewById(R.id.titleText);
        sourceTextView = (TextView)findViewById(R.id.sourceText);
        resultDataModel= (ResultDataModel)getIntent().getParcelableExtra("detail");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Description");
        setValues();

    }
    public void setValues(){
        byTextView.setText(resultDataModel.getByline());
        sectionTextView.setText(resultDataModel.getSection());
        sourceTextView.setText(resultDataModel.getSource());
        titleTextView.setText(resultDataModel.getTitle());
        dateTextView.setText(resultDataModel.getPublished_date());
        viewsTextView.setText(Integer.toString(resultDataModel.getViews()));
    }
}
