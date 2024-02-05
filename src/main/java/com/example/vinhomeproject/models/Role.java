package com.example.vinhomeproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role extends Base{
    private String role;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<Users> users;

}
