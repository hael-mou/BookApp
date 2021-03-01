package com.elmoudden.bookapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter <BookAdapter.bookHolder> {

    private ArrayList<Book> books;

    public BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public bookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new bookHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull bookHolder holder, int position) {
        Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.page.setText(book.getPage()+"");
        holder.review.setText(book.getN_reviews()+"");
        holder.ratingBar.setRating(book.getRatingScore());
        if(book.getImageid()!=0){
        holder.image.setImageResource(book.getImageid());}
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class bookHolder extends  RecyclerView.ViewHolder{
        TextView title,author,page,review;
        RatingBar ratingBar;
        ImageView image;
        public bookHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            page = itemView.findViewById(R.id.page);
            review = itemView.findViewById(R.id.review);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            image=itemView.findViewById(R.id.book_image);
        }
    }
}    
