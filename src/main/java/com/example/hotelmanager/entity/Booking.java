package com.example.hotelmanager.entity;

//import com.example.hotelmanager.constan.Facilities;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
//chưa những class để ánh xạ với bảng trong db
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "number_of_guests")
    private Integer numberOfGuests;

    @Column(name = "booking_status")
    private String bookingStatus;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Facilities.class)
//    private Set<Facilities> facilities;

    @Column(name = "facilities")
     private String facilities;
}
