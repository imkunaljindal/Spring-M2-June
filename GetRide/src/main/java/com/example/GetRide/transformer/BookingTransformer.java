package com.example.GetRide.transformer;

import com.example.GetRide.Enum.BookingStatus;
import com.example.GetRide.dto.request.BookingRequest;
import com.example.GetRide.dto.response.BookingResponse;
import com.example.GetRide.model.Booking;
import com.example.GetRide.model.Cab;
import com.example.GetRide.repository.BookingRepo;

import java.util.UUID;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,
                                                  Cab cab) {
        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .bookingStatus(BookingStatus.CONFIRMED)
                .totalDistance(bookingRequest.getTotalDistance())
                .totalFare(bookingRequest.getTotalDistance()*cab.getFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking) {
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .bookingStatus(booking.getBookingStatus())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .bookedAt(booking.getBookedAt())
                .customerResponse(CustomerTransformer.customerToCustomerResponse(booking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
