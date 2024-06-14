package com.example.GetRide.model;

import com.example.GetRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cabNumber;

    CabType cabType;

    double farePerKm;

    boolean booked;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
