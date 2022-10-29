````java
package ma.hassan.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name ;
    private String email;

    public Customer() {
    }

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}

````
## customer repository
```java
package ma.hassan.customerservice.repositories;

import ma.hassan.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}

```
## Customer DTO
- Customer request DTO 
````java
package ma.hassan.customerservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerRequestDTO {
    private String id;
    private String name ;
    private String email;

    public CustomerRequestDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerRequestDTO() {
    }

}

````

## Customer DTO
- Customer response DTO
````java
package ma.hassan.customerservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CustomerResponseDTO {
    private String id;
    private String name ;
    private String email;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}

````

## Customer Service 
````java
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

````

## Customer Controller 
````java
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

````
## Test 
````java
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
            customerService.save(new CustomerRequestDTO("C01","hassan","hassan@gmail.com"));
            customerService.save(new CustomerRequestDTO("C02","elmakhloufi","elmakhloufi@gmail.com"));

        };
    }
}
````
## Test of customer service

![](screens/1.png)

## Dockerfile 

````dockerfile
FROM adoptopenjdk/openjdk8

EXPOSE 8081
COPY target/*.jar customer-service.jar

ENTRYPOINT exec java $JAVA_OPTS -jar customer-service.jar
````



