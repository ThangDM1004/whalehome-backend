package com.example.vinhomeproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ApartmentClass extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double rent_price;

    private double width;

    private double length;

    private double height;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
}
