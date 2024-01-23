package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.ApartmentDTO;
import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.repositories.ApartmentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    private ApartmentRepository apartmentRepository;

    public ResponseEntity<ResponseObject> getAll(){
        List<Apartment> apartments = apartmentRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                apartments
        ));
    }

    public ResponseEntity<String> create(ApartmentDTO apartmentDTO){
        apartmentRepository.save(Apartment.builder()
                        .name(apartmentDTO.getName())
                        .description(apartmentDTO.getDescription())
                        .living_room(apartmentDTO.getLiving_room())
                        .bed_room(apartmentDTO.getBed_room())
                        .kitchen(apartmentDTO.getKitchen())
                        .rest_room(apartmentDTO.getRest_room())
                        .floor(apartmentDTO.getFloor())
                        .area(apartmentDTO.getArea())
                        .air_conditioner(apartmentDTO.getAir_conditioner())
                        .electric_fan(apartmentDTO.getElectric_fan())
                        .television(apartmentDTO.getTelevision())
                        .electric_stoves(apartmentDTO.getElectric_stoves())
                        .gas_stoves(apartmentDTO.getGas_stoves())
                        .apartment_class(apartmentDTO.getApartment_class())
                        .building(apartmentDTO.getBuilding())
                        .build());
        return ResponseEntity.ok("Create successfully");
        //
    }
}
