package com.indra.sofia2.archetype.auth.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.indra.sofia2.archetype.service.KpiService;
import com.indra.sofia2.archetype.service.bean.kpi.request.KpiJoinRequest;
import com.indra.sofia2.archetype.service.bean.kpi.response.KpiJoinResponse;

@Component
public class SofiaAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = Logger.getLogger(SofiaAuthenticationProvider.class);
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private KpiService kpiService;
	
	@Value("${web.kpi.token:}")
	private String webKpiToken;
	
	@Value("${web.kpi.instance:}")
	private String webKpiInstance;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
			logger.info("trying to authenticate user " + authentication.getName());
	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
	        AuthResponse authResponse = authService.authenticate(username, password);
	        
	        if (authResponse.isAuthenticated()) {
	        	
	        	KpiJoinResponse joinResponse = kpiService.joinByToken(new KpiJoinRequest(webKpiToken, webKpiInstance));
	        		        	
	        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        	authorities.add(new SimpleGrantedAuthority(authResponse.getResponse().getUser().getRol()));
	        	
	        	CustomUser user  = new CustomUser(username, password, joinResponse.getSessionKey(), authorities);
	        	
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
