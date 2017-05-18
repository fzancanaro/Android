package com.flaviazancanaro.sqlitelogin.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.flaviazancanaro.sqlitelogin.R;

/**
 * Created by flaviazancanaro on 25/4/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }
   //creating menu - In process to build
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.mnuHome)
        {
            Toast.makeText(this, "go to menu", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.mnuSetttings)
        {
            Toast.makeText(this, "go to settings", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.mnuShare)
        {
            Toast.makeText(this, "go to settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
