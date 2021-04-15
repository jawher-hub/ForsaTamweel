package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}