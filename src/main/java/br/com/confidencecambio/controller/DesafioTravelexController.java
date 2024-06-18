package br.com.confidencecambio.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.request.ImcRequest;
import br.com.confidencecambio.response.ImcResponse;
import br.com.confidencecambio.service.DesafioTravelexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping( "/desafio-travelex" )
@Api( "DesafioTravelex" )
public class DesafioTravelexController {

	private static Logger LOG = LoggerFactory.getLogger( DesafioTravelexController.class );
	
	@Autowired
	private DesafioTravelexService service;
	
	@PostMapping( "/calculo-imc" )
	@ApiOperation( "Retorna o cálculo do IMC a partir do peso e altura informados" )
	public ResponseEntity<ImcResponse> calcularIMC( @Valid @RequestBody ImcRequest request ) {
		LOG.info( this.getClass().getName() + " - executando calcularIMC - {}", request );
		
		ImcResponse response = service.calcularIMC( request );
		
		LOG.info( this.getClass().getName() + " - IMC calculado - {}", response );
		
		return ResponseEntity.ok( response );
	}
}
