package com.indra.sofia2.archetype.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indra.sofia2.archetype.auth.CustomUser;
import com.indra.sofia2.archetype.service.PhoneService;
import com.indra.sofia2.archetype.service.bean.phone.Phone;
import com.indra.sofia2.archetype.service.bean.phone.PhoneWrapper;


@RestController
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping("/resource")
	public Map<String,Object> home() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	//https://www.future-processing.pl/blog/exploring-spring-boot-and-spring-security-custom-token-based-authentication-of-rest-services-with-spring-security-and-pinch-of-spring-java-configuration-and-spring-integration-testing/
	@RequestMapping(value = "/phone/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  @ResponseBody List<PhoneWrapper> list (@AuthenticationPrincipal CustomUser user) {
		
		return phoneService.getAllPhones(user.getSessionKey());
		
	}
	
	@RequestMapping(value = "/phone/{id}", method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public  @ResponseBody Phone detail (@AuthenticationPrincipal CustomUser user, @PathVariable(value="id")String id) {		
		
		return phoneService.getPhone(user.getSessionKey(), id).getPhone();
	}

}
