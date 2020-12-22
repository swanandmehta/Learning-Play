package service.impl;

import adaptor.InvoiceAdaptor;
import dto.InvoiceDto;
import models.Invoice;
import models.InvoiceStatus;
import repository.IInvoiceRepository;
import service.IInvoiceService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class InvoiceService implements IInvoiceService {

    private final IInvoiceRepository invoiceRepository;

    @Inject
    public InvoiceService(IInvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDto> list() {
        return invoiceRepository.list()
                                .stream()
                                .map(invoice -> InvoiceAdaptor.toInvoiceDto(invoice, null))
                                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDto find(int id) {
        Invoice invoice = invoiceRepository.find(id);
        List<InvoiceStatus> invoiceTypes = invoiceRepository.getInvoiceTypes();
        return InvoiceAdaptor.toInvoiceDto(invoice, invoiceTypes);
    }

    @Override
    public InvoiceDto getEmptyInvoiceDto() {
        List<InvoiceStatus> invoiceTypes = invoiceRepository.getInvoiceTypes();
        return new InvoiceDto(invoiceTypes);
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }
}
