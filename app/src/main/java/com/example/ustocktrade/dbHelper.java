package com.example.ustocktrade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper
{
    public static final String TABLE_NAME ="user";
    public static final String COL_1 ="email";
    public static final String COL_2 ="password";



    public dbHelper(Context context) {
        super(context, "ustock.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        //onCreate(db);

    }

//    public Cursor getAllData()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cu = db.rawQuery("select * from " + TABLE_NAME,null);
//        return cu;
//    }

    public boolean updateData(String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,email);
        cv.put(COL_2,password);
        db.update(TABLE_NAME,cv,"EMAIL = ?",new String[]{email});
        return true;

    }
}
