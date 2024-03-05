package com.example.vinhomeproject.service;


import com.example.vinhomeproject.dto.PostDTO;
import com.example.vinhomeproject.models.Post;
import com.example.vinhomeproject.repositories.*;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService {
    @Autowired
    private  PostRepository rs;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private BuildingRepository buildingRepository;



    public ResponseEntity<ResponseObject> getAllPost() {
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findAll()
        ));
    }

    public ResponseEntity<ResponseObject> getPostId(Long id) {
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findById(id)
        ));
    }

    public ResponseEntity<String> deletePost(Long id) {
        Post existingUser = rs.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setStatus(!existingUser.isStatus());
            return ResponseEntity.ok("delete successfully");
        } else {
            return ResponseEntity.ok("id not exist");
        }


    }

    public ResponseEntity<ResponseObject> updatePost(Post id) {
        Post post = rs.findById(id.getId()).orElse(null);
        if (post != null) {
            post.setCreateBy(id.getCreateBy());
            post.setStatus(id.isStatus());
            post.setApartment(id.getApartment());
            post.setTitle(id.getTitle());
            post.setDescription(id.getDescription());
            post.setCreateDate(id.getCreateDate());
            post.setModifiedBy(id.getModifiedBy());
            return ResponseEntity.ok(new ResponseObject(
                    "Update post successfully",
                    post
            ));
        } else {
            return ResponseEntity.ok(new ResponseObject(
                    "Not found post ",
                    post
            ));
        }
    }

    public ResponseEntity<String> createPost(PostDTO postDTO) {
        rs.save(Post.builder().apartment(apartmentRepository.findById(postDTO.getApartmentId()).get())
                        .description(postDTO.getDescription())
                        .title(postDTO.getTitle())
                .build());
        return ResponseEntity.ok("create successfully");
    }

    public ResponseEntity<ResponseObject> countAllPost(){return ResponseEntity.ok(new ResponseObject(
            "successfully",
            rs.findAll().size()
    ));}

    public Page<Post> getPage(int currentPage, int pageSize, String field) {
        return rs.findAll(PageRequest.of(currentPage-1, pageSize, Sort.by(Sort.Direction.ASC, field)));
    }
    public Page<Post> searchByTitle(String title, int currentPage, int pageSize, String field) {
        currentPage -=1;
        List<Post> allPosts = rs.findAll();

        // Chuẩn hóa từ khóa tìm kiếm
        String normalizedKeyword = normalizeString(title);

        // Tìm kiếm trong danh sách các bản ghi
        List<Post> filteredPosts = allPosts.stream()
                .filter(post -> normalizeString(post.getTitle()).contains(normalizedKeyword))
                .collect(Collectors.toList());

        // Tạo trang từ danh sách đã lọc
        int startItem = currentPage * pageSize;
        List<Post> pageList;

        if (filteredPosts.size() < startItem) {
            pageList = List.of();
        } else {
            int toIndex = Math.min(startItem + pageSize, filteredPosts.size());
            pageList = filteredPosts.subList(startItem, toIndex);
        }

        return new PageImpl<>(pageList, PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.ASC, field)), filteredPosts.size());
    }

    public int count() {
        return rs.findAll().size();
    }

    public Page<Post> filterPost(Long areaId, Long zoneId, Long buildingId, Long apartmentId,  Pageable pageable){
        if(apartmentId != null){
            return rs.findPostByApartmentId(apartmentId, pageable);
        }
        if(buildingId != null){
            return rs.findByApartment_Building_Id(buildingId, pageable);
        }
        if(zoneId != null){
            return rs.findByApartment_Building_Zone_Id(zoneId, pageable);
        }
        if(areaId != null){
            return rs.findByApartment_Building_Zone_Area_Id(areaId, pageable);
        }
        return rs.findAll(pageable);
    }

    private String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "").toLowerCase();
    }
}
