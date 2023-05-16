package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    RoomType createRoomType(RoomType roomType);
    RoomType updateRoomType(RoomType roomType);
    void deleteRoomType(int id);
    RoomType getRoomTypeById(int id);
    List<RoomType> getAllRoomTypes();
}
