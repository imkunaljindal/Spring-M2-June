package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.CabType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CabResponse {

    String cabNumber;

    CabType cabType;

    double farePerKm;

    boolean booked;
}
