package com.example.employeezy.adiprojecttwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PlayerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);


        Intent intent = getIntent();

        //sets variables and puts data from intent from either MainActivity, RosterList, or StarterList
        //into a template for a Profile view

        String profilePlayerName = intent.getStringExtra("playerName");
        String profileNumber = intent.getStringExtra("playerNum");
        String profileRookieYear = intent.getStringExtra("rookieYear");
        String profilePlayerPosition = intent.getStringExtra("playerPosition");
        //String playerIsStarter = intent.getStringExtra("playerIsStarter");
        //String profilePlayerID = intent.getStringExtra("playerID");

        TextView profileName = (TextView) findViewById(R.id.profile_player_name);
        profileName.setText(profilePlayerName);
        TextView profileplayerNum = (TextView) findViewById(R.id.profile_player_number);
        profileplayerNum.setText("#" + profileNumber);
        TextView profileYear = (TextView) findViewById(R.id.profile_rookie_year);
        profileYear.setText("Has been in the NBA since " + profileRookieYear);
        TextView profilePosition = (TextView) findViewById(R.id.profile_position);
        profilePosition.setText("He is a " + profilePlayerPosition + " for Los Angeles");

    }
}
