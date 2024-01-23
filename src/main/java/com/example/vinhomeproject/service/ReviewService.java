package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.ReviewDTO;
import com.example.vinhomeproject.mapper.ReviewMapper;
import com.example.vinhomeproject.models.Review;
import com.example.vinhomeproject.repositories.ReviewRepository;
import com.example.vinhomeproject.repositories.ReviewRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repo;
    @Autowired
    private ReviewMapper mapper;

    public ResponseEntity<ResponseObject> getAllReview(){
        List<Review> reviews = repo.findAll();
        if(!reviews.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    reviews
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List review null",
                    null
            ));
        }
    }

    public ResponseEntity<ResponseObject> createReview(ReviewDTO reviewDTO){
        reviewDTO.setStatus(true);
        repo.save(mapper.createProblemsToProblemsDto(reviewDTO));
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                "Create review successfully",
                null
        ));
    }
    public ResponseEntity<ResponseObject>  deleteReview(Long id){
        Optional<Review> review = repo.findById(id);
        review.get().setStatus(false);
        repo.save(review.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete review successfully",
                null
        ));
    }

    public ResponseEntity<ResponseObject>  updateReview(Long id,ReviewDTO reviewDTO){
        Optional<Review> review = repo.findById(id);
        mapper.update(reviewDTO,review.get());
        repo.save(review.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete review successfully",
                null
        ));
    }
    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Review> review = repo.findById(id);
        if(review.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    review
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Review null",
                    null
            ));
        }
    }
}
