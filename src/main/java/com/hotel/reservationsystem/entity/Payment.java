package com.hotel.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate paymentDate;
    @Column(nullable = false, length = 20)
    private String cardNo;
    @Column(nullable = false, length = 2)
    private String cardMonth;
    @Column(nullable = false, length = 2)
    private String cardYear;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;
}