package br.com.ordemservico.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.api.model.UsuarioDTO;
import br.com.ordemservico.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(1));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> criar(@RequestBody @Valid UsuarioDTO usuarioDTO){
		return ResponseEntity.ok(usuarioDTO);
	}
	

}
