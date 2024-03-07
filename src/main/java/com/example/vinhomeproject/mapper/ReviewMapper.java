package com.example.vinhomeproject.mapper;

import com.example.vinhomeproject.dto.ProblemDTO;
import com.example.vinhomeproject.dto.ReviewDTO;
import com.example.vinhomeproject.dto.ReviewDTO_2;
import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.models.Problems;
import com.example.vinhomeproject.models.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review createProblemsToProblemsDto(ReviewDTO reviewDTO);
    void update(ReviewDTO reviewDTO, @MappingTarget Review review);

    @Mapping(target = "apartmentId", source = "apartment")
    ReviewDTO_2 reviewToReviewDTO(Review review);

    default Long map(Apartment value) {
        return value.getId();
    }

}
