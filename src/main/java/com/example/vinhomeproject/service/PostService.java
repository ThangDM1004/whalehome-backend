package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.Post;
import com.example.vinhomeproject.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository rs;



    public PostService(PostRepository rs) {
        this.rs = rs;
    }

    public List<Post> getAllPost(){return rs.findAll();}
    public Post getPostId(Long id){return rs.findPostById(id);}

    public Post deletePost(Long id) {
        Post existingUser = rs.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setStatus(false);


            return rs.save(existingUser);
        }

        return null;
    }
    public Post updatePost(Post id){
        Post post=rs.findById(id.getId()).orElse(null);
        if (post!=null){
            post.setCreateBy(id.getCreateBy());
            post.setStatus(id.isStatus());
            post.setApartment(id.getApartment());
            post.setTitle(id.getTitle());
            post.setDescription(id.getDescription());
            post.setCreateDate(id.getCreateDate());
            post.setModifiedBy(id.getModifiedBy());
            return rs.save(post);

        }
        return null;
    }
    public Post createPost(Post id){
        Post post=new Post();
        post.setStatus(id.isStatus());
        post.setApartment(id.getApartment());
        post.setTitle(id.getTitle());
        post.setDescription(id.getDescription());
        post.setCreateDate(id.getCreateDate());
        post.setModifiedBy(id.getModifiedBy());
        post.setCreateBy(id.getCreateBy());
        return rs.save(post);
    }
}
