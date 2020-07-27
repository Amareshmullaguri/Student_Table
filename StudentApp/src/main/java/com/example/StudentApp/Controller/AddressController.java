package com.example.StudentApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApp.Repository.AddressRepository;
import com.example.StudentApp.modal.Address;
import com.example.StudentApp.modal.Student;

@RestController
@RequestMapping("/Address")

public class AddressController {
	@Autowired
	private AddressRepository repository;
	
	@PostMapping("/save")
	public Address save(@RequestBody Address address) {
		return repository.save(address);
	}

}
