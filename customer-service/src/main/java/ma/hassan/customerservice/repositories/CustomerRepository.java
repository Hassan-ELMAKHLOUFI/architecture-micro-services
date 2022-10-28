package ma.hassan.customerservice.repositories;

import ma.hassan.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
