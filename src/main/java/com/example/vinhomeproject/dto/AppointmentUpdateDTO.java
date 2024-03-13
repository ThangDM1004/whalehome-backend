package com.example.vinhomeproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentUpdateDTO {
    private String statusAppointment;
    private LocalDate dateTime;
    private Long usersId;
    private Long apartmentId;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    private String note;
}
