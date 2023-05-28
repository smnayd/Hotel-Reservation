package com.hotel.reservationsystem.controller;

import com.hotel.reservationsystem.entity.Hotel;
import com.hotel.reservationsystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "http://localhost:5173")
public class HotelController {
    private HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        try{
            Hotel createdHotel = hotelService.createHotel(hotel);
            return new ResponseEntity<>(createdHotel,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") int id,@RequestBody Hotel hotel){
        try{
            hotel.setId(id);
            Hotel updatedHotel = hotelService.updateHotel(hotel);
            return new ResponseEntity<>(updatedHotel,HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") int id){
        try{
            hotelService.deleteHotel(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") int id){
        try{
            Hotel hotel = hotelService.getHotelById(id);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        try{
            List<Hotel> hotels = hotelService.getAllHotels();
            return new ResponseEntity<>(hotels,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/images/{imageName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        try {
            Resource resource = new ClassPathResource("static/images/" + imageName);
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam("dateIn") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateIn,
                                    @RequestParam("dateOut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOut,
                                    @RequestParam("guestCount") int guestCount) {
        try{
            List<Hotel> hotels = hotelService.searchHotels(dateIn, dateOut, guestCount);
            if(!hotels.isEmpty()){
                return new ResponseEntity<>(hotels,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}