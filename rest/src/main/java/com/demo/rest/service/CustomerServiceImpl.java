package com.demo.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.rest.dao.CustomerRepository;
import com.demo.rest.pojo.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository dao/* = new CustomerRepository()*/;
	
	@Override
	public Customer addCustomer(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return dao.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public void deleteCustomer(int customerId) {
		dao.delete(dao.findByCustomerId(customerId).get());
	}

	@Override
	public Customer viewCustomer(int customerId) {
		return dao.findByCustomerId(customerId).get();
	}

}
