package com.vivianaranha.toastapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This is a Toast", Toast.LENGTH_SHORT).show();
            }
        });


    }

//    public void showToast(View view) {
//        Toast.makeText(this, "This is a Toast", Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    public void onClick(View v) {
//        Toast.makeText(this, "This is a Toast", Toast.LENGTH_SHORT).show();
//    }
}
