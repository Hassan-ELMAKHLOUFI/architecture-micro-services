package ma.hassan.billing.services;

import lombok.AllArgsConstructor;
import ma.hassan.billing.DTOs.InvoiceRequestDTO;
import ma.hassan.billing.DTOs.InvoiceResponseDTO;
import ma.hassan.billing.entities.Customer;
import ma.hassan.billing.entities.Invoice;
import ma.hassan.billing.mappers.InvoiceMapper;
import ma.hassan.billing.openfeign.CustomerRestClient;
import ma.hassan.billing.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {



    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    @Autowired
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        //verification de l'integrite referentielle  Invoice/Customer
        Customer customer;


            customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());

        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice saveInvoice = invoiceRepository.save(invoice);
        saveInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String InvoiceId) {
        Invoice invoice = invoiceRepository.findById(InvoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);

        for (Invoice invoice : invoices) {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice->invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();

        for (Invoice invoice : invoices) {
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }
}
