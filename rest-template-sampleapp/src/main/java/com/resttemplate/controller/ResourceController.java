package com.resttemplate.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.model.Employee;
import com.resttemplate.model.Order;

@RestController
@RequestMapping("/orderid")
public class ResourceController {
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderDeatils(@PathParam("orderId") Integer orderId){
		System.out.println("++++++++ORDER ID : "+orderId);
		Order order = new Order();
		order.setOrderId(45454545);
		order.setAmount(80000);
		
		// Using RestTemplate for consuming the rest api
		RestTemplate restTemplate = new  RestTemplate();
		String endpoint = "http://localhost:9090/emp/{empId}";
		
	    ResponseEntity<Employee> emp =	restTemplate.getForEntity(endpoint, Employee.class,"12");
		
	    if(emp.getStatusCodeValue() == 200) {
	    	System.out.println("++++++++Status Code : "+emp.getStatusCodeValue());
	    Employee employee =	emp.getBody();
	    order.setAddress(employee.getAddress());
	    order.setName(employee.getName());
	    }
	    
		return new ResponseEntity<Order>(order,HttpStatus.OK);
		
	}

}
