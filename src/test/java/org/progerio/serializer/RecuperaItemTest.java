package org.progerio.serializer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecuperaItemTest {

	@Test
	void testRecuperarItem() {

		Item item = new Item();
		item.setMatricula(123456);
		item.setSenha("Nova Senha");
		item.setUsuario("Fulano");
		Item.setNumeroSerial(67890L);
		FileUtilities.escreva("itemArq", item);

		Item item2 = FileUtilities.leia("itemArq");
		assertEquals(123456, item2.getMatricula());
		assertNull(item2.getSenha());
		assertEquals("Fulano", item2.getUsuario());

	}

}
