package com.example.coworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity3 extends AppCompatActivity {

    private ImageButton bookStation,roomMeeting;

    //book history button
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = findViewById(R.id.buttonHS);

        bookStation = findViewById(R.id.bookStation);
        roomMeeting = findViewById(R.id.meetingRoom);

        //OnClick For Book Work Station
        bookStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity3.this, SelectDate.class);
                startActivity(intent);
            }
        });

        //OnClick Meeting Room

        roomMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, AvailableDesk.class);
                startActivity(intent);
            }
        });

        //Book History

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, BookHistory.class);
                startActivity(intent);
            }
        });

    }
}