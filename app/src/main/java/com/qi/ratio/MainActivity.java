package com.qi.ratio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatioImageView imageView = (RatioImageView) findViewById(R.id.image);
        Picasso.with(this).load("https://dl.hanmimei.com/slider/pic/20170120/bdf94acb60d4478b8a2f98ea8cbfcbd91484881777460.jpg").into(imageView);
    }
}
