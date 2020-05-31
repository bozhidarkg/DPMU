package com.example.dpmu1;

import android.app.admin.DelegatedAdminReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public DBManager(Context c) {
        this.context = c;
    }

    public DBManager() {

    }

    public DBManager open() throws SQLException{
        this.dbHelper = new DatabaseHelper(this.context);
        this.database=this.dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        this.dbHelper.close();
    }
    public void insert(String name, String desc) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.COL_2, name);
        contentValue.put(DatabaseHelper.COL_3, desc);
        this.database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }
   public Cursor fetch(){
        Cursor cursor = this.database.query(DatabaseHelper.TABLE_NAME, new String[]{DatabaseHelper.COL_2,DatabaseHelper.COL_3,DatabaseHelper.COL_4},null,null,null,null,null);
       if (cursor != null) {
           cursor.moveToFirst();
       }
       return cursor;
   }
    public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, desc);
        return this.database.update(DatabaseHelper.TABLE_NAME, contentValues, "_id = " + _id, null);
    }

    public void delete(long _id) {
        this.database.delete(DatabaseHelper.TABLE_NAME, "_id=" + _id, null);
    }
}
