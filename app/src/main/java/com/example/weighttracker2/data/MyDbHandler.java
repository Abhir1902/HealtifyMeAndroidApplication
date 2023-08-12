package com.example.weighttracker2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.weighttracker2.model.UserData;
import com.example.weighttracker2.params.Params;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.ID + " INTEGER PRIMARY KEY," +
                Params.NAME + " TEXT, " +
                Params.AGE + " TEXT, " +
                Params.HEIGHT + " TEXT, " +
                Params.WEIGHT + " TEXT, " +
                Params.GENDER + " TEXT" +")";
        //nameTEXT
        Log.d("dbharry", "Query being run is : "+ create);
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(String name,String age,String height,String weight,String gender){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.NAME, name);
        values.put(Params.AGE, age);
        values.put(Params.HEIGHT, height);
        values.put(Params.WEIGHT, weight);
        values.put(Params.GENDER, gender);

        db.insert(Params.TABLE_NAME, null, values);
        Log.d("dbharry", "Successfully inserted");
        db.close();

    }

//    public List<Contact> getAllContacts(){
//        List<Contact> contactList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // Generate the query to read from the database
//        String select = "SELECT * FROM " + Params.TABLE_NAME;
//        Cursor cursor = db.rawQuery(select, null);
//
//        //Loop through now
//        if(cursor.moveToFirst()){
//            do{
//                Contact contact = new Contact();
//                contact.setId(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhone_number(cursor.getString(2));
//                contactList.add(contact);
//            }while(cursor.moveToNext());
//        }
//        return contactList;
//    }
//
    public int updateuser(UserData user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.NAME, user.getName());
        values.put(Params.AGE, user.getAge());
        values.put(Params.HEIGHT, user.getHeight());
        values.put(Params.WEIGHT, user.getWeight());
        values.put(Params.GENDER, user.getGender());

        //Lets update now
        return db.update(Params.TABLE_NAME, values, Params.ID + "=?",
                new String[]{String.valueOf(user.getId())});
    }
//
//    public void deleteContactById(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(id)});
//        db.close();
//    }
//
//    public void deleteContact(Contact contact){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(Params.TABLE_NAME, Params.KEY_ID +"=?", new String[]{String.valueOf(contact.getId())});
//        db.close();
//    }
//
//    public int getCount(){
//        String query = "SELECT  * FROM " + Params.TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor.getCount();
//
//    }

}


