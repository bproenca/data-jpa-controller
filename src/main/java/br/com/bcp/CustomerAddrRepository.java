package br.com.bcp;

import org.springframework.data.repository.CrudRepository;

public interface CustomerAddrRepository extends CrudRepository<CustomerAddress, Long> {

}