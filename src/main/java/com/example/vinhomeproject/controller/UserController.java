package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Users;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UsersSerivce serivce;
    @GetMapping()
    public String test(){
        return "User controller";
    }
    @GetMapping("/get-all-user")
    public ResponseEntity<ResponseObject> getAllUser(){
        List<Users> users = serivce.getAllUser();
        if(users.size()>0){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
               "Successfully",
               users
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List user null",
                    null
            ));
        }
    }

//    @PostMapping("/create-user")
//    public  ResponseEntity<ResponseObject> createUser(@RequestBody Users users){
//
//    }
}
