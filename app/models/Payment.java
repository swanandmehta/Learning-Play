package models;

import javax.persistence.*;

@Entity
public class Payment extends Transaction {

    @Column(name = "invoice_id")
    private int invoiceId;

    @Column(name="payment_method_id")
    private int paymentMethodId;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = false)
    @JoinColumn(name = "payment_method_id", insertable = false, updatable = false)
    private PaymentMethod method;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "invoice_id", updatable = false, insertable = false)
    private Invoice invoice;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
