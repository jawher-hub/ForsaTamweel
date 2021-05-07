package tn.esprit.spring.controler;

import java.util.List;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ServiceEvent;

@Scope(value = "session")
@Controller(value = "EventController")
@ELBeanName(value = "EventController")
@Join(path = "/", to = "login.jsf")
public class EventController {
	private static final Logger L=LogManager.getLogger(EventController.class);
	@Autowired
ServiceEvent serE;

	private long idEvent;
	private String name;
	private String description; 
	private Long numOfRegistrants; 
	private Long remainingPlaces;
	private String dateDeCreation;
	private User user;
	private List<Event> events;

	public List<Event> getEvents() {
		return serE.findAll();
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public ServiceEvent getSerE() {
		return serE;
	}

	public void setSerE(ServiceEvent serE) {
		this.serE = serE;
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

	public String getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(String dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addEvent() {
		Event ev= new Event(name, description, numOfRegistrants, remainingPlaces,dateDeCreation);
		L.info("zzazaezaeazzaa"+ev);
		L.info("zzazaezaeazzaa"+serE.addEvent(ev));
		}
	public void updateEvent()
	{ serE.addEvent(new Event(idEvent,name, description, numOfRegistrants, remainingPlaces,dateDeCreation)); }

	public void removeEvent(Long idEvent)
	{
	serE.deleteEvent(idEvent);
	}

	public void displayEvent(Event e)
	{
	this.setName(e.getName());
	this.setDescription(e.getDescription());
	this.setDateDeCreation(e.getDateDeCreation());
	this.setNumOfRegistrants(e.getNumOfRegistrants());
	this.setRemainingPlaces(e.getRemainingPlaces());

	}
	
}
