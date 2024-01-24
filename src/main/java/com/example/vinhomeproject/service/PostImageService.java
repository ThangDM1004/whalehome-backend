package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.PostImage;
import com.example.vinhomeproject.repositories.PostImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageService {
    private final PostImageRepository rs;



    public PostImageService(PostImageRepository rs) {
        this.rs = rs;
    }

    public List<PostImage> getAllPostImage() {
        return rs.findAll();
    }

    public PostImage getPostImageById(Long id) {
        return rs.findPostImageById(id);
    }

    public PostImage deletePostImage(Long id) {
        PostImage ex = rs.findPostImageById(id);
        if (ex != null) {
            ex.setStatus(false);
            return rs.save(ex);
        } else {
            return null;
        }
    }

    public PostImage updatePostImage(PostImage postImage) {
        PostImage ps = rs.findPostImageById(postImage.getId());
        if (ps != null) {
            ps.setStatus(postImage.isStatus());
            ps.setModifiedBy(postImage.getModifiedBy());
            ps.setCreateBy(postImage.getCreateBy());
            ps.setCreateDate(postImage.getCreateDate());
            ps.setImage_alt(postImage.getImage_alt());
            ps.setImage_url(postImage.getImage_url());

            return rs.save(ps);
        } else {
            return null;
        }

    }

    public PostImage createPostImage(PostImage ps) {
        if (ps != null) {
            return rs.save(ps);
        } else {
            return null;
        }

    }
}
