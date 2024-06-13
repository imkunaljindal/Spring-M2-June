package com.example.GetRide.dto.response;

import com.example.GetRide.Enum.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;
    private String emailId;
    private Gender gender;
}
