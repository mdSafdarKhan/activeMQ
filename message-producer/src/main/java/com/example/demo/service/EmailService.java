package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Email;

@Service
public class EmailService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${active-mq.topic}")
	private String topic;

	public void sendMessage(Email email) {
		try {
			System.out.println("Attempting Send message to Topic: " + topic);
			jmsTemplate.convertAndSend(topic, email);
		} catch (Exception e) {
			System.out.println("Recieved Exception during send Message: " + e);
		}
	}
}
