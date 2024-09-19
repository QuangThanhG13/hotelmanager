package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    //     @Modifying
//    @Query("DELETE FROM Room r WHERE r.id IN :roomIds")
//    void deleteRoomsByIds(@Param("roomIds") List<Long> roomIds);

}
