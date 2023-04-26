package com.example.ApniDukkan.Service;

import com.example.ApniDukkan.DTO.Request.ProductRequest;
import com.example.ApniDukkan.DTO.Response.ProductResponse;
import com.example.ApniDukkan.Exception.InvalidSellerException;

public interface ProductService {

    public ProductResponse addProduct(ProductRequest productRequest) throws InvalidSellerException;
}
