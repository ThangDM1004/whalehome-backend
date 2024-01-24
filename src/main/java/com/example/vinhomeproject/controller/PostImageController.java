package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.PostImage;
import com.example.vinhomeproject.service.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/postimage")
public class PostImageController {
    private PostImageService sv;
    @Autowired
    public void PostImageSerivce(PostImageService sv){this.sv=sv;}
    @GetMapping
    public List<PostImage> getPostImage(){return sv.getAllPostImage();}
    @PutMapping("/delete")
    public PostImage deletePostImage(Long id){return sv.deletePostImage(id);}
    @PutMapping("/update")
    public PostImage updatePostImage(PostImage ps){return sv.updatePostImage(ps);}
    @PostMapping("/create")
    public PostImage createPostImage(PostImage ps){return sv.createPostImage(ps);}
}
