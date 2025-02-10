package org.progerio.serializer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtilities {

	public static void escreva(String nomeArq, Item item) {
		try {
			FileOutputStream fout = new FileOutputStream(nomeArq);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(item);
			oos.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Item leia(String nomeArq) {
		Item item = null;
		try {
			FileInputStream fin = new FileInputStream(nomeArq);
			ObjectInputStream ois = new ObjectInputStream(fin);
			item = (Item) ois.readObject();
			ois.close();
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return item;
	}
}
