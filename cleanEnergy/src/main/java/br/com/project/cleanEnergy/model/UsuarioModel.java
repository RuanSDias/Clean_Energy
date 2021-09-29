package br.com.project.cleanEnergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

/**
 * Classe espelho da tabela usuario no banco db_clean_energy.
 * 
 * @author Clean Energy
 * @since 1.0
 *
 */
@Entity(name = "tbUsuario")
public class UsuarioModel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idUsuario;

	@NotNull
	private String nomeCompleto;

	@Email
	private String email;

	@NotNull
	@Size(min = 5, max = 8)
	private String senha;

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
	
	
}
