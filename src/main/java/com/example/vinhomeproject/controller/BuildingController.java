package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.AreaDTO;
import com.example.vinhomeproject.dto.BuildingDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.AreaService;
import com.example.vinhomeproject.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app"})
@RequestMapping("/api/v1/buildings")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return buildingService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return buildingService.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody BuildingDTO buildingDTO){
        return buildingService.create(buildingDTO);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return buildingService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody BuildingDTO buildingDTO){
        return buildingService.update(id,buildingDTO);
    }
}
