package br.com.cod3r.cm;

import org.junit.jupiter.api.Test;

public class TabuleiroTeste {

	private Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
	
	@Test
	void testeTabuleiro () {
		tabuleiro.abrir(3, 3);
	}
}
