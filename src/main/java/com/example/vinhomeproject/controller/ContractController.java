package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.ContractDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app"})
@RequestMapping("/api/v1/contracts")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return contractService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return contractService.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ContractDTO contractDTO){
        return contractService.create(contractDTO);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return contractService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody ContractDTO contractDTO){
        return contractService.update(id,contractDTO);
    }
}
