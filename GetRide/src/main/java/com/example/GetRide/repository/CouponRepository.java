package com.example.GetRide.repository;


import com.example.GetRide.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
}
