package org.progerio.serializer;

import java.io.Serializable;

public class Item implements Serializable {

	private static long numeroSequencia;

	private String usuario;

	private long matricula;

	private transient String senha;

	public Item() {
		numeroSequencia = System.currentTimeMillis();
		usuario = "Nenhum";
		matricula = System.currentTimeMillis();
		senha = "Nenhuma";
	}

	@Override
	public String toString() {
		return "Item: numeroSequencia=" + numeroSequencia + ", usuario=" + usuario + ", matricula=" + matricula
				+ ", senha=" + senha;
	}

	public static long getNumeroSerial() {
		return numeroSequencia;
	}

	public static void setNumeroSerial(long numeroSerial) {
		Item.numeroSequencia = numeroSerial;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
