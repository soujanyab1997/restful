package com.ravi.restful.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.restful.webservices.model.Name;
import com.ravi.restful.webservices.model.PersonVOne;
import com.ravi.restful.webservices.model.PersonVTwo;

@RestController
public class VersionRestController {

	@GetMapping(path = "/v1/persons")
	public PersonVOne getPersonVOne() {
		PersonVOne personVOne = new PersonVOne();
		personVOne.setName("Karnati Ravinder");
		return personVOne;
	}
	
	@GetMapping(path = "/v2/persons")
	public PersonVTwo getPersionVTwo() {
		PersonVTwo personVTwo = new PersonVTwo();
		Name name = new Name();
		name.setFirstName("Karnati");
		name.setLastName("Ravinder");
		personVTwo.setName(name);
		return personVTwo;
	}

}
