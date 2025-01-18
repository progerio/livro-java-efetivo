package org.progerio.references.phantomreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.net.URI;
import java.util.Map;

public class GerenciadorDeFluxosDeEntrada {

	private final Map<Reference<URI>, FileInputStream> fluxosDeEntrada;

	private final ReferenceQueue<URI> referenciasMortas;

	public GerenciadorDeFluxosDeEntrada(Map<Reference<URI>, FileInputStream> fluxosDeEntrada,
			ReferenceQueue<URI> referenciasMortas) {
		this.fluxosDeEntrada = fluxosDeEntrada;
		this.referenciasMortas = referenciasMortas;
	}

	public FileInputStream obterFluxoDeEntrada(URI caminho) throws FileNotFoundException {
		removerReferenciasMortas();

		File arquivo = new File(caminho);
		FileInputStream fluxo = new FileInputStream(arquivo);
		Reference<URI> referencia = new PhantomReference<URI>(caminho, referenciasMortas);
		fluxosDeEntrada.put(referencia, fluxo);
		return fluxo;
	}

	public void removerReferenciasMortas() {
		Reference<?> reference = referenciasMortas.poll();

		while (reference != null) {
			FileInputStream fluxo = fluxosDeEntrada.get(reference);
			fluxosDeEntrada.remove(reference);

			try {
				fluxo.close();
			} catch (Exception e) {
				reference.clear();
				reference = referenciasMortas.poll();
			}
		}
	}
}
