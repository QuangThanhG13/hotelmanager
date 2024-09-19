package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  //  List<Room> findBookingBy(final LocalDate checkinDate,final LocalDate checkoutDate,final String roomType);

//    @Query(value = "SELECT * FROM hotel  WHERE hotel.available_from >= ?1 AND hotel.available_to <= ?2 AND hotel.ID NOT IN " +
//            "(SELECT hotel_id FROM reservation WHERE (check_in >= ?1 OR check_out <= ?2))", nativeQuery = true)
//    List<Booking>findAllBetweenDate (@Param ("checkinDate") String checkinDate,@Param ("checkoutDate") String checkoutDate);
}

