package ma.hassan.customerservice.web;

import ma.hassan.customerservice.DTOs.CustomerRequestDTO;
import ma.hassan.customerservice.DTOs.CustomerResponseDTO;
import org.springframework.web.bind.annotation.*;
import ma.hassan.customerservice.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")

public class Controller {
    private CustomerService customerService ;

    public Controller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO){
        return  customerService.save(customerRequestDTO);
    }

    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String  id){
        return  customerService.getCustomer(id);
    }
}
