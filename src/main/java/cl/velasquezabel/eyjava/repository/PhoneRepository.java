package cl.velasquezabel.eyjava.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import cl.velasquezabel.eyjava.entity.Phone;


public interface PhoneRepository extends CrudRepository<Phone, UUID>{
	
}