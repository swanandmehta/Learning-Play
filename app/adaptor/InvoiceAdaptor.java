package adaptor;

import dto.InvoiceDto;
import models.Invoice;
import models.InvoiceStatus;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceAdaptor {

    public static InvoiceDto toInvoiceDto(Invoice invoice, List<InvoiceStatus> invoiceTypes) {
        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setClientId(invoice.getClientId());
        dto.setNumber(invoice.getNumber());
        dto.setStatus(invoice.getStatus().getId());
        dto.setStatusValue(invoice.getStatus().getStatus());
        dto.setValue(invoice.getValue());
        dto.setTimestamp(invoice.getCreatedDate());
        dto.setOptions(
                invoiceTypes == null ? null :
                invoiceTypes.stream()
                            .filter(type -> type.getId() != dto.getStatus())
                            .collect(Collectors.toList()));
        return dto;
    }

    public static Invoice toInvoice(InvoiceDto dto) {
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId() == null ? 0 : dto.getId());
        invoice.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        invoice.setValue(dto.getValue());
        invoice.setStatusId(dto.getStatus());
        invoice.setNumber(dto.getNumber());
        invoice.setClientId(dto.getClientId());
        return invoice;
    }
}
