package tn.esprit.spring.controler;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rating;

import tn.esprit.spring.service.ServiceRating;


@RequestMapping("/rating")
@RestController
public class ControllerRating  {
	@Autowired
	private ServiceRating se;

// http://localhost:8090/rating/save/{id}/{idEvent}
	@PostMapping("/save/{id}/{idEvent}")
	public void affectRatToEvents(@PathVariable Long id,@PathVariable Long idEvent,@RequestBody Rating rat){
		  se.affectRatToEvent( id, idEvent, rat);
	}
	
// http://localhost:8090/rating/allrating
	@GetMapping("/allrating")
	public List<Rating> findAllRating(){
		return se.findAll();
	}
	
// http://localhost:8090/rating/delete/{id}
	@DeleteMapping("/delete/{id}")
	public void deleteRating(@PathVariable("id") Long id){
			se.deleteRating(id);}

	}
	
	