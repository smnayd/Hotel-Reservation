package com.hotel.reservationsystem.repository;

import com.hotel.reservationsystem.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {
    @Query("SELECT DISTINCT r FROM RoomType r inner join r.rooms ro WHERE r.hotel.id = :hotelId AND ro.availability  = true")
    List<RoomType> getRoomTypesByHotelId(@Param("hotelId") int hotelId);

}
