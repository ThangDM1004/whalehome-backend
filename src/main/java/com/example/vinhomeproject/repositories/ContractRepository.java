package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.dto.ContractDTO_2;
import com.example.vinhomeproject.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("SELECT NEW com.example.vinhomeproject.dto.ContractDTO_2(c.dateSign,c.description,c.dateStartRent,c.contractHistory,a.id,a.name,a.building.name,a.building.zone.name,a.building.zone.area.name) FROM Contract c, Appointment ap, Apartment a WHERE c.appointment.id = ap.id and ap.apartment.id = a.id")
    List<ContractDTO_2> getAll();
}
