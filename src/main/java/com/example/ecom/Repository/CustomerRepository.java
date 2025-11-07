package com.example.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecom.Dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
}
