package repository;

import com.google.inject.ImplementedBy;
import models.Invoice;
import models.InvoiceStatus;
import repository.impl.InvoiceRepository;

import java.util.List;

@ImplementedBy(InvoiceRepository.class)
public interface IInvoiceRepository {

    List<Invoice> list();

    List<InvoiceStatus> getInvoiceTypes();

    void save(Invoice invoice);

    Invoice find(int id);
}
