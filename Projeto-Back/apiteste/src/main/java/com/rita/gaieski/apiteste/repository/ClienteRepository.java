package com.rita.gaieski.apiteste.repository;



import com.rita.gaieski.apiteste.model.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> { // retorno long

}
