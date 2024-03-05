package com.example.vinhomeproject.service;


import com.example.vinhomeproject.dto.ContractDTO;
import com.example.vinhomeproject.dto.ContractHistoryDTO;
import com.example.vinhomeproject.models.Contract;
import com.example.vinhomeproject.models.ContractHistory;
import com.example.vinhomeproject.repositories.ContractHistoryRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractHistoryService {
    @Autowired
    private ContractHistoryRepository contractHistoryRepository;

    public ResponseEntity<ResponseObject> getAll(){
        List<ContractHistory> contractHistories = contractHistoryRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contractHistories
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<ContractHistory> contractHistory = contractHistoryRepository.findById(id);
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contractHistory
        ));
    }

    public ResponseEntity<String> create(ContractHistoryDTO contractHistoryDTO){
        contractHistoryRepository.save(ContractHistory.builder()
                .price(contractHistoryDTO.getPrice())
                .description(contractHistoryDTO.getDescription())
                .image(contractHistoryDTO.getImage())
                .expiredTime(contractHistoryDTO.getExpiredTime())
                .users(contractHistoryDTO.getUsers())
                .contracts(contractHistoryDTO.getContracts())
                .build());
        return ResponseEntity.ok("successfully");
    }
    public ResponseEntity<String> delete(Long id){
        Optional<ContractHistory> contractHistory = contractHistoryRepository.findById(id);
        if(contractHistory.isPresent()){
            contractHistory.get().setStatus(!contractHistory.get().isStatus());
            contractHistoryRepository.save(contractHistory.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
    public ResponseEntity<String> update(Long id, ContractHistoryDTO contractHistoryDTO){
        Optional<ContractHistory> contractHistory = contractHistoryRepository.findById(id);
        if(contractHistory.isPresent()){
            if(contractHistoryDTO.getPrice()!=0){contractHistory.get().setPrice(contractHistoryDTO.getPrice());}
            if(contractHistoryDTO.getDescription()!=null){contractHistory.get().setDescription(contractHistoryDTO.getDescription());}
            if(contractHistoryDTO.getImage()!=null){contractHistory.get().setImage(contractHistoryDTO.getImage());}
            if(contractHistoryDTO.getExpiredTime()!=null){contractHistory.get().setExpiredTime(contractHistoryDTO.getExpiredTime());}
            if(contractHistoryDTO.getUsers()!=null){contractHistory.get().setUsers(contractHistoryDTO.getUsers());}
            if(contractHistoryDTO.getContracts()!=null){contractHistory.get().setContracts(contractHistoryDTO.getContracts());}

            contractHistoryRepository.save(contractHistory.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
}
