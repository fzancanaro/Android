package com.vivianaranha.debuggingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.editText);
        secondNumber = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView2);
    }

    public void addNumbers(View view) {
        int x = Integer.parseInt(firstNumber.getText().toString());
        int y = Integer.parseInt(secondNumber.getText().toString());
        int answer = result(x,y);
        textView.setText("Result: " + answer);


//        Toast.makeText(this, "Result: " + answer, Toast.LENGTH_SHORT).show();


//        Toast toast = Toast.makeText(this, "Result: " + answer, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.CENTER, 200, -200);
//        toast.show();


        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_message, null);

        toast.setView(toastView);
        toast.show();


        Log.d("MainActivity_Log", "Debug Answer: " + answer);
        Log.e("MainActivity_Log", "Error Answer: " + answer);
        Log.i("MainActivity_Log", "Info Answer: " + answer);
        Log.w("MainActivity_Log", "Warning Answer: " + answer);
        Log.v("MainActivity_Log", "Verbose Answer: " + answer);
        Log.wtf("MainActivity_Log", "WTF Answer: " + answer);


    }

    private int result(int a, int b){
        int c = a + b;
        return c;
    }
}
