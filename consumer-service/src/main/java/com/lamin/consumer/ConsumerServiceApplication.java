package com.lamin.consumer;

import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

import com.lamin.consumer.model.Book;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerServiceApplication {	
	
	private Logger logger = LoggerFactory.getLogger(ConsumerServiceApplication.class);

    @StreamListener("input")
    public void consumeMessage(Book book) {
        logger.info("Consume payload : " + book);
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}
}
