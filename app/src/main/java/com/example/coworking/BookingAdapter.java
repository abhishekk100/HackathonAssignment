package com.example.coworking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.coworking.register.Booking;

import java.util.List;

public class BookingAdapter extends ArrayAdapter<Booking> {

    private Context context;
    private List<Booking> bookingList;

    public BookingAdapter(Context context, List<Booking> bookingList) {
        super(context, 0, bookingList);
        this.context = context;



    }
}
