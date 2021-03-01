package com.elmoudden.bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     private RecyclerView list;
     private ArrayList<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findview();
        addImage();
        BookAdapter adapter = new BookAdapter(books);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

        list.setLayoutManager(lm);
        list.hasFixedSize();
        list.setAdapter(adapter);

    }

    private void findview(){
        list = findViewById(R.id.list_item);
    }

    private void addImage(){
    DatabaseAccess database;
    database = DatabaseAccess.getInstance(this);
    database.open();
    books = database.getAllBooks();
    books.get(1).setImageid(R.drawable.richdad);
    books.get(2).setImageid(R.drawable.cheese);
    books.get(3).setImageid(R.drawable.antigone);
    books.get(4).setImageid(R.drawable.la_boite);
    books.get(5).setImageid(R.drawable.les_miserables);
    database.close();
   }


}