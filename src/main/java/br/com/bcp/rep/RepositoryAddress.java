package br.com.bcp.rep;

import org.springframework.data.repository.CrudRepository;

import br.com.bcp.dto.CustomerAddress;

public interface RepositoryAddress extends CrudRepository<CustomerAddress, Long> {

}