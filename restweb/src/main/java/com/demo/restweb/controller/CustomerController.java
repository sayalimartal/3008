package com.demo.restweb.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.demo.restweb.pojo.Customer;

@Controller
public class CustomerController {
	
	RestTemplate restTemplate = new RestTemplate();
	static final String url = "http://localhost:8080/customer/view/";

		@RequestMapping("/customers")
		public String viewAllCustomers(Model model) {
			
			String viewUrl = "http://localhost:8080/customers";
			ResponseEntity<List<Customer>> response = restTemplate.exchange(viewUrl, HttpMethod.GET, null,new ParameterizedTypeReference<List<Customer>>() {}); 
			List<Customer> customers = response.getBody();

			System.out.println(customers);
			model.addAttribute("customers", customers);
			return "viewAllCustomers";
		}
		
		@RequestMapping("/customer/{customerId}")
		public String viewCustomer(@PathVariable int customerId, Model model) {
//			String url = "http://localhost:8080/customer/view/"+customerId;
			ResponseEntity<Resource<Customer>> response = restTemplate.exchange(url+customerId, HttpMethod.GET, null,new ParameterizedTypeReference<Resource<Customer>>() {});
//			@SuppressWarnings("rawtypes")
//			ResponseEntity<ArrayList> customerDetails = restTemplate.getForEntity("http://localhost:8080/customer/{customerId}", ArrayList.class);
//			String link = response.getBody().getLink("View All Customers").getHref();
			Customer customer = response.getBody().getContent();
			System.out.println(customer);
//			System.out.println(link);
			model.addAttribute("customer", customer);
//			model.addAttribute("link", link);
			return "viewCustomer";
		}	
		
		@RequestMapping("/customer/add")
		public String addCustomer(@RequestParam int customerId,@RequestParam String customerName,@RequestParam long contactNumber,@RequestParam String emailId,@RequestParam String dateOfBirth,@RequestParam String url, Model model) {
			return "addNewCustomer";
		}	
		
		@RequestMapping("/home")
		public String home() {
			return "home";
		}

}
