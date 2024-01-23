package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.Contract;
import com.example.vinhomeproject.models.Users;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractHistoryDTO {
    private double price;
    private String description;
    private String image;
    private Date expiredTime;

    private Users users;

    private Set<Contract> contracts;
}
