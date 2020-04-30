package com.example.promotion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddPromo extends AppCompatActivity {
    Button btnAdd,btnview,btnEdit,btnDelete,btnBook;
    PromoDB  myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promo);

        myDb = new PromoDB(this);
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
                Intent intent = new Intent(getApplicationContext(),FormPromo.class);
                startActivity(intent);
            }
        });

        //Delete Section
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DeletePromo.class);
                startActivity(intent);
            }
        });

        //Edit Service
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EditPromo.class);
                startActivity(intent);
            }
        });

    }

    public void viewAll(){
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() <= 0){
                    //Show Message
                    ShowMessages("Error", "Nothing Found");
                }else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("ID : " + res.getString(0) + "\n");
                        buffer.append("Customer Name :" + res.getString(1) + "\n");
                        buffer.append("Car No :" + res.getString(2) + "\n");
                        buffer.append("Mobile No :" + res.getString(3) + "\n");
                        buffer.append("Promo Code : " + res.getString(4) + "\n\n");

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
