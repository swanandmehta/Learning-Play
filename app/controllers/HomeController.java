package controllers;

import filters.TransactionsFilters;
import models.Transaction;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.ITransactionService;

import javax.inject.Inject;
import java.text.ParseException;
import java.util.function.Predicate;

public class HomeController extends Controller implements IApplicationController {

    private final ITransactionService transactionService;

    @Inject
    public HomeController(ITransactionService transactionService){
        this.transactionService = transactionService;
    }

    public Result load() {
        return ok(views.html.index.render(transactionService.list()));
    }

    public Result filter(Http.Request request) throws ParseException {
        return ok(views.html.index.render(transactionService.filter(request)));
    }
}
