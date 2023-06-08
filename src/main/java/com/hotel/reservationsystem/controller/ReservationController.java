package com.hotel.reservationsystem.controller;

import com.hotel.reservationsystem.entity.Hotel;
import com.hotel.reservationsystem.entity.Reservation;
import com.hotel.reservationsystem.entity.RoomType;
import com.hotel.reservationsystem.entity.User;
import com.hotel.reservationsystem.service.HotelService;
import com.hotel.reservationsystem.service.ReservationService;
import com.hotel.reservationsystem.service.RoomTypeService;
import com.hotel.reservationsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;
    private HotelService hotelService;
    private RoomTypeService roomTypeService;
    private UserService userService;
    @Autowired
    public ReservationController(ReservationService reservationService, HotelService hotelService, RoomTypeService roomTypeService, UserService userService){
        this.reservationService = reservationService;
        this.hotelService = hotelService;
        this.roomTypeService = roomTypeService;
        this.userService = userService;
    }

    @PostMapping("/{hotelId}/{roomTypeId}/{userId}")
    public ResponseEntity<Reservation> createReservationWithDetails(
            @PathVariable("hotelId") int hotelId,
            @PathVariable("roomTypeId") int roomTypeId,
            @PathVariable("userId") int userId,
            @RequestBody Reservation reservation) {
        try {
            Hotel hotel = hotelService.getHotelById(hotelId);
            RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
            User user = userService.getUserById(userId);

            reservation.setHotel(hotel);
            reservation.setRoomType(roomType);
            reservation.setUser(user);

            Reservation createdReservation = reservationService.createReservation(reservation);
            return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") int id, @RequestBody Reservation reservation) {
        try{
            reservation.setId(id);
            Reservation updatedReservation = reservationService.updateReservation(reservation);
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") int id) {
        try{
            reservationService.deleteReservation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") int id) {
        try{
            Reservation reservation = reservationService.getReservationById(id);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }

        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        try{
            List<Reservation> reservations = reservationService.getAllReservations();
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/view/{userId}")
    public ResponseEntity<List<Reservation>> getByUserId(@PathVariable("userId")int userId){
        try{
            List<Reservation> reservations = reservationService.getByUserId(userId);
            return new ResponseEntity<>(reservations,HttpStatus.OK);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
