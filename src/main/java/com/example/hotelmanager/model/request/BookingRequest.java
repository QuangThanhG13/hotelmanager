package com.example.hotelmanager.model.request;

import com.example.hotelmanager.entity.Room;
//import com.example.hotelmanager.constan.Facilities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingRequest {

    private Long customerId;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numberOfGuests;
//    private Set<Facilities> requestedFacilities;
    private String requestedFacilities; // convert enum to string
}
