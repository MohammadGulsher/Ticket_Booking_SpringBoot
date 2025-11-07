package com.example.ecom.Dao;

import com.example.ecom.Dto.Customer;

public interface CustomerDao {
	
	public Customer saveCustomer(Customer customer);
	
	public Customer findByEmailDao(String email);

}
