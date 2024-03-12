package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.models.Users;
import lombok.*;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {
    private String statusAppointment;
    private LocalDate dateTime;
    private Users users;
    private Apartment apartment;
    private LocalTime time;
}
