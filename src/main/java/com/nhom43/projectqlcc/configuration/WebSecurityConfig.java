package com.nhom43.projectqlcc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

//    @Autowired
    private UserDetailsService jwtUserDetailsService;

//    @Autowired
    private JwtRequestFilter jwtRequestFilter;

//    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Cấu hình AuthenticationManager để nó biết từ đâu cần tải
        // người dùng cho thông tin đăng nhập phù hợp
        // Sử dụng BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Chúng tôi không cần CSRF cho ví dụ này
        httpSecurity.csrf().disable()
                // Không xác thực yêu cầu cụ thể này
                .authorizeRequests().antMatchers("/authenticate", "/register").permitAll().
                // Tất cả các yêu cầu khác cần được xác thực
                        anyRequest().authenticated().and().
                // Đảm bảo rằng chúng ta sử dụng phiên không trạng thái; phiên sẽ không được sử dụng để
                // lưu trữ trạng thái của người dùng.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Thêm bộ lọc để xác thực mã Tokens với mọi yêu cầu
//        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
