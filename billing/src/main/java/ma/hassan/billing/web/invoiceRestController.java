package ma.hassan.billing.web;

import lombok.AllArgsConstructor;
import ma.hassan.billing.DTOs.InvoiceRequestDTO;
import ma.hassan.billing.DTOs.InvoiceResponseDTO;
import ma.hassan.billing.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path = "/api")
public class invoiceRestController {
    private InvoiceService invoiceService ;
    public invoiceRestController (InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);

    }
    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer (@PathVariable(name = "customerId") String customerId){
        return invoiceService.invoicesByCustomerId(customerId);

    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        return invoiceService.save(invoiceRequestDTO);


    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getAllInvoices(){
        return invoiceService.allInvoices();
    }



}
