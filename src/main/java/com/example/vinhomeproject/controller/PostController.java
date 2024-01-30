package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Post;

import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private PostService sv;
    @Autowired
    public void PostSerivce(PostService sv){this.sv=sv;}
    @GetMapping
    public ResponseEntity<ResponseObject> getPost(){return sv.getAllPost();}
    @PutMapping("/delete")
    public ResponseEntity<String> deletePost(Long id){return sv.deletePost(id);}
    @PutMapping("/update")
    public ResponseEntity<String> updatePost(Post post){return sv.updatePost(post);}
    @PostMapping("/create")
    public ResponseEntity<String> createPost(Post post){return sv.createPost(post);}
}
