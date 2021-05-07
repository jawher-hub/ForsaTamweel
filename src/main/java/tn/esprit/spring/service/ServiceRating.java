package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.RepositoryEvent;
import tn.esprit.spring.repository.RepositoryRating;
import tn.esprit.spring.repository.RepositoryUser;

@Service
public class ServiceRating {
	@Autowired
	 RepositoryRating rep;
	@Autowired
	 RepositoryUser repU;
	@Autowired
	RepositoryEvent repE;
	
	
	public void affectRatToEvent(Long id,Long idEvent, Rating rat){
		User user = repU.findById(id).orElse(null);
		Event event = repE.findById(idEvent).orElse(null);
		if (user != null && event != null)
		{
			List<Rating> re= rep.getByEvAndUser(event, user);
			if(re.isEmpty())
			{
			rat.setUser(user);
			rat.setEv(event);
			rep.save(rat);}
		 }
		return ; }
	
	public List<Rating> findAll (){
		return rep.findAll(); }
	

public void deleteRating(Long  id){

		rep.deleteById(id);}

		
	}