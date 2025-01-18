package org.progerio.references.weakhashmap;

import java.util.Map;

public class MetadadosDeVideosEmExibicao {

	private final Map<Video, MetadadosDeVideo> informacoesVideos;

	public MetadadosDeVideosEmExibicao(Map<Video, MetadadosDeVideo> informacoesVideos) {
		
		this.informacoesVideos = informacoesVideos;
	}

	public void registrarVide(Video video, MetadadosDeVideo metadadosDeVideo) {
		informacoesVideos.put(video, metadadosDeVideo);
	}

	public MetadadosDeVideo obterMetadados(Video video) {
		return informacoesVideos.get(video);
	}

	public int obterNumeroDeVideosRegistrados() {
		return informacoesVideos.size();
	}
}
