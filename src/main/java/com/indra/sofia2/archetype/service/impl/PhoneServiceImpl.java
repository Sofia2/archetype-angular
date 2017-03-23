package com.indra.sofia2.archetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indra.sofia2.archetype.controller.Phone;
import com.indra.sofia2.archetype.service.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService{
	
	private static final String NEXUS_ID = "nexus";
	private static final String MOTO_WIFI_ID = "motoxoomwifi";
	private static final String MOTO_ID = "motoxoom";

	@Override
	public List<Phone> getAllPhones() {
		List<Phone> phones = new ArrayList<>();
		phones.add(getPhone(NEXUS_ID));
		phones.add(getPhone(MOTO_WIFI_ID));
		phones.add(getPhone(MOTO_ID));
		return phones;
	}

	@Override
	public Phone getPhone(String id) {
		
		Phone phone = null;
		
		switch (id) {
			case NEXUS_ID:
				phone = new Phone("nexus","Nexus S", "Fast just got faster with Nexus S.",
						"resources/images/phones/nexus-s.0.jpg");
				break;
			case MOTO_WIFI_ID:
				phone = new Phone("motoxoomwifi","Motorola XOOM with Wi-Fi", "The Next, Next Generation tablet.",
						"resources/images/phones/motorola-xoom-with-wi-fi.0.jpg");
				break;
			case MOTO_ID:
				phone = new Phone("motoxoom","MOTOROLA XOOM", "The Next, Next Generation tablet.",
			  			"resources/images/phones/motorola-xoom.0.jpg");
				break;
	
			default:
				break;
		}
		
		return phone;
	}

}
