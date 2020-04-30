package com.example.promotion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PromoDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Promotion.db";
    public static final String TABLE_NAME = "promotion_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "CustomerName";
    public static final String COL_3= "CAR_NO";
    public static final String COL_4= "MobileNo";
    public static final String COL_5= "Promocode";

    public PromoDB(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, CustomerName TEXT, CAR_NO TEXT,MobileNo TEXT,Promocode TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    //Insert data

    public boolean insertData(String CustomerName,String car_no,String MobileNo,String Promocode){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,CustomerName);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,MobileNo);
        contentValues.put(COL_5,Promocode);
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

    public boolean updateData(String id, String CustomerName, String car_no, String MobileNo, String Promocode){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,CustomerName);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,MobileNo);
        contentValues.put(COL_5,Promocode);

        db.update(TABLE_NAME,contentValues,"ID = ? ", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"ID =?", new String[]{id});

    }


}
