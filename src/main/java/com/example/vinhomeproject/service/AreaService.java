package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.AppointmentDTO;
import com.example.vinhomeproject.dto.AreaDTO;
import com.example.vinhomeproject.models.Appointment;
import com.example.vinhomeproject.models.Area;
import com.example.vinhomeproject.repositories.AreaRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public ResponseEntity<ResponseObject> getAll(){
        List<Area> areas = areaRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                areas
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Area> area = areaRepository.findById(id);
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                area
        ));
    }
    public ResponseEntity<String> create(AreaDTO areaDTO){
        areaRepository.save(Area.builder()
                .name(areaDTO.getName())
                .zones(areaDTO.getZones())
                .build());
        return ResponseEntity.ok("successfully");
    }
    public ResponseEntity<String> delete(Long id){
        Optional<Area> area = areaRepository.findById(id);
        if(area.isPresent()){
            area.get().setStatus(false);
            areaRepository.save(area.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<String> update(Long id, AreaDTO areaDTO){
        Optional<Area> area = areaRepository.findById(id);
        if(area.isPresent()){
            area.get().setName(areaDTO.getName());
            area.get().setZones(areaDTO.getZones());
            areaRepository.save(area.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
}
