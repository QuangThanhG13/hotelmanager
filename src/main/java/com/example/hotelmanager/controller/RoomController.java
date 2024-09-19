package com.example.hotelmanager.controller;

import com.example.hotelmanager.exception.GlobalExceptionHandler;
import com.example.hotelmanager.model.request.RoomRequest;
import com.example.hotelmanager.model.response.ResponseObject;
import com.example.hotelmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    //    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<ResponseObject> insertRoom(@RequestBody RoomRequest roomRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        200,
                        "Successfully insert room",
                         roomService.insertRoom(roomRequest)
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getRoomById(@PathVariable Long id ) {
        this.roomService.getRoomById(id);
        return ResponseEntity.ok().body(
                new ResponseObject(
                        200,
                        "Successfully get room",
                        this.roomService.getRoomById(id)
                )
        );
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<ResponseObject> updateRoom(@PathVariable Long roomId,
                                                     @RequestBody RoomRequest roomRequest) {
        this.roomService.updateRoom(roomId, roomRequest);
        return ResponseEntity.ok().body(
                new ResponseObject(
                        200,
                        "Successfully update room",
                        HttpStatus.OK
                )
        );
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<ResponseObject> deleteRoom(@PathVariable Long roomId) {
        this.roomService.deleteRoom(roomId);
        return ResponseEntity.ok().body(
                new ResponseObject(
                        200,
                        "Successfully delete room",
                        HttpStatus.OK
                )
        );
    }

   //  xóa nhiều id
    @DeleteMapping("/v2/room")
    public ResponseEntity<ResponseObject> deleteRoomBulk(@RequestBody List<Long> roomIds) {
        roomService.deleteRoomBulk(roomIds);
        return ResponseEntity.ok().body(
                new ResponseObject(
                        200,
                        "Successfully delete rooms",
                        HttpStatus.OK
                )
        );
    }

    @GetMapping
//    @PreAuthorize("hasRole('user')")
    public ResponseEntity<ResponseObject> getAllRooms() {
        return ResponseEntity.ok().body(
                new ResponseObject(
                        200,
                        "Successfully get all rooms",
                        this.roomService.getAllRooms()
                )
        );
    }

}

// const response = pm.response.json();
// const accessToken = response.access_token;
// pm.globals.set("authToken", accessToken);