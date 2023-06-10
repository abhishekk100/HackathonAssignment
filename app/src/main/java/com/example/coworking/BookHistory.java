package com.example.coworking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import com.example.coworking.register.Booking;

public class BookHistory extends AppCompatActivity {
    private ListView bookingHistoryListView;
    private TextView emptyTextView;

    private List<Booking> bookingList;
    private BookingAdapter bookingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_history);
        bookingHistoryListView = findViewById(R.id.bookList);
        emptyTextView = findViewById(R.id.emptyTextView);

        // Initialize booking list
        bookingList = new ArrayList<>();



        // Initialize booking adapter
        bookingAdapter = new BookingAdapter(this, bookingList);

        // Set the adapter to the ListView
        bookingHistoryListView.setAdapter(bookingAdapter);

        // Set the empty view for the ListView
        bookingHistoryListView.setEmptyView(emptyTextView);
    }
}