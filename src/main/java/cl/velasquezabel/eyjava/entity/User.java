package cl.velasquezabel.eyjava.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id", nullable=false)
	private long id;

	@Column(name="full_name", nullable=false)
	private String fullName;

	@Column(name="email", nullable=false)
	private String email;

	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="created_at", nullable=false)
	private Date created;

	@Column(name="modified_at", nullable=false)
	private Date modified;

	@Column(name="last_login", nullable=false)
	private Date lastLogin;

	@Column(name="is_active", nullable=false)
	private Boolean active;
	
	@Column(name="auth_token", nullable=false)
	private String token;
	
	@OneToMany(mappedBy="user_id", cascade={CascadeType.PERSIST , CascadeType.REMOVE})
	private List<Phone>phones;
}
