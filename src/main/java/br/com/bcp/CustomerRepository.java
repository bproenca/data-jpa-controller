package br.com.bcp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public List<Customer> findByFirstName(String firstName);
}