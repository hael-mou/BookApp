package com.elmoudden.bookapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.elmoudden.bookapp.MyDataBase.BOOK_author;

public class DatabaseAccess {

    private SQLiteDatabase dataBase;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new MyDataBase(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null ){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.dataBase = this.openHelper.getWritableDatabase();
    }
    public void close(){
       if (this.dataBase != null){
           this.dataBase.close();
       }
    }


    public ArrayList<Book> getAllBooks(){
        ArrayList <Book> books = new ArrayList<>();
        Cursor cursor = this.dataBase.rawQuery("SELECT * FROM "+MyDataBase.BOOK_TB_NAME,null);
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_id));
                String title = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_title));
                String author= cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_author));
                int ratingScore = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ratingScore));
                int page = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_page));
                int reviews = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_reviews));
                books.add(new Book(title,author,null,id,ratingScore,page,reviews,0));
            }while (cursor.moveToNext());
            cursor.close();
        }

        return books;
    }

    public ArrayList<Book> getBook(String titleSearch){
        ArrayList <Book> books = new ArrayList<>();
        Cursor cursor = this.dataBase.rawQuery("SELECT * FROM "+MyDataBase.BOOK_TB_NAME+" WHERE "+MyDataBase.BOOK_title+"=?",new String[]{titleSearch});
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_id));
                String title = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_title));
                String author= cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_author));
                int ratingScore = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ratingScore));
                int page = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_page));
                int reviews = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_reviews));
                int imageid = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ImageId));
                String category = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_Category));
                books.add(new Book(title,author,category,id,ratingScore,page,reviews,imageid));
            }while (cursor.moveToNext());
            cursor.close();
        }
        return books;
    }

    public ArrayList<Book> getBookAuthor(String authorSearch){
        ArrayList <Book> books = new ArrayList<>();
        Cursor cursor = this.dataBase.rawQuery("SELECT * FROM "+MyDataBase.BOOK_TB_NAME+" WHERE "+BOOK_author+"=?",new String[]{authorSearch});
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_id));
                String title = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_title));
                String author= cursor.getString(cursor.getColumnIndex(BOOK_author));
                int ratingScore = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ratingScore));
                int page = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_page));
                int reviews = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_reviews));
                int imageid = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ImageId));
                String category = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_Category));
                books.add(new Book(title,author,category,id,ratingScore,page,reviews,imageid));
            }while (cursor.moveToNext());
            cursor.close();
        }
        return books;
    }

    public ArrayList<Book> getBook(int ratingScoreSearch){
        ArrayList <Book> books = new ArrayList<>();
        Cursor cursor = this.dataBase.rawQuery("SELECT * FROM "+MyDataBase.BOOK_TB_NAME+" WHERE "+MyDataBase.BOOK_ratingScore+"=?",new String[]{ratingScoreSearch+""});
        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_id));
                String title = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_title));
                String author= cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_author));
                int ratingScore = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ratingScore));
                int page = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_page));
                int reviews = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_reviews));
                int imageid = cursor.getInt(cursor.getColumnIndex(MyDataBase.BOOK_ImageId));
                String category = cursor.getString(cursor.getColumnIndex(MyDataBase.BOOK_Category));
                books.add(new Book(title,author,category,id,ratingScore,page,reviews,imageid));
            }while (cursor.moveToNext());
            cursor.close();
        }
        return books;
    }

    public long getNumberBooks(){
        return DatabaseUtils.queryNumEntries(this.dataBase,MyDataBase.BOOK_TB_NAME);
    }
}
