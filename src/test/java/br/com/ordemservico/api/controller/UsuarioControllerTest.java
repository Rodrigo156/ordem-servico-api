package br.com.ordemservico.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ordemservico.api.model.UsuarioDTO;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = UsuarioController.class)
@AutoConfigureMockMvc
@Import({
	
})
public class UsuarioControllerTest {

	static String URL_API_USUARIO = "/api/v1/usuarios";
	
	
	@Autowired
	MockMvc mvc;
	
	
	
	@Test
	@DisplayName("Deve Criar Usuario com sucesso")
	public void deveCriarUsuariioComSucesso() throws Exception{
		
		// Cenario
		UsuarioDTO usuarioDTO = UsuarioDTO.builder()
										
										.build();
		
		String content = new ObjectMapper().writeValueAsString(usuarioDTO);
		
		// Ação
		 MockHttpServletRequestBuilder request= MockMvcRequestBuilders
						.post(URL_API_USUARIO)
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(content);
		
		// Verificação
		 mvc
		 	.perform(request)
		 	.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	
	
}
