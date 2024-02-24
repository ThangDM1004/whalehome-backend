package com.example.vinhomeproject.service;


import com.example.vinhomeproject.dto.PostDTO;
import com.example.vinhomeproject.models.Post;
import com.example.vinhomeproject.repositories.ApartmentRepository;
import com.example.vinhomeproject.repositories.PostRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    @Autowired
    private  PostRepository rs;
    @Autowired
    private ApartmentRepository apartmentRepository;



    public ResponseEntity<ResponseObject> getAllPost() {
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findAllPosts()
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
            existingUser.setStatus(false);


            return ResponseEntity.ok("delete successfully");
        } else {
            return ResponseEntity.ok("id not exist");
        }


    }

    public ResponseEntity<String> updatePost(Post id) {
        Post post = rs.findById(id.getId()).orElse(null);
        if (post != null) {
            post.setCreateBy(id.getCreateBy());
            post.setStatus(id.isStatus());
            post.setApartment(id.getApartment());
            post.setTitle(id.getTitle());
            post.setDescription(id.getDescription());
            post.setCreateDate(id.getCreateDate());
            post.setModifiedBy(id.getModifiedBy());
            return ResponseEntity.ok("update successfully");
        } else {
            return ResponseEntity.ok("id not exist");
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
        return rs.findAll(PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.ASC, field)));
    }
}
