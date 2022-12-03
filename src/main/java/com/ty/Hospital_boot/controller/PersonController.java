package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital_boot.dto.Person;
import com.ty.Hospital_boot.service.PersonService;
import com.ty.Hospital_boot.util.ResponseStructure;

@RestController
@RequestMapping("person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(@RequestBody Person person,@RequestParam  int id) {
		return personService.updatePerson(person , id);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);
		
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@RequestParam int id) {
		return personService.deletePersonById(id);
	}

}
