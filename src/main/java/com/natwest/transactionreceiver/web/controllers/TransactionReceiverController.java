package com.natwest.transactionreceiver.web.controllers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natwest.transactionreceiver.web.Mapper.TransactionDtoToEntity;
import com.natwest.transactionreceiver.web.entity.Transaction;
import com.natwest.transactionreceiver.web.model.TransactionDTO;
import com.natwest.transactionreceiver.web.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
public class TransactionReceiverController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionDtoToEntity transactionDtoToEntity;

	@PostMapping("/receiveTransactionData")
	public void sendTransactionData(@RequestBody final String transactionDTOString) throws IOException {
		TransactionDTO transactionDto = deserializeEncodedObject(transactionDTOString);
		transactionService.saveTransaction(transactionDtoToEntity.mapTransactionDtoToEntity(transactionDto));
	}

	private TransactionDTO deserializeEncodedObject(String transactionDTOString)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper ob = new ObjectMapper();
		byte[] transactionDtoBytes = Base64.getDecoder().decode(transactionDTOString);
		TransactionDTO transactionDTO = ob.readValue(transactionDtoBytes, TransactionDTO.class);
		return transactionDTO;
	}

}
