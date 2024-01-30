package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.ZoneDTO;
import com.example.vinhomeproject.dto.ZoneDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.ZoneService;
import com.example.vinhomeproject.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app"})
@RequestMapping("/api/v1/zone")
public class ZoneController {
    @Autowired
    private ZoneService serivce;
    @GetMapping()
    public ResponseEntity<ResponseObject> getAllZone(){
        return serivce.getAllZone();
    }
    @PostMapping("")
    public  ResponseEntity<ResponseObject> createZone(@RequestBody ZoneDTO zone){
        return serivce.createZone(zone);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteZone(@PathVariable Long id){
        return  serivce.deleteZone(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateZone(@PathVariable Long id,@RequestBody ZoneDTO userDTO){
        return  serivce.updateZone(id,userDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getbyId(@PathVariable Long id){
        return serivce.getById(id);
    }
}
