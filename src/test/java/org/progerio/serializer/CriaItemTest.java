package org.progerio.serializer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class CriaItemTest {

	@Test
	void testCriarItem() {
		Item item = new Item();
		item.setMatricula(123456);
		item.setSenha("Nova Senha");
		item.setUsuario("Fulano");
		Item.setNumeroSerial(67890L);
		FileUtilities.escreva("itemArq", item);
		 
		 File file = new File("itemArq");
		 
		 assertTrue(file.exists());
		 
		 if(file.exists()) {
			 file.delete();
		 }
	}

}
