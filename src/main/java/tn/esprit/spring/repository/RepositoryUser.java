package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.User;

public interface RepositoryUser extends JpaRepository<User,Long> {
	public User getUserByEmailAndPassword(String login, String password);
}
