package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.ApartmentDTO;
import com.example.vinhomeproject.dto.ApartmentDTO_2;
import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.repositories.ApartmentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
                        .apartmentClass(apartmentDTO.getApartmentClass())
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
            apartment.get().setApartmentClass(apartmentDTO.getApartmentClass());
            apartment.get().setBuilding(apartmentDTO.getBuilding());

            apartmentRepository.save(apartment.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
    public ResponseEntity<ResponseObject> countAll(){
        List<Apartment> apartments = apartmentRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                apartments.size()
        ));
    }

    public ResponseEntity<ResponseObject> findAllApartmentsWithDetails(){
        Set<ApartmentDTO_2> apartments = apartmentRepository.findAllApartmentsWithDetails();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                apartments
        ));
    }
    public ResponseEntity<ResponseObject> findApartmentByIdWithDetails(Long id){
        ApartmentDTO_2 apartment = apartmentRepository.findApartmentByIdWithDetails(id);
        if(apartment != null){
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

    public Page<Apartment> getPage(int currentPage, int pageSize, String field) {
        return apartmentRepository.findAll(PageRequest.of(currentPage, pageSize, Sort.by(Sort.Direction.ASC, field)));
    }
}
