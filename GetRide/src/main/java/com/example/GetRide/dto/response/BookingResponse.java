package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.BookingStatus;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    String bookingId;

    String pickup;

    String destination;

    BookingStatus bookingStatus;

    double totalDistance;

    double totalFare;

    Date bookedAt;

    CustomerResponse customerResponse;

    DriverResponse driverResponse;
}
