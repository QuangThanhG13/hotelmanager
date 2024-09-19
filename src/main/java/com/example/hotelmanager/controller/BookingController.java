package com.example.hotelmanager.controller;

import com.example.hotelmanager.model.request.BookingRequest;
import com.example.hotelmanager.model.response.ResponseObject;
import com.example.hotelmanager.service.BookingService;
import com.example.hotelmanager.service.PagnitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @Autowired
    PagnitionService pagnitionService;


   @PostMapping
   public  ResponseEntity<ResponseObject> createBooking (@RequestBody BookingRequest bookingRequest) {
       return ResponseEntity.status(HttpStatus.OK).body(
               new ResponseObject(
                       200,
                       "Booking successfully created",
                       bookingService.createBookingRoom(bookingRequest)
               )
       );
   }

   @GetMapping
    public ResponseEntity<ResponseObject> getBookingavailability(@RequestParam("dateFrom") String from, @RequestParam("dateTo") String to) {
       return ResponseEntity.status(HttpStatus.OK).body(
               new ResponseObject(
                       200,
                       "Success",
                       bookingService.getAvailable(from, to)
               )
       );
   }


//   @GetMapping("/search")
//    public ResponseEntity<ResponseObject> searchAvailableBookings(
//            @RequestParam LocalDate checkInDate,
//            @RequestParam LocalDate checkOutDate,
//            @RequestParam String roomType
//            ) {
//
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject(
//                        200 ,
//                        "Success" ,
//                        bookingService.searchAvailableBookings(checkInDate, checkOutDate, roomType))
//        );
//    }
}
