package com.example.GetRide.transformer;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .drivingLicense(driverRequest.getDrivingLicense())
                .mobileNo(driverRequest.getMobileNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .mobNo(driver.getMobileNo())
                .cab(CabTransformer.cabToCabResponse(driver.getCab()))
                .build();
    }
}
