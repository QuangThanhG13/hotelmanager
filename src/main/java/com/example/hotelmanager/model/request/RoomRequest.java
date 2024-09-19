package com.example.hotelmanager.model.request;

//import com.example.hotelmanager.constan.Facilities;
//import com.example.hotelmanager.constan.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomRequest {
    private String roomType;
    private Double roomPrice;
    private Integer availableRooms;
//   private Set<Facilities> facilities;
    private String facilities; // convert enum to string
}
