package ma.hassan.billing.repositories;

import ma.hassan.billing.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {

    List<Invoice> findByCustomerId(String clientId);
}
