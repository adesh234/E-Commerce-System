package com.example.ApniDukkan.DTO.Request;

import com.example.ApniDukkan.Enum.ProductType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String productName;

    int price;

    int quantity;

    ProductType productType;

    int sellerId;
}
