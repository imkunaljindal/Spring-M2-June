package com.example.GetRide.model;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookingId; // UUID

    private String pickup;

    private String destination;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private double totalDistance;

    private double totalFare;

    @CreationTimestamp
    private Date bookedAt;

}
