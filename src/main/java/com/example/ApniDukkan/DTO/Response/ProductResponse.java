package com.example.ApniDukkan.DTO.Response;

import com.example.ApniDukkan.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    String productName;

    String sellerName;

    int quantity;

    ProductStatus productStatus;
}
