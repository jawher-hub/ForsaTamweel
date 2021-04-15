package tn.esprit.spring.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "Service")

public class Servicee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idService;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateDeCreation;
	public Servicee(long idService, String name, String description) {
		super();
		this.idService = idService;
		this.name = name;
		this.description = description;
	}
	public Servicee(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Servicee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdService() {
		return idService;
	}
	public void setIdService(long idService) {
		this.idService = idService;
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
	
	public Date getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Service [idService=" + idService + ", name=" + name + ", description=" + description + "]";
	}
	

}
