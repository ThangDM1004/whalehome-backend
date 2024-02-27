package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u ORDER BY u.id ASC ")
    List<Users> findAll();
    Optional<Users> findByEmail(String email);
    @Query("SELECT u FROM Users u ORDER BY u.createDate DESC ")
    List<Users> getUserSortByDate();
}
