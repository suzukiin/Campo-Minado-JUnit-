package br.com.cod3r.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.cod3r.cm.Campo;

public class CampoTeste {
	private Campo campo = new Campo(3,3);
	
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () ->{
			campo.abrir();
		});
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinhos() {
		
		Campo campo12 = new Campo(1,1);
		Campo campo11 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
}
