package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditServiceDetails extends AppCompatActivity {

    EditText serviceId,userMobile, userCarNo, userCarModel,userService;
    Button btnUpdate;
    DatabaseHelper myDbUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_service_details);

        myDbUpdate = new  DatabaseHelper(this);
        serviceId =findViewById(R.id.serviceId);
        userMobile = findViewById(R.id.userMobile);
        userCarNo = findViewById(R.id.userCarNo);
        userCarModel = findViewById(R.id.userCarModel);
        userService = findViewById(R.id.userService);
        btnUpdate = findViewById(R.id.btnUpdate);
        UpdateData();
    }

    public  void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDbUpdate.updateData(serviceId.getText().toString(),userMobile.getText().toString(),userCarNo.getText().toString(),userCarModel.getText().toString(),userService.getText().toString());
                if(isUpdated == true ){
                    Toast.makeText(EditServiceDetails.this, "DaTa Update", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(EditServiceDetails.this, "DaTa not Update", Toast.LENGTH_SHORT).show();
                }
                Intent intent =new Intent(getApplicationContext(),Options.class);
                startActivity(intent);
            }
        });
    }
}
