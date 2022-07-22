package com.natwest.transactionreceiver;

import com.natwest.transactionreceiver.web.model.TransactionDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * This class is to bootstrap the transaction receiver service
 * 
 * @author Rituraj
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
