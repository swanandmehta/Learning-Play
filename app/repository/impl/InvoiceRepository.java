package repository.impl;

import models.Invoice;
import models.InvoiceStatus;
import play.db.jpa.JPAApi;
import repository.IInvoiceRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class InvoiceRepository implements IInvoiceRepository {

    private final JPAApi jpaApi;

    @Inject
    public InvoiceRepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public List<Invoice> list() {
        return this.jpaApi.em("default").createQuery("from models.Invoice", Invoice.class).getResultList();
    }

    @Override
    public List<InvoiceStatus> getInvoiceTypes() {
        return this.jpaApi.em("default")
                            .createQuery("from models.InvoiceStatus", InvoiceStatus.class)
                            .getResultList();
    }

    @Override
    public void save(Invoice invoice) {
        this.jpaApi.withTransaction((entityManager -> {
                entityManager.merge(invoice);
        }));
    }

    @Override
    public Invoice find(int id) {
        return this.jpaApi.em("default").find(Invoice.class, id);
    }
}
