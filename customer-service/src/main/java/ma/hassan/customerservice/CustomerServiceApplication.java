package ma.hassan.customerservice;

import ma.hassan.customerservice.DTOs.CustomerRequestDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.hassan.customerservice.services.CustomerService;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01","adria","adria@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","openLab","openLab@gmail.com"));

        };
    }
}
