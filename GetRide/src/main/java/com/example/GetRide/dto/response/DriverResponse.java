package com.example.GetRide.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {

    String name;
    long mobNo;
    CabResponse cab;
}
