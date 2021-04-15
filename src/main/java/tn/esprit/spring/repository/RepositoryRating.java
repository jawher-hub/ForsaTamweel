package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.User;

public interface RepositoryRating extends JpaRepository<Rating, Long> {
	
	
	
     List<Rating> getByEvAndUser(Event ev, User user);
}
