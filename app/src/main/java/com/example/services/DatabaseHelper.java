package com.example.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Washus.db";
    public static final String TABLE_NAME = "service_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "MOBILE";
    public static final String COL_3= "CAR_NO";
    public static final String COL_4= "CAR_MODEL";
    public static final String COL_5= "SERVICE";

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create batabse
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, MOBILE TEXT, CAR_NO TEXT,CAR_MODEL TEXT,SERVICE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    //Insert data

    public boolean insertData(String mobile,String car_no,String car_model, String service){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,mobile);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,car_model);
        contentValues.put(COL_5,service);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1){
            return false;
        }else {
            return true;
        }

    }
    //Get All data
    public Cursor getAllData(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res =db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }

    //Update data

    public boolean updateData(String id, String mobile, String car_no, String car_model, String service){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,mobile);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,car_model);
        contentValues.put(COL_5,service);

        db.update(TABLE_NAME,contentValues,"ID = ? ", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"ID =?", new String[]{id});

    }
}
