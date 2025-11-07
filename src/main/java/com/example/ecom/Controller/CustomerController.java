package com.example.ecom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.Dto.Customer;
import com.example.ecom.Response.ResponseStructure;
import com.example.ecom.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	/*
	 * Insert the method..
	 */
	@PostMapping("/register")
	public ResponseStructure<Customer> saveCustomerService(@RequestBody Customer customer)
	{
		return customerService.saveCustomerService(customer);
	}
	
	/*
	 * Login Email and Password...
	 */
	@GetMapping("/login/{email}/{password}")
	public ResponseStructure<Customer> LoginCustomerWithEmailAndPAsswordService(@PathVariable("email") String email,@PathVariable("password") String password)
	{
		return customerService.loginCustomerWithEmailAndPasswordService(email, password);
	}
}
