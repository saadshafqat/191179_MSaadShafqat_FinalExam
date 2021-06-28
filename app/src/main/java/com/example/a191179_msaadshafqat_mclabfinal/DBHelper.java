package com.example.a191179_msaadshafqat_mclabfinal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.fragment.app.Fragment;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Fragment context) {
        super(context.getContext(), "hobbiesrecord.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table hobbies(name TEXT , time TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop Table if exists hobbies");


    }
    public Boolean insertData(String Name,String Time)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", Name);
        contentValues.put("time", Time);

        long result=DB.insert("hobbies", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData()
    {
        String query="SELECT* FROM hobbies";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=null;
        if(db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;

    }
}
