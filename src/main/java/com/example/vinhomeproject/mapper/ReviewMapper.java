package com.example.vinhomeproject.mapper;

import com.example.vinhomeproject.dto.ProblemDTO;
import com.example.vinhomeproject.dto.ReviewDTO;
import com.example.vinhomeproject.models.Problems;
import com.example.vinhomeproject.models.Review;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review createProblemsToProblemsDto(ReviewDTO reviewDTO);
    void update(ReviewDTO reviewDTO, @MappingTarget Review review);
}
