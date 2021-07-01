package com.nhom43.projectqlcc.springsecurity.config;


import java.util.Arrays;
import java.util.List;

import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;
import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TaiKhoanRepository taiKhoanDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles=null;
        TaiKhoan user = taiKhoanDAO.findByTaiKhoan(username);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getPhanQuyen()));
            return new User(user.getTaiKhoan(), user.getMatKhau(), roles);
        }
        throw new UsernameNotFoundException("\"Không tìm thấy người dùng có username: " + username);
    }

    public TaiKhoan save(TaiKhoanDTO tkDTO) {
        TaiKhoan newUser = new TaiKhoan();

        newUser.setTaiKhoan(tkDTO.getTaiKhoan());
        newUser.setMatKhau(bcryptEncoder.encode(tkDTO.getMatKhau()));
        newUser.setPhanQuyen(tkDTO.getPhanQuyen());
        newUser.setEmail(tkDTO.getEmail());
        newUser.setSoDienThoai(tkDTO.getSoDienThoai());

        return taiKhoanDAO.save(newUser);
    }
}