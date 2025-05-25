package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderPaymentDto;
import com.example.demo.entity.Order;

public interface OrderAndPaymentService {
	
	void addOrderAndPayment(OrderPaymentDto dto);

	List<Order> getAllOrders();
	

}
	