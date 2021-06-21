package com.nhom43.projectqlcc.controller;

import com.nhom43.projectqlcc.entity.TaiKhoan;
import com.nhom43.projectqlcc.model.dto.TaiKhoanDTO;
import com.nhom43.projectqlcc.service.TaiKhoanService;
import com.nhom43.projectqlcc.service.TaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tai-khoan")

public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping ("")
    public ResponseEntity<?> getListTaiKhoan (){
        List<TaiKhoanDTO> taiKhoans = taiKhoanService.getListTaiKhoan();
        return ResponseEntity.ok(taiKhoans);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getTaiKhoanById (@PathVariable("id") int id){
//        System.out.println(id);
        TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoanById(id);
        return ResponseEntity.ok(taiKhoanDTO);
    }

    @GetMapping ("/search")
    public ResponseEntity<?> searchTaiKhoan (@RequestParam(name = "keyword", required = false, defaultValue = "") String name){
        List<TaiKhoanDTO> taiKhoans = taiKhoanService.searchTaiKhoan(name);
        return ResponseEntity.ok(taiKhoans);
    }

    @PostMapping("")
    public ResponseEntity<?> createTaiKhoan (){
        return null;
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> updateTaiKhoan (){
        return null;
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteTaiKhoan (){
        return null;
    }

}
