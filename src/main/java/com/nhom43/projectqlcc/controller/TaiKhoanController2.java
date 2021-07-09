//package com.nhom43.projectqlcc.controller;
//
//import com.nhom43.projectqlcc.entity.model.TaiKhoan;
//import com.nhom43.projectqlcc.entity.dto.TaiKhoanDTO;
//import com.nhom43.projectqlcc.service.TaiKhoanService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin (origins = "http://localhost:3000")  // Cho phép nhận các yêu cầu từ Font-end có địa chỉ ...
//@RequestMapping("/tai-khoan")
//
//public class TaiKhoanController2 {
//    @Autowired
//    private TaiKhoanService taiKhoanService;
//
//    @GetMapping("")
//    public ResponseEntity<?> getListTaiKhoan() {
//        List<TaiKhoan> taiKhoans = taiKhoanService.getListTaiKhoan();
//        return ResponseEntity.ok(taiKhoans);
//    }
//
//    @GetMapping("/id={id}")
//    public ResponseEntity<?> getTaiKhoanById(@PathVariable("id") int id) {
//        TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoanById(id);
//        return ResponseEntity.ok(taiKhoanDTO);
//    }
//
//    @GetMapping("/taikhoan={taikhoan}")
//    public ResponseEntity<?> getTaiKhoanByTaiKhoan(@PathVariable("taikhoan") String taiKhoan) {
//        TaiKhoanDTO taiKhoanDTO = taiKhoanService.getTaiKhoanByTaiKhoan(taiKhoan);
//        return ResponseEntity.ok(taiKhoanDTO);
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<?> searchTaiKhoan(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
//        List<TaiKhoanDTO> taiKhoans = taiKhoanService.searchTaiKhoan(name);
//        return ResponseEntity.ok(taiKhoans);
//    }
//
//    @PostMapping("")
//    public ResponseEntity<?> createTaiKhoan() {
//        TaiKhoan taiKhoan = new TaiKhoan();
//
//
//        return null;
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateTaiKhoan() {
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteTaiKhoan() {
//        return null;
//    }
//
//}
