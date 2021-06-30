package com.nhom43.projectqlcc.service;

import java.util.ArrayList;

import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;
import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Không tìm thấy người dùng có username: " + username);
        }
    }
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public TaiKhoan save(TaiKhoanDTO tkDTO) {
        TaiKhoan newUser = new TaiKhoan();

        newUser.setTaiKhoan(tkDTO.getTaiKhoan());
        newUser.setMatKhau(bcryptEncoder.encode(tkDTO.getMatKhau()));
        newUser.setPhanQuyen(tkDTO.getPhanQuyen());
        newUser.setEmail(tkDTO.getEmail());
        newUser.setSoDienThoai(tkDTO.getSoDienThoai());

        return taiKhoanRepository.save(newUser);
    }
}
