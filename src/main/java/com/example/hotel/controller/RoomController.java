package com.example.hotel.controller;

import com.example.hotel.model.Room;
import com.example.hotel.response.RoomResponse;
import com.example.hotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
           @RequestParam("photo") MultipartFile photo,
           @RequestParam("roomType") String roomType,
           @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {

        Room saveRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(saveRoom.getId(), saveRoom.getRoomType(), saveRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }
}
