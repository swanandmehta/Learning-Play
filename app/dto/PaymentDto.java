package dto;

import models.PaymentMethod;

import java.sql.Timestamp;
import java.util.List;

public class PaymentDto {

    private Integer id;
    private Timestamp timestamp;
    private Double value;
    private Integer invoiceId;
    private Integer methodId;
    private String methodValue;
    private List<Integer> invoiceList;
    private List<PaymentMethod> paymentMethods;

    public PaymentDto(){

    }

    public PaymentDto(List<PaymentMethod> methods, List<Integer> invoiceIds) {
        this.paymentMethods = methods;
        this.invoiceList = invoiceIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public String getMethodValue() {
        return methodValue;
    }

    public void setMethodValue(String methodValue) {
        this.methodValue = methodValue;
    }

    public List<Integer> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Integer> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
