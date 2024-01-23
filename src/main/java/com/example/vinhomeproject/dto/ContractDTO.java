package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.ContractHistory;
import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.models.Problems;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDTO {
    private Date dateSign;
    private String description;
    private Date dateStartRent;

    private Set<Problems> problems;

    private Set<Payment> payments;

    private ContractHistory contractHistory;
}
