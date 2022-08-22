package com.sona.admin.booking;

import com.sona.common.entity.Booking;
import com.sona.common.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/booking")
    public String listAll(Model model, @Param("keyword") String keyword) {
        if (keyword != null) {
            List<Booking> bookings = bookingService.getByKeyword(keyword);
            model.addAttribute("bookings", bookings);
            model.addAttribute("keyword", keyword);
        } else {
            List<Booking> bookings = bookingService.listAll();
            model.addAttribute("bookings", bookings);
        }
        return "booking/all-booking";
    }
}
