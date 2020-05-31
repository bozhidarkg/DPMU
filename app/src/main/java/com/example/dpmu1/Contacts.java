package com.example.dpmu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Contacts extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPhone;
    EditText mTextCity;
    Button mButtonAdd;
   Button mViewContacts;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.userName);
        mTextPhone = (EditText)findViewById(R.id.userPhone);
        mTextCity = (EditText)findViewById(R.id.userCity);
        mButtonAdd = (Button) findViewById(R.id.addUser);
        mViewContacts = (Button) findViewById(R.id.checkPhone);

        mViewContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(Contacts.this,ContactsList.class);
                startActivity(listIntent);
            }
        });
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String phone = mTextPhone.getText().toString().trim();
                String city = mTextCity.getText().toString().trim();


                    db.addUser(user,phone,city);
                    Toast.makeText(Contacts.this, "Sucesfully added contact", Toast.LENGTH_SHORT).show();

                }



        });

    }
}
