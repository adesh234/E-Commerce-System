package com.example.ApniDukkan.Service.Impl;

import com.example.ApniDukkan.DTO.Request.ProductRequest;
import com.example.ApniDukkan.DTO.Response.ProductResponse;
import com.example.ApniDukkan.Entity.Product;
import com.example.ApniDukkan.Entity.Seller;
import com.example.ApniDukkan.Exception.InvalidSellerException;
import com.example.ApniDukkan.Repository.ProductRepository;
import com.example.ApniDukkan.Repository.SellerRepository;
import com.example.ApniDukkan.Service.ProductService;
import com.example.ApniDukkan.Transformer.ProductTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) throws InvalidSellerException {
        Seller seller;
        try{
            seller = sellerRepository.findById(productRequest.getSellerId()).get();
        }catch (Exception e){
            throw new InvalidSellerException("Seller does not exist");
        }
        Product product = ProductTranformer.ProductResponseToProduct(productRequest);
        product.setSeller(seller);
        // add current product to the list (complete the changes int parent too)
        seller.getProducts().add(product);
        sellerRepository.save(seller); // saves seller and product both

        // do response DTO

        return ProductTranformer.ProductToProductResponse(product);
    }
}
