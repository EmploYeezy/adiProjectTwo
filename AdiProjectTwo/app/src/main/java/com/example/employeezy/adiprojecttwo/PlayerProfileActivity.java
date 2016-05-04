package com.example.employeezy.adiprojecttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayerProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        Intent intent = getIntent();
        String profilePLayerName = intent.getStringExtra("playerName");
        TextView textView = (TextView) findViewById(R.id.made_it);
        textView.setText(profilePLayerName);

    }
}
