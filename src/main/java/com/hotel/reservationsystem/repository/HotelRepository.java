package com.hotel.reservationsystem.repository;

import com.hotel.reservationsystem.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    String getHotelByImage(String image);
    @Query("SELECT DISTINCT h FROM Hotel h JOIN h.roomTypes r "
            + "WHERE r.capacity >= :guestCount "
            + "AND ((:dateIn > CURRENT_DATE AND :dateOut >= :dateIn) "
            + "     OR (:dateIn >= CURRENT_DATE AND :dateOut > CURRENT_DATE)) "
            + "AND NOT EXISTS (SELECT 1 FROM Reservation res "
            + "                WHERE res.hotel = h "
            + "                AND ((res.dateIn <= :dateOut AND res.dateOut >= :dateIn) "
            + "                     OR (res.dateIn >= :dateIn AND res.dateOut <= :dateOut)))")
    List<Hotel> searchHotels(@Param("dateIn") Date dateIn, @Param("dateOut") Date dateOut, @Param("guestCount") int guestCount);

}
