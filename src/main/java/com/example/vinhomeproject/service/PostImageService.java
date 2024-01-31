package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.PostImage;
import com.example.vinhomeproject.repositories.PostImageRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageService {
    private final PostImageRepository rs;



    public PostImageService(PostImageRepository rs) {
        this.rs = rs;
    }

    public ResponseEntity<ResponseObject> getAllPostImage() {
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findAll()
        ));
    }

    public ResponseEntity<ResponseObject> getPostImageById(Long id) {

        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findPostImageById(id)
        ));
    }

    public ResponseEntity<String> deletePostImage(Long id) {
        PostImage ex = rs.findPostImageById(id);
        if (ex != null) {
            ex.setStatus(false);
            return ResponseEntity.ok("delete successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }
    }

    public ResponseEntity<String> updatePostImage(PostImage postImage) {
        PostImage ps = rs.findPostImageById(postImage.getId());
        if (ps != null) {
            ps.setStatus(postImage.isStatus());
            ps.setModifiedBy(postImage.getModifiedBy());
            ps.setCreateBy(postImage.getCreateBy());
            ps.setCreateDate(postImage.getCreateDate());
            ps.setImage_alt(postImage.getImage_alt());
            ps.setImage_url(postImage.getImage_url());

            return ResponseEntity.ok("update successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }

    }

    public ResponseEntity<String> createPostImage(PostImage ps) {
        if (ps != null) {
             rs.save(ps);
            return ResponseEntity.ok("create successfully");
        } else {
            return null;
        }

    }
}
