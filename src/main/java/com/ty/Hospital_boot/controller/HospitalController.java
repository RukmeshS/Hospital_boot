package com.ty.Hospital_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Hospital_boot.dto.Hospital;
import com.ty.Hospital_boot.service.HospitalService;
import com.ty.Hospital_boot.util.ResponseStructure;

@RestController
@RequestMapping("hospital")
public class HospitalController {

	@Autowired
	HospitalService hospitalservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital)
	{
		return hospitalservice.saveHospital(hospital);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id)
	{
		return hospitalservice.getHospitalById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestBody Hospital hospital,@RequestParam int id)
	{
		return hospitalservice.updateHospital(hospital, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(@RequestParam int id) 
	{
		return hospitalservice.deleteHospitalById(id);
	}
}
