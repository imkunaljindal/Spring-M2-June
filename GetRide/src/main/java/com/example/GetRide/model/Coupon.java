package com.example.GetRide.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="coupon")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String couponCode;

    int percentageDiscount;
}
