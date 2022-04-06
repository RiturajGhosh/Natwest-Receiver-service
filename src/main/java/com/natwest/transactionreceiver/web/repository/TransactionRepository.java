package com.natwest.transactionreceiver.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.transactionreceiver.web.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
