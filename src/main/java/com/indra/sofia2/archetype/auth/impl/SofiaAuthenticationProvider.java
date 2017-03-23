package com.indra.sofia2.archetype.auth.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.indra.sofia2.archetype.auth.AuthenticationService;
import com.indra.sofia2.archetype.auth.CustomUser;
import com.indra.sofia2.archetype.auth.beans.AuthResponse;

@Component
public class SofiaAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = Logger.getLogger(SofiaAuthenticationProvider.class);
	
	@Autowired
	private AuthenticationService authService;
	/*
	@Autowired
	private KpsConfiguration kpsConfiguration;
	
	@Autowired
	private KpiService kpiService;
*/
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
			logger.info("trying to authenticate user " + authentication.getName());
	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
	        AuthResponse authResponse = authService.authenticate(username, password);
	        
	        if (authResponse.isAuthenticated()) {
	        	/*
	        	KpiJoinResponse joinResponse = kpiService.joinByToken(new KpiJoinRequest ( 
						   kpsConfiguration.getWebKpiToken(), 
						   kpsConfiguration.getWebKpiInstance()));
	        	
	        	*/
	        		        	
	        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        	authorities.add(new SimpleGrantedAuthority(authResponse.getResponse().getUser().getRol()));
	        	
	        	CustomUser user  = new CustomUser(username, password, "sessionkey", authorities);
	        	
	        	return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
	        	
	            // use the credentials and authenticate against the third-party system
	            //return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<GrantedAuthority>());
	        } else {
	            return null;
	        }

	}

	
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
	
}
