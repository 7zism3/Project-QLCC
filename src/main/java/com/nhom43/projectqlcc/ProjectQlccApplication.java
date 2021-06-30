package com.nhom43.projectqlcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Đánh dấu các thư mục sẽ đc Scan để tìm các Component, mặc định k có sẽ quét toàn bộ
//@ComponentScan("com.nhom43.projectqlcc.entity")

// Đánh dấu file Spring Boot để chạy
@SpringBootApplication
        (exclude = SecurityAutoConfiguration.class)

public class ProjectQlccApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProjectQlccApplication.class, args);
//        TaiKhoan taiKhoan = context.getBean (TaiKhoan.class);
//        System.out.println("Kiểu: "+ taiKhoan);
//        taiKhoan.hello();
    }

    @Bean
    public RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
