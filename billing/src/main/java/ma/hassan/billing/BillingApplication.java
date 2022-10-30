package ma.hassan.billing;

import ma.hassan.billing.DTOs.InvoiceRequestDTO;
import ma.hassan.billing.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(InvoiceService invoiceService){
		return args -> {
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(78000),"1"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(90000),"1"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(18000),"2"));
		};
	}

}
