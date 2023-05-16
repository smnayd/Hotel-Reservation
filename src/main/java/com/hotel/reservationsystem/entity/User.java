package com.hotel.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String fname;
    @Column(nullable = false, length = 50)
    private String lname;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 11)
    private String phone;
    /* @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;*/
}
