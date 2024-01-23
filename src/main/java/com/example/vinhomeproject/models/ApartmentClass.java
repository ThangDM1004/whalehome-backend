package com.example.vinhomeproject.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class ApartmentClass extends Base{
    private String name;

    private double rent_price;

    private double width;

    private double length;

    private double height;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
}
