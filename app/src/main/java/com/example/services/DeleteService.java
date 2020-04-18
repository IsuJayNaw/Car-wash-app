package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteService extends AppCompatActivity {
    EditText id;
    Button btndeleteService;
    DatabaseHelper deleteService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_service);


        id =findViewById(R.id.deleteId);
        deleteService = new DatabaseHelper(this);
        btndeleteService =findViewById(R.id.btnservicedDelete);
        DeleteData();
    }
    public void DeleteData(){
        btndeleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = deleteService.deleteData(id.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(DeleteService.this, "Data Delete!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DeleteService.this, "DaTa not Deleted", Toast.LENGTH_SHORT).show();
                }

                Intent intent =new Intent(getApplicationContext(),Options.class);
                startActivity(intent);
            }
        });
    }

}
