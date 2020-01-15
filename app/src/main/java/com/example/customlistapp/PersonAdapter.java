package com.example.customlistapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends BaseAdapter {

    Activity mActivity;
    MyFriends myFriends;

    public PersonAdapter(Activity mActivity, MyFriends myFriends) {
        this.mActivity = mActivity;
        this.myFriends = myFriends;
    }

    @Override
    public int getCount() {
        return myFriends.myFriendsList.size();
    }

    @Override
    public Person getItem(int position) {
        return myFriends.myFriendsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View onePersonLine;
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);
        TextView tv_name = onePersonLine.findViewById(R.id.tv_nameLabel);
        TextView tv_age = onePersonLine.findViewById(R.id.tv_ageLabel);
        ImageView iv_avatar = onePersonLine.findViewById(R.id.iv_avatar);

        Person person = this.getItem(position);
        int icon_resource_numbers [] = {
              R.drawable.image_001,
              R.drawable.image_002,
              R.drawable.image_003,
              R.drawable.image_004,
              R.drawable.image_005,
              R.drawable.image_006,
              R.drawable.image_007,
              R.drawable.image_008,
              R.drawable.image_009,
              R.drawable.image_010,
              R.drawable.image_011,
              R.drawable.image_012,
              R.drawable.image_013,
              R.drawable.image_014,
              R.drawable.image_015,
              R.drawable.image_016
        };

        tv_name.setText(person.getName());
        tv_age.setText(Integer.toString(person.getAge()));
        iv_avatar.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
