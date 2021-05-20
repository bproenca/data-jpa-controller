package br.com.bcp.rep;

import org.springframework.data.repository.CrudRepository;

import br.com.bcp.dto.CustomerInCreate;

public interface RepositoryCustomerInCreate extends CrudRepository<CustomerInCreate, Long> {

}