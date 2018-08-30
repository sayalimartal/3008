package com.demo.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.App;
import com.demo.rest.pojo.Customer;
import com.demo.rest.service.CustomerServiceImpl;

@RestController
public class CustomerOperations {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	@Autowired
	CustomerServiceImpl service/* = new CustomerServiceImpl()*/;
	
//	String customerName, Long contactNumber, String emailId, String dateOfBirth,String url
	@RequestMapping(value="/customer/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		LOG.info("Added customer to database..");
//		Customer customer = new Customer(customerName, contactNumber, emailId, dateOfBirth,url);
		return new ResponseEntity<Customer>(service.addCustomer(customer), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/customers/{start}/{count}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public ResponseEntity<Resources> viewAllCustomersInPages(@PathVariable("start") int start, @PathVariable("count") int count) {
		LOG.info("Viewed "+count+" customers on page "+start);
		List<Customer> tempCustomers = service.viewAllCustomers();
		List<Customer> customers = new ArrayList<>();
		for(int i=start-1;i<start+count-1;i++)
		{
			customers.add(tempCustomers.get(i));		
		}
		Link nextLink = linkTo(methodOn(this.getClass()).viewAllCustomersInPages(start+count>(tempCustomers.size()-count)?tempCustomers.size()-count+1:start+count,count)).withRel("nextLink");
		Link previousLink = linkTo(methodOn(this.getClass()).viewAllCustomersInPages(start-count>=0?start-count:1,count)).withRel("previousLink");
		Resources resources = new Resources<>(customers,previousLink,nextLink);
		return new ResponseEntity<Resources>(resources, HttpStatus.OK);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET /*produces=org.springframework.http.MediaType.APPLICATION_JSON*/)
	public ResponseEntity<List<Customer>> viewAllCustomers() {
		LOG.info("Viewed all customers");
//		logger.info("Returning all the ToDo´s");
		return new ResponseEntity<List<Customer>>(service.viewAllCustomers(), HttpStatus.OK);
//		return service.viewAllCustomers();
	}
	
	@RequestMapping(value="/customer/view/{customerId}", method=RequestMethod.GET, produces=org.springframework.http.MediaType.ALL_VALUE)
	public ResponseEntity<Resource<Customer>>/*  Customer */ viewCustomer(@PathVariable int customerId) {
		LOG.info("Viewing customer with id "+customerId);
		Link link =  linkTo(methodOn(this.getClass()).viewAllCustomers()).withRel("View All Customers");
//		return new ResponseEntity.created(URI.create(link.getHref())).build();
		
		Resource<Customer> resource = new Resource<Customer>(service.viewCustomer(customerId),link);
		return new ResponseEntity<Resource<Customer>>(resource,HttpStatus.OK);
		
//		customer.add(linkTo(methodOn((CustomerOperations.class).updateCustomer(customer).withSelfRel())));
//		return new Resource<Customer>(service.viewCustomer(customerId),link);
//		return service.viewCustomer(customerId);
	}
	
	@RequestMapping(value="/customer/delete/{customerId}", method=RequestMethod.DELETE, produces=org.springframework.http.MediaType.ALL_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId ){
		LOG.info("Delete customer with id "+customerId);
//		logger.info("ToDo id to remove " + customerId);
//    	if (toDo == null || toDo.getId() <= 0){
//            throw new ToDoException("ToDo to delete doesn´t exist");
//    	}
    	service.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer with id has been deleted", HttpStatus.OK);
	}
		

	
	@RequestMapping(value="/customer/update", method=RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		LOG.info("Update customer");
//		logger.info("Payload to update " + payload);
//    	ToDo toDo = toDoService.getToDoById(payload.getId());
//    	if (toDo == null || toDo.getId() <= 0){
//            throw new ToDoException("ToDo to update doesn´t exist");
//    	}
		return new ResponseEntity<Customer>(service.updateCustomer(customer), HttpStatus.OK);
	}

}
