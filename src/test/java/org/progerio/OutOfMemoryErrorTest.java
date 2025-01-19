package org.progerio;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class OutOfMemoryErrorTest {

	@Test
	public void testPoolStringThrowsOutOfMemoryErrorException() {
	    Throwable exception = assertThrows(OutOfMemoryError.class, () -> {
	    	String texto = "Uma pobre String na Perm Gen...";
			List<String> lista = new ArrayList<String>();
			for (int i = 0; true; i++) {
				String textoFinal = texto + i;
				// Utiliza o padrão de projeto FlyWeight.
				textoFinal = textoFinal.intern();
				// Manter referenciado para que não
				// seja coletado pelo GC.
				lista.add(textoFinal);
			}
	    });
	    assertEquals("Java heap space", exception.getMessage());
	}
	
	@Test
	void testWithoutPoolStringThrowsOutOfMemoryErrorException() {
		Throwable exception = assertThrows(OutOfMemoryError.class, () -> {
			String texto = "Não fui para o pool, fiquei na heap...";
			List<String> lista = new ArrayList<String>();
			for (int i = 0; true; i++) {
				// Sem utilizar o pool
				String textoFinal = texto + i;
				// Manter referenciado para que não
				// seja coletado pelo GC.
				lista.add(textoFinal);
			}
		});
		assertEquals("Java heap space", exception.getMessage());
	}
}
