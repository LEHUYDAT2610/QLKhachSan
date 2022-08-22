package com.sona.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room_category_image")
public class RoomCategoryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private RoomCategory roomCategory;

    public RoomCategoryImage(String name, RoomCategory roomCategory) {
        this.name = name;
        this.roomCategory = roomCategory;
    }
}
