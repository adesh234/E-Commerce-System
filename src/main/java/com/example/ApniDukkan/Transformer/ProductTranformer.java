package com.example.ApniDukkan.Transformer;


import com.example.ApniDukkan.DTO.Request.ProductRequest;
import com.example.ApniDukkan.DTO.Response.ProductResponse;
import com.example.ApniDukkan.Entity.Product;
import com.example.ApniDukkan.Enum.ProductStatus;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductTranformer {

    public static Product ProductResponseToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .productType(productRequest.getProductType())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
    public static ProductResponse ProductToProductResponse(Product product){
        return ProductResponse.builder()
                .quantity(product.getQuantity())
                .productName(product.getName())
                .productStatus(product.getProductStatus())
                .sellerName(product.getSeller().getName())
                .build();
    }
}
