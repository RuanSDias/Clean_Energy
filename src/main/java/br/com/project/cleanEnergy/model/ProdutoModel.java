package br.com.project.cleanEnergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe espelho da tabela produto no banco db_clean_energy.
 * 
 * @author Clean Energy
 * @since 1.0
 *
 */
@Entity(name = "tb_Produto")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduto;

	@NotNull
	@Size(min = 1, max = 100)
	private String nome;

	@NotNull
	private double preco;

	@NotNull
	private String descricao;

	@NotNull
	private String imagem;

	@ManyToOne
	@JoinColumn(name = "fk_categoria", nullable = false)
	@JsonIgnoreProperties("produtosCategoria")
	private CategoriaModel categoria;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	@JsonIgnoreProperties("produtosUsuarios")
	private UsuarioModel usuario;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

}
