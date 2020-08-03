package com.consumer.sample.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.consumer.sample.consumer.entity.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication {

	private Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

	@StreamListener(Sink.INPUT)
	public void consumeMessage(Message user) {
		logger.info("Consumer payload : " + user);
	}


	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
