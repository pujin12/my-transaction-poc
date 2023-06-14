package com.mypoc.transactionservice.repo;

import com.mypoc.transactionservice.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    List<Transaction> findAll();
    List<Transaction> findByCreateDateGreaterThanEqualAndCreateDateLessThanEqualAndCustomer_CustomerId(LocalDateTime fromDate, LocalDateTime toDate, Long customerId);
}
