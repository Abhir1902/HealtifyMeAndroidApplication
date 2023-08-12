package com.example.weighttracker2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCounter extends SQLiteOpenHelper {
    public DBCounter(Context context) {
        super(context, "CalorieData.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table CalorieTracker(name TEXT primary key, calorie INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists CalorieTracker");
    }
    public Boolean insertfooddata(String name, String calorie)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("calorie", calorie);

        long result=DB.insert("CalorieTracker", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updatefooddata(String name, String calorie)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("calorie", calorie);

        Cursor cursor = DB.rawQuery("Select * from CalorieTracker where name = ?", new String[]{name});

        if (cursor.getCount() > 0) {
            long result = DB.update("CalorieTracker", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
   /* public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("CalorieTracker", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }*/

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from CalorieTracker", null);
        return cursor;
    }
}
