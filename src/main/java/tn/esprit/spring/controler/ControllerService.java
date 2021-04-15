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

import tn.esprit.spring.entity.Servicee;

import tn.esprit.spring.service.ServiceServ;

@RequestMapping("/Service")
@RestController
public class ControllerService {
	@Autowired
	private ServiceServ se;
	
// http://localhost:8090/Service/save
	@PostMapping("/save")
	public Servicee addService(@RequestBody Servicee s) throws ParseException{
		return se.addService(s);}
	
// http://localhost:8090/Service/alleservices
	@GetMapping("/alleservices")
	public List<Servicee> findAllService(){
		return se.findAllservices();
	}
	
// http://localhost:8090/Service/find/{id}
	@GetMapping("/find/{id}")
	
	public Servicee getByServiceId(@PathVariable("id") Long id) {
		return se.findService(id);
	}
	
// http://localhost:8090/Service/delete/{id}
	@DeleteMapping("/delete/{id}")
	public void deleteService(@PathVariable("id") Long id){
			se.deleteService(id);}
	
// http://localhost:8090/Service/update
	@PutMapping("/update")
	public Servicee updateService(@RequestBody Servicee s){
		return se.updateService(s);
	}
	}
