package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.entity.Booking;
import com.example.hotelmanager.model.request.BookingRequest;
import com.example.hotelmanager.repository.BookingRepository;
import com.example.hotelmanager.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBookingRoom(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setCustomerId(bookingRequest.getCustomerId());
        booking.setCheckInDate(bookingRequest.getCheckInDate());
        booking.setCheckOutDate(bookingRequest.getCheckOutDate());
        booking.setNumberOfGuests(bookingRequest.getNumberOfGuests());
        booking.setFacilities(bookingRequest.getRequestedFacilities());

        return bookingRepository.save(booking);

    }

    @Override
    public List<Booking> getAvailable(String checkInDate, String chckOutDate) {
        return null;
    }
}

//    @Override
//    public List<Booking> getAvailable(String checkInDate, String chckOutDate) {
//        return bookingRepository.findAllBetweenDate(checkInDate, chckOutDate);
//    }
//}
//    @Override
//    public List<Room> searchAvailableBookings(LocalDate checkinDate, LocalDate checkoutDate, String roomType) {
//
//        List<Room> rooms = bookingRepository.findBookingBy(checkinDate , checkoutDate , roomType);
//
//        return rooms;
//    }
//}
