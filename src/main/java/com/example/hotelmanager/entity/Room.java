package com.example.hotelmanager.entity;

//import com.example.hotelmanager.constan.Facilities;
//import com.example.hotelmanager.constan.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

   // @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_price")
    private Double roomPrice;

    @Column(name = "available_rooms")
    private Integer availableRooms;

//    @Enumerated(EnumType.STRING)
//    @ElementCollection(targetClass = Facilities.class)
      @Column(name = "facilities")
      private String facilities;
//    private Set<Facilities> facilities;


    // @ElementCollection: xac dinh 1 tap hop (Set) cac facilities.
    // Annotation nay cho JPA biet facilities la mot collection cua cac enum Facilities.
}
