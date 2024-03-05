package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.AppointmentDTO;
import com.example.vinhomeproject.models.Appointment;
import com.example.vinhomeproject.repositories.AppointmentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public ResponseEntity<ResponseObject> getAll(){
        List<Appointment> appointments = appointmentRepository.findAll();
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                appointments
        ));
    }

    public ResponseEntity<ResponseObject> getById(Long id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                appointment
        ));
    }

    public ResponseEntity<String> create(AppointmentDTO appointmentDTO){
        appointmentRepository.save(Appointment.builder()
                        .statusAppointment(appointmentDTO.getStatusAppointment())
                        .dateTime(appointmentDTO.getDateTime())
                        .users(appointmentDTO.getUsers())
                        .apartment(appointmentDTO.getApartment())
                        .build());
        return ResponseEntity.ok("successfully");
    }

    public ResponseEntity<String> delete(Long id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            appointment.get().setStatus(false);
            appointmentRepository.save(appointment.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }

    public ResponseEntity<String> update(Long id, AppointmentDTO appointmentDTO){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            if(appointmentDTO.getStatusAppointment()!=null){appointment.get().setStatusAppointment(appointmentDTO.getStatusAppointment());}
            if(appointmentDTO.getDateTime()!=null){appointment.get().setDateTime(appointmentDTO.getDateTime());}
            if(appointmentDTO.getUsers()!=null){appointment.get().setUsers(appointmentDTO.getUsers());}
            if (appointmentDTO.getApartment()!=null){appointment.get().setApartment(appointmentDTO.getApartment());}
            appointmentRepository.save(appointment.get());
            return ResponseEntity.ok("successfully");
        }
        return ResponseEntity.badRequest().body("failed");
    }
}
