package repository;

import com.google.inject.ImplementedBy;
import models.Payment;
import models.PaymentMethod;
import repository.impl.PaymentRepository;

import java.util.Arrays;
import java.util.List;

@ImplementedBy(PaymentRepository.class)
public interface IPaymentRepository {
    List<Payment> list();

    Payment find(int id);

    void save(Payment payment);

    List<PaymentMethod> getPaymentMethods();
}
