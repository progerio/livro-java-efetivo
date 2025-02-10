package org.progerio.serializer;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CriaEArmazenaPessoas {

	
	public static void escreve(Pessoa p) {
		try {
			FileOutputStream fOutputStream = new FileOutputStream("grava.dados");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fOutputStream);
			objectOutputStream.writeObject(p);
			objectOutputStream.close();
			fOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
