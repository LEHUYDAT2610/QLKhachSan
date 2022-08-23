package com.sona.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "register_date")
    private Date registerDate;
    @Column(name = "checkin_date")
    private Date checkinDate;
    @Column(name = "checkout_date")
    private Date checkoutDate;
    @Column(name = "total_member")
    private int totalMember;
    @Column
    private int status;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Transient
    public void setCheckinDate(String checkinDate){
        try {
            this.checkinDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkinDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Transient
    public void setCheckoutDate(String checkoutDate){
        try {
            this.checkoutDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkoutDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
