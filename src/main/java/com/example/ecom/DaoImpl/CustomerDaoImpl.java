package com.example.ecom.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecom.Dao.CustomerDao;
import com.example.ecom.Dto.Customer;
import com.example.ecom.Repository.CustomerRepository;
@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired 
	private CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByEmailDao(String email) {
		Customer c=customerRepository.findByEmail(email);
		return c;
	}

	
}
