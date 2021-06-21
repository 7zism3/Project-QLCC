package com.nhom43.projectqlcc.model.mapper;

import com.nhom43.projectqlcc.entity.TaiKhoan;
import com.nhom43.projectqlcc.model.dto.TaiKhoanDTO;

public class TaiKhoanMapper {
    public static TaiKhoanDTO toTaiKhoanDTO (TaiKhoan taiKhoan){
        TaiKhoanDTO tmp = new TaiKhoanDTO();
        tmp.setIdTaiKhoan(taiKhoan.getIdTaiKhoan());
        tmp.setTaiKhoan(taiKhoan.getTaiKhoan());
        tmp.setPhanQuyen(taiKhoan.getPhanQuyen());
        tmp.setSoDienThoai(taiKhoan.getSoDienThoai());
        tmp.setEmail(taiKhoan.getEmail());
        return tmp;
    }
}
