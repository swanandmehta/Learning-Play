package models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Invoice extends Transaction {

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "number")
    private int number;

    @Column(name = "status_id")
    private int statusId;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = false, cascade = {})
    @JoinColumn(name = "status_id", updatable = false, insertable = false)
    private InvoiceStatus status;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = false, cascade = {}, mappedBy = "invoice")
    private List<Payment> paymentList;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
