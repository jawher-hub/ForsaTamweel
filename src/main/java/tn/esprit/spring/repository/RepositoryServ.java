package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Servicee;
@Repository
public interface RepositoryServ extends JpaRepository<Servicee, Long> {
	public Servicee findServiceeByIdService(Long id);
}
