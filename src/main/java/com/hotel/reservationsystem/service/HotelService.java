package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(int id);
    Hotel getHotelById(int id);
    List<Hotel> getAllHotels();
}
