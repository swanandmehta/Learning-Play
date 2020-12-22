package service.impl;

import adaptor.PaymentAdaptor;
import dto.InvoiceDto;
import dto.PaymentDto;
import models.Invoice;
import models.Payment;
import models.PaymentMethod;
import repository.IPaymentRepository;
import service.IInvoiceService;
import service.IPaymentService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PaymentService implements IPaymentService {

    private final IPaymentRepository paymentRepository;
    private final IInvoiceService invoiceService;

    @Inject
    public PaymentService(IPaymentRepository paymentRepository, IInvoiceService invoiceService){
        this.paymentRepository = paymentRepository;
        this.invoiceService = invoiceService;
    }

    @Override
    public List<PaymentDto> list() {
        return paymentRepository.list()
                .stream()
                .map(payment -> PaymentAdaptor.toPaymentDto(payment, null, null))
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto find(int id) {
        Payment payment = paymentRepository.find(id);
        List<Integer> invoiceIds = invoiceService.list()
                                                    .stream()
                                                    .filter(invoiceDto -> !invoiceDto.getId().equals(payment.getInvoiceId()))
                                                    .map(InvoiceDto::getId)
                                                    .collect(Collectors.toList());
        List<PaymentMethod> methods = paymentRepository.getPaymentMethods()
                                                        .stream()
                                                        .filter(paymentMethod ->
                                                                paymentMethod.getId() != payment.getPaymentMethodId())
                                                        .collect(Collectors.toList());
        return PaymentAdaptor.toPaymentDto(payment, invoiceIds, methods);
    }

    @Override
    public PaymentDto getEmptyDto() {
        List<PaymentMethod> methods = paymentRepository.getPaymentMethods();
        List<Integer> invoiceIds = invoiceService.list().stream()
                .map(InvoiceDto::getId).collect(Collectors.toList());
        return new PaymentDto(methods, invoiceIds);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
