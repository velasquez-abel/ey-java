package cl.velasquezabel.eyjava.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cl.velasquezabel.eyjava.entity.Phone;

@DataJpaTest
public class PhoneRepositoryTest {
	
	@Autowired
	PhoneRepository repo;
	
	@org.junit.jupiter.api.Test
	public void shouldSavePhone() {
		Phone phone = new Phone();
		phone.setUserId( UUID.fromString("227923ca-8e87-49ba-a2bd-094fd6bdd6ec") );
		phone.setId( UUID.randomUUID() );
		phone.setCityCode("1");
		phone.setCountryCode("2");
		phone.setNumber("12345678");
		repo.save( phone );
	}

}
