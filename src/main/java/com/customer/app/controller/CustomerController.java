package com.customer.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.model.CustomerModel;
import com.customer.app.services.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	List<CustomerModel> list = new ArrayList<CustomerModel>();

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public CustomerModel addCustomer(@RequestBody CustomerModel customerModel) {
		list.add(customerModel);
		System.out.println("Customer Added");
		return customerModel;
	}

	@RequestMapping(value = "/getcustomers", method = RequestMethod.GET)
	public List<CustomerModel> getCustomers(HttpServletResponse response) throws IOException {
		System.out.println("Test");
		/*
		 * CustomerExporter customer=new
		 * CustomerExporter(customerService.getAllCustomers());
		 * customer.export(response);
		 */ return customerService.getAllCustomers();
	}

	@GetMapping("/getcustomerbyname/{name}")
	public ResponseEntity getCustomerByName(@PathVariable("name") String name) {
		// System.out.println("System Fault Customer");
		CustomerModel model = customerService.getCustomerByName(name);
		System.out.println("Customer Object : " + model);

		if (model != null) {
			return new ResponseEntity<CustomerModel>(model, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Customer Not Found By there Name : " + name, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/customerlogin/{username}/{password}")
	public ResponseEntity<String> login(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		// System.out.println("System Fault Customer");
		String response = customerService.findByUsernameAndPassword(username, password);
		System.out.println("Response Status : " + response);
		if (response.equals("Success")) {
			return new ResponseEntity<String>(
					"Login Success for Username : " + username + " and Password : " + password, HttpStatus.OK);
		} else {

			return new ResponseEntity<String>(
					"Customer Not Found By there Username : " + username + " and Password : " + password,
					HttpStatus.NOT_FOUND);
		}
	}

}
