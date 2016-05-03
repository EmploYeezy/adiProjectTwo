package com.example.employeezy.adiprojecttwo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button rosterListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rosterListButton = (Button) findViewById(R.id.roster_list_button);
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


        //hardcoded seed data for the database
        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Jordan Clarkson", "2014");
        db.insert(2, "D'Angelo Russel", "2015");

        //really lame output test
        Player retrievedPlayer = db.getPlayer(2);
        ((TextView)findViewById(R.id.text)).setText(retrievedPlayer.toString());
    }

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
            Toast.makeText(MainActivity.this,"Searching for "+query,Toast.LENGTH_SHORT).show();
        }

    }

}
