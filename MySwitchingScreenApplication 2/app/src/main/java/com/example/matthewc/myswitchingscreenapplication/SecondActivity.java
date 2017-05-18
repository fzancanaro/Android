package com.example.matthewc.myswitchingscreenapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String username;
    Human human;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView usernameText = (TextView)findViewById(R.id.usernameText);

        //reference the intent that created this activity
        Intent intentThatCreatedThisActivity = getIntent();

        //want to get values from intent
        username = intentThatCreatedThisActivity.getStringExtra("username");//use key to find from before
        //if it cant find it, give back a null
        if(username != null){
            usernameText.setText("Username: "+username);
        }
        else
        {
            usernameText.setText("Username not found");
        }

        //get human, if we can
        human = (Human)intentThatCreatedThisActivity.getSerializableExtra("human"); //use human look up key
        if(human == null)
            human = new Human();
    }

    public void backClick(View view) {
        //fill in Human object from editText boxes
        EditText nameET = (EditText)findViewById(R.id.nameEditText);
        EditText ageET = (EditText)findViewById(R.id.ageEditText);
        EditText emailET = (EditText)findViewById(R.id.emailEditText);

        human.setName(nameET.getText().toString());
        human.setAge(Integer.parseInt(ageET.getText().toString()));
        human.setEmail(emailET.getText().toString());

        //Make an intent to send data back to the waiting first activity
        Intent sendDataBack = new Intent();
        sendDataBack.putExtra("username",username);//send username back, for no real reason, just practice
        sendDataBack.putExtra("human", human);

        //set result code and data to send back for when this activity finishes
        setResult(RESULT_OK, sendDataBack);

        //kill the currect activity
        finish();
    }
}
