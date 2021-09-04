package com.example.tidings2;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tidings2.Models.NewsHeadllines;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {

    NewsHeadllines headllines;
    TextView title, published_at, content, author;
    ImageView news_img;
    Button btn;
    ImageButton backbtn;
    String article_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        author = findViewById(R.id.news_author);
        title = findViewById(R.id.full_title);
        published_at = findViewById(R.id.publishAt);
        content = findViewById(R.id.full_article);
        news_img = findViewById(R.id.thumbnail_img);
        btn = findViewById(R.id.full_article_btn);

        headllines = (NewsHeadllines) getIntent().getSerializableExtra("data");

        backbtn = findViewById(R.id.backbtn);
//        author.setText(headllines.getAuthor());
        title.setText(headllines.getTitle());
        published_at.setText(headllines.getPublishedAt());
        content.setText(headllines.getContent());
        Picasso.get().load(headllines.getUrlToImage()).into(news_img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                article_url = headllines.getUrl();
                Uri webpage = Uri.parse(article_url);
                Intent i = new Intent(Intent.ACTION_VIEW, webpage);
                if(i.resolveActivity(getPackageManager()) != null){
                    startActivity(i);
                }
                else {
                    Log.e("ImplicitIntent", "Can't Handel");
                }
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}