package repository.impl;

import models.Payment;
import models.PaymentMethod;
import play.db.jpa.JPAApi;
import repository.IPaymentRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PaymentRepository implements IPaymentRepository {

    private final JPAApi jpaApi;

    @Inject
    public PaymentRepository(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public List<Payment> list() {
        return this.jpaApi.em("default").createQuery("from models.Payment", Payment.class)
                .getResultList();
    }

    @Override
    public Payment find(int id) {
        return this.jpaApi.em("default").find(Payment.class, id);
    }

    @Override
    public void save(Payment payment) {
        this.jpaApi.withTransaction((entityManager -> {
            entityManager.merge(payment);
        }));
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return this.jpaApi.em("default")
                .createQuery("from models.PaymentMethod", PaymentMethod.class)
                .getResultList();
    }
}
