package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoom(int id);
    Room getRoomById(int id);
    List<Room> getAllRooms();
    //Room getRoomByHotelId(int hotelId);
}
