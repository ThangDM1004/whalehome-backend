package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.UserDTO;
import com.example.vinhomeproject.dto.ZoneDTO;
import com.example.vinhomeproject.mapper.UserMapper;
import com.example.vinhomeproject.mapper.ZoneMapper;
import com.example.vinhomeproject.models.Users;
import com.example.vinhomeproject.models.Zone;
import com.example.vinhomeproject.repositories.UsersRepository;
import com.example.vinhomeproject.repositories.ZoneRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ZoneService {

    @Autowired
    private ZoneRepository repo;
    @Autowired
    private ZoneMapper mapper;

    public ResponseEntity<ResponseObject> getAllZone(){
        List<Zone> zones = repo.findAll();
        if(!zones.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    zones
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "List zone null",
                    null
            ));
        }
    }

    public ResponseEntity<ResponseObject> createZone(ZoneDTO zoneDTO){
        zoneDTO.setStatus(true);
        repo.save(mapper.createZoneToZoneDto(zoneDTO));
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new ResponseObject(
                    "Create zone successfully",
                    null
            ));
    }
    public ResponseEntity<ResponseObject>  deleteZone(Long id){
        Optional<Zone> zone = repo.findById(id);
        zone.get().setStatus(false);
        repo.save(zone.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete zone successfully",
                null
        ));
    }

    public ResponseEntity<ResponseObject>  updateZone(Long id,ZoneDTO zoneDTO){
        Optional<Zone> zone = repo.findById(id);
        mapper.update(zoneDTO,zone.get());
        repo.save(zone.get());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Delete user successfully",
                null
        ));
    }
    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Zone> zone = repo.findById(id);
        if(zone.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Successfully",
                    zone.get()
            ));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Zone null",
                    null
            ));
        }
    }
}


