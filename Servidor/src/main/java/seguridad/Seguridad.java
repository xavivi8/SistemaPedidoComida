package seguridad;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Seguridad {

	public void laSeguridad() {

		SSLContext sslContext;
		try {
			sslContext = SSLContext.getInstance("TLS");
			KeyManagerFactory keyManagerFactory = KeyManagerFactory
					.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			TrustManagerFactory trustManagerFactory = TrustManagerFactory
					.getInstance(TrustManagerFactory.getDefaultAlgorithm());

			// Cargar el almacén de claves y el almacén de confianza (truststore) con tus
			// certificados
			char[] keystorePassword = "llaves".toCharArray();
			char[] truststorePassword = "confio".toCharArray();
			KeyStore keyStore = KeyStore.getInstance("JKS");
			KeyStore trustStore = KeyStore.getInstance("JKS");

			try (InputStream keyStoreStream = new FileInputStream("llaves.jks");
					InputStream trustStoreStream = new FileInputStream("confio.jks")) {
				keyStore.load(keyStoreStream, keystorePassword);
				trustStore.load(trustStoreStream, truststorePassword);
			}

			keyManagerFactory.init(keyStore, keystorePassword);
			trustManagerFactory.init(trustStore);

			sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
		} catch (NoSuchAlgorithmException | KeyStoreException | CertificateException | IOException
				| UnrecoverableKeyException | KeyManagementException e) {
			e.printStackTrace();
			return;
		}

		SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
		SSLServerSocket serverSocket = null; // Declarar fuera del bloque try
	}
}
