package repository;

import com.google.inject.ImplementedBy;
import models.Transaction;
import repository.impl.TransactionRepository;

import java.util.List;

@ImplementedBy(TransactionRepository.class)
public interface ITransactionRepository {

    List<Transaction> list();

}
