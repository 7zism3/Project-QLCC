package com.nhom43.projectqlcc.service;

import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaiKhoanService {
    public List<TaiKhoan> getListTaiKhoan();

    public TaiKhoanDTO getTaiKhoanById (int id);

    public TaiKhoanDTO getTaiKhoanByTaiKhoan (String taiKhoan);

    List<TaiKhoanDTO> searchTaiKhoan(String name);

//    public TaiKhoan save(TaiKhoanDTO tkDTO);
}
