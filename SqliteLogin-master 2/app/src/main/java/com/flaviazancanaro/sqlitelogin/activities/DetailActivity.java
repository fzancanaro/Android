package com.flaviazancanaro.sqlitelogin.activities;

/**
 * Created by flaviazancanaro on 2/5/17.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flaviazancanaro.sqlitelogin.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;



public class DetailActivity extends AppCompatActivity {

    //new
    SQLiteDatabase database;

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    Toolbar mToolbar;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_layout);

      /*
       SQLiteOpenHelper dbHelper = new dbHelper(this);
        database = dbHelper.getWritableDatabase();
        Toast.makeText(this, "Database acquired!", Toast.LENGTH_LONG).show();
*/

//get image by id in the list?
       /* mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        mImageView = (ImageView) findViewById(R.id.imageView2);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mToolbar.setTitle(mBundle.getString("parkName"));
            mImageView.setImageResource(mBundle.getInt("parkPictures"));
        }*/
//
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        //TODO
        //USING NAME OF PARK, SELECT ALL IMAGES FROM DB WITH SAME PARK NAME
        //ADD IMAGES TO IMAGES ARRAY

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.victoria1);
        images.add(R.drawable.victoria2);
        images.add(R.drawable.victoria3);
        images.add(R.drawable.blaxland1);
        images.add(R.drawable.blaxland2);
        images.add(R.drawable.blaxland3);



        //new
        int img1 = R.drawable.prince2;
        //load, grt img  id
        //ImageView iv = (ImageView)findViewById(R.id.imageView);
        //iv.setImageResource(img1);

        //test
     //   ImageView iv = (ImageView) findViewById(R.id.imageView);
     //   iv.setImageResource(getIntent().getIntExtra("blaxland1", 0));

        //try get img from drawable and text from sqlite
        int imageid = getResources().getIdentifier("/Users/flaviazancanaro/AndroidStudioProjects/SqliteLogin-master 2/app/src/main/res/drawable/blaxland1.jpg", null, null);
        ImageView imagenow = (ImageView) findViewById(R.id.imageView);
       // imagenow.setImageDrawable(getResources().getDrawable(R.drawable.blaxland1));

       // ImageView parkName = (ImageView) findViewById(R.id.imageView);
      //  imagenow.setImageResource(imageid);

        





        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, images);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            DetailActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

}
