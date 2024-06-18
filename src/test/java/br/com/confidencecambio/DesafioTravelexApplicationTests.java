package br.com.confidencecambio;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.confidencecambio.enums.ImcStatusEnum;
import br.com.confidencecambio.request.ImcRequest;
import br.com.confidencecambio.response.ImcResponse;

@SpringBootTest
@AutoConfigureMockMvc
class DesafioTravelexApplicationTests {

	private static ObjectMapper objectMapper;

	@Autowired
    private MockMvc mockMvc;
	
	private final String BASE_URL = "/desafio-travelex";
	
	@BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper();
    }
	
	@Test
    @Order( 1 )
    public void testeCalculaImcMuitoAbaixoPeso() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 50 ), Double.valueOf( 1.75 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 16.3 );
		assertEquals( response.getSituacao(), ImcStatusEnum.MUITO_ABAIXO_DO_PESO.getSituacao() );
    }

	@Test
    @Order( 2 )
    public void testeCalculaImcAbaixoPeso() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 50 ), Double.valueOf( 1.70 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 17.3 );
		assertEquals( response.getSituacao(), ImcStatusEnum.ABAIXO_DO_PESO.getSituacao() );
    }

	@Test
    @Order( 3 )
    public void testeCalculaImcPesoNormal() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 55 ), Double.valueOf( 1.65 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 20.2 );
		assertEquals( response.getSituacao(), ImcStatusEnum.PESO_NORMAL.getSituacao() );
    }
	
	@Test
    @Order( 4 )
    public void testeCalculaImcAcimaPeso() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 75 ), Double.valueOf( 1.70 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 26.0 );
		assertEquals( response.getSituacao(), ImcStatusEnum.ACIMA_DO_PESO.getSituacao() );
    }
	
	@Test
    @Order( 5 )
    public void testeCalculaImcObesidadeI() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 70 ), Double.valueOf( 1.50 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 31.1 );
		assertEquals( response.getSituacao(), ImcStatusEnum.OBESIDADE_I.getSituacao() );
    }

	@Test
    @Order( 6 )
    public void testeCalculaImcObesidadeII() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 90 ), Double.valueOf( 1.55 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 37.5 );
		assertEquals( response.getSituacao(), ImcStatusEnum.OBESIDADE_II.getSituacao() );
    }
	
	@Test
    @Order( 7 )
    public void testeCalculaImcObesidadeIII() throws Exception {
		ImcRequest imcRequest = new ImcRequest( Double.valueOf( 100 ), Double.valueOf( 1.55 ) );

		ImcResponse response = executarMetodo( imcRequest );
		
		assertEquals( response.getImc(), 41,6 );
		assertEquals( response.getSituacao(), ImcStatusEnum.OBESIDADE_III.getSituacao() );
    }
	
	private ImcResponse executarMetodo( ImcRequest imcRequest ) throws Exception, JsonProcessingException, JsonMappingException, UnsupportedEncodingException {
		MvcResult result = this.mockMvc.perform( post( BASE_URL + "/calculo-imc" ).contentType( MediaType.APPLICATION_JSON )
			.content( objectMapper.writeValueAsString( imcRequest ) )
			.header( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON ) )
			.andExpect( status().isOk() )
			.andReturn();
		
		return objectMapper.readValue( result.getResponse().getContentAsString(), new TypeReference<ImcResponse>() {} );
	}
	
	@Test
    @Order( 8 )
    public void testeCalculaImcSemValores() throws Exception {
		ImcRequest imcRequest = new ImcRequest( 0d, 0d );
		
		this.mockMvc.perform( post( BASE_URL + "/calculo-imc" ).contentType( MediaType.APPLICATION_JSON )
			.content( objectMapper.writeValueAsString( imcRequest ) )
			.header( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON ) )
			.andExpect( status().isBadRequest() )
			.andExpect( content().string( containsString( "Campo(s) invalido(s). Preencha corretamente e tente novamente." ) ) )
			.andExpect( content().string( containsString( "O peso deve ser maior que 0" ) ) )
			.andExpect( content().string( containsString( "A altura deve ser maior que 0" ) ) )
			.andReturn();
    }
}
