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

import com.ty.Hospital_boot.dto.Branch;
import com.ty.Hospital_boot.service.BranchService;
import com.ty.Hospital_boot.util.ResponseStructure;

@RestController
@RequestMapping("branch")
public class BranchController {

	@Autowired
	BranchService branchservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchservice.saveBranch(branch);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id)
	{
		return branchservice.getBranchById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestBody Branch branch,@RequestParam int id)
	{
		return branchservice.updateBranch(branch, id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> deleteBranchById(@RequestParam int id) 
	{
		return branchservice.deleteBranchById(id);
	}
}
