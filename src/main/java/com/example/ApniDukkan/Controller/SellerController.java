package com.example.ApniDukkan.Controller;

import com.example.ApniDukkan.DTO.Request.SellerRequest;
import com.example.ApniDukkan.DTO.Response.GetSellerResponse;
import com.example.ApniDukkan.Exception.InvalidSellerException;
import com.example.ApniDukkan.Exception.SellerExistException;
import com.example.ApniDukkan.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequest sellerRequest) throws SellerExistException {
        return sellerService.addSeller(sellerRequest);
    }
    @GetMapping("/get_by_email")
    public ResponseEntity getByEmail(@RequestParam("email") String email) {
        try{
            GetSellerResponse getSellerResponse = sellerService.getByEmail(email);
            return new ResponseEntity(getSellerResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_by_id")
    public ResponseEntity getById(@RequestParam("id")int id){
        try{
            GetSellerResponse getSellerResponse = sellerService.getById(id);
            return new ResponseEntity(getSellerResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public List<GetSellerResponse> getAllSeller(){
        return sellerService.getAllSeller();
    }
    @PutMapping("/updateAgeByEmail")
    public GetSellerResponse updateAgeByEmail(@RequestParam String email, @RequestParam int age) throws InvalidSellerException {
        return sellerService.updateAgeByEmail(email,age);
    }
    @DeleteMapping("/delete_by_email")
    public String deleteByEmail(@RequestParam("email") String email) throws InvalidSellerException {
        return sellerService.deleteByEmail(email);
    }
    // delete a seller based on email
    // delete by id
    // get all seller of particular age
}