package com.customer.app.services;

import java.util.List;

import com.customer.app.model.CustomerModel;

public interface CustomerService {

	public CustomerModel addCustomer(CustomerModel customerModel);

	public List<CustomerModel> getAllCustomers();

	public CustomerModel getCustomerByName(String name);
	 public String findByUsernameAndPassword(String username,String password);

}
