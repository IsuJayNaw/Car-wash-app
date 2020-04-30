package com.example.booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class bookDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "Washus.db";
    public static final String TABLE_NAME = "Booking_table";
    public static final String COL_1= "ID";
    public static final String COL_2= "Name";
    public static final String COL_3= "CAR_NO";
    public static final String COL_4= "Date";
    public static final String COL_5= "Time";

    public bookDB(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create batabse
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, CAR_NO TEXT,Date TEXT,Time TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }

    //Insert data

    public boolean insertData(String Name,String car_no,String Date, String Time){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,Date);
        contentValues.put(COL_5,Time);
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

    public boolean updateData(String id, String Name, String car_no, String Date, String Time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,car_no);
        contentValues.put(COL_4,Date);
        contentValues.put(COL_5,Time);

        db.update(TABLE_NAME,contentValues,"ID = ? ", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"ID =?", new String[]{id});

    }




}
