package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.ApartmentClassDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.ApartmentClassSerivce;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/apartmentclass")
public class ApartmentClassController {
    private ApartmentClassSerivce apartmentClassSerivce;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll(){
        return apartmentClassSerivce.getAll();
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ApartmentClassDTO apartmentClassDTO){
        return apartmentClassSerivce.create(apartmentClassDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return apartmentClassSerivce.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ApartmentClassDTO apartmentClassDTO){
        return apartmentClassSerivce.update(id,apartmentClassDTO);
    }
}
