package com.nhom43.projectqlcc.entity.mapper;

import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;

public class TaiKhoanMapper {
    public static TaiKhoanDTO toTaiKhoanDTO (TaiKhoan taiKhoan){
        TaiKhoanDTO tmp = new TaiKhoanDTO();
        tmp.setTaiKhoan(taiKhoan.getTaiKhoan());
        tmp.setPhanQuyen(taiKhoan.getPhanQuyen());
        tmp.setSoDienThoai(taiKhoan.getSoDienThoai());
        tmp.setEmail(taiKhoan.getEmail());
        return tmp;
    }

}
