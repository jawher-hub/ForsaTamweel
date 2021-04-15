package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;
@Repository
public interface RepositoryEvent extends JpaRepository<Event, Long> {
	//public void deleteEventByIdEvent(Long id);

	public Event findEventByIdEvent(Long id);

}
