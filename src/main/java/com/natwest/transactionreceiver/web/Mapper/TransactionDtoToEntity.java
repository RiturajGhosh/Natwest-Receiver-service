package com.natwest.transactionreceiver.web.Mapper;

import org.springframework.stereotype.Component;

import com.natwest.transactionreceiver.web.entity.Transaction;
import com.natwest.transactionreceiver.web.model.TransactionDTO;

@Component
public class TransactionDtoToEntity {
	public Transaction mapTransactionDtoToEntity(TransactionDTO transactionDto) {
		Transaction transaction = new Transaction();
		if (transactionDto != null) {
			transaction.setAccountForm(transactionDto.getAccountForm());
			transaction.setAccountNumber(transactionDto.getAccountNumber());
			transaction.setAmount(transactionDto.getAmount());
			transaction.setCurrency(transactionDto.getCurrency());
			transaction.setType(transactionDto.getType());
		}
		return transaction;
	}
}
