package com.cc.newsy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OoyalaVideoPlayer player = new OoyalaVideoPlayer();
        player.init((ViewGroup) findViewById(R.id.videoPlayer));

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playVideo("I5YnB4MDE6x6gtSpZsQLsQ2K9MriuDf7");
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playVideo("RtaGR5MDE6UnNJ6xjebeJgAUrvu-_NLn");
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playVideo("pxMDAxMTE6uQlj5pQ6-rBXm4VuiIqdGf");
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.playVideo("d3ZGEyMTE6O2o1GFPDDF0yZwx__Ig_RZ");
            }
        });
    }
}
