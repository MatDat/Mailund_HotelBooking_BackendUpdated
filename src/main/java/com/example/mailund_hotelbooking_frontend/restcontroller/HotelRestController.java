package com.example.mailund_hotelbooking_frontend.restcontroller;

import com.example.mailund_hotelbooking_frontend.model.Hotel;
import com.example.mailund_hotelbooking_frontend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HotelRestController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/addHotel")
    private ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/getAllHotels")
    private ResponseEntity<List<Hotel>> getHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/findHotelById/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable("id") int id){
        return hotelService.findById(id);
    }

    @PutMapping("/editHotel")
    public ResponseEntity<Hotel> editHotel(@RequestBody Hotel hotel){
        return hotelService.editHotel(hotel);
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable("id") int id){
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
