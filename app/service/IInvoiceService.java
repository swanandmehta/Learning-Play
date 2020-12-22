package service;

import com.google.inject.ImplementedBy;
import dto.InvoiceDto;
import models.Invoice;
import service.impl.InvoiceService;

import java.util.List;

@ImplementedBy(InvoiceService.class)
public interface IInvoiceService {

    List<InvoiceDto> list();

    InvoiceDto find(int id);

    InvoiceDto getEmptyInvoiceDto();

    void save(Invoice invoice);
}
