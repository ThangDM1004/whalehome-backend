package com.example.vinhomeproject.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Role extends Base{
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
