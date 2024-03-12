package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.models.Users;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO_2 {
    private String statusAppointment;
    private LocalDate dateTime;
    private LocalTime time;
    private String createBy;
    private Apartment apartment;
    private String note;
    private String address;
}
