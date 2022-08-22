package com.sona.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "using_service")
public class UsingService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    Booking booking;

    @ManyToOne
    @JoinColumn(name = "service_id")
    ServiceHotel serviceHotel;

}
