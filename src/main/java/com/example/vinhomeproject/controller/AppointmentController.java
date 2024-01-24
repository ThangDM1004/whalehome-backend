package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.AppointmentDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return appointmentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return appointmentService.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.create(appointmentDTO);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return appointmentService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.update(id,appointmentDTO);
    }
}
