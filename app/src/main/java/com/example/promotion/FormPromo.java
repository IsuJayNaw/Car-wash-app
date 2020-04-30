package com.example.promotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormPromo extends AppCompatActivity {
    PromoDB myDb;
    Button btnAddData;
    EditText customername, userCarNoo, umobileno, promocode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_promo);

        myDb = new PromoDB(this);
        customername = findViewById(R.id.customername);
        userCarNoo = findViewById(R.id.userCarNoo);
        umobileno = findViewById(R.id.umobileno);
        promocode = findViewById(R.id.promocode);
        btnAddData = findViewById(R.id.btnAddData);
        AddData();
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(customername.getText().toString(),userCarNoo.getText().toString(),umobileno.getText().toString(),promocode.getText().toString());

                if(isInserted == true ){
                    Toast.makeText(FormPromo.this, "DaTa Inserted", Toast.LENGTH_LONG).show();
                    //Toasty.success(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();


                }else {
                    // Toasty.error(Formpreview.this, "Data Insert!", Toast.LENGTH_LONG).show();
                    Toast.makeText(FormPromo.this, "Data Insert!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}
