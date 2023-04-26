package com.example.ApniDukkan.Service.Impl;

import com.example.ApniDukkan.DTO.Request.SellerRequest;
import com.example.ApniDukkan.DTO.Response.GetSellerResponse;
import com.example.ApniDukkan.Entity.Seller;
import com.example.ApniDukkan.Exception.InvalidSellerException;
import com.example.ApniDukkan.Exception.SellerExistException;
import com.example.ApniDukkan.Repository.SellerRepository;
import com.example.ApniDukkan.Service.SellerService;
import com.example.ApniDukkan.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public String addSeller(SellerRequest sellerRequest) throws SellerExistException {

        if(sellerRepository.findByEmailId(sellerRequest.getEmailId())!=null)
            throw new SellerExistException("Seller with emailId already registered");

        Seller seller = SellerTransformer.SellerRequestToSeller(sellerRequest);
        sellerRepository.save(seller);
        return "Seller Added";
    }

    @Override
    public GetSellerResponse getByEmail(String email) throws InvalidSellerException {
        Seller seller;
        try{
            seller = sellerRepository.findByEmailId(email);
            return SellerTransformer.SellerToSellerResponse(seller);
        }catch (Exception e){
            throw new InvalidSellerException("Seller does not exist");
        }
    }

    @Override
    public GetSellerResponse getById(int id) throws InvalidSellerException {
        Seller seller;
        try{
            seller = sellerRepository.findById(id).get();
            return SellerTransformer.SellerToSellerResponse(seller);
        }catch (Exception e){
            throw new InvalidSellerException("Seller does not exist");
        }
    }

    @Override
    public List<GetSellerResponse> getAllSeller() {
        List<Seller> list = sellerRepository.findAll();
        List<GetSellerResponse> allSeller = new ArrayList<>();
        for(Seller seller : list){
            allSeller.add(SellerTransformer.SellerToSellerResponse(seller));
        }
        return allSeller;
    }

    @Override
    public GetSellerResponse updateAgeByEmail(String email, int age) throws InvalidSellerException {
        try {
            Seller seller = sellerRepository.findByEmailId(email);
            seller.setAge(age);
            sellerRepository.save(seller);
            return SellerTransformer.SellerToSellerResponse(seller);

        }catch (Exception e){
            throw new InvalidSellerException("Seller does not exist");
        }
    }

    @Override
    public String deleteByEmail(String email) throws InvalidSellerException {

        if(sellerRepository.findByEmailId(email)==null)
            throw new InvalidSellerException("Seller does not exist");

        sellerRepository.deleteByEmailId(email);
        return "Seller Deleted Successfully";
    }
}