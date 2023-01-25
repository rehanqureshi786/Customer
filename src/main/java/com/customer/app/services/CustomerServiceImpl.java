package com.customer.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.exception.ResourceAlreadyExistException;
import com.customer.app.exception.ResourceNotFoundException;
import com.customer.app.model.CustomerModel;
import com.customer.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) throws ResourceAlreadyExistException {
		// TODO Auto-generated method stub

		if (customerRepository.existsById(customerModel.getId())) {
			throw new ResourceAlreadyExistException("Customer Already Exist with ID: " + customerModel.getId());

		} else
			return customerRepository.save(customerModel);
	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public CustomerModel getCustomerByName(String name) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		try {
			return customerRepository.getCustomerByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Customer not found by " + name);
			throw new ResourceNotFoundException("Customer Not Found By Name: " + name);
		}
	}

	@Override
	public String findByUsernameAndPassword(String username, String password) { // TODO Auto-generated method stub
																				// return
		CustomerModel model = customerRepository.findByUsernameAndPassword(username, password);
		String response = "Fail";
		if (model != null) {
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

	@Override
	public CustomerModel getCustomerById(int id){
		// TODO Auto-generated method stub
		Optional<CustomerModel> model=customerRepository.findById(id);
		if(model.isPresent())
		{
			return model.get();
		}
		else
		{
			throw new ResourceNotFoundException("Customer Not Found with ID : "+id);
		}
	}

}
