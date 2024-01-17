package com.example.vinhomeproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Area extends Base{
    private String name;

    @OneToMany(mappedBy = "area")
    private List<Zone> zones;
}
