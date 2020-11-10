package com.example.demo.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class ActiveMQConfiguration {

	@Value("${active-mq.broker-url}")
    private String brokerUrl;
	
	@Bean
	public ConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory activeMQConnectionFactory  = new ActiveMQConnectionFactory();
	    activeMQConnectionFactory.setBrokerURL(brokerUrl);
	    activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.example.demo.model"));
	    return  activeMQConnectionFactory;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setPubSubDomain(true);
	    return factory;
	}
}
