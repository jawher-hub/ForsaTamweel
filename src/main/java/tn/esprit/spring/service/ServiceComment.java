package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Exception.BusinessResourceException;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.RepositoryComment;



@Service
public class ServiceComment {
	@Autowired
	private RepositoryComment repC;
	
	public Comment addComment(Comment c){
		return repC.save(c);
	}

	public List<Comment> findAll(){
		return repC.findAll();
	}

	public Comment findComment(Long id){
		return repC.findCommentById(id);

	}
	
	public Comment updateComment(Comment ev)
	{
		return repC.save(ev);
	}
	public void deleteComment(Long  id){
	
			repC.deleteById(id);
	}
	}
