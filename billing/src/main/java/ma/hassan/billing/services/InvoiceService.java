package ma.hassan.billing.services;




import ma.hassan.billing.DTOs.InvoiceRequestDTO;
import ma.hassan.billing.DTOs.InvoiceResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

    public InvoiceResponseDTO getInvoice(String InvoiceId);

    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);

    List<InvoiceResponseDTO> allInvoices();
}
