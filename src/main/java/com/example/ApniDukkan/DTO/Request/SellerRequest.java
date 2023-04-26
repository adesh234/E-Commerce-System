package com.example.ApniDukkan.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerRequest {
    String name;

    String emailId;

    int age;

    String mobNo;
}
