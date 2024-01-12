package com.example.mailund_hotelbooking_frontend.service;

import com.example.mailund_hotelbooking_frontend.model.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    void saveHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelId(1);
        hotel.setName("Dummy Hotel");
        hotel.setStreet("Dummy Street 123");
        hotel.setCity("Dummy City");
        hotel.setZip("123");
        hotel.setCountry("Dummy Country");
        hotel.setCreated(LocalDateTime.now());
        hotel.setUpdated(LocalDateTime.now());

        hotelService.saveHotel(hotel);

        assertTrue(hotel.getHotelId() > 0);
    }
}
