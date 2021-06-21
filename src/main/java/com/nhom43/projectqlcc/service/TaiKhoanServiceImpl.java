package com.nhom43.projectqlcc.service;

import com.nhom43.projectqlcc.entity.TaiKhoan;
import com.nhom43.projectqlcc.exception.NotFoundException;
import com.nhom43.projectqlcc.model.dto.TaiKhoanDTO;
import com.nhom43.projectqlcc.model.mapper.TaiKhoanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private static ArrayList<TaiKhoan> taiKhoans = new ArrayList<TaiKhoan>();

    static {
        taiKhoans.add(new TaiKhoan(1, "admin", "admin", 1, "113", "admin@qlcc.com"));
        taiKhoans.add(new TaiKhoan(2, "P101_KH", "khachHang", 2, "090..11", "kh01@qlcc.com"));
        taiKhoans.add(new TaiKhoan(3, "P102_KH", "khachHang", 2, "090..12", "kh02@qlcc.com"));
    }

    @Override
    public List<TaiKhoanDTO> getListTaiKhoan() {
        List<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        for (TaiKhoan taiKhoan : taiKhoans) {
            result.add(TaiKhoanMapper.toTaiKhoanDTO(taiKhoan));
        }
        return result;
    }

    @Override
    public TaiKhoanDTO getTaiKhoanById(int id) {
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (id == taiKhoan.getIdTaiKhoan()) {
                return TaiKhoanMapper.toTaiKhoanDTO(taiKhoan);
            }
        }
        throw new NotFoundException("Tài khỏan không tồn tại trong hệ thống.");
    }

    @Override
    public List<TaiKhoanDTO> searchTaiKhoan(String name) {
        List<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan.getTaiKhoan().contains(name)) {
                result.add(TaiKhoanMapper.toTaiKhoanDTO(taiKhoan));
            }
        }
        return result;
    }
}
