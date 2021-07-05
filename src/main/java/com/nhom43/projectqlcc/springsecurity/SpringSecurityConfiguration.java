package com.nhom43.projectqlcc.springsecurity;


import com.nhom43.projectqlcc.springsecurity.config.CustomJwtAuthenticationFilter;
import com.nhom43.projectqlcc.springsecurity.config.CustomUserDetailsService;
import com.nhom43.projectqlcc.springsecurity.config.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Cấu hình AuthenticationManager để nó biết từ đâu cần tải
        // người dùng cho thông tin đăng nhập phù hợp
        // Sử dụng BCryptPasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Chúng tôi không cần CSRF cho ví dụ này
        http.csrf().disable()
                .authorizeRequests()
                // Yêu cầu xác thự quyền ADMIN
                .antMatchers("/helloadmin").hasRole("ADMIN")
                // Yêu cầu xác thực quyền USER hoặc ADMIN
                .antMatchers("/hellouser").hasAnyRole("USER", "ADMIN")
                // Không xác thực yêu cầu cụ thể này
                .antMatchers("/authenticate", "/register").permitAll().anyRequest().authenticated()
                // Nếu có bất kỳ ngoại lệ nào xảy ra, sẽ gọi
                .and().exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler).and()
                // Đảm bảo rằng chúng ta sử dụng phiên không trạng thái; phiên sẽ không được sử dụng để
                // lưu trữ trạng thái của người dùng
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Thêm bộ lọc để xác thực mã Tokens với mọi yêu cầu
        http.addFilterBefore(customJwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);
    }


}