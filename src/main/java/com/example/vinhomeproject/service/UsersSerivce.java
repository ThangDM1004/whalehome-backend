package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.Users;
import com.example.vinhomeproject.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsersSerivce {

    @Autowired
    private UsersRepository repo;

    public List<Users> getAllUser(){
        return repo.findAll();
    }

    public void createUser(Users user){
        repo.save(user);
    }


}
