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
import tn.esprit.spring.entity.Servicee;

import tn.esprit.spring.repository.RepositoryServ;

@Service
public class ServiceServ {
@Autowired
private RepositoryServ rep;

public Servicee addService(Servicee s) throws ParseException{

	try{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date d = dateFormat.parse(dateFormat.format(Calendar.getInstance().getTime())); 
		s.setDateDeCreation(d);
		return rep.save(s);}
catch (BusinessResourceException e) {
	System.err.println("service non existant");
	throw new BusinessResourceException("ServiceNotFound", "Aucun service avec l'identifiant: "+s.getIdService());}
}

public Servicee updateService(Servicee s)
{
	return rep.save(s);
}
public void deleteService(Long  id){
	
		try{
			 rep.deleteById(id);}
		catch(EmptyResultDataAccessException ex){
			System.err.println("error");
			throw new BusinessResourceException("DeleteServicetError", "Erreur de suppression de la service avec l'identifiant: "+id);
		}
}

public List<Servicee> findAllservices(){
	return rep.findAll();
}

public Servicee findService(Long id){
	
 return rep.findServiceeByIdService(id) ;
	}
}