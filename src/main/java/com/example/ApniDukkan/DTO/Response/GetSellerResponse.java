package com.example.ApniDukkan.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetSellerResponse {

    String name;

    String emailId;

    int age;

    String mobNo;
}
