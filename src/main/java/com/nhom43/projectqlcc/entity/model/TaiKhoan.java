package com.nhom43.projectqlcc.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Component
//---------
@Entity
@Table(name = "taikhoan")
public class TaiKhoan implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @ToString.Include()
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtaikhoan")
    private long idTaiKhoan;

    // Mapping thông tin biến với tên cột trong Database
    @ToString.Include()
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @Column(name = "phanquyen")
    private String phanQuyen;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "email")
    private String email;

    // Nếu không đánh dấu @Column thì sẽ mapping tự động theo tên biến
}
