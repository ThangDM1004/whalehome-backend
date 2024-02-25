package com.example.vinhomeproject.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationUserRequest {
    private String access_token;
}
