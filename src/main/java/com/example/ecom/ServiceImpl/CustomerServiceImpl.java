package com.example.ecom.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ecom.Dao.CustomerDao;
import com.example.ecom.Dto.Customer;
import com.example.ecom.Response.ResponseStructure;
import com.example.ecom.Service.CustomerService;

import jakarta.servlet.http.HttpSession;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ResponseStructure<Customer> responseStructure;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public ResponseStructure<Customer> saveCustomerService(Customer customer) {
		Customer customer1=customerDao.saveCustomer(customer);
		if(customer1!=null)
		{
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Customer Register");
			responseStructure.setData(customer1);
			return responseStructure;
		}
		else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Not Register Customer");
			responseStructure.setData(customer1);
			return responseStructure;
		}
	}

	@Override
	public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordService(String email, String password) {
		Customer customer1=customerDao.findByEmailDao(email);
		if(customer1!=null)
		{
			if(customer1.getPassword().equals(password))
			{
				session.setAttribute("customerSession", email);
				responseStructure.setStatusCode(HttpStatus.CONTINUE.value());
				responseStructure.setMessage("Login success go ahead..");
				customer1.setPassword("*****");
				responseStructure.setData(customer1);
				return responseStructure;
			}else
			{
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMessage("Login faild...becaused password is wrong");
				responseStructure.setData(customer1);
				return responseStructure;
			}
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Login11 is Faild..becaused password Failed");
			responseStructure.setData(customer1);
			return responseStructure;
		}
	}

}
