package com.example.employeezy.adiprojecttwo;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
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
        Cursor cursor = DatabaseHelper.getInstance(RosterList.this).getRosterData();

        DatabaseUtils.dumpCursor(cursor);

        CursorAdapter rosterAdapter = new CursorAdapter(this, cursor, 0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.activity_roster_items, parent,false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView rosterPlayerName = (TextView) view.findViewById(R.id.roster_player_name);
                String playerNamesGetter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NAME));
                rosterPlayerName.setText(playerNamesGetter);

                TextView rosterYear = (TextView) view.findViewById(R.id.roster_year);
                String rookieYearGetter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ROOKIE_YEAR));
                rosterYear.setText(rookieYearGetter);
            }
        };

        rosterList.setAdapter(rosterAdapter);

    }
}