package com.example.vinhomeproject.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO_2 {
    private double price;
    private LocalDate expiredDate;
    private String content;
    private Long contractId;
    private boolean status;
}
