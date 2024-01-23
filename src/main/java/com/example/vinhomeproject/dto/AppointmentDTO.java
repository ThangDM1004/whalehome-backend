package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.Apartment;
import com.example.vinhomeproject.models.Users;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {
    private String statusAppointment;
    private Date dateTime;
    private Users users;
    private Apartment apartment;
}
