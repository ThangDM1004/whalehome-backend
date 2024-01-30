package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.ReviewDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/review")
public class ReviewController {
    @Autowired
    private ReviewService serivce;
    @GetMapping()
    public ResponseEntity<ResponseObject> getAllReview(){
        return serivce.getAllReview();
    }
    @PostMapping("")
    public  ResponseEntity<ResponseObject> createReview(@RequestBody ReviewDTO review){
        return serivce.createReview(review);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteReview(@PathVariable Long id){
        return  serivce.deleteReview(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateReview(@PathVariable Long id,@RequestBody ReviewDTO userDTO){
        return  serivce.updateReview(id,userDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getbyId(@PathVariable Long id){
        return serivce.getById(id);
    }
}
