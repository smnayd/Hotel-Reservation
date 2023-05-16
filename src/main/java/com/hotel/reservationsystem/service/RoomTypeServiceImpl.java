package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.RoomType;
import com.hotel.reservationsystem.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository){
        this.roomTypeRepository = roomTypeRepository;
    }
    @Override
    public RoomType createRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType updateRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void deleteRoomType(int id) {
        roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomType getRoomTypeById(int id) {
        return roomTypeRepository.findById(id).orElse(null);
    }
    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }
}
