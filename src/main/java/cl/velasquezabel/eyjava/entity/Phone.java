package cl.velasquezabel.eyjava.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "phones")
@EntityListeners(AuditingEntityListener.class)
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinTable(name="users")
	@Column(name="user_id")
	private String userId;
	
	@Column(name="number", nullable=false)
	private String number;	

	@Column(name="city_code", nullable=false)
	private String cityCode;
	
	@Column(name="country_code", nullable=false)
	private String countryCode;	
}
