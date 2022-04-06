package com.natwest.transactionreceiver.web.service;

import com.natwest.transactionreceiver.web.entity.Transaction;

/**
 * Service interface defining Transaction service
 * 
 * @author Rituraj
 *
 */
public interface TransactionService {

	/**
	 * Method to save transaction data
	 * 
	 * @param transaction
	 */
	void saveTransaction(Transaction transaction);
}
