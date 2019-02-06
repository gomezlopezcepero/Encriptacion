package rendimientoAlgoritmosCifrados;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class RendimientoRSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto = "Las islas Kuriles fueron habitadas por los ainúes desde tiempo inmemorial, hasta que fueron expulsados por los rusos en el siglo XVIII. Japón se quedó con ellas en 1875 (Tratado de San Petersburgo) a cambio de ceder la isla de Sajalín a Rusia. ";
		System.out.println("Texto a encriptar: "+texto);
		System.out.println("========================");
		System.out.println("Probando encriptación RSA...");
		
		
		long startTime = System.currentTimeMillis();

		cifradoRSA(texto);

		long endTime = System.currentTimeMillis();

		System.out.println("RSA tardó " + (endTime - startTime) + " milisegundos en encriptar");
		
				
		
	}
	
	static public void cifradoRSA(String texto) {
		
		try {
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
	    KeyPair keyPair = keyPairGenerator.generateKeyPair();
	    PublicKey clavePublica = keyPair.getPublic();
	    PrivateKey clavePrivada = keyPair.getPrivate();

	      Cipher cifrador = Cipher.getInstance("RSA");		    
	      
	      
	      cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
	      byte[] encriptado = cifrador.doFinal(texto.getBytes());

		} catch (Exception e) {
	         e.printStackTrace();
	      }
	      		
	}
	

}
