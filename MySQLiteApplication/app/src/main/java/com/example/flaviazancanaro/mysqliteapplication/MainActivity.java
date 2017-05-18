package com.example.flaviazancanaro.mysqliteapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase contactDB = null;
    Button createDBButton, addContactButton, deleteContactButton, getContactsButton, deleteDBButton;
    EditText nameEditText, emailEdittext, contactsListEditText, idEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link layout to class objects

        createDBButton = (Button) findViewById(R.id.createDBButton);
        addContactButton = (Button) findViewById(R.id.addContactButton);
        deleteContactButton = (Button) findViewById(R.id.deleteContactButton);
        getContactsButton = (Button) findViewById(R.id.getContactButton);
        deleteDBButton = (Button) findViewById(R.id.deleteDBButton);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEdittext = (EditText) findViewById(R.id.emailEditText);
        contactsListEditText = (EditText) findViewById(R.id.contactsEditText);
        idEditText = (EditText) findViewById(R.id.idToDeleteEditText);


    }

    public void CreateDB(View view) {

        try{
        //create or open a private database
        contactDB = openOrCreateDatabase("MyContacts.db", MODE_PRIVATE, null);
        //if creating a new DB, it wont actually
        contactDB.execSQL("CREATE TABLE IF NOT EXISTS contacts (id integer primary key, name varchar, email varchar);");

        //check if file was created or already exists
        File db = getApplicationContext().getDatabasePath("MyContacts.db");

        if (db.exists()) {
            Toast.makeText(this, "Database Created!", Toast.LENGTH_SHORT).show();
            createDBButton.setEnabled(false);
            addContactButton.setEnabled(true);
            deleteContactButton.setEnabled(true);
            deleteDBButton.setEnabled(true);
            getContactsButton.setEnabled(true);

        } else {
            Toast.makeText(this, "Databse NOT FOUND!", Toast.LENGTH_SHORT).show();
        }
    }
    catch(
    android.database.SQLException ex)

    {
        Log.e("Creating DB error", ex.getMessage());

    }

}
    public void addContact(View view) {

        String name = nameEditText.getText().toString();
        String email = emailEdittext.getText().toString();

        contactDB.execSQL("INSERT INTO contacts(name, email) VALUES(' "+name+"', '"+email+"')");
    }


    public void deleteContact(View view) {
        String id = idEditText.getText().toString();

    }

    public void getContact(View view) {
    //cursor
        Cursor cursor = contactDB.rawQuery("SELECT * FROM contacts", null);

        //get our column ids
        int idCol = cursor.getColumnIndex("id");
        int nameCol = cursor.getColumnIndex("name");
        int emailCol = cursor.getColumnIndex("email");

        cursor.moveToFirst();

        String contacts = "";

        //if
        if(cursor != null && cursor.getCount() > 0) {
            do {
                contacts += cursor.getString(idCol) + ": " + cursor.getString(nameCol) + " " + cursor.getString(emailCol) + "\n";
            } while (cursor.moveToNext());
        }
        else
               Toast.makeText(this, "NO CONTACTS", Toast.LENGTH_SHORT).show();

        contactsListEditText.setText(contacts);

    }

    public void deleteDB(View view) {

        deleteDatabase("MyContacts.db");
        createDBButton.setEnabled(true);
        addContactButton.setEnabled(false);
        deleteContactButton.setEnabled(false);
        deleteDBButton.setEnabled(false);
        getContactsButton.setEnabled(false);
    }


}
