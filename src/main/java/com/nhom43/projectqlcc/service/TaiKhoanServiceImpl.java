package com.nhom43.projectqlcc.service;

import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.repository.TaiKhoanRepository;
import com.nhom43.projectqlcc.exception.NotFoundException;
import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;
import com.nhom43.projectqlcc.entity.mapper.TaiKhoanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    //----------------


    @Override
    public List<TaiKhoan> getListTaiKhoan() {
        List<TaiKhoan> result = taiKhoanRepository.findAll();
        return result;
    }

    @Override
    public TaiKhoanDTO getTaiKhoanById(int id) {
        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (id == taiKhoan.getIdTaiKhoan()) {
                return TaiKhoanMapper.toTaiKhoanDTO(taiKhoan);
            }
        }
        throw new NotFoundException("Tài khoản không tồn tại trong hệ thống.");
    }

    @Override
    public TaiKhoanDTO getTaiKhoanByTaiKhoan(String tk) {
        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (tk.equals(taiKhoan.getTaiKhoan())) {
                return TaiKhoanMapper.toTaiKhoanDTO(taiKhoan);
            }
        }
        throw new NotFoundException("Tài khoản không tồn tại trong hệ thống.");
    }

    @Override
    public List<TaiKhoanDTO> searchTaiKhoan(String name) {
        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
        List<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        for (TaiKhoan taiKhoan : taiKhoans) {
            if (taiKhoan.getTaiKhoan().contains(name)) {
                result.add(TaiKhoanMapper.toTaiKhoanDTO(taiKhoan));
            }
        }
        return result;
    }
}
