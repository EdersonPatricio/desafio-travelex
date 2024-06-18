package br.com.confidencecambio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.confidencecambio.model.Cliente;
import br.com.confidencecambio.model.Gerente;
import br.com.confidencecambio.model.Robo;

@SpringBootTest
public class ClassesModelTests {

	@Test
	@Order( 1 )
	public void testeCliente() throws Exception {
		Cliente cliente = new Cliente( "João Soares Silva" );

		assertEquals( cliente.getPrimeiroNome(), "João" );
		assertEquals( cliente.getUltimoNome(), "Soares Silva" );
		assertEquals( cliente.getNomeMaiusculo(), "JOÃO SOARES SILVA" );
		assertEquals( cliente.getNomeAbreviado(), "João S. Silva" );
	}

	@Test
	@Order( 2 )
	public void testeClienteComEspacosEmBranco() throws Exception {
		Cliente cliente = new Cliente( "   João Soares Silva  " );

		assertEquals( cliente.getPrimeiroNome(), "João" );
		assertEquals( cliente.getUltimoNome(), "Soares Silva" );
		assertEquals( cliente.getNomeMaiusculo(), "JOÃO SOARES SILVA" );
		assertEquals( cliente.getNomeAbreviado(), "João S. Silva" );
	}

	@Test
	@Order( 3 )
	public void testeGerente() throws Exception {
		Gerente gerente = new Gerente( "Amadeu Alvares Soares Silva" );

		assertEquals( gerente.getPrimeiroNome(), "Amadeu" );
		assertEquals( gerente.getUltimoNome(), "Alvares Soares Silva" );
		assertEquals( gerente.getNomeMaiusculo(), "AMADEU ALVARES SOARES SILVA" );
		assertEquals( gerente.getNomeAbreviado(), "Amadeu A. S. Silva" );
	}

	@Test
	@Order( 4 )
	public void testeGerenteComEspacosEmBranco() throws Exception {
		Gerente gerente = new Gerente( "   Amadeu Alvares Soares Silva  " );

		assertEquals( gerente.getPrimeiroNome(), "Amadeu" );
		assertEquals( gerente.getUltimoNome(), "Alvares Soares Silva" );
		assertEquals( gerente.getNomeMaiusculo(), "AMADEU ALVARES SOARES SILVA" );
		assertEquals( gerente.getNomeAbreviado(), "Amadeu A. S. Silva" );
	}
	
	@Test
	@Order( 5 )
    public void testeRobo() throws Exception {
		Robo robo = new Robo( "R2D2" );

		// Robo não tem método para nome abreviado,
		// pois estas definições são pra nomes próprios
		assertEquals( robo.getPrimeiroNome(), "R2D2" );
		assertEquals( robo.getUltimoNome(), "R2D2" );
		assertEquals( robo.getNomeMaiusculo(), "R2D2" );
	}
	
	@Test
	@Order( 6 )
    public void testeNomeNull() throws Exception {
		RuntimeException exception = assertThrows( IllegalArgumentException.class, () -> new Cliente( null ) );
		assertEquals( exception.getMessage(), "O nome não pode ser nulo ou vazio." );
	}
}
