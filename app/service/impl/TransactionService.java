package service.impl;

import filters.TransactionsFilters;
import models.Transaction;
import play.mvc.Http;
import repository.ITransactionRepository;
import service.ITransactionService;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionService implements ITransactionService {

    private final ITransactionRepository transactionRepository;

    @Inject
    public TransactionService(ITransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> list() {
        return transactionRepository.list();
    }

    @Override
    public Stream<Transaction> filter(Stream<Transaction> inputs, Predicate<Transaction> filter) {
        return inputs.filter(filter);
    }

    @Override
    public List<Transaction> filter(Http.Request request) throws ParseException {
        Predicate<Transaction> byDate = TransactionsFilters.byDate(request.queryString("to").get(), request.queryString("from").get());
        return filter(transactionRepository.list().stream(), byDate)
                .collect(Collectors.toList());
    }
}
