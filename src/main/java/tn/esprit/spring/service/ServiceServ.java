package tn.esprit.spring.service;


import java.time.format.DateTimeFormatter;


import java.time.LocalDateTime;

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

public Servicee addService(Servicee s){

	try{
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");			
		String d =  dateTime.format(formatter); 
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