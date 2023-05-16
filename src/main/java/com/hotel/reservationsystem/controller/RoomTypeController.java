package com.hotel.reservationsystem.controller;

import com.hotel.reservationsystem.entity.RoomType;
import com.hotel.reservationsystem.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roomtypes")
public class RoomTypeController {
    private RoomTypeService roomTypeService;
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService){
        this.roomTypeService = roomTypeService;
    }
    @PostMapping
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        try{
            RoomType createdRoomType = roomTypeService.createRoomType(roomType);
            return new ResponseEntity<>(createdRoomType, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable("id") int id, @RequestBody RoomType roomType) {
        try{
            roomType.setId(id);
            RoomType updatedRoomType = roomTypeService.updateRoomType(roomType);
            return new ResponseEntity<>(updatedRoomType, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable("id") int id) {
        try{
            roomTypeService.deleteRoomType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable("id") int id) {
        try{
            RoomType roomType = roomTypeService.getRoomTypeById(id);
            return new ResponseEntity<>(roomType, HttpStatus.OK);
        }

        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<RoomType>> getAllRoomTypes() {
        try{
            List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
            return new ResponseEntity<>(roomTypes, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
