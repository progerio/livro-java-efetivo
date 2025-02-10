package org.progerio.serializer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class RestaurarPessoa {

	public static Pessoa restaurar() {
		try {
			FileInputStream fin = new FileInputStream("grava.dados");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Pessoa p = (Pessoa) ois.readObject();
			ois.close();
			fin.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
