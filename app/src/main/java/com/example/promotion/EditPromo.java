package com.example.promotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPromo extends AppCompatActivity {
    EditText promoId,customername, userCarNoo, umobileno,promocode;
    Button btnUpdate;
    PromoDB myDbUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_promo);

        myDbUpdate = new PromoDB(this);
        promoId =findViewById(R.id.promoId);
        customername = findViewById(R.id.customername);
        userCarNoo = findViewById(R.id.userCarNoo);
        umobileno = findViewById(R.id.umobileno);
        promocode = findViewById(R.id.promocode);
        btnUpdate = findViewById(R.id.btnUpdate);
        UpdateData();
    }
    public  void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDbUpdate.updateData(promoId.getText().toString(),customername.getText().toString(),userCarNoo.getText().toString(),umobileno.getText().toString(),promocode.getText().toString());
                if(isUpdated == true ){
                    Toast.makeText(EditPromo.this, "DaTa Update", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EditPromo.this, "DaTa not Update", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
