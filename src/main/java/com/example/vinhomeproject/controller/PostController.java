package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Post;

import com.example.vinhomeproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app"})
@RequestMapping("/api/v1/post")
public class PostController {
    private PostService sv;
    @Autowired
    public void PostSerivce(PostService sv){this.sv=sv;}
    @GetMapping
    public List<Post> getPost(){return sv.getAllPost();}
    @PutMapping("/delete")
    public Post deletePost(Long id){return sv.deletePost(id);}
    @PutMapping("/update")
    public Post updatePost(Post post){return sv.updatePost(post);}
    @PostMapping("/create")
    public Post createPost(Post post){return sv.createPost(post);}
}
