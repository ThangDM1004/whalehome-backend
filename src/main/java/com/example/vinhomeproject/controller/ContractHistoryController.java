package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.dto.ContractDTO;
import com.example.vinhomeproject.dto.ContractHistoryDTO;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.ContractHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/contracthistories")
public class ContractHistoryController {
    @Autowired
    private ContractHistoryService contractHistoryService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        return contractHistoryService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return contractHistoryService.getById(id);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody ContractHistoryDTO contractHistoryDTO){
        return contractHistoryService.create(contractHistoryDTO);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return contractHistoryService.delete(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody ContractHistoryDTO contractHistoryDTO){
        return contractHistoryService.update(id,contractHistoryDTO);
    }
}
