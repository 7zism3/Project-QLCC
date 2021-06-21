package com.nhom43.projectqlcc.service;

import com.nhom43.projectqlcc.model.dto.TaiKhoanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaiKhoanService {
    public List<TaiKhoanDTO> getListTaiKhoan();

    public TaiKhoanDTO getTaiKhoanById (int id);

    List<TaiKhoanDTO> searchTaiKhoan(String name);
}
