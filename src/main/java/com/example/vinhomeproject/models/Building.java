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
public class Building extends Base{

    private String name;

    @ManyToOne
    @JoinColumn(name = "zone")
    private Zone zone;

}
