package com.sona.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "room_category")
public class RoomCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 64, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column
    private float size;
    @Column
    private String amenities;
    @Column(name = "main_image", nullable = false)
    private String mainImage;
    @Column
    private String description;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomCategory")
//    private List<Room> rooms;

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL)
    private Set<RoomCategoryImage> images = new HashSet<>();

    public void addExtraImage(String imageName) {
        this.images.add(new RoomCategoryImage(imageName, this));
    }

    @Transient
    public String getMainImagePath() {
        if (id == null || mainImage == null)
            return "/img/default-image.jpg";
        return "/category-images/" + this.id + "/" + this.mainImage;
    }
}
