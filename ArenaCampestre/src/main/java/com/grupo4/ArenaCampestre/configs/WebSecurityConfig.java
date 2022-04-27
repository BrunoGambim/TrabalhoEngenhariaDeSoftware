package com.grupo4.ArenaCampestre.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.grupo4.ArenaCampestre.handlers.CustomAccessDeniedHandler;
import com.grupo4.ArenaCampestre.handlers.CustomAuthenticationSuccessHandler;
import com.grupo4.ArenaCampestre.models.enums.UserRole;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    
    private static final String[] PUBLIC_MATCHERS = {
    		"/css/**", "/js/**", "/registration","/home" , "/"
	};
    
    private static final String[] CUSTOMER_MATCHERS = {
    		"/customer/**"
    };
    
    private static final String[] MANAGER_MATCHERS = {
    		"/manager/**"
	};

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(CUSTOMER_MATCHERS).hasAnyAuthority(UserRole.CUSTOMER.toString())
                .antMatchers(MANAGER_MATCHERS).hasAnyAuthority(UserRole.MANAGER.toString())
                .anyRequest().authenticated()
                .and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
            .and()
            .formLogin()
            	.successHandler(authenticationSuccessHandler())
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
       return authenticationManager();
    }
    
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
    
    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder());
		super.configure(auth);
	}
}
