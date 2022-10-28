package ma.hassan.billing.mappers;


import ma.hassan.billing.DTOs.InvoiceRequestDTO;
import ma.hassan.billing.DTOs.InvoiceResponseDTO;
import ma.hassan.billing.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {


    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO fromInvoice(Invoice invoice);

}
