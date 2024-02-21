package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.Post;
import com.example.vinhomeproject.repositories.PostRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository rs;



    public PostService(PostRepository rs) {
        this.rs = rs;
    }

    public ResponseEntity<ResponseObject> getAllPost(){return ResponseEntity.ok(new ResponseObject(
            "successfully",
            rs.findAll()
    ));}
    public ResponseEntity<ResponseObject> getPostId(Long id){return ResponseEntity.ok(new ResponseObject(
            "successfully",
            rs.findPostById(id)
    ));}

    public ResponseEntity<String> deletePost(Long id) {
        Post existingUser = rs.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setStatus(false);


            return ResponseEntity.ok("delete successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }


    }
    public  ResponseEntity<String> updatePost(Post id){
        Post post=rs.findById(id.getId()).orElse(null);
        if (post!=null){
            post.setCreateBy(id.getCreateBy());
            post.setStatus(id.isStatus());
            post.setApartment(id.getApartment());
            post.setTitle(id.getTitle());
            post.setDescription(id.getDescription());
            post.setCreateDate(id.getCreateDate());
            post.setModifiedBy(id.getModifiedBy());
            return ResponseEntity.ok("update successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }
    }
    public  ResponseEntity<String> createPost(Post id){
        Post post=new Post();
        post.setStatus(id.isStatus());
        post.setApartment(id.getApartment());
        post.setTitle(id.getTitle());
        post.setDescription(id.getDescription());
        post.setCreateDate(id.getCreateDate());
        post.setModifiedBy(id.getModifiedBy());
        post.setCreateBy(id.getCreateBy());
         rs.save(post);
        return ResponseEntity.ok("create successfully");
    }

    public ResponseEntity<ResponseObject> countAllPost(){return ResponseEntity.ok(new ResponseObject(
            "successfully",
            rs.findAll().size()
    ));}
}
