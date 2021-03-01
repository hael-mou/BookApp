package com.elmoudden.bookapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDataBase extends SQLiteAssetHelper {

    public static final String DB_NAME = "books.db";
    public static final int DB_VERSION = 1;

    public static final String BOOK_TB_NAME = "BOOKs";
    public static final String BOOK_id = "id";
    public static final String BOOK_title = "title";
    public static final String BOOK_author = "author";
    public static final String BOOK_ratingScore = "ratingScore";
    public static final String BOOK_page = "n_page";
    public static final String BOOK_reviews = "n_reviews";
    public static final String BOOK_ImageId = "imageID";
    public static final String BOOK_Category = "Category";

    public MyDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

}
