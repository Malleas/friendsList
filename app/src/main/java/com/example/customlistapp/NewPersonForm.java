package com.example.customlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_cancel, btn_ok;
    EditText et_name, et_age, et_photoNumber;
    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        et_photoNumber = findViewById(R.id.et_pictureNumber);

        Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent != null){
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int pictureNumber = incomingIntent.getInt("pictureNumber");
            positionToEdit = incomingIntent.getInt("edit");

            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_photoNumber.setText(Integer.toString(pictureNumber));
        }


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPictureNumber = et_photoNumber.getText().toString();

                Intent intent= new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("edit", positionToEdit);
                intent.putExtra("name", newName);
                intent.putExtra("age", newAge);
                intent.putExtra("pictureNumber", newPictureNumber);
                startActivity(intent);
            }
        });
    }
}
