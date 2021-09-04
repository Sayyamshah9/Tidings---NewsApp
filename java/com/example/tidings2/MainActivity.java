package com.example.tidings2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tidings2.Models.NewsApiResponse;
import com.example.tidings2.Models.NewsHeadllines;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Code for Progress Dialog
        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching News");
        dialog.show();

        //        Code for Setting Date
        TextView date = findViewById(R.id.dateid);
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String d = day + "/" + (month+1) + "/" + year;
        date.setText(d);

//        Calling API
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener);
    }

    private final OnFetchDataListener<NewsApiResponse> listener = new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadllines> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadllines> list){
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadllines headlLines) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        i.putExtra("data", headlLines);
        startActivity(i);
    }
}