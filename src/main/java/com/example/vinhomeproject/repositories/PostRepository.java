package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.dto.PostDTO;
import com.example.vinhomeproject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT NEW com.example.vinhomeproject.dto.PostDTO(p.title, p.description, a.id) " +
            "FROM Post p " +
            "JOIN p.apartment a ")
    Set<PostDTO> findAllPosts();
}
