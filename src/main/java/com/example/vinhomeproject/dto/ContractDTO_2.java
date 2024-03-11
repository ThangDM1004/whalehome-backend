package com.example.vinhomeproject.dto;

import com.example.vinhomeproject.models.Contract;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDTO_2 {
    private Contract contract;
    private Long apartmentId;
    private String apartmentName;
    private String buildingName;
    private String zoneName;
    private String areaName;
}
