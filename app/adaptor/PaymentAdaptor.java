package adaptor;

import dto.PaymentDto;
import models.Payment;
import models.PaymentMethod;

import java.sql.Timestamp;
import java.util.List;

public class PaymentAdaptor {
    public static Payment toPayment(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setPaymentMethodId(dto.getMethodId());
        payment.setInvoiceId(dto.getInvoiceId());
        payment.setId(dto.getId() == null ? 0 : dto.getId());
        payment.setValue(dto.getValue());
        payment.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        return payment;
    }

    public static PaymentDto toPaymentDto(Payment payment, List<Integer> invoiceList,
                                          List<PaymentMethod> methods) {
        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setTimestamp(payment.getCreatedDate());
        dto.setValue(payment.getValue());
        dto.setInvoiceId(payment.getInvoiceId());
        dto.setMethodId(payment.getPaymentMethodId());
        dto.setMethodValue(payment.getMethod().getValue());
        dto.setInvoiceList(invoiceList);
        dto.setPaymentMethods(methods);
        return dto;
    }
}
