package com.example.employeezy.adiprojecttwo;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RosterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster_list);

        ListView rosterList = (ListView) findViewById(R.id.roster_list);

        Cursor rosterCursor = (Cursor) new DatabaseHelper(this).getPlayer(1);

        CursorAdapter rosterAdapter = new CursorAdapter(RosterList.this, rosterCursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.activity_roster_list, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView rosterPlayerName = (TextView) view.findViewById(R.id.roster_player_name);
                TextView rosterYear = (TextView) view.findViewById(R.id.roster_year);

                rosterPlayerName.setText(cursor.getString(cursor.getColumnIndex("name")));
                rosterYear.setText(cursor.getString(cursor.getColumnIndex("year")));

            }
        };

        rosterList.setAdapter(rosterAdapter);

    }
}