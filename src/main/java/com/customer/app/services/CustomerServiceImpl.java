package com.customer.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.customer.app.model.CustomerModel;
import com.customer.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

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

	@Override
	public String findByUsernameAndPassword(String username, String password) { // TODO Auto-generated method stub
																				// return
		CustomerModel model = customerRepository.findByUsernameAndPassword(username, password);
		String response = "";
		if (model.getUsername() != null && model.getPassword() != null) {
			if ((model.getUsername()).equals(username) && (model.getPassword()).equals(password)) {
				response = "Success";
				return response;
			} else {
				return response;
			}
		} else {
			return response;
		}

	}

}
