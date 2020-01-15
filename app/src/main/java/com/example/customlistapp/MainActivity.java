package com.example.customlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

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

        myFriends = ((MyApplication) this.getApplication()).getMyFriends();
        adapter = new PersonAdapter(MainActivity.this, myFriends);

        lv_people.setAdapter(adapter);

        //listen for incoming msgs
        Bundle incomingMessages = getIntent().getExtras();

        if(incomingMessages != null){
            //capture incoming data
            String name = incomingMessages.getString("name");
            int age = Integer.parseInt(incomingMessages.getString("age"));
            int pictureNumber = Integer.parseInt(incomingMessages.getString("pictureNumber"));
            int positionEdited = incomingMessages.getInt("edit");
            //create new persons object
            Person person = new Person(name, age, pictureNumber);
            //add person to the list and update adapter
            if(positionEdited > -1){
                myFriends.getMyFriendsList().remove(positionEdited);
            }
            myFriends.getMyFriendsList().add(person);
            adapter.notifyDataSetChanged();
        }




        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewPersonForm.class );
                startActivity(intent);
            }
        });

        btn_sortAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriendsList(), new Comparator<Person>() {
                    @Override
                    public int compare(Person person1, Person person2) {
                        return person1.getAge() - person2.getAge();
                    }
                });
                adapter.notifyDataSetChanged();
            }
        });

        btn_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyFriendsList());
                adapter.notifyDataSetChanged();
            }
        });

        lv_people.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });
    }

    public void editPerson(int position){
        Intent intent = new Intent(getApplicationContext(), NewPersonForm.class);

        Person person = myFriends.getMyFriendsList().get(position);
        intent.putExtra("edit", position);
        intent.putExtra("name", person.getName());
        intent.putExtra("age", person.getAge());
        intent.putExtra("pictureNumber", person.getPictureNumber());

        startActivity(intent);

    }
}
