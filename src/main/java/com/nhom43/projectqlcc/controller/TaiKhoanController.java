package com.nhom43.projectqlcc.controller;

import com.nhom43.projectqlcc.entity.model.TaiKhoan;
import com.nhom43.projectqlcc.entity.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Cho phép nhận các yêu cầu từ Font-end có địa chỉ ...
@RequestMapping("/tai-khoan")

public class TaiKhoanController {

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @GetMapping("")
    public ResponseEntity<List<TaiKhoan>> getAlltaiKhoans() {
        try {
            List<TaiKhoan> taiKhoans = new ArrayList<TaiKhoan>();
            taiKhoanRepository.findAll().forEach(taiKhoans::add);
            if (taiKhoans.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(taiKhoans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<TaiKhoan> getTaiKhoanById(@PathVariable("id") long id) {
        Optional<TaiKhoan> TaiKhoanData = taiKhoanRepository.findById(id);
        if (TaiKhoanData.isPresent()) {
            return new ResponseEntity<>(TaiKhoanData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<TaiKhoan> createTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        try {
            TaiKhoan _taiKhoan = taiKhoanRepository
                    .save(new TaiKhoan(taiKhoan.getTaiKhoan(), taiKhoan.getMatKhau()
                            , taiKhoan.getPhanQuyen(), taiKhoan.getSoDienThoai()
                            , taiKhoan.getEmail()));
            return new ResponseEntity<>(_taiKhoan, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id={id}")
    public ResponseEntity<TaiKhoan> updateTaiKhoan(@PathVariable("id") long id, @RequestBody TaiKhoan taiKhoan) {
        Optional<TaiKhoan> TaiKhoanData = taiKhoanRepository.findById(id);
        if (TaiKhoanData.isPresent()) {
            TaiKhoan _taiKhoan = TaiKhoanData.get();
            _taiKhoan.setTaiKhoan(taiKhoan.getTaiKhoan());
            _taiKhoan.setMatKhau(taiKhoan.getMatKhau());
            _taiKhoan.setPhanQuyen(taiKhoan.getPhanQuyen());
            _taiKhoan.setSoDienThoai(taiKhoan.getSoDienThoai());
            _taiKhoan.setEmail(taiKhoan.getEmail());
            return new ResponseEntity<>(taiKhoanRepository.save(_taiKhoan), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<HttpStatus> deleteTaiKhoan(@PathVariable("id") long id) {
        try {
            taiKhoanRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteAlltaiKhoans() {
        try {
            taiKhoanRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/taiKhoans/published")
//    public ResponseEntity<List<TaiKhoan>> findByPublished() {
//        try {
//            List<TaiKhoan> taiKhoans = taiKhoanRepository.findByPublished(true);
//
//            if (taiKhoans.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(taiKhoans, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
