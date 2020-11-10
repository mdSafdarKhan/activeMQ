package com.example.demo.component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Email;

@Component
public class EmailConsumer implements MessageListener {

	@Override
	@JmsListener(destination = "${active-mq.topic}")
	public void onMessage(Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			Email email = (Email) objectMessage.getObject();
			// do additional processing
			System.out.println("Received Message: " + email);
		} catch (Exception e) {
			System.out.println("Received Exception : " + e);
		}
	}

}
