package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u ORDER BY u.id ASC ")
    List<Users> findAll();
    Optional<Users> findByEmail(String email);

    @Query("SELECT a FROM Apartment a, Appointment ap, Contract c, ContractHistory ch, Users u " +
            "WHERE a.id = ap.apartment.id " +
            "AND ap.contract.id = c.id " +
            "AND c.contractHistory.id = ch.id " +
            "AND ch.users.id = u.id " +
            "AND u.id = ?1 AND ap.statusAppointment = \"Complete\"")
    List<Apartment> getListApartmentByUserId(Long id);
}
