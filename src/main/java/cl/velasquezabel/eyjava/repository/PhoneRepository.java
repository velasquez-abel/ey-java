package cl.velasquezabel.eyjava.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface PhoneRepository<Phone, Long> extends BaseRepository<Phone, Long>{
	
}