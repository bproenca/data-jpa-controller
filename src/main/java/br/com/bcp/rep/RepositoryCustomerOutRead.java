package br.com.bcp.rep;

import org.springframework.data.repository.CrudRepository;

import br.com.bcp.dto.CustomerOutRead;

public interface RepositoryCustomerOutRead extends CrudRepository<CustomerOutRead, Long> {

}