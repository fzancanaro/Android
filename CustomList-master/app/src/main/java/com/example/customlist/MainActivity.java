package com.example.customlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  {

    Toolbar mToolbar;
    ListView mListView;

    String[] parkNames = {
            "Centennial \nOxford Street \nNSW 2021",
            "North Harbour \nCondamine Street South, \nBalgowlah NSW 2093",
            "Blaxland Riverside Park \nJamieson St, \nSydney NSW 2127",
            "pratten Park \n40 Arthur St, \nAshfield NSW 2131",
            "Prince Alfred Park \nChalmers St, \nSurry Hills NSW 2010",
            "redfern Park \nredfern St,  \nRedfern NSW 2016",
            "silverwater Park  \n2 Clyde St,\nSilverwater NSW 2128",
            "Sydney Park  \nSydney Park Rd,  \nSt Peters NSW 2044",
            "tumbalong Park",
            "Victoria Park"
           };
    int[] parkPictutes = {R.drawable.blaxland,
            R.drawable.northharbour,
            R.drawable.blaxland,
            R.drawable.pratten,
            R.drawable.princealfred,
            R.drawable.redfern,
            R.drawable.silverwater,
            R.drawable.sydneypark,
            R.drawable.tumbalong,
            R.drawable.victoria
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, parkNames, parkPictutes);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(MainActivity.this, DetailActivity.class);
                mIntent.putExtra("countryName", parkNames[i]);
                mIntent.putExtra("countryFlag", parkPictutes[i]);
                startActivity(mIntent);
            }
        });
    }
}
