package com.example.mailund_hotelbooking_frontend;

import com.example.mailund_hotelbooking_frontend.model.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MailundHotelBookingFrontendApplicationTests {

    @Test
    void contextLoads() {
        Hotel hotel = new Hotel();
        hotel.setName("Dummy Hotel");
        hotel.setStreet("Dummy Street 123");
        hotel.setCity("Dummy City");
        hotel.setZip("123");
        hotel.setCountry("Dummy Country");
        hotel.setCreated(LocalDateTime.now());
        hotel.setUpdated(LocalDateTime.now());
    }

}
