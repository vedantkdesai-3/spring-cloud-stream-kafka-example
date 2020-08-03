package com.producer.sample.producer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.producer.sample.producer.entity.Message;

@SpringBootApplication
@RestController
@EnableBinding(Source.class)
public class ProducerApplication {

	private Logger logger = LoggerFactory.getLogger(ProducerApplication.class);

	@Autowired
	private MessageChannel output;

	@GetMapping("/publish/{name}")
	public String publish(@PathVariable("name") String name) {
		Message user = new Message((new Date()).getTime(), name);
		logger.info("Message Pubished" + user);
		output.send(MessageBuilder.withPayload(user).build());
		return "Published";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
