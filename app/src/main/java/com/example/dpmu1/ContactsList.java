package com.example.dpmu1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactsList extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;

    EditText mTextCity;
    Button mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        mBackButton = (Button) findViewById(R.id.back);

       String querry = "Select ID, NAME, PHONE, CITY FROM contact.db";
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(ContactsList.this,MainActivity.class);
                startActivity(listIntent);
            }
        });
        String user = mTextUsername.getText().toString().trim();

        String city = mTextCity.getText().toString().trim();

    }
}
