package com.example.employeezy.adiprojecttwo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StarterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_list);

        final ListView starterList = (ListView) findViewById(R.id.starter_list);
        final Cursor cursor = DatabaseHelper.getInstance(StarterList.this).getStarterData();

        CursorAdapter starterAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.activity_starter_items, parent, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView starterPlayerName = (TextView) view.findViewById(R.id.starter_player_name);
                String starterNamesGetter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NAME));
                starterPlayerName.setText(starterNamesGetter);

                TextView startingPosition = (TextView) view.findViewById(R.id.starter_position);
                String startingPositionGetter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_POSITION));
                startingPosition.setText(startingPositionGetter);
            }
        };

        starterList.setAdapter(starterAdapter);
        //sends all the player information to the profile view
        starterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), PlayerProfileActivity.class);
                String playerDBID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_ID));
                String playerNameForIntent = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NAME));
                String playerNumForIntent = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NUM));
                String playerRookieYearForIntent = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ROOKIE_YEAR));
                String playerPositionForIntent = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_POSITION));
                String playerIsStarter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_IS_STARTER));
                intent.putExtra("playerID", playerDBID);
                intent.putExtra("playerName", playerNameForIntent);
                intent.putExtra("playerNum", playerNumForIntent);
                intent.putExtra("rookieYear", playerRookieYearForIntent);
                intent.putExtra("playerPosition", playerPositionForIntent);
                intent.putExtra("playerIsStarter", playerIsStarter);
                startActivity(intent);
            }
        });

    }
}
