package com.nhom43.projectqlcc.springsecurity.config;


import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        String message;
        // Kiểm tra xem Request có phải là bất kỳ ngoại lệ nào mà chúng tôi đã lưu trữ trong Request hay không?
        final Exception exception = (Exception) request.getAttribute("xception");
        // Nếu có thì hãy sử dụng nó để tạo thông báo phản hồi, còn lại hãy sử dụng authException
        if (exception != null) {
            byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("cause", exception.toString()));
            response.getOutputStream().write(body);
        } else {
            if (authException.getCause() != null) {
                message = authException.getCause().toString() + " " + authException.getMessage();
            } else {
                message = authException.getMessage();
            }
            byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));
            response.getOutputStream().write(body);
        }
    }

}