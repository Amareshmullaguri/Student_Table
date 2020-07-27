package com.example.StudentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentApp.modal.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	

}
