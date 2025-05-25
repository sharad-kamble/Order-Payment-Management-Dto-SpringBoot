package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderPaymentDto;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderAndPaymentService;

@RestController
public class OrderController {

	@Autowired
	private OrderAndPaymentService orderService;

	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderPaymentDto dto) {
		orderService.addOrderAndPayment(dto);
		return new ResponseEntity<>("Order and Payment saved successfully", HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }			
	

}
