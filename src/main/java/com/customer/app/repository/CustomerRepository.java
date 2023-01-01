package com.customer.app.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

	@Query("FROM CustomerModel WHERE name = ?1")
	public CustomerModel getCustomerByName(String name);

	@Query("SELECT username,password FROM CustomerModel cm WHERE cm.username=?1 AND cm.password=?2")
	public CustomerModel findByUsernameAndPassword(String username, String password);

}
