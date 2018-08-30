package com.demo.rest.dao;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.rest.pojo.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,ObjectId>
{
	Optional<Customer> findByCustomerId(int customerId);
}
