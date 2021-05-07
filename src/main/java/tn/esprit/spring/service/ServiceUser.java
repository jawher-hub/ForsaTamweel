package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Exception.BusinessResourceException;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.RepositoryUser;

@Service
public class ServiceUser {
	@Autowired
	private RepositoryUser rep;
	
	public User addUser(User u) {
		return rep.save(u);
	}
	
	public List<User> findAll(){
		return rep.findAll();
	}
	public User updateuser(User u) {
		return rep.save(u);
	}

	public void deleteEvent(Long id) {
		try {
			rep.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			System.err.println("error");
			throw new BusinessResourceException("DeleteuserError",
					"Erreur de suppression de l'evenement avec l'identifiant: " + id);}
	}
	public User authenticate(String login, String password) {
		return rep.getUserByEmailAndPassword(login, password);
	}
}