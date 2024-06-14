package com.example.GetRide.transformer;

import com.example.GetRide.dto.request.CabRequest;
import com.example.GetRide.dto.response.CabResponse;
import com.example.GetRide.model.Cab;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest) {
        return Cab.builder()
                .cabType(cabRequest.getCabType())
                .cabNumber(cabRequest.getCabNumber())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab) {
        return CabResponse.builder()
                .booked(cab.isBooked())
                .cabNumber(cab.getCabNumber())
                .farePerKm(cab.getFarePerKm())
                .cabType(cab.getCabType())
                .build();
    }
}
