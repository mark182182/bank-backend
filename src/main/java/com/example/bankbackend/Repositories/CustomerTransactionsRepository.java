package com.example.bankbackend.Repositories;

import com.example.bankbackend.Models.CustomerTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTransactionsRepository extends CrudRepository<CustomerTransactions, Long> {
}
