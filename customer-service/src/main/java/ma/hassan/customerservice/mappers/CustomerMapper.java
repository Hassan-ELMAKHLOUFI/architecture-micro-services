package ma.hassan.customerservice.mappers;

import ma.hassan.customerservice.DTOs.CustomerRequestDTO;
import ma.hassan.customerservice.DTOs.CustomerResponseDTO;
import ma.hassan.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
