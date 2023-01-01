package com.customer.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.model.CustomerModel;
import com.customer.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository  customerRepository ;
	
	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		return customerRepository.save(customerModel);
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public CustomerModel getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByName(name);
	}

	
}
