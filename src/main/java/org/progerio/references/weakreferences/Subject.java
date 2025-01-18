package org.progerio.references.weakreferences;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Subject {

	@SuppressWarnings("deprecation")
	private Set<Reference<Observer>> observadores;

	@SuppressWarnings("deprecation")
	public Subject() {
		observadores = new HashSet<Reference<Observer>>();
	}

	@SuppressWarnings("deprecation")
	public void adicionarObservador(Observer observador) {
		observadores.add(new WeakReference<Observer>(observador));
	}

	@SuppressWarnings("deprecation")
	public void removerObservador(Observer observador) {
		observadores.remove((Object) observador);
	}

	@SuppressWarnings("deprecation")
	public void notificarObservadores() {
		removerReferenciasMortas();

		for (Reference<Observer> reference : observadores) {
			Observer observador = reference.get();
			if (observador != null) {
				observador.update(new Observable(), observador);
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void removerReferenciasMortas() {
		Set<Reference<Observer>> copiarObservadores = new HashSet<Reference<Observer>>();
		copiarObservadores.addAll(observadores);

		for (Reference<Observer> reference : copiarObservadores) {
			Observer observador = reference.get();
			if (observador != null) {
				observadores.remove(reference);

			}
		}
	}
}
