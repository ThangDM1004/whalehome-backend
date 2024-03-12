package com.example.vinhomeproject.service;

import com.example.vinhomeproject.dto.AppointmentDTO;
import com.example.vinhomeproject.models.Appointment;
import com.example.vinhomeproject.repositories.ApartmentRepository;
import com.example.vinhomeproject.repositories.AppointmentRepository;
import com.example.vinhomeproject.repositories.UsersRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private UsersRepository usersRepository;
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
                "Get appointment by id successfully",
                appointment
        ));
    }

    public ResponseEntity<ResponseObject> create(AppointmentDTO appointmentDTO){
        appointmentDTO.setApartment(apartmentRepository.findById(appointmentDTO.getApartment().getId()).get());
        appointmentDTO.setUsers(usersRepository.findById(appointmentDTO.getUsers().getId()).get());
        appointmentRepository.save(Appointment.builder()
                        .statusAppointment(appointmentDTO.getStatusAppointment())
                        .dateTime(appointmentDTO.getDateTime())
                        .users(appointmentDTO.getUsers())
                        .time(appointmentDTO.getTime())
                        .apartment(appointmentDTO.getApartment())
                        .build());
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Create appointment successfully",
                appointmentDTO
        ));
    }

    public ResponseEntity<ResponseObject> delete(Long id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            appointment.get().setStatus(!appointment.get().isStatus());
            appointmentRepository.save(appointment.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Delete appointment successfully",
                    appointment.get()
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found appointment",
                ""
        ));
    }

    public ResponseEntity<ResponseObject> update(Long id, AppointmentDTO appointmentDTO){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            if(appointmentDTO.getStatusAppointment()!=null){appointment.get().setStatusAppointment(appointmentDTO.getStatusAppointment());}
            if(appointmentDTO.getDateTime()!=null){appointment.get().setDateTime(appointmentDTO.getDateTime());}
            if(appointmentDTO.getUsers()!=null){appointment.get().setUsers(appointmentDTO.getUsers());}
            if (appointmentDTO.getApartment()!=null){appointment.get().setApartment(appointmentDTO.getApartment());}
            appointmentRepository.save(appointment.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                    "Update appointment successfully",
                    appointment.get()
            ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject(
                "Not found appointment",
                ""
        ));
    }
}
