package com.example.GetRide.controller;

import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity bookCab(@RequestParam(value = "coupon-applied", required = false) boolean couponApplied,
            @RequestBody BookingRequest bookingRequest) {
        try {
            BookingResponse response = bookingService.bookCab(bookingRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // find all the bookings done today
    // get top k highest fares bookings
    // get top k lowest fares bookings
    // get the customer with the highest fare booking
    // get the customer with lowest fare booking
}
