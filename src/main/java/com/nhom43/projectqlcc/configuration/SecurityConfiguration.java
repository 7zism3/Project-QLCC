package com.nhom43.projectqlcc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
//    @Autowired
    DataSource dataSource;
//    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select taikhoan, matkhau from taikhoan where taikhoan = ?")
                .authoritiesByUsernameQuery("Select taikhoan, phanquyen from taikhoan where taikhoan = ?");
    }
//    @Override
    protected void configure(HttpSecurity http) throws Exception{
        super.configure(http);
    }

}
