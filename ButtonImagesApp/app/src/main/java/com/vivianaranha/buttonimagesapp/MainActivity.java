package com.vivianaranha.buttonimagesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void showFacebook(View view) {
        imageView.setImageResource(R.drawable.ic_fb);
    }

    public void showTwitter(View view) {
        imageView.setImageResource(R.drawable.ic_twitter);
    }
}
