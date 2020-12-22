package controllers;

import adaptor.InvoiceAdaptor;
import dto.InvoiceDto;
import models.Invoice;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import service.IInvoiceService;

import javax.inject.Inject;
import java.util.List;

public class InvoiceController extends Controller implements IApplicationController {


    private final IInvoiceService invoiceService;
    private final FormFactory factory;

    @Inject
    public InvoiceController(FormFactory factory, IInvoiceService invoiceService){
        this.factory = factory;
        this.invoiceService = invoiceService;
    }

    public Result load() {
        List<InvoiceDto> invoices = invoiceService.list();
        return ok(views.html.invoice.invoice.render(invoices));
    }

    public Result getById(int id){
        InvoiceDto dto = invoiceService.find(id);
        return ok(views.html.invoice.invoiceElement.render(dto));
    }

    public Result create() {
        InvoiceDto dto = invoiceService.getEmptyInvoiceDto();
        return ok(views.html.invoice.invoiceElement.render(dto));
    }

    public Result save(Http.Request request) {
        Invoice invoice = InvoiceAdaptor.toInvoice(factory.form(InvoiceDto.class).bindFromRequest(request).get());
        invoiceService.save(invoice);
        return Results.redirect("/invoice");
    }
}
