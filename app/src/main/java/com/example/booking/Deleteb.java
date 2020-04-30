package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Deleteb extends AppCompatActivity {

    EditText id;
    Button btndeleteService;
    bookDB deleteService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteb);


        id =findViewById(R.id.deleteId);
        deleteService = new bookDB(this);
        btndeleteService =findViewById(R.id.btnservicedDelete);
        DeleteData();
    }
    public void DeleteData(){
        btndeleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = deleteService.deleteData(id.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(Deleteb.this, "Data Delete!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Deleteb.this, "DaTa not Deleted", Toast.LENGTH_SHORT).show();
                }

                Intent intent =new Intent(getApplicationContext(),Opt.class);
                startActivity(intent);
            }
        });
    }

}
