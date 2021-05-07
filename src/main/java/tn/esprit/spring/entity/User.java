package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Enumerated(EnumType.STRING)
	Role role;

	
	@OneToMany(mappedBy="user", fetch= FetchType.EAGER)
	List<Rating> rate;
	
	@OneToMany(mappedBy="u", fetch= FetchType.LAZY)
	List<Servicee> s;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id) {
		super();
		this.id = id;
	
		
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(long id, String name, String email, String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	

	public User(String name, String email, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public User(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(long id, String name, String email, String password, List<Rating> rate, List<Servicee> s) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.rate = rate;
		this.s = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Servicee> getS() {
		return s;
	}

	public void setS(List<Servicee> s) {
		this.s = s;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public List<Rating> getRate() {
		return rate;
	}

	public void setRate(List<Rating> rate) {
		this.rate= rate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;}
	
}