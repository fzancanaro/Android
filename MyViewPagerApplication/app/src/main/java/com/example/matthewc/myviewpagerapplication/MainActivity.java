package com.example.matthewc.myviewpagerapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    SlideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new SlideAdapter(getSupportFragmentManager());

        TextFragment textFrag = new TextFragment();
        textFrag.setText("THIS APP IS GOING TO BE AWESOME!!!");
        ImageFragment imgFrag = new ImageFragment();
        ButtonFragment btnFrag = new ButtonFragment();

        adapter.pages.add(textFrag);
        adapter.pages.add(imgFrag);
        adapter.pages.add(btnFrag);

        pager.setAdapter(adapter);


    }
}
