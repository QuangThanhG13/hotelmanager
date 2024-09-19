package com.example.hotelmanager.service.impl;

import com.example.hotelmanager.entity.Room;
import com.example.hotelmanager.exception.BusinessException;
import com.example.hotelmanager.exception.GlobalExceptionHandler;
import com.example.hotelmanager.exception.Resource;
//import com.example.hotelmanager.constan.RoomType;
import com.example.hotelmanager.repository.RoomRepository;
import com.example.hotelmanager.model.request.RoomRequest;
import com.example.hotelmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;



    @Override
    public Room insertRoom(RoomRequest roomRequest) throws BusinessException {

        Room room = new Room();
        room.setRoomType(roomRequest.getRoomType());
        room.setRoomPrice(roomRequest.getRoomPrice());
        room.setAvailableRooms(roomRequest.getAvailableRooms());
        room.setFacilities(roomRequest.getFacilities());

        return roomRepository.save(room);
    }

    @Override
    public void updateRoom(Long roomId, RoomRequest roomRequest) throws BusinessException {
        Optional<Room> room = roomRepository.findById(roomId); // Phần Optional chưa hiểu lắm.

        if (room.isPresent()) {
//            if (isValidRoomType(RoomType.valueOf(roomRequest.getRoomType()))) {
//                throw new BusinessException(Resource.ROOM_TYPE_NOT_FOUND);
//            }
            room.get().setRoomType(roomRequest.getRoomType());
            room.get().setRoomPrice(roomRequest.getRoomPrice());
            room.get().setAvailableRooms(roomRequest.getAvailableRooms());
            room.get().setFacilities(roomRequest.getFacilities());

            roomRepository.save(room.get());
        } else {
            throw new BusinessException(Resource.ROOM_ID_NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(Long roomId) throws BusinessException {
        this.roomRepository.findById(roomId)
                .ifPresentOrElse(room -> this.roomRepository.deleteById(roomId),
                        () -> { throw new BusinessException(Resource.ROOM_ID_NOT_FOUND); });
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long roomId) throws BusinessException{
        return roomRepository.findById(roomId).orElseThrow(
               () -> new BusinessException(Resource.ROOM_ID_NOT_FOUND));
    }

    @Override
    public void deleteRoomBulk(List<Long> roomIds) throws BusinessException{
        List<Room> rooms =this.roomRepository.findAllById(roomIds);

        this.roomRepository.deleteAll(rooms);

    }



//    private boolean isValidRoomType(String roomType) {
//        return !Arrays.asList(RoomType.values()).contains(roomType);  // valid: false
//    }
}

//chưa xử dụng try catch
//xử dung logging exception