package com.example.GetRide.controller;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;
import com.example.GetRide.service.DriverService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest) {
        String respone = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(respone, HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponse getDriver(@RequestParam("mob-no") long mobileNo) {
        return driverService.getDriver(mobileNo);
    }

    // get all the drivers above a particular age

    // get the driver with maximum number of bookings

    // update the driver license
    // update driver phone number

    // driver with the least number of bookings

    // get all the drivers with less than 10 bookings



}
