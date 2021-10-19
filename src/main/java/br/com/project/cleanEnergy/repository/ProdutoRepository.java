package br.com.project.cleanEnergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.cleanEnergy.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends  JpaRepository<ProdutoModel, Long> {
	
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);

}
