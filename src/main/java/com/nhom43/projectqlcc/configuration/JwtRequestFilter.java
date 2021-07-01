package com.nhom43.projectqlcc.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.ExpiredJwtException;

//@Component
public class JwtRequestFilter {
//        extends OncePerRequestFilter {
//
////    @Autowired
////    private JwtUserDetailsService jwtUserDetailsService;
//
////    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
////    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        final String requestTokenHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwtToken = null;
//        // Mã token JWT có dạng "Mã token mang". Xóa từ Bearer và
//        //		chỉ lấy Mã token
//        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//            jwtToken = requestTokenHeader.substring(7);
//            try {
//                username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Không thể lấy JWT Token");
//            } catch (ExpiredJwtException e) {
//                System.out.println("Mã Token JWT đã hết hạn");
//            }
//        } else {
//            logger.warn("Mã Token JWT không bắt đầu bằng Chuỗi ký hiệu \"Bearer \"");
//        }
//
//        // Sau khi chúng tôi nhận được mã Token xác thực nó.
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//
//            // Nếu mã Token hợp lệ, hãy cấu hình Spring Security để đặt
//            // xác thực theo cách thủ công
//            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//                usernamePasswordAuthenticationToken
//                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                // Sau khi đặt Xác thực trong ngữ cảnh, chúng tôi chỉ định
//                // rằng người dùng hiện tại đã được xác thực. Vì vậy, nó vượt qua
//                // Cấu hình bảo mật mùa xuân thành công.
//
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//        chain.doFilter(request, response);
//    }

}