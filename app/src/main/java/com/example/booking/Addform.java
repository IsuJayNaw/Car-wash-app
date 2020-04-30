package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addform extends AppCompatActivity {

    bookDB myDb;
    Button btnAddData;
    EditText userName, userCarNo, userDate, userTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addform);


        myDb = new bookDB(this);
        userName = findViewById(R.id.userName);
        userCarNo = findViewById(R.id.userCarNo);
        userDate = findViewById(R.id.userDate);
        userTime = findViewById(R.id.userTime);
        btnAddData = findViewById(R.id.btnAddData);
        AddData();
    }


    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(userName.getText().toString(),userCarNo.getText().toString(),userDate.getText().toString(),userTime.getText().toString());

                if(isInserted == true ){
                    Toast.makeText(Addform.this, "DaTa Inserted", Toast.LENGTH_LONG).show();
                    //Toasty.success(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                }else {
                    // Toasty.error(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                    Toast.makeText(Addform.this, "Data Insert!", Toast.LENGTH_LONG).show();
                }

                Intent intent =new Intent(getApplicationContext(),Opt.class);
                startActivity(intent);

            }
        });
    }
}
