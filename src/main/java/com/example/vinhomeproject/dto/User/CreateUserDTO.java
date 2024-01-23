package com.example.vinhomeproject.dto.User;

import com.example.vinhomeproject.models.Role;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class CreateUserDTO {
    private String email;
    private String password;
    private String phone;
    private String fullName;
    private Date dataOfBirth;
    private boolean status;
    private String image;
    private String gender;
    private String address;
    private boolean isVerified;
    private Set<Role> roles;

}
