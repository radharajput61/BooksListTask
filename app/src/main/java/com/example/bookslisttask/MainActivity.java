package com.example.bookslisttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView cd_fiction,cd_drama,cd_HOMOUR,POLITICS,PHILOSOPHY,HISTORY,ADVENTURE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cd_fiction=findViewById(R.id.cd_fiction);
        cd_drama=findViewById(R.id.cd_drama);
        cd_HOMOUR=findViewById(R.id.cd_HOMOUR);
        POLITICS=findViewById(R.id.POLITICS);
        PHILOSOPHY=findViewById(R.id.PHILOSOPHY);
        HISTORY=findViewById(R.id.HISTORY);
        ADVENTURE=findViewById(R.id.ADVENTURE);
        cd_fiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Fiction"));
            }
        });

        cd_drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Drama"));
            }
        });

        cd_HOMOUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Homour"));
            }
        });

        POLITICS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Politics"));
            }
        });

        PHILOSOPHY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Philosophy"));
            }
        });

        HISTORY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","History"));
            }
        });

        ADVENTURE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BookList.class).putExtra("title","Adventure"));
            }
        });
    }
}