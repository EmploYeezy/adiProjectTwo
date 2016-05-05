package com.example.employeezy.adiprojecttwo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

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

    //search toolbar inflater
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
            Cursor cursor = DatabaseHelper.getInstance(MainActivity.this).searchNames(query);


        }

    }

}
