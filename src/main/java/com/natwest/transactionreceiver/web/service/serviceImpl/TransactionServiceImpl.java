package com.natwest.transactionreceiver.web.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.natwest.transactionreceiver.web.entity.Transaction;
import com.natwest.transactionreceiver.web.repository.TransactionRepository;
import com.natwest.transactionreceiver.web.service.TransactionService;

/**
 * Transaction service Implementaion class
 * 
 * @author Rituraj
 *
 */
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	// bean injection for transaction repository
	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, rollbackFor = Exception.class)
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

}
