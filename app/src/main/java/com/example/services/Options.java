package com.example.services;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Options extends AppCompatActivity {
    Button btnAdd,btnview,btnEdit,btnDelete,btnBook;
    DatabaseHelper  myviewDb;

    //logingit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        myviewDb = new DatabaseHelper(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnview = findViewById(R.id.btnDataView);
        btnEdit= findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnBook = findViewById(R.id.btnBook);
        viewAll();


        //Add Service
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Formpreview.class);
                startActivity(intent);
            }
        });

        //Delete Section
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeleteService.class);
                startActivity(intent);
            }
        });

        //Edit Service
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EditServiceDetails.class);
                startActivity(intent);
            }
        });
    }


    public void viewAll(){
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myviewDb.getAllData();
                if (res.getCount() <= 0){
                    //Show Message
                    ShowMessages("Error", "Nothing Found");
                }else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID : " + res.getString(0) + "\n");
                        buffer.append("Mobile :" + res.getString(1) + "\n");
                        buffer.append("Car No :" + res.getString(2) + "\n");
                        buffer.append("Car Model :" + res.getString(3) + "\n");
                        buffer.append("Service : " + res.getString(4) + "\n\n");

                    }
                    //Show all data
                    ShowMessages("Data", buffer.toString());
                }
            }
        });
    }

    public  void ShowMessages(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
