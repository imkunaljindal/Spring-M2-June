package com.example.GetRide.service;

import com.example.GetRide.dto.request.DriverRequest;
import com.example.GetRide.dto.response.DriverResponse;
import com.example.GetRide.model.Cab;
import com.example.GetRide.model.Driver;
import com.example.GetRide.repository.DriverRepository;
import com.example.GetRide.transformer.CabTransformer;
import com.example.GetRide.transformer.DriverTransformer;
import org.hibernate.metamodel.internal.EmbeddableInstantiatorPojoOptimized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public String addDriverAndCab(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Cab cab = CabTransformer.cabRequestToCab(driverRequest.getCabRequest());
        driver.setCab(cab);
        cab.setDriver(driver);

        // save both driver and cab
        driverRepository.save(driver); // save both
        return "Driver registered successfully";


    }

    public DriverResponse getDriver(long mobileNo) {
        Driver savedDriver = driverRepository.findByMobileNo(mobileNo);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
