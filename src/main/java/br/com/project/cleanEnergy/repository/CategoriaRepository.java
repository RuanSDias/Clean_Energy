package br.com.project.cleanEnergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.cleanEnergy.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long > {
	
	public List<CategoriaModel> findAllByNomeContainingIgnoreCase(String categoria);
	

}
