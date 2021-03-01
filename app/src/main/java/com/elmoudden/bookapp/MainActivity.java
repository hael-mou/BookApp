package com.elmoudden.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_item);

        DatabaseAccess database;
        ArrayList<Book> books;

        database = DatabaseAccess.getInstance(this);
        database.open();
        books = database.getAllBooks();
        database.close();

        BookAdapter adapter = new BookAdapter(books);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        list.setLayoutManager(lm);
        list.hasFixedSize();
        list.setAdapter(adapter);
    }



}