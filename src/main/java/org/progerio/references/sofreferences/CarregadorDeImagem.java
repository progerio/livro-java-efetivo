package org.progerio.references.sofreferences;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class CarregadorDeImagem {

	private final Map<URI, Reference<Image>> cacheDeImagem;

	public CarregadorDeImagem() {
		cacheDeImagem = new HashMap<URI, Reference<Image>>();
	}

	public Image fetchImage(URI imagePath) {
		Image image = null;

		Reference<Image> imageRef = getImageRefDoCache(imagePath);
		if (imageRef != null) {
			image = imageRef.get();
		}

		if (image == null) {
			image = carregarImagem(imagePath);
			adicionarImagemAoCache(imagePath, image);

		}
		return image;
	}

	private Image carregarImagem(URI imagePath) {
		InputStream stream = ClassLoader.getSystemResourceAsStream(imagePath.toString());
		Image image = null;
		try {
			image = ImageIO.read(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

	private void adicionarImagemAoCache(URI imagePath, Image image) {
		cacheDeImagem.put(imagePath, new SoftReference<Image>(image));

	}

	private Reference<Image> getImageRefDoCache(URI imageUri) {
		return cacheDeImagem.get(imageUri);
	}
}
