package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.ApartmentDTO;
import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.repositories.ApartmentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public ResponseEntity<ResponseObject> getAll(){
        List<Apartment> apartments = apartmentRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                apartments
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if(apartment.isPresent()){
            return ResponseEntity.ok(new ResponseObject(
                    "successfully",
                    apartment
            ));
        }
        return ResponseEntity.ok(new ResponseObject(
                "failed",
                null
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
        return ResponseEntity.ok("successfully");
    }

    public ResponseEntity<String> delete(Long id){
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if(apartment.isPresent()){
            apartment.get().setStatus(false);
            apartmentRepository.save(apartment.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<String> update(Long id, ApartmentDTO apartmentDTO){
        Optional<Apartment> apartment = apartmentRepository.findById(id);
        if(apartment.isPresent()){
            apartment.get().setName(apartmentDTO.getName());
            apartment.get().setDescription(apartmentDTO.getDescription());
            apartment.get().setLiving_room(apartmentDTO.getLiving_room());
            apartment.get().setBed_room(apartmentDTO.getBed_room());
            apartment.get().setKitchen(apartmentDTO.getKitchen());
            apartment.get().setRest_room(apartmentDTO.getRest_room());
            apartment.get().setFloor(apartmentDTO.getFloor());
            apartment.get().setArea(apartmentDTO.getArea());
            apartment.get().setAir_conditioner(apartmentDTO.getAir_conditioner());
            apartment.get().setElectric_fan(apartmentDTO.getElectric_fan());
            apartment.get().setTelevision(apartmentDTO.getTelevision());
            apartment.get().setElectric_stoves(apartmentDTO.getElectric_stoves());
            apartment.get().setGas_stoves(apartmentDTO.getGas_stoves());
            apartment.get().setApartment_class(apartmentDTO.getApartment_class());
            apartment.get().setBuilding(apartmentDTO.getBuilding());

            apartmentRepository.save(apartment.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
}
