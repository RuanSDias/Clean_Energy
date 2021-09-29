package br.com.project.cleanEnergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Classe espelho da tabela categoria no banco db_clean_energy.
 * 
 * @author Clean Energy
 * @since 1.0
 *
 */

@Entity(name = "tb_categoria")
public class CategoriaModel {
	
	//Atributos para diferentes variáveis
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idCategoria;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String produto;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String material;
	
	@NotNull
	@Size(min = 1, max = 10)
	private String potencia;
	
	//Getter and setters
	public long getId() {
		return idCategoria;
	}
	public void setId(long id) {
		this.idCategoria = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
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
	
	

}
