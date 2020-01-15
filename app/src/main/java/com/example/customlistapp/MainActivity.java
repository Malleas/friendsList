package com.example.customlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btn_sortABC, btn_sortAge, btn_add;
    ListView lv_people;

    PersonAdapter adapter;
    MyFriends myFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_sortABC = findViewById(R.id.btn_sortABC);
        btn_sortAge = findViewById(R.id.btn_sortAge);
        lv_people = findViewById(R.id.lv_people);

        myFriends = new MyFriends();
        adapter = new PersonAdapter(MainActivity.this, myFriends);

        lv_people.setAdapter(adapter);
    }
}
