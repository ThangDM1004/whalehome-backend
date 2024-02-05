package com.example.vinhomeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Users extends  Base {
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private LocalDate dateOfBirth;
    private boolean status;
    private String image;
    private String gender;
    private String address;
    private boolean isVerified;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Review> review;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<ContractHistory> contractHistories;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Notifications> notifications;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Token> tokens;

}
