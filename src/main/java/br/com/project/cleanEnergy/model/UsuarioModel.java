package br.com.project.cleanEnergy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * Classe espelho da tabela usuario no banco db_clean_energy.
 * 
 * @author Clean Energy
 * @since 1.0
 *
 */
@Entity(name = "tb_Usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@NotNull
	private String nomeCompleto;

	// @ApiModelProperty(example = "email@email.com.br")
	@NotNull
	@Email
	private String email;

	@NotBlank
	@Size(min = 5, max = 100)
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<ProdutoModel> produtosUsuarios;
	private String tipo;

	public UsuarioModel(long idUsuario, String nomeCompleto, String email, String senha) {
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioModel(String nomeCompleto, String email, String senha) {
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioModel() {

	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<ProdutoModel> getProdutosUsuarios() {
		return produtosUsuarios;
	}

	public void setProdutosUsuarios(List<ProdutoModel> produtosUsuarios) {
		this.produtosUsuarios = produtosUsuarios;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
