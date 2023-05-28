package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Hotel;

import java.util.Date;
import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(int id);
    Hotel getHotelById(int id);
    List<Hotel> getAllHotels();
    String getHotelByImage(String image);
    List<Hotel> searchHotels(Date dateIn, Date dateOut, int guestCount);

}
