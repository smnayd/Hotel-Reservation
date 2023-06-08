package com.hotel.reservationsystem.repository;

import com.hotel.reservationsystem.entity.Hotel;
import com.hotel.reservationsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> getByUserId(int UserId);
}
