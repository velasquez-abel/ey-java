package cl.velasquezabel.eyjava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cl.velasquezabel.eyjava.entity.Phone;

@DataJpaTest
public class PhoneRepositoryTest {
	
	@Autowired
	private PhoneRepository<Phone, Long> repo;
	
	@org.junit.jupiter.api.Test
	public void shouldSavePhone() {
		Phone phone = new Phone();
		phone.setUserId( new Long(0));
		repo.save( phone );
	}

}
