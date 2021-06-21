package com.nhom43.projectqlcc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TaiKhoanDTO {

    private int idTaiKhoan;
    private String taiKhoan;
    private int phanQuyen;
    private String soDienThoai;
    private String email;

    public void hello() {
        System.out.println("Xin chào! ");
    }
}
