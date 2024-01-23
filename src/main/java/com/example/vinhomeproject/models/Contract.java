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
public class Contract extends Base{
    private Date dateSign;
    private String description;
    private Date dateStartRent;

    @OneToMany(mappedBy = "contract")
    @JsonIgnore
    private Set<Problems> problems;

    @OneToMany(mappedBy = "contract")
    @JsonIgnore
    private Set<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private ContractHistory contractHistory;
}
