package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Room;

import java.util.List;

public interface PagnitionService {
    public List<Room> getRoomSeach(Integer pageNo, Integer pageSize, String sortBy);

}
