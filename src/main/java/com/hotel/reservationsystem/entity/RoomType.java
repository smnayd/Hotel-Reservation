package com.hotel.reservationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "room_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String type;
    @Column(nullable = false)
    private int capacity;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    /*@OneToMany(mappedBy = "roomType")
    private List<Room> rooms;*/
}
