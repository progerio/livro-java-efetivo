package org.progerio.serializer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

class CriaEArmazenaPessoasTest {

	@Test
	void testCriandoPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Leandro");
		pessoa.setTelefone("3xxx-xxxx");

		CriaEArmazenaPessoas.escreve(pessoa);

		File file = new File("grava.dados");

		assertTrue(file.exists());

		if (file.exists()) {
			file.delete();
		}
	}

}
