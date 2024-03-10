package com.example.vinhomeproject.service;


import com.example.vinhomeproject.dto.AreaDTO;
import com.example.vinhomeproject.dto.ContractDTO;
import com.example.vinhomeproject.models.Area;
import com.example.vinhomeproject.models.Contract;
import com.example.vinhomeproject.repositories.ContractHistoryRepository;
import com.example.vinhomeproject.repositories.ContractRepository;
import com.example.vinhomeproject.repositories.PaymentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractHistoryRepository contractHistoryRepository;
    public ResponseEntity<ResponseObject> getAll(){
        List<Contract> contracts = contractRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contracts
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Contract> contract = contractRepository.findById(id);
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contract
        ));
    }

    public ResponseEntity<ResponseObject> create(ContractDTO contractDTO){
        contractDTO.setContractHistory(contractHistoryRepository.findById(contractDTO.getContractHistory().getId()).get());
        contractRepository.save(Contract.builder()
                .dateSign(contractDTO.getDateSign())
                .description(contractDTO.getDescription())
                .dateStartRent(contractDTO.getDateStartRent())
                .contractHistory(contractDTO.getContractHistory())
                .build());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Create contract successfully",
                contractDTO
        ));
    }

    public ResponseEntity<ResponseObject> delete(Long id){
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            contract.get().setStatus(!contract.get().isStatus());
            contractRepository.save(contract.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Delete contract successfully",
                    contract
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found contract",
                ""
        ));
    }

    public ResponseEntity<ResponseObject> update(Long id, ContractDTO contractDTO){
        Optional<Contract> contract = contractRepository.findById(id);
        if(contract.isPresent()){
            if(contractDTO.getDateSign()!=null){contract.get().setDateSign(contractDTO.getDateSign());}
            if(contractDTO.getDescription()!=null){contract.get().setDescription(contractDTO.getDescription());}
            if(contractDTO.getDateStartRent()!=null){contract.get().setDateStartRent(contractDTO.getDateStartRent());}
            if(contractDTO.getContractHistory()!=null){contract.get().setContractHistory(contractHistoryRepository.findById(contractDTO.getContractHistory().getId()).get());}
            contractRepository.save(contract.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Update contract successfully",
                    contract
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found contract",
                ""
        ));
    }
    public ResponseEntity<ResponseObject> countAll(){
        List<Contract> contracts = contractRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                contracts.size()
        ));
    }
}
