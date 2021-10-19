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

import br.com.project.cleanEnergy.Repository.CategoriaRepository;
import br.com.project.cleanEnergy.model.CategoriaModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
@Api(tags = "Controlador de Categorias", description = "Utilitário de Categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@ApiOperation(value = "Busca lista de categorias no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna lista de categorias")})
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}

	@ApiOperation(value = "Busca categoria por Id")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna categoria existente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("id/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(value = "Busca categoria por nome")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna categoria existente ou inexistente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaModel>> getByName (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		
	}

	@ApiOperation(value = "Salva nova categoria no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna categoria cadastrada")})
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@ApiOperation(value = "Atualiza categoria existente")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna categoria atualizada")})		
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	@ApiOperation(value = "Deleta categoria existente")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Categoria deletado!"),
	@ApiResponse(code = 400, message = "Id de categoria inválido!")})
	@DeleteMapping("/id/{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
		
	}










}
