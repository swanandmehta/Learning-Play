package service;

import com.google.inject.ImplementedBy;
import models.Transaction;
import play.mvc.Http;
import service.impl.TransactionService;

import java.text.ParseException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@ImplementedBy(TransactionService.class)
public interface ITransactionService {

    List<Transaction> list();

    Stream<Transaction> filter(Stream<Transaction> inputs, Predicate<Transaction> filter);

    List<Transaction> filter(Http.Request request) throws ParseException;
}
