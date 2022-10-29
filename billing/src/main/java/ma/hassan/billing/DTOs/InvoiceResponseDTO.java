package ma.hassan.billing.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.hassan.billing.entities.Customer;


import java.math.BigDecimal;
import java.util.Date;


public class InvoiceResponseDTO {

    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;

    public InvoiceResponseDTO(String id, Date date, BigDecimal amount, Customer customer) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
    }

    public InvoiceResponseDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
