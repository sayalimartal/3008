package com.demo.restweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.demo.restweb.pojo.Customer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class CustomerController {
	

		@RequestMapping("/customers")
		public String viewAllCustomers(Model model) {
			
			RestTemplate restTemplate = new RestTemplate();
			String viewUrl = "http://localhost:8080/customers";
			ResponseEntity<> response
			  = restTemplate.getForEntity(viewUrl, JsonObject[].class);

//			JsonObject jsono = new JsonObject();
//			JsonElement json = new JsonElement();
			Gson gson = new Gson();
			JsonElement gson1 = new Gson().toJsonTree(response.getBody());
//			jsono =response.getBody().getAsJsonObject();
			String result = gson.toJson(gson1);
			Customer customer = gson.fromJson(result, Customer.class);
			System.out.println(customer);
			model.addAttribute("customer", customer);
			/*model.put("message", this.message);*/
			return "viewAllCustomers";
		}
		
		@RequestMapping("/home")
		public String home() {
			return "home";
		}

}
