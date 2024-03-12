package com.example.vinhomeproject.models;

import com.example.vinhomeproject.config.TimeConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class Appointment extends Base{
    private String statusAppointment;
    private LocalDate dateTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    private String note;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;


    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    @JsonIgnore
    private Contract contract;
}
