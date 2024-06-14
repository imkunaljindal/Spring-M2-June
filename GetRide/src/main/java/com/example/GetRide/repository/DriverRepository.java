package com.example.GetRide.repository;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Driver findByMobileNo(long mobileNo);
}
