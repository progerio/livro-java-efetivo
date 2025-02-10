package org.progerio.serializer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class RestaurarPessoaTest {

	@Test
	void testRestaurarPessoas() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Leandro");
		pessoa.setTelefone("3xxx-xxxx");

		CriaEArmazenaPessoas.escreve(pessoa);

		Pessoa pessoa2 = RestaurarPessoa.restaurar();

		assertEquals("Leandro", pessoa2.getNome());
		assertEquals("3xxx-xxxx", pessoa2.getTelefone());

		File file = new File("grava.dados");
		assertTrue(file.exists());
		if (file.exists()) {
			file.delete();
		}
	}

}
