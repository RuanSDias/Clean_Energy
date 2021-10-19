package br.com.project.cleanEnergy.controllers;

import java.util.List;
import java.util.Optional;

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
import br.com.project.cleanEnergy.model.UsuarioModel;
import br.com.project.cleanEnergy.model.dtos.CredenciaisDTO;
import br.com.project.cleanEnergy.model.dtos.UsuarioLoginDTO;
import br.com.project.cleanEnergy.repository.UsuarioRepository;
import br.com.project.cleanEnergy.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Controlador de Usuários", description = "Utilitário de Usuário")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UsuarioController {

	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioService servicos;

	@ApiOperation(value = "Busca lista de usuários no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna lista de usuários")})
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> pegarTodes() {
		List<UsuarioModel> objetoLista = repository.findAll();

		if (objetoLista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(objetoLista);
		}
	}

	@ApiOperation(value = "Busca usuário por Id")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna usuário existente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("/{id_usuario}")
	public ResponseEntity<UsuarioModel> pegarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(400).build());

	}
	
	@ApiOperation(value = "Busca usuário por nome")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna usuário existente ou inexistente"),
	@ApiResponse(code = 204, message = "Retorno inexistente")})
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioModel>> pegarPorNome (@PathVariable String nomeCompleto){
		return ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(nomeCompleto));
	}
	
	@ApiOperation(value = "Salva novo usuário no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna usuário cadastrado")})
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody UsuarioModel novoUsuario) {
		return servicos.cadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElse(ResponseEntity.status(400).build());

	}
	
	@ApiOperation(value = "Loga usuário no sistema")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna login do usuário cadastrado"),
	@ApiResponse(code = 400, message = "Erro na requisição")})
	@PostMapping("/logar")
	public ResponseEntity<CredenciaisDTO> credenciais(@Valid @RequestBody UsuarioLoginDTO usuarioParaAutenticar) {
		return servicos.pegarCredenciais(usuarioParaAutenticar);
	}
	
	@ApiOperation(value = "Atualiza usuário existente")
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna usuário atualizado")})
	@PutMapping
	public ResponseEntity<UsuarioModel> atualizar(@Valid @RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(usuario));
   }
	
	@ApiOperation(value = "Deletar usuário existente")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Usuário deletado!"),
	@ApiResponse(code = 400, message = "Id de usuário inválido!")})
	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<UsuarioModel> deletar(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<UsuarioModel> objetoOptional = repository.findById(idUsuario);

		if (objetoOptional.isPresent()) {
			repository.deleteById(idUsuario);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}