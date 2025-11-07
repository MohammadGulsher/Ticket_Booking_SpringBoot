package com.example.ecom.Service;

import com.example.ecom.Dto.Customer;
import com.example.ecom.Response.ResponseStructure;

public interface CustomerService {

	ResponseStructure<Customer> saveCustomerService(Customer customer);
	
	ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email,String password);
}
