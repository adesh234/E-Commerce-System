package com.example.ApniDukkan.Transformer;

import com.example.ApniDukkan.DTO.Request.SellerRequest;
import com.example.ApniDukkan.DTO.Response.GetSellerResponse;
import com.example.ApniDukkan.Entity.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {
    public static Seller SellerRequestToSeller(SellerRequest sellerRequest){
        return Seller.builder()
                .name(sellerRequest.getName())
                .age(sellerRequest.getAge())
                .emailId(sellerRequest.getEmailId())
                .mobNo(sellerRequest.getMobNo())
                .build();
    }
    public static GetSellerResponse SellerToSellerResponse(Seller seller){
        return GetSellerResponse.builder()
                .age(seller.getAge())
                .emailId(seller.getEmailId())
                .mobNo(seller.getMobNo())
                .name(seller.getName())
                .build();
    }
}