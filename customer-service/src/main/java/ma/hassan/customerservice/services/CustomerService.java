package ma.hassan.customerservice.services;

import ma.hassan.customerservice.DTOs.CustomerRequestDTO;
import ma.hassan.customerservice.DTOs.CustomerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id );
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();


}
