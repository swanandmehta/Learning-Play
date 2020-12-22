package controllers;

import adaptor.PaymentAdaptor;
import dto.PaymentDto;
import models.Payment;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import service.IPaymentService;

import javax.inject.Inject;
import java.util.List;

public class PaymentController extends Controller implements IApplicationController {

    private final IPaymentService paymentService;
    private final FormFactory factory;

    @Inject
    public PaymentController(FormFactory factory, IPaymentService paymentService){
        this.factory = factory;
        this.paymentService = paymentService;
    }

    public Result load() {
        List<PaymentDto> payments = paymentService.list();
        return ok(views.html.payment.payment.render(payments));
    }

    public Result getById(int id){
        PaymentDto dto = paymentService.find(id);
        return ok(views.html.payment.paymentElement.render(dto));
    }

    public Result create() {
        PaymentDto dto = paymentService.getEmptyDto();
        return ok(views.html.payment.paymentElement.render(dto));
    }

    public Result save(Http.Request request) {
        Payment payment = PaymentAdaptor.toPayment(factory.form(PaymentDto.class).bindFromRequest(request).get());
        paymentService.save(payment);
        return Results.redirect("/payment");
    }

}
