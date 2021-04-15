package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Comment;

public interface RepositoryComment extends JpaRepository<Comment, Long> {

	Comment findCommentById(Long id);
	

}
