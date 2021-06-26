package br.com.ordemservico.api.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String cpf;
	
	private String telefone;
	
	private LocalDate dtNascimento;
	
	private boolean ativo;

}
