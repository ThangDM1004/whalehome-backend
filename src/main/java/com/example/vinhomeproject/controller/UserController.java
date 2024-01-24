package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UsersService serivce;
    @GetMapping()
    public ResponseEntity<ResponseObject> getAllUser(){
        return serivce.getAllUser();
    }
    @PostMapping("")
    public  ResponseEntity<ResponseObject> createUser(@RequestBody UserDTO users){
        return serivce.createUser(users);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id){
      return  serivce.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        return  serivce.updateUser(id,userDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getbyId(@PathVariable Long id){
        return serivce.getById(id);
    }
}
