package tn.esprit.spring.controler;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Event;

import tn.esprit.spring.service.ServiceEvent;

@RequestMapping("/Event")
@RestController
public class ControllerEvent {
	@Autowired
	private ServiceEvent se;
// http://localhost:8090/Event/save
	@PostMapping("/save")
	public Event addEvent(@RequestBody Event e) throws ParseException{
		return se.addEvent(e);
	}
	
// http://localhost:8090/Event/allevents
	@GetMapping("/allevents")
	public List<Event> findAllEvent(){
		return se.findAll();
	}
//// http://localhost:8090/Event/find/{id}	
	@GetMapping("/find/{id}")
	public Event getByEventid(@PathVariable("id") Long id) {
		return se.findEvent(id);
	}
	
// http://localhost:8090/Event/delete/{idEvent}
	@DeleteMapping("/delete/{idEvent}")
	public void deleteEvent(@PathVariable("idEvent") Long idEvent){
			se.deleteEvent(idEvent);}
	
// http://localhost:8090/Event/update
	@PutMapping("/update")
	public Event updateEvent(@RequestBody Event e){
		return se.updateEvent(e);
	}
	}
