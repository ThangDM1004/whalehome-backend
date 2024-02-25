package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.request.AuthenticationRequest;
import com.example.vinhomeproject.request.AuthenticationUserRequest;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<ResponseObject> register(@RequestBody UserDTO request){
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject(
                "Register successfully",
                service.register(request)
        ));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseObject> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Login successfully",
                service.authenticate(request)
        ));

    }
    @PostMapping("/getUser")
    public ResponseEntity<ResponseObject> getUserFromAccessToken(@RequestBody AuthenticationUserRequest ar){
        return service.getUserFromAccessToken(ar.getAccess_token());
    }

}
