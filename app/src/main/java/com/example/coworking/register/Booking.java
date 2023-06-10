package com.example.coworking.register;

public class Booking {
    private String bookingName;
    private String bookingDate;
    private String bookingTime;

    public Booking(String bookingName, String bookingDate, String bookingTime) {
        this.bookingName = bookingName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public String getBookingName() {
        return bookingName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }
}

