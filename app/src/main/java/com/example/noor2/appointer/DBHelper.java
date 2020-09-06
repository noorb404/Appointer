package com.example.noor2.appointer;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "data.db";
    public static final String TABLE_NAME = "CUSTOMER";
    public static final String COL1 = "ID";
    public static final String COL2 = "USERNAME";
    public static final String COL3 = "PASSWORD";
    public static final String COL4 = "PHONE_NUMBER";
    public static final String COL5 = "EMAIL";
    public static final String COL6 = "USER_KIND";
    public static final String COL7 = "SERVICE_KIND";
//    public static final Business COL8 = "Business";

    SQLiteDatabase db;

    /*CONSTRUCTOR ..*/
    public DBHelper(Context c) { super(c,DATABASE_NAME,null,1); }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " USERNAME TEXT, PASSWORD TEXT, PHONE_NUMBER TEXT, EMAIL TEXT, USER_KIND TEXT, SERVICE_KIND TEXT )");
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public boolean addData(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(COL2, user.getUserName());
        con.put(COL3, user.getPassword());
        con.put(COL4, user.getPhoneNumber());
        con.put(COL5, user.getEmail());
        con.put(COL6, user.getUserKind());
        con.put(COL7, user.getServices());

        long result = db.insert(TABLE_NAME, null, con);
        if (result == -1)
            return false;
        return true;
    }
    public boolean updateDB(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put(COL2, user.getUserName());
        con.put(COL3, user.getPassword());
        con.put(COL4, user.getPhoneNumber());
        con.put(COL5, user.getEmail());
        con.put(COL6, user.getUserKind());
        con.put(COL7, user.getServices());
        db.update(TABLE_NAME, con, "USERNAME = ?", new String[] {String.valueOf(user.getUserName())});
        return true;
    }

    public boolean CheckUserName(String Usr,String Pass,String Use){
        ArrayList<User> nn = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        if (c.getCount()==0 && Use.equals("signup"))
            return FALSE;
        c.moveToFirst();
        while (!c.isAfterLast()) {
            nn.add(new User(c.getInt(0), c.getString(1),
                    c.getString(2), c.getString(3), c.getString(4),c.getString(5),c.getString(6)));
            c.moveToNext();
        }
        c.close();
        if(Use.equals("signup")) {
            for (User user : nn) {
                if (user.getUserName().equals(Usr))
                    return TRUE;
            }
            return FALSE;
        }else if(Use.equals("signin"))
        {
            for (User user : nn) {
                if (user.getUserName().equals(Usr))
                    if(user.getPassword().equals(Pass))
                        return FALSE;
            }
        }
        return TRUE;

    }
    public User GetData(String Usr)
    {
        ArrayList<User> nn = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        if (c.getCount()==0)
            return null;
        c.moveToFirst();
        while (!c.isAfterLast()) {
            nn.add(new User(c.getInt(0), c.getString(1),
                    c.getString(2), c.getString(3), c.getString(4),c.getString(5),c.getString(6)));
            c.moveToNext();
        }
        c.close();
        for (User user : nn) {
            if (user.getUserName().equals(Usr))
            {
                return user;
            }

        }
        return null;
    }
    public ArrayList<User> getAll() {
        ArrayList<User> nn = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        if (c.getCount()==0)
            return nn;

        c.moveToFirst(); //IMPORTANT!!!!
        while (!c.isAfterLast()) {
            nn.add(new User(c.getInt(0), c.getString(1),
                    c.getString(2), c.getString(3), c.getString(4),c.getString(5),c.getString(6)));
            c.moveToNext();
        }
        c.close();
        return nn;
    }
}
