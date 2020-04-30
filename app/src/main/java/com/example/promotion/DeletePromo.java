package com.example.promotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePromo extends AppCompatActivity {
    EditText id;
    Button btndeleteService;
    PromoDB deleteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_promo);

        id =findViewById(R.id.deleteId);
        deleteService = new PromoDB(this);
        btndeleteService =findViewById(R.id.btnservicedDelete);
        DeleteData();
    }
    public void DeleteData(){
        btndeleteService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = deleteService.deleteData(id.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(DeletePromo.this, "Data Delete!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DeletePromo.this, "DaTa not Deleted", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
