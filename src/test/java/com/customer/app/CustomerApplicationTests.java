package com.customer.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CustomerApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * @Autowired private CustomerRepository customerRepository;
	 */
	// Junit Test for SaveCustomer test

	/*
	 * @Test public void saveCustomerTest() {
	 * 
	 * CustomerModel customer = new CustomerModel(); customer.setName("Sachin");
	 * customer.setEmail("sachin@gmail.com"); customer.setPhone("9503587594");
	 * customer.setUsername("sachin"); customer.setPassword("int@123");
	 * 
	 * customerRepository.save(customer);
	 * Assertions.assertThat(customer.getId()).isGreaterThan(0); }
	 * 
	 * 
	 * @Test public void getCustomer() { CustomerModel customer =
	 * customerRepository.findById(1).get();
	 * Assertions.assertThat(customer.getId()).isEqualTo(1); }
	 */
}
