package repository.impl;

import models.Transaction;
import play.db.jpa.JPAApi;
import repository.ITransactionRepository;

import javax.inject.Inject;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {

    private final JPAApi jpaApi;

    @Inject
    public TransactionRepository(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Override
    public List<Transaction> list() {
        return jpaApi.em("default")
                .createQuery("FROM models.Transaction", Transaction.class).getResultList();
    }
}
