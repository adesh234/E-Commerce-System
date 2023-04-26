package com.example.ApniDukkan.Controller;

import com.example.ApniDukkan.DTO.Request.ProductRequest;
import com.example.ApniDukkan.DTO.Response.ProductResponse;
import com.example.ApniDukkan.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest){
        try {
            ProductResponse productResponse = productService.addProduct(productRequest);
            return new ResponseEntity(productResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}