package com.nhom43.projectqlcc.entity;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Đánh dấu đây là 1 Component

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Component
public class TaiKhoan {

    @ToString.Include()
    private int idTaiKhoan;
    @ToString.Include()
    private String taiKhoan;
    private String matKhau;
    private int phanQuyen;
    private String soDienThoai;
    private String email;

    public void hello() {
        System.out.println("Xin chào! ");
    }
}
