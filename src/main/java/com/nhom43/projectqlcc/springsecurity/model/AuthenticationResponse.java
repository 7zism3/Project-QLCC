package com.nhom43.projectqlcc.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String taiKhoan;
    private String phanQuyen;
    private String messages;

}
