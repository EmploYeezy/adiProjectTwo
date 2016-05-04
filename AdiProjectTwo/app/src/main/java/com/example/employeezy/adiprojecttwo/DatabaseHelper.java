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

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Players.db";

    public static final String PLAYERS_TABLE = "players";

    public static final String COL_PLAYER_ID = "_id";
    public static final String COL_PLAYER_NAME = "player_name";
    public static final String COL_PLAYER_NUM = "player_number";
    public static final String COL_ROOKIE_YEAR = "rookie_year";
    public static final String COL_POSITION = "position";
    public static final String COL_POSITION_NUM = "position_number";
    public static final String COL_IS_STARTER = "starts";

    public static final String[] COL_NAMES = {COL_PLAYER_NAME, COL_PLAYER_ID, COL_PLAYER_NUM, COL_ROOKIE_YEAR,
            COL_POSITION, COL_POSITION_NUM, COL_IS_STARTER};

    private static final String CREATE_PLAYERS_TABLE =
            "CREATE TABLE " + PLAYERS_TABLE +
                    "(" +
                    COL_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_PLAYER_NAME + " TEXT, " +
                    COL_PLAYER_NUM + " INTEGER, " +
                    COL_ROOKIE_YEAR + " INTEGER, " +
                    COL_POSITION + " TEXT, " +
                    COL_POSITION_NUM + " INTEGER, " +
                    COL_IS_STARTER + " INTEGER)";

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

    //begin hard coding database info for Players_Table
    private void loadPlayersTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();

        values.put(COL_PLAYER_NAME, "Jordan Clarkson");
        values.put(COL_PLAYER_NUM, 6);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Guard");
        values.put(COL_POSITION_NUM, 2);
        values.put(COL_IS_STARTER, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "D'Angelo Russell");
        values.put(COL_PLAYER_NUM, 0);
        values.put(COL_ROOKIE_YEAR, 2015);
        values.put(COL_POSITION, "Guard");
        values.put(COL_POSITION_NUM, 1);
        values.put(COL_IS_STARTER, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Julius Randle");
        values.put(COL_PLAYER_NUM, 30);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 4);
        values.put(COL_IS_STARTER, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Metta World Peace");
        values.put(COL_PLAYER_NUM, 37);
        values.put(COL_ROOKIE_YEAR, 2001);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 3);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Tarik Black");
        values.put(COL_PLAYER_NUM, 28);
        values.put(COL_ROOKIE_YEAR, 2014);
        values.put(COL_POSITION, "Center");
        values.put(COL_POSITION_NUM, 5);
        values.put(COL_IS_STARTER, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Brandon Bass");
        values.put(COL_PLAYER_NUM, 2);
        values.put(COL_ROOKIE_YEAR,2006);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 4);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Anthony Brown");
        values.put(COL_PLAYER_NUM, 3);
        values.put(COL_ROOKIE_YEAR, 2015);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 3);
        values.put(COL_IS_STARTER, 1);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Larry Nance Jr.");
        values.put(COL_PLAYER_NUM, 7);
        values.put(COL_ROOKIE_YEAR, 2015);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 4);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Lou Williams");
        values.put(COL_PLAYER_NUM, 23);
        values.put(COL_ROOKIE_YEAR, 2006);
        values.put(COL_POSITION, "Guard");
        values.put(COL_POSITION_NUM, 2);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Marcelo Huertas");
        values.put(COL_PLAYER_NUM, 9);
        values.put(COL_ROOKIE_YEAR, 2015);
        values.put(COL_POSITION, "Guard");
        values.put(COL_POSITION_NUM, 1);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Nick 'Swaggy P' Young");
        values.put(COL_PLAYER_NUM, 0);
        values.put(COL_ROOKIE_YEAR, 2008);
        values.put(COL_POSITION, "Forward");
        values.put(COL_POSITION_NUM, 3);
        values.put(COL_IS_STARTER, 0);
        db.insert(PLAYERS_TABLE, null, values);

        values.put(COL_PLAYER_NAME, "Roy Hibbert");
        values.put(COL_PLAYER_NUM, 17);
        values.put(COL_ROOKIE_YEAR, 2009);
        values.put(COL_POSITION, "Center");
        values.put(COL_POSITION_NUM, 5);
        values.put(COL_IS_STARTER, 0);
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

