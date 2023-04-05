package com.universal_yazilim.bid.ysm.transaction_app.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
web tabanlı guvenlik sağlamak icin @EnableWebSecurity "annotation" ı ve WebSecurityConfigurerAdapter  sınıfı kullanildi
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Value("${service.security.secure-key-username}")
    private String secureKeyUserName;

    @Value("${service.security.secure-key-password}")
    private String secureKeyPassword;

/*
Uygulamanin kullanici ad ve parola bilgilerinin
belirlenen bilgiler olmasi icin bu method "override" edilir
 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(secureKeyUserName)
                .password(encoder.encode(secureKeyPassword))
                .roles("USER");
    }

    //oturum acma session kullanilmayacak. JSON Web Token Kullanilacak
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        super.configure(httpSecurity);
        httpSecurity.csrf().disable();// tarayici uzerinde farkli sekmelerde oradaki oturum bilgileriniz calinmasini engeller.


    }
}
