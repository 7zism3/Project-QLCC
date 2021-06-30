package com.nhom43.projectqlcc.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TaiKhoanDTO {

    private String taiKhoan;
    private String matKhau;
    private String phanQuyen;
    private String soDienThoai;
    private String email;

}
