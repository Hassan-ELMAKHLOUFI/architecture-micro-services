package ma.hassan.billing.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data  @NoArgsConstructor
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private String customerId;

    public BigDecimal getAmount() {
        return amount;
    }

    public InvoiceRequestDTO(BigDecimal amount, String customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
