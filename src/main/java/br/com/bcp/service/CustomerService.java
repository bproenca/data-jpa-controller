package br.com.bcp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bcp.dto.Customer;
import br.com.bcp.exception.CustomerNotFoundException;
import br.com.bcp.rep.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
	private CustomerRepository customerRepo;

    public Customer getCustomerById(@PathVariable(value = "id") Long id) {
        return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

    public Customer saveCustomer(@RequestBody Customer customer) {
        customer.linkAddress();
        return customerRepo.save(customer);
	}

    
}
