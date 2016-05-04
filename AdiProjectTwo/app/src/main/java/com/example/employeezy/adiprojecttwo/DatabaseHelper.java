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

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "Players.db";

    public static final String PLAYERS_TABLE = "players";

    public static final String COL_PLAYER_ID = "_id";
    public static final String COL_PLAYER_NAME = "player_name";
    public static final String COL_PLAYER_NUM = "player_number";
    public static final String COL_ROOKIE_YEAR = "rookie_year";
    public static final String COL_POSITION = "position";
    public static final String COL_POSITION_NUM = "position_number";

    public static final String[] COL_NAMES = {COL_PLAYER_NAME, COL_PLAYER_ID, COL_PLAYER_NUM, COL_ROOKIE_YEAR,
            COL_POSITION, COL_POSITION_NUM};

    private static final String CREATE_PLAYERS_TABLE =
            "CREATE TABLE " + PLAYERS_TABLE +
                    "(" +
                    COL_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_PLAYER_NAME + " TEXT, " +
                    COL_PLAYER_NUM + " INTEGER, " +
                    COL_ROOKIE_YEAR + " INTEGER, " +
                    COL_POSITION + " TEXT, " +
                    COL_POSITION_NUM + " INTEGER)";

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLAYERS_TABLE);
        loadPlayersTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + PLAYERS_TABLE);
        onCreate(db);
    }

    //being hard coding database info for Players_Table
    private void loadPlayersTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_PLAYER_NAME, "Jordan Clarkson");
        values.put(COL_PLAYER_NUM, 6);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Shooting Guard");
        values.put(COL_POSITION_NUM, 2);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "D'Angelo Russell");
        values.put(COL_PLAYER_NUM, 0);
        values.put(COL_ROOKIE_YEAR, 2015);
        values.put(COL_POSITION, "Point Gaurd");
        values.put(COL_POSITION_NUM, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Julius Randle");
        values.put(COL_PLAYER_NUM, 30);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Power forward");
        values.put(COL_POSITION_NUM, 4);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Metta World Peace");
        values.put(COL_PLAYER_NUM, 37);
        values.put(COL_ROOKIE_YEAR, 1996);
        values.put(COL_POSITION, "Small Forward");
        values.put(COL_POSITION_NUM, 3);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Tarik Black");
        values.put(COL_PLAYER_NUM, 28);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Ceter");
        values.put(COL_POSITION_NUM, 5);
        db.insert(PLAYERS_TABLE, null, values);
    }

    public Cursor getRosterData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(PLAYERS_TABLE, // a. table
                COL_NAMES, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                COL_POSITION_NUM + " DESC ", // g. order by
                null); // h. limit
        return cursor;
    }

}




    //Begins old Database
//    public static final String SQL_CREATE_PLAYER_TABLE =
//            "CREATE TABLE players ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";
//
//    public static final String SQL_DROP_DROP_PLAYER_TABLE = "DROP TABLE IF EXISTS players";
//
//
//    public void insert(int id, String name, String year) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("id", id);
//        values.put("name", name);
//        values.put("year", year);
//
//        db.insert("Players", null, values);
//    }
//
//    public Player getPlayer(int id){
//
//        SQLiteDatabase db = getReadableDatabase();
//        String[] projection = new String[] {"id", "name", "year"};
//        String selection = "id = ?";
//        String[] selectionArgs = new String[]{ String.valueOf(id)};
//        Cursor cursor = db.query("Players", projection, selection, selectionArgs, null, null, null, null);
//        cursor.moveToFirst();
//        String name = cursor.getString( cursor.getColumnIndex("name"));
//        String year = cursor.getString( cursor.getColumnIndex("year"));
//
//        return new Player(id, name, year);
//    }
//
//    public void delete(int id){
//        SQLiteDatabase db = getWritableDatabase();
//        String selection = "id =?";
//        String [] selectionArgs = new String[] { String.valueOf(id)};
//        db.delete("Players", selection, selectionArgs);
//    }
//}
//
//

