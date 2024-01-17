package com.example.vinhomeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ContractHistory extends Base {
    private double price;
    private boolean status;
    private String description;
    private String image;
    private Date expiredTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToMany(mappedBy = "contractHistory")
    @JsonIgnore
    private Set<Contract> contracts;
}
