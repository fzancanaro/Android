package com.example.matthewc.myswitchingscreenapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText usernameET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button)findViewById(R.id.nextBtn);
        usernameET = (EditText)findViewById(R.id.usernameEditText);



        //programatically add onclick listener to button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to go to next screen
                Intent nextScreen = new Intent(v.getContext(), SecondActivity.class);

                String username = usernameET.getText().toString();

                //lets send username to the next screen
                nextScreen.putExtra("username", username); //key and value pair (use key to find value later)
                //we wanna send a human through too
                Human human = new Human();
                nextScreen.putExtra("human", human); //must be a serializeable

                //startActivity(nextScreen); if we wanna run new activity, dont care about results, do this one
                startActivityForResult(nextScreen, 1); //1 is for request code, which we not using here


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String username = data.getStringExtra("username");
        Human human = (Human)data.getSerializableExtra("human");

        if(username != null)
            Toast.makeText(this, "Username sent back = "+username, Toast.LENGTH_SHORT).show();

        if(human != null){
            TextView output = (TextView)findViewById(R.id.returnedDataText);
            output.setText("Human: "+human.getName()+" Email: "+human.getEmail()+" Age: "+human.getAge());
        }
    }
}
