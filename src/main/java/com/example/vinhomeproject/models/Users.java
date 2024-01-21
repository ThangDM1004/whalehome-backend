package com.example.vinhomeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

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
    private Date dataOfBirth;
    private boolean status;
    private String image;
    private String gender;
    private String address;
    private boolean isVerified;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Role> roles;

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
    private List<Token> tokens;

}
