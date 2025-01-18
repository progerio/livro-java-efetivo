package org.progerio.references.weakhashmap;

public interface Video {

	void tocar();

	void pausar();

	void parar();

	void avancar(double multiplicador);

	void retrocedor(double multiplicador);

	void buscar(long tempo);
}
