package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editb extends AppCompatActivity {

    EditText id,userName, userCarNo, userDate,userTime;
    Button btnUpdate;
    bookDB myDbUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editb);

        myDbUpdate = new bookDB(this);
        id =findViewById(R.id.id);
        userName = findViewById(R.id.userName);
        userCarNo = findViewById(R.id.userCarNo);
        userDate = findViewById(R.id.userDate);
        userTime = findViewById(R.id.userTime);
        btnUpdate = findViewById(R.id.btnUpdate);
        UpdateData();
    }

    public  void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDbUpdate.updateData( id.getText().toString(),userName.getText().toString(),userCarNo.getText().toString(),userDate.getText().toString(),userTime.getText().toString());
                if(isUpdated == true ){
                    Toast.makeText(Editb.this, "DaTa Update", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Editb.this, "DaTa not Update", Toast.LENGTH_SHORT).show();
                }
                Intent intent =new Intent(getApplicationContext(),Opt.class);
                startActivity(intent);
            }
        });
    }
}
