package com.indra.sofia2.archetype.service;

import java.util.List;

import com.indra.sofia2.archetype.controller.Phone;

public interface PhoneService {
	
	List<Phone> getAllPhones();
	Phone getPhone(String id);

}
