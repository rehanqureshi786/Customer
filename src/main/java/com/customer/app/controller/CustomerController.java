package com.customer.app.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.export.CustomerExporter;
import com.customer.app.model.CustomerModel;
import com.customer.app.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	List<CustomerModel> list=new ArrayList<CustomerModel>();

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public CustomerModel addCustomer(@RequestBody CustomerModel customerModel) {
		list.add(customerModel);
		System.out.println("Customer Added");
		return customerModel;
	}

	@RequestMapping(value = "/getcustomers",method = RequestMethod.GET)
	public List<CustomerModel> getCustomers(HttpServletResponse response)throws IOException
	{
		System.out.println("Test");
		/*
		 * CustomerExporter customer=new
		 * CustomerExporter(customerService.getAllCustomers());
		 * customer.export(response);
		 */	return customerService.getAllCustomers();
	}
}

