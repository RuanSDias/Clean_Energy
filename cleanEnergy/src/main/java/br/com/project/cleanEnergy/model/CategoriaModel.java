package br.com.project.cleanEnergy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe espelho da tabela categoria no banco db_clean_energy.
 * 
 * @author Clean Energy
 * @since 1.0
 *
 */

@Entity(name = "tb_categoria")
public class CategoriaModel {

	// Atributos para diferentes variáveis
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	private String nome;

	private String material;

	private String potencia;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produtosCategoria;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public List<ProdutoModel> getProdutosCategoria() {
		return produtosCategoria;
	}

	public void setProdutosCategoria(List<ProdutoModel> produtosCategoria) {
		this.produtosCategoria = produtosCategoria;
	}

}
