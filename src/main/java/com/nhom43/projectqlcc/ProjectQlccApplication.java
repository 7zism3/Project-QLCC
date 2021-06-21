package com.nhom43.projectqlcc;

import com.nhom43.projectqlcc.entity.TaiKhoan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// Đánh dấu các thư mục sẽ đc Scan để tìm các Component, mặc định k có sẽ quét toàn bộ
//@ComponentScan("com.nhom43.projectqlcc.entity")

// Đánh dấu file Spring Boot để chạy
@SpringBootApplication
public class ProjectQlccApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProjectQlccApplication.class, args);
//        TaiKhoan taiKhoan = context.getBean (TaiKhoan.class);
//        System.out.println("Kiểu: "+ taiKhoan);
//        taiKhoan.hello();
    }

}
