package br.com.project.cleanEnergy.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.cleanEnergy.model.ProdutoModel;
import br.com.project.cleanEnergy.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/produtos")
@Api(tags = "Controlador de Produtos", description = "Utilitário de Produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@ApiOperation(value = "Busca lista de produtos no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna lista de produtos")})
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> pegarTodos(){
         return ResponseEntity.ok(repository.findAll());
	}
	
	@ApiOperation(value = "Busca produto por Id")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna produto existente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("/id/{idProduto}")
    public ResponseEntity<ProdutoModel> pegarPorId(@PathVariable Long idProduto){
		return repository.findById(idProduto)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(value = "Busca produto por nome")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna produto existente ou inexistente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> pegarPorNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@ApiOperation(value = "Salva novo produto no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna produto cadastrado")})
	@PostMapping
	public ResponseEntity<ProdutoModel> criar(@Valid @RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produto));
	}
	
	@ApiOperation(value = "Atualiza produto existente")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna produto atualizado")})
	@PutMapping
	public ResponseEntity<ProdutoModel> atualizar(@Valid @RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(produto));
   }
	
	@ApiOperation(value = "Deleta produto existente")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Produto deletado!"),
	@ApiResponse(code = 400, message = "Id de produto inválido!")})
	@DeleteMapping("/{idProduto}")
	public void delete(@PathVariable Long idProduto) {
		repository.deleteById(idProduto);
	}
	
}