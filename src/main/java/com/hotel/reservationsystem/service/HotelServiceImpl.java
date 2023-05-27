package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Hotel;
import com.hotel.reservationsystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    private HotelRepository hotelRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }
    @Override
    public Hotel createHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    @Override
    public Hotel updateHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }
    @Override
    public void deleteHotel(int id){
        hotelRepository.deleteById(id);
    }
    @Override
    public Hotel getHotelById(int id){
        return hotelRepository.findById(id).orElse(null);
    }
    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    @Override
    public String getHotelByImage(String image){
        return hotelRepository.getHotelByImage(image);
    }
    public List<Hotel> searchHotels(Date dateIn, Date dateOut, int guestCount) {
        return hotelRepository.searchHotels(dateIn, dateOut, guestCount);
    }
}
