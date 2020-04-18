package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Formpreview extends AppCompatActivity {
    DatabaseHelper myDb;
    Button btnAddData;
    EditText userMobile, userCarNo, userCarModel, userService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formpreview);


        myDb = new DatabaseHelper(this);
        userMobile = findViewById(R.id.userMobile);
        userCarNo = findViewById(R.id.userCarNo);
        userCarModel = findViewById(R.id.userCarModel);
        userService = findViewById(R.id.userService);
        btnAddData = findViewById(R.id.btnAddData);
        AddData();
    }


    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(userMobile.getText().toString(),userCarNo.getText().toString(),userCarModel.getText().toString(),userService.getText().toString());

                if(isInserted == true ){
                    Toast.makeText(Formpreview.this, "DaTa Inserted", Toast.LENGTH_LONG).show();
                    //Toasty.success(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                }else {
                   // Toasty.error(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                    Toast.makeText(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                }

                Intent intent =new Intent(getApplicationContext(),Options.class);
                startActivity(intent);

            }
        });
    }
}
