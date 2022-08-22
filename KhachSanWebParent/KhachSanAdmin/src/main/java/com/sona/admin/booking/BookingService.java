package com.sona.admin.booking;

import com.sona.common.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getByKeyword(String keyword) {
        return bookingRepository.findByKeyword(keyword);
    }

    public List<Booking> listAll() {
        return (List<Booking>) bookingRepository.findAll();
    }
}
