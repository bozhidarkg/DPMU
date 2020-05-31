package com.example.dpmu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;

public class ContactsActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConfPass;
    Button mButtonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_activity);
        mTextUsername = (EditText)findViewById(R.id.regUser);
        mTextPassword = (EditText)findViewById(R.id.regPass);
        mTextConfPass = (EditText)findViewById(R.id.regConfPass);
        mButtonBack = (Button) findViewById(R.id.backBtn);

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(ContactsActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}
