package com.indra.sofia2.archetype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import com.indra.sofia2.archetype.auth.impl.SofiaAuthenticationProvider;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
		@Autowired
    	private SofiaAuthenticationProvider authProvider;
		
		@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(this.authProvider);
	    }
		
		@Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(this.authProvider);
	    }

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
            .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers("/login")
                .and()
            .formLogin()
                .loginPage("/login").usernameParameter("username")
                						.passwordParameter("password")
                						.loginProcessingUrl("/login")
                .permitAll()
                .and()
            .logout().logoutUrl("/logout")
                .permitAll();
		}
		
	
}
