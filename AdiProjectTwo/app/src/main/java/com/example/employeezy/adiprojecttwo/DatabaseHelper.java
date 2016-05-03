package com.example.employeezy.adiprojecttwo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by EmployYeezy on 5/2/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Players.db";

    public static final String SQL_CREATE_PLAYER_TABLE =
            "CREATE TABLE players ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

    public static final String SQL_DROP_DROP_PLAYER_TABLE = "DROP TABLE IF EXISTS players";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLAYER_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_DROP_PLAYER_TABLE);
        onCreate(db);
    }

    public void insert(int id, String name, String year) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("year", year);

        db.insert("Players", null, values);
    }

    public Player getPlayer(int id){

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[] {"id", "name", "year"};
        String selection = "id = ?";
        String[] selectionArgs = new String[]{ String.valueOf(id)};
        Cursor cursor = db.query("Players", projection, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();
        String name = cursor.getString( cursor.getColumnIndex("name"));
        String year = cursor.getString( cursor.getColumnIndex("year"));

        return new Player(id, name, year);
    }

    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String selection = "id =?";
        String [] selectionArgs = new String[] { String.valueOf(id)};
        db.delete("Players", selection, selectionArgs);
    }
}



