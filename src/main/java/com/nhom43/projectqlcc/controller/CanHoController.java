package com.nhom43.projectqlcc.controller;

import com.nhom43.projectqlcc.entity.model.CanHo;
import com.nhom43.projectqlcc.entity.repository.CanHoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
@RequestMapping("/can-ho")

public class CanHoController {
    
    @Autowired
    CanHoRepository canHoRepository;

    @GetMapping("")
    public ResponseEntity<List<CanHo>> getAllcanHos() {
        try {
            List<CanHo> canHos = new ArrayList<CanHo>();
            canHoRepository.findAll().forEach(canHos::add);
            if (canHos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(canHos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id={id}")
    public ResponseEntity<CanHo> getCanHoById(@PathVariable("id") long id) {
        Optional<CanHo> CanHoData = canHoRepository.findById(id);
        if (CanHoData.isPresent()) {
            return new ResponseEntity<>(CanHoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<CanHo> createCanHo(@RequestBody CanHo canHo) {
        try {
            CanHo _canHo = canHoRepository
                    .save(new CanHo(canHo.getTenCanHo(), canHo.getMoTa()
                            , canHo.getDienTich()));
            return new ResponseEntity<>(_canHo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id={id}")
    public ResponseEntity<CanHo> updateCanHo(@PathVariable("id") long id, @RequestBody CanHo canHo) {
        Optional<CanHo> CanHoData = canHoRepository.findById(id);
        if (CanHoData.isPresent()) {
            CanHo _canHo = CanHoData.get();
            _canHo.setTenCanHo(canHo.getTenCanHo());
            _canHo.setMoTa(canHo.getMoTa());
            _canHo.setDienTich(canHo.getDienTich());
            return new ResponseEntity<>(canHoRepository.save(_canHo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<HttpStatus> deleteCanHo(@PathVariable("id") long id) {
        try {
            canHoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteAllcanHos() {
        try {
            canHoRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/canHos/published")
//    public ResponseEntity<List<CanHo>> findByPublished() {
//        try {
//            List<CanHo> canHos = canHoRepository.findByPublished(true);
//
//            if (canHos.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(canHos, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
