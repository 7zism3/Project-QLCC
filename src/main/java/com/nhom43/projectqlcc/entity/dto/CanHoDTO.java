package com.nhom43.projectqlcc.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Component
    public class CanHoDTO {

        private String tenCanHo;
        private String moTa;
        private int dienTich;

    }