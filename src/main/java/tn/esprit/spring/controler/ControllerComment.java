package tn.esprit.spring.controler;

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

import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.service.ServiceComment;




@RequestMapping("/comment")
@RestController
public class ControllerComment {
	@Autowired
	private ServiceComment se;
	

// http://localhost:8090/comment/save
	@PostMapping("/save")
	public Comment addCom(@RequestBody Comment e) {
		return se.addComment(e);
	}
	
// http://localhost:8090/comment/allecomments
	@GetMapping("/allecomments")
	public List<Comment> findAllEvent(){
		return se.findAll();
	}
	
// http://localhost:8090/comment/delete/{id}
	@DeleteMapping("/delete/{id}")
	public void deleteEvent(@PathVariable("id") Long id){
			se.deleteComment(id);}
	
// 	
	@PutMapping("/update")
	public Comment updateComment(@RequestBody Comment e){
		return se.updateComment(e);
	}

}
