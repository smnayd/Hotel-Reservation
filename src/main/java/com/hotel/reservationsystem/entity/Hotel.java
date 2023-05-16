package com.hotel.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String hotelName;
    @Column(nullable = false, length = 40)
    private String country;
    @Column(nullable = false, length = 40)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false, length = 11, unique = true)
    private String phone;
    private int rating;
    /*@OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;*/
}
