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
        String profilePlayerID = intent.getStringExtra("playerID");
        String profilePlayerName = intent.getStringExtra("playerName");
        String profileNumber = intent.getStringExtra("playerNum");
        String profileRookieYear = intent.getStringExtra("rookieYear");
        String profilePlayerPosition = intent.getStringExtra("playerPosition");
        //String playerIsStarter = intent.getStringExtra("playerIsStarter");

        TextView profileID = (TextView) findViewById(R.id.profile_player_ID);
        profileID.setText(profilePlayerID);
        TextView profileName = (TextView) findViewById(R.id.profile_player_name);
        profileName.setText(profilePlayerName);
        TextView profileplayerNum = (TextView) findViewById(R.id.profile_player_number);
        profileplayerNum.setText(profileNumber);
        TextView profileYear = (TextView) findViewById(R.id.profile_rookie_year);
        profileYear.setText(profileRookieYear);
        TextView profilePosition = (TextView) findViewById(R.id.profile_position);
        profilePosition.setText(profilePlayerPosition);

    }
}


//intent.putExtra("playerID", playerDBID);
//intent.putExtra("playerName", playerNameForIntent);
//        intent.putExtra("playerNum", playerNumForIntent);
//        intent.putExtra("rookieYear", playerRookieYearForIntent);
//        intent.putExtra("playerPosition", playerPositionForIntent);
//        intent.putExtra("playerIsStarter", playerIsStarter);