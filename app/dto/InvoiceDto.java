package dto;

import models.InvoiceStatus;

import java.sql.Timestamp;
import java.util.List;

public class InvoiceDto {
    private Integer id;
    private Double value;
    private Integer clientId;
    private Integer number;
    private Integer status;
    private String statusValue;
    private List<InvoiceStatus> options;
    private Timestamp timestamp;

    public InvoiceDto(){

    }

    public InvoiceDto(List<InvoiceStatus> options){
        this.options = options;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public List<InvoiceStatus> getOptions() {
        return options;
    }

    public void setOptions(List<InvoiceStatus> options) {
        this.options = options;
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
}
