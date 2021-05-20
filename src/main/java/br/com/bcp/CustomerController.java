package br.com.bcp;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
	private CustomerRepository customerRep;

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/customer/{id}")
	public Customer greeting(@PathVariable(value = "id") Long id) {
        Optional<Customer> customer = customerRep.findById(id);
        if (customer.isPresent()) {
            log.info("Found customer with ID {}: {}", id, customer.get());
            return customer.get();
        } else {
            log.info("Customer with ID {} not found", id);
            return null;
        }
	}

    @PostMapping("/customer")
	public Customer greeting(@RequestBody Customer customer) {
        return customerRep.save(customer);
	}
}
