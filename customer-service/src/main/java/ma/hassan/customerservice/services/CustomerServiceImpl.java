package ma.hassan.customerservice.services;

import ma.hassan.customerservice.DTOs.CustomerRequestDTO;
import ma.hassan.customerservice.DTOs.CustomerResponseDTO;
import ma.hassan.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import ma.hassan.customerservice.mappers.CustomerMapper;
import org.springframework.stereotype.Service;
import ma.hassan.customerservice.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
public class CustomerServiceImpl implements CustomerService {

   CustomerRepository customerRepository ;
   CustomerMapper customerMapper ;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer c = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        c.setId(UUID.randomUUID().toString());
        Customer customerSave = customerRepository.save(c);

        CustomerResponseDTO customerResponseDto = customerMapper.customerToCustomerDTO(customerSave);

        return customerResponseDto;

    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        System.out.println("****************************************");
        Customer customer = customerRepository.findById(id).get();
        System.out.println(customer.getId());
        return  customerMapper.customerToCustomerDTO(customer);

    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer updatedCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerDTO(updatedCustomer);
        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDTO> customerResponseDTOS= customers.stream().map(customer -> customerMapper.customerToCustomerDTO(customer)).collect(Collectors.toList());
        return customerResponseDTOS;
    }
}
