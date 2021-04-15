package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Exception.BusinessResourceException;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.RepositoryEvent;

@Service
public class ServiceEvent {
	@Autowired
	private RepositoryEvent repEvent;

	public Event addEvent(Event ev) throws ParseException{
try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date d = dateFormat.parse(dateFormat.format(Calendar.getInstance().getTime())); 
		ev.setDateDeCreation(d);
		return repEvent.save(ev);}
catch (BusinessResourceException e) {
	System.err.println("event non existant");
	throw new BusinessResourceException("EventNotFound", "Aucun evenement avec l'identifiant: "+ev.getIdEvent());}
	}

	public Event updateEvent(Event ev)
	{
		return repEvent.save(ev);
	}
	public void deleteEvent(Long  idEvent){
		try{
			repEvent.deleteById(idEvent);}
		catch(EmptyResultDataAccessException ex){
			System.err.println("error");
			throw new BusinessResourceException("DeleteEventError", "Erreur de suppression de l'evenement avec l'identifiant: "+idEvent);
		}

	}

	public List<Event> findAll(){
		return repEvent.findAll();
	}

	public Event findEvent(Long id){
		return repEvent.findEventByIdEvent(id);

	}
	
}