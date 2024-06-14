package com.example.GetRide.controller;

import com.example.GetRide.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping
    public ResponseEntity addCoupon(@RequestParam("code") String couponCode,
                                    @RequestParam("discount") int percentageDiscount){
       String response = couponService.addCoupon(couponCode,percentageDiscount);
       return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
