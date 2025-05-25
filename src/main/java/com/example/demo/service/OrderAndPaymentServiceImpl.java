package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderPaymentDto;
import com.example.demo.entity.Cashback;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Order;
import com.example.demo.entity.Payment;
import com.example.demo.repository.CashbackRepo;
import com.example.demo.repository.FeedbackRepo;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.PaymentRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderAndPaymentServiceImpl implements OrderAndPaymentService {

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	PaymentRepo paymentRepo;

	@Autowired
	CashbackRepo cashbackRepo;

	@Autowired
	FeedbackRepo feedbackRepo;

	@Override
	@Transactional
	public void addOrderAndPayment(OrderPaymentDto dto) {

		saveorder(dto);

		savepayment(dto);

		savecashback(dto);

		savefeedback(dto);

	}

	private void saveorder(OrderPaymentDto dto) {
		Order order = new Order();
		order.setOrderType(dto.getOrderType());
		order.setCustomerName(dto.getCustomerName());
		order.setProductName(dto.getProductName());
		orderRepo.save(order);
	}

	private void savepayment(OrderPaymentDto dto) {
		Payment payment = new Payment();
		payment.setAmount(dto.getAmount());
		payment.setPaymentType(dto.getPaymentType());
		paymentRepo.save(payment);
	}

	private void savecashback(OrderPaymentDto dto) {
		Cashback cashback = new Cashback();
		cashback.setValue(dto.getValue());
		cashback.setDescription(dto.getDescription());
//		System.out.println(10/0); throwing arithmatic exception
		cashbackRepo.save(cashback);

	}

	private void savefeedback(OrderPaymentDto dto) {
		Feedback feedback = new Feedback();
		feedback.setMessage(dto.getMessage());
		feedback.setusersName(dto.getUsersName());
		feedbackRepo.save(feedback);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

}
