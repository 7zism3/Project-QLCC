package com.nhom43.projectqlcc.controller;

import com.nhom43.projectqlcc.entity.TaiKhoan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @RequestMapping (value = "/login", method = RequestMethod.GET)
    public TaiKhoan login(){
        TaiKhoan taiKhoan = new TaiKhoan(1, "admin", "admin", 1, "113", "admin@qlcc.com");

        return taiKhoan;
    }

}
