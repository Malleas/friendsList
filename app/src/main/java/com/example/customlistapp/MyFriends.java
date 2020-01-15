package com.example.customlistapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFriends {

    List<Person> myFriendsList;

    public MyFriends(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }

    public MyFriends(){
        String [] startingNames = {"Alice", "Bob", "Charles"};
        this.myFriendsList = new ArrayList<>();
        Random rng = new Random();
        for(int i = 0; i < startingNames.length; i++){
            Person person = new Person(startingNames[i], rng.nextInt(50) + 15, rng.nextInt(18));
            myFriendsList.add(person);
        }
    }

    public List<Person> getMyFriendsList() {
        return myFriendsList;
    }

    public void setMyFriendsList(List<Person> myFriendsList) {
        this.myFriendsList = myFriendsList;
    }
}
