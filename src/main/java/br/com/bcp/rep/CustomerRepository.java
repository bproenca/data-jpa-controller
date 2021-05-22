package br.com.bcp.rep;

import org.springframework.data.repository.CrudRepository;

import br.com.bcp.dto.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}