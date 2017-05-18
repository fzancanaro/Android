package com.flaviazancanaro.sqlitelogin.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.ContactsContract;

import com.flaviazancanaro.sqlitelogin.R;
import com.flaviazancanaro.sqlitelogin.model.User;

/**
 * Created by delaroy on 3/27/17.
 */
public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_USER = "user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);

        //   db.execSQL(CREATE_IMAGES_TABLE);
/*
        String command = "INSERT TO IMAGES(" + PARKNAME + "," + IMAGES + ") VALUES('blaxland1'," + R.drawable.blaxland1 + "," +
                "'blaxland2'," + R.drawable.blaxland2 + ",'blaxland3'," + R.drawable.blaxland3 + ",'centennial1'," +
                R.drawable.centennial1 + ",'centennial2'," + R.drawable.centennial2 + ",'centennial3'," + R.drawable.centennial3 +
                ",'north1'," + R.drawable.north1 + ",'north2'," + R.drawable.north2 + "," + ",'north3'," + R.drawable.north3 + "," +
                "'pratten1'," + R.drawable.pratten1 + ",'pratten2'," + R.drawable.pratten2 + ",'pratten3'," + R.drawable.pratten3 + "," +
                "'prince1'," + R.drawable.prince1 + ",'prince2'," + R.drawable.prince2 + ",'prince3'," + R.drawable.prince3 + "," +
                "'redfern1'," + R.drawable.redfern1 + ",'redfern2'," + R.drawable.redfern2 + ",'credfern3'," + R.drawable.redfern3 + "," +
                "'victoria1'," + R.drawable.victoria1 + ",'victoria2'," + R.drawable.victoria2 + ",'victoria3'," + R.drawable.victoria3 + ",)";
        db.execSQL(command);

*/
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public boolean checkUser(String email) {
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password) {
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
/*
    //create table for text images
// Table Name
    public static final String TABLE_NAME = "IMAGES";

    // Table columns
    public static final String _ID = "_id";
    public static final String PARKNAME = "name";
    public static final String IMAGES = "imgId";

    // Creating table query
    private static final String CREATE_TABLE = "parkNames " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PARKNAME + "  text not null, " + IMAGES + " int NOT NULL);";

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from" +IMAGES, null);
        return res;
    }

     /*SQLiteDatabase db = ...;

    Cursor cur = db.rawQuery("SELECT COUNT(*) FROM IMAGES", null);

    {
        if (cur != null) {
            cur.moveToFirst();
            if (cur.getInt(0) == 0) {
                // Tabela esta vazia, preencha com seus dados iniciais
            } else {
                // Tabela ja contem dados.
            }
        }

    }
    */

}
