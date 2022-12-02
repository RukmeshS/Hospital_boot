package com.ty.Hospital_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Hospital_boot.dao.PersonDao;
import com.ty.Hospital_boot.dto.Person;
import com.ty.Hospital_boot.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(personDao.savePerson(person));

		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();

		Person person2 = personDao.getPersonById(id);

		if (person2 != null) {
			person.setId(id);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(personDao.updatePerson(person, id));
		} else {
			return null;
		}
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id) {

		Person person = personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();

		if (person != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("returning person data");
			responseStructure.setData(personDao.getPersonById(id));
		}

		else {
			return null;
		}

		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(
				responseStructure, HttpStatus.OK);

		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deletePersonById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		Person person = personDao.getPersonById(id);

		if (person != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("found");
			responseStructure.setData(personDao.deletePerson(id));

		}

		else {
			return null;

		}
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);

		return responseEntity;
	}

}
