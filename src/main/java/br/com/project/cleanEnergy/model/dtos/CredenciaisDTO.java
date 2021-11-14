package br.com.project.cleanEnergy.model.dtos;


/**
 * Classe Espelho para retornar credênciais para o sistema
 * 
 * @author Grupo 4
 * @since 1.0
 *
 */

public class CredenciaisDTO {
	
	private Long idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String token;
	private String tipo;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
