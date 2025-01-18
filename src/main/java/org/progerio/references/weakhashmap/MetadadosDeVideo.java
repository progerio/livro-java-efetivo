package org.progerio.references.weakhashmap;

import java.sql.Date;
import java.util.List;

public interface MetadadosDeVideo {

	String getTitulo();

	String getAutor();

	List<String> getPalavrasChave();

	long getDuracao();

	List<String> getElenco();

	Date getDataLancamento();

}
