package service;

import com.google.inject.ImplementedBy;
import dto.PaymentDto;
import models.Payment;
import service.impl.PaymentService;

import java.util.List;

@ImplementedBy(PaymentService.class)
public interface IPaymentService {
    List<PaymentDto> list();

    PaymentDto find(int id);

    PaymentDto getEmptyDto();

    void save(Payment payment);
}
