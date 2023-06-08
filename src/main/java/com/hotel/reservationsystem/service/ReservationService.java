package com.hotel.reservationsystem.service;

import com.hotel.reservationsystem.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(int id);
    Reservation getReservationById(int id);
    List<Reservation> getAllReservations();
    List<Reservation> getByUserId(int userId);
}
