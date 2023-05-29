package com.hotel.reservationsystem.repository;

import com.hotel.reservationsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    /*@Query("select r from Room r where r.hotel.id = :hotelId")
    Room getRoomByHotelId(@Param("hotelId") int hotelId);*/
}
