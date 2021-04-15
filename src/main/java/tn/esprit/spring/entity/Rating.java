package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRating;
	private float rate;
	public Long getIdRating() {
		return idRating;
	}
	public void setIdRating(Long idRating) {
		this.idRating = idRating;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Rating(Long idRating, float rate) {
		super();
		this.idRating = idRating;
		this.rate = rate;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(float rate) {
		super();
		
		this.rate = rate;
	}
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEv() {
		return ev;
	}
	public void setEv(Event ev) {
		this.ev = ev;
	}
	@ManyToOne
	private Event ev;
	public Rating(Long idRating, float rate, User user, Event ev) {
		super();
		this.idRating = idRating;
		this.rate = rate;
		this.user = user;
		this.ev = ev;
	}

}
