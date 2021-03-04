package com.elmoudden.bookapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BookAdapter extends RecyclerView.Adapter <BookAdapter.bookHolder> implements Filterable {

    private ArrayList<Book> books;
    private ArrayList<Book> bookList;
    private OnRecycleClick recycleClick;

    public BookAdapter(ArrayList<Book> books, OnRecycleClick recycleClick) {
        this.books = books;
        this.bookList = new ArrayList<>(books);
        this.recycleClick = recycleClick;
    }


    @NonNull
    @Override
    public bookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new bookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull bookHolder holder, int position) {
        Book book = bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.page.setText(book.getPage()+"");
        holder.review.setText(book.getN_reviews()+"");
        holder.ratingBar.setRating(book.getRatingScore());
       if(book.getImageid()!=-1)
        holder.image.setImageResource(book.getImageid());
       holder.Selectbook = book;
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

        Filter filter= new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Book> filtered=new ArrayList<>();

                if(constraint.length()==0 || constraint.toString().isEmpty()){
                        bookList.clear();
                        bookList.addAll(books);
                    filtered.addAll(bookList);

                }
                else{
                    String filtr=constraint.toString().toLowerCase();

                    for(Book book:books){
                        if(book.getTitle().toLowerCase().contains(filtr)||book.getAuthor().toLowerCase().contains(filtr) ){
                        filtered.add(book);}
                    }
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                bookList.clear();
                bookList= (ArrayList<Book>) results.values;
                notifyDataSetChanged();
            }
        };

    public class bookHolder extends  RecyclerView.ViewHolder{

        TextView title,author,page,review;
        RatingBar ratingBar;
        ImageView image;
        Book Selectbook;
        public bookHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            page = itemView.findViewById(R.id.page);
            review = itemView.findViewById(R.id.review);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            image=itemView.findViewById(R.id.book_image);

            itemView.setOnClickListener(v -> {
                recycleClick.onItemclicklick(Selectbook);
            });
        }

    }
}    
