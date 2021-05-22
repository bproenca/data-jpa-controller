package br.com.bcp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bcp.dto.Customer;
import br.com.bcp.service.CustomerService;

@RestController
public class CustomerController {
    
    @Autowired
	private CustomerService customerService;

    @GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Long id) {
        return customerService.getCustomerById(id);
	}

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
	}

}
