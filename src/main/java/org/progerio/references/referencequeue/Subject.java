package org.progerio.references.referencequeue;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Subject {

	@SuppressWarnings("deprecation")
	private ReferenceQueue<Observer> referenciasMortas;

	@SuppressWarnings("deprecation")
	private Set<Reference<Observer>> observadores;

	@SuppressWarnings("deprecation")
	public Subject() {
		observadores = new HashSet<Reference<Observer>>();
		referenciasMortas = new ReferenceQueue<Observer>();
	}

	@SuppressWarnings("deprecation")
	public void registrarObservadores(Observer observador) {
		observadores.add(new WeakReference<Observer>(observador, referenciasMortas));
	}

	@SuppressWarnings("deprecation")
	public void notificarObservadores() {
		removerReferenciasMortas();

		for (Reference<Observer> ref : observadores) {
			Observer observador = ref.get();
			if (observador != null) {
				observador.update(new Observable(), observador);
			}
		}
	}

	private void removerReferenciasMortas() {
		Reference<?> ref = referenciasMortas.poll();
		while (ref != null) {
			observadores.remove(ref);
			ref = referenciasMortas.poll();
		}
	}

}
