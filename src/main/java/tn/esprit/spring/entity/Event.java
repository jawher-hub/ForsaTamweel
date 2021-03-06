package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "Event")

public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idEvent;
		@Column(name = "name")
		private String name;
		@Column(name = "description")
		private String description;
		@Column(name = "numOfRegistrants")
		private Long numOfRegistrants;
		@Column(name = "remainingPlaces")
		private Long remainingPlaces;
		@Column(name= "dateDeCreation")
		private String dateDeCreation;
	@OneToMany(mappedBy="ev", fetch= FetchType.EAGER,cascade = CascadeType.ALL)
	List<Rating> rat;
	
	@OneToMany(mappedBy="e", fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	 List<Comment> comm;
	

	

	
	public Event(long idEvent, String name, String description, Long numOfRegistrants, Long remainingPlaces,
			String dateDeCreation) {
		super();
		this.idEvent = idEvent;
		this.name = name;
		this.description = description;
		this.numOfRegistrants = numOfRegistrants;
		this.remainingPlaces = remainingPlaces;
		this.dateDeCreation = dateDeCreation;
	}

	public Event(String name, String description, Long numOfRegistrants, Long remainingPlaces, String dateDeCreation) {
		super();
		this.name = name;
		this.description = description;
		this.numOfRegistrants = numOfRegistrants;
		this.remainingPlaces = remainingPlaces;
		this.dateDeCreation = dateDeCreation;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getNumOfRegistrants() {
		return numOfRegistrants;
	}
	public void setNumOfRegistrants(Long numOfRegistrants) {
		this.numOfRegistrants = numOfRegistrants;
	}
	public Long getRemainingPlaces() {
		return remainingPlaces;
	}
	public void setRemainingPlaces(Long remainingPlaces) {
		this.remainingPlaces = remainingPlaces;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;}
	
	public String getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	@Override
	public String toString() {
		return "Event [idEvent=" + idEvent + ", name=" + name + ", description=" + description + ", numOfRegistrants="
		+ numOfRegistrants + ", remainingPlaces=" + remainingPlaces + "]";}
}
