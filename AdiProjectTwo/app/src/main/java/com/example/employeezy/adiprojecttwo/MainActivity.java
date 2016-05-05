package com.example.employeezy.adiprojecttwo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button rosterListButton;
    Button startersButton;

    //Buttons on home screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleIntent(getIntent());

        //makes the Player button on the homes screen goto the roster list
        rosterListButton = (Button) findViewById(R.id.roster_list_button);
        rosterListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent engageRoster = new Intent(MainActivity.this, RosterList.class);
                startActivity(engageRoster);
            }
        });
        //makes the Starting Lineup button on the home screen goto the starters list
        startersButton = (Button) findViewById(R.id.starters_button);
        startersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent engageStarters = new Intent(MainActivity.this, StarterList.class);
                startActivity(engageStarters);
            }
        });
    }

    ////Beings search function.
    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    ///search toolbar inflater
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    //search action
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            //This if statement uses a Regex to determine if the input from the user is an Integer
            //or a string. If it's an integer the cursor goes to searchForNumbers, else searchNames.
            final Cursor cursor;
            if(query.matches("^-?\\d+$"))
                cursor = DatabaseHelper.getInstance(MainActivity.this).searchForNumbers(Integer.parseInt(query));
            else
                cursor = DatabaseHelper.getInstance(MainActivity.this).searchNames(query);

            ListView mainActivityList = (ListView) findViewById(R.id.main_activity_list);

            //search result shower
            CursorAdapter mainActivityAdapter = new CursorAdapter(this, cursor, 0) {
                @Override
                public View newView(Context context, Cursor cursor, ViewGroup parent) {
                    LayoutInflater layoutInflater = LayoutInflater.from(context);
                    View view = layoutInflater.inflate(R.layout.activity_main_items, parent, false);
                    return view;
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    TextView mainPLayerName = (TextView) view.findViewById(R.id.main_player_name);
                    String playNamesGetter = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PLAYER_NAME));
                    mainPLayerName.setText(playNamesGetter);
                }
            };
            mainActivityList.setAdapter(mainActivityAdapter);

            //Sends player profile data to be populated in profile view
            mainActivityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
}
