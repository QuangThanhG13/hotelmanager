package com.example.hotelmanager.repository;

import com.example.hotelmanager.entity.Room;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagnitionRepository extends PagingAndSortingRepository <Room, Long> {
//    Page<Order> findAll(String sortBy);
}
