package com.example.hotelmanager.service;

import com.example.hotelmanager.entity.Room;
import com.example.hotelmanager.exception.BusinessException;
import com.example.hotelmanager.model.request.RoomRequest;

import java.util.List;

public interface RoomService {
    Room insertRoom(RoomRequest roomRequest) throws BusinessException;
    void updateRoom(Long roomId, RoomRequest roomRequest) throws BusinessException;
    void deleteRoom(Long roomId) throws BusinessException;
    List<Room> getAllRooms();
    Room getRoomById(Long roomId);
    void deleteRoomBulk(List<Long> roomIds);
}
