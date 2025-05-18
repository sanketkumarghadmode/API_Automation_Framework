package com.MyApiAproject.modules;

import com.MyApiAproject.pojos.*;
import com.google.gson.Gson;


public class PayloadManager {

    // Convert Java Objects to JSON
    // Gson -> Ser and DeSer.
    Gson gson;

    public String createPayloadBookingAsString() {

        Booking booking = new Booking();
        booking.setFirstname("sanket");
        booking.setLastname("ghadmode");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        // Java Object -> JSON
        Gson gson = new Gson();
        return gson.toJson(booking);
    }

    // Converting the String to the JAVA Object
    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
       BookingResponse  bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;
    }

    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1  = gson.fromJson(tokenResponse, TokenResponse.class);
            return tokenResponse1.getToken().toString();

    }

    public Booking getResponseFromJSON(String getResponse){
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }


    public String FullUpdate(){

        Booking booking = new Booking();
        booking.setFirstname("Aniket");
        booking.setLastname("Rasne");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

       return gson.toJson(booking);

    }


}
