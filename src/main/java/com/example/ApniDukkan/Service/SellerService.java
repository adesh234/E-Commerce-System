package com.example.ApniDukkan.Service;

import com.example.ApniDukkan.DTO.Request.SellerRequest;
import com.example.ApniDukkan.DTO.Response.GetSellerResponse;
import com.example.ApniDukkan.Exception.InvalidSellerException;
import com.example.ApniDukkan.Exception.SellerExistException;

import java.util.List;

public interface SellerService {

    String addSeller(SellerRequest sellerRequest) throws SellerExistException;

    GetSellerResponse getByEmail(String email) throws InvalidSellerException;

    GetSellerResponse getById(int id) throws InvalidSellerException;

    List<GetSellerResponse> getAllSeller();

    GetSellerResponse updateAgeByEmail(String email, int age) throws InvalidSellerException;

    String deleteByEmail(String email) throws InvalidSellerException;
}
