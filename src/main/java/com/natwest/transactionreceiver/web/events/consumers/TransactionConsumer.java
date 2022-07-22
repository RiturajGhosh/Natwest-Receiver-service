package com.natwest.transactionreceiver.web.events.consumers;


import common.model.TransactionDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @KafkaListener(topics = "TRANSACTION", groupId = "group")
    public void receive(ConsumerRecord<String, TransactionDTO> record) {
        TransactionDTO transactionDTO = record.value();
        System.out.println(transactionDTO);
    }
}
