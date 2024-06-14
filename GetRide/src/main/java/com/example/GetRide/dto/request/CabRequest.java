package com.example.GetRide.dto.request;

import com.example.GetRide.Enum.CabType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CabRequest {

    String cabNumber;

    CabType cabType;

    double farePerKm;
}
