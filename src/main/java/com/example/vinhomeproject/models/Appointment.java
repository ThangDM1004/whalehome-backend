package com.example.vinhomeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
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


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users users;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    @JsonIgnore
    private Apartment apartment;

}
