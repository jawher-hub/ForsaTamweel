package tn.esprit.spring.controler;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.User;

import tn.esprit.spring.service.ServiceUser;

@RequestMapping("/user")
@RestController
public class ControllerUser {
	@Autowired
	private ServiceUser se;
// http://localhost:8090/Event/save
	@PostMapping("/save")
	public User addEvent(@RequestBody User u) {
		return se.addUser(u);
	}
	// http://localhost:8090/Event/alleusers
		@GetMapping("/allusers")
		public List<User> findAllUser(){
			return se.findAll();
		}
}