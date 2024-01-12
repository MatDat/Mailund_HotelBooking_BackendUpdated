package com.example.mailund_hotelbooking_frontend.service;

import com.example.mailund_hotelbooking_frontend.model.Hotel;
import com.example.mailund_hotelbooking_frontend.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public ResponseEntity<Hotel> saveHotel(Hotel hotel){
        hotel.setCreated(LocalDateTime.now());
        hotel.setUpdated(LocalDateTime.now());
        hotelRepo.save(hotel);
        return ResponseEntity.ok(hotel);
    }

    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelRepo.findAll());
    }

    public ResponseEntity<Hotel> findById(int id){
        Optional<Hotel> optionalHotel = hotelRepo.findById(id);
        if (optionalHotel.isPresent()){
            return ResponseEntity.ok(optionalHotel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Hotel> editHotel(Hotel updatedHotel){
        Optional<Hotel> optionalHotel = hotelRepo.findById(updatedHotel.getHotelId());

        if (optionalHotel.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Hotel currentHotel = optionalHotel.get();

        if (updatedHotel.getName() != null){
            currentHotel.setName(updatedHotel.getName());
        }
        if (updatedHotel.getStreet() != null){
            currentHotel.setStreet(updatedHotel.getStreet());
        }
        if (updatedHotel.getCity() != null){
            currentHotel.setCity(updatedHotel.getCity());
        }
        if (updatedHotel.getZip() != null){
            currentHotel.setZip(updatedHotel.getZip());
        }
        if (updatedHotel.getCountry() != null){
            currentHotel.setCountry(updatedHotel.getCountry());
        }

        try{
            Hotel updated = hotelRepo.save(currentHotel);
            return ResponseEntity.ok(updated);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public void deleteHotelById(int id){
        Optional<Hotel> HotelToBeDeleted = hotelRepo.findById(id);

        if (HotelToBeDeleted.isPresent()){
            hotelRepo.deleteById(id);
        } else{
            throw new Error("Hotel not found with id: " + id);
        }
    }
}
