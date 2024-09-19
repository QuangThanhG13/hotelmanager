package com.example.hotelmanager.service;


import com.example.hotelmanager.entity.Booking;
import com.example.hotelmanager.model.request.BookingRequest;


import java.util.List;

public interface BookingService {
  Booking createBookingRoom(BookingRequest bookingRequest);
  //List<Room> searchAvailableBookings(LocalDate checkinDate,LocalDate checkoutDate , String roomType);
  List<Booking> getAvailable(String checkInDate , String chckOutDate);
}
