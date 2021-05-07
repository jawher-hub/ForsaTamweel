package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.repository.RepositoryComment;

@Service
public class ServiceComment {
	@Autowired
	private RepositoryComment repC;

	String[] list = {"test","spring","jsf","framework"};
	String replace = "";

	public Comment addComment(Comment c) {
		for (int i = 0; i < list.length; i++) {
			if ((c.getComment().toLowerCase()).contains(list[i].toLowerCase().trim())) {
				for (int j = 0; j < list[i].length(); j++) {
					replace = replace.concat("*");
				}
				c.setComment(c.getComment().toLowerCase().replaceAll(list[i].toLowerCase(), replace));
			}
		}
		replace = "";
		c.setComment(c.getComment().trim());
		
		return repC.save(c);
	}

	public List<Comment> findAll() {
		return repC.findAll();
	}

	public Comment updateComment(Comment c) {
		for (int i = 0; i < list.length; i++) {
			if ((c.getComment().toLowerCase()).contains(list[i].toLowerCase().trim())) {
				for (int j = 0; j < list[i].length(); j++) {
					replace = replace.concat("*");
				}
				c.setComment(c.getComment().toLowerCase().replaceAll(list[i].toLowerCase(), replace));
			}
		}
		replace = "";
		c.setComment(c.getComment().trim());
		return repC.save(c);
	}

	public void deleteComment(Long id) {

		repC.deleteById(id);
	}
}
