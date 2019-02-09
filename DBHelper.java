package com.example.oheunji.chungmuro;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT,price INTEGER,item TEXT, create_at TEXT, store TEXT);");

        //db.execSQL("CREATE TABLE MONEYBOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT, price INTEGER, create_at1 TEXT, store TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String create_at, String item, int price, String store) {

        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO MONEYBOOK VALUES(null,'" + store + "', '" + item + "', " + price + ", '" + create_at + "');");
        db.close();

        // 이거추가했음
        //
    }

    public void update(String item, int price) {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("UPDATE MONEYBOOK SET price=" + price + " WHERE item='" + item + "';");
        db.close();
    }

    public void delete(String item) {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE FROM MONEYBOOK WHERE item='" + item + "';");
        db.close();
    }

    public String getResult(String storeName) {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        /*String result_id = "";
        String result_date = "";
        String result_grade = "";
        String result_review = "";
        String result_shop = "";
        List<String> result_all;*/
        String[][] result_all = new String[4][];


        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK WHERE item = ? ORDER BY _id DESC"  , new String[]{storeName});
        while (cursor.moveToNext()) {
            result += "010님"//cursor.getString(0)
                    + "   "//" 날짜:"
                    + cursor.getString(4)
                    + "    "//" 평점: "
                    + cursor.getInt(3)
                    + "점    "//" 리뷰: "
                    + cursor.getString(1)
                    //+ " 식당이름: "
                    //+ cursor.getString(2)
                    + "\n";
        }

        return result;
    }
}