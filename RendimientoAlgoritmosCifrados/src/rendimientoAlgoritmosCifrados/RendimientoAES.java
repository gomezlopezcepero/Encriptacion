package rendimientoAlgoritmosCifrados;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RendimientoAES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto = "Las islas Kuriles fueron habitadas por los ainúes desde tiempo inmemorial, hasta que fueron expulsados por los rusos en el siglo XVIII. Japón se quedó con ellas en 1875 (Tratado de San Petersburgo) a cambio de ceder la isla de Sajalín a Rusia. ";
		System.out.println("Texto a encriptar: "+texto);
		System.out.println("========================");
		System.out.println("Probando encriptación AES...");
		
		long startTime = System.currentTimeMillis();

		cifradoAES(texto);

		long endTime = System.currentTimeMillis();

		System.out.println("AES tardó " + (endTime - startTime) + " milisegundos en encriptar");
		
		
		
	}

	
	static public void cifradoAES(String texto) {
		   
		   try {
	          KeyGenerator kg = KeyGenerator.getInstance("AES");
	          kg.init (128);
	          SecretKey clave = kg.generateKey();
	         
	          Cipher c = Cipher.getInstance("AES");
	          c.init(Cipher.ENCRYPT_MODE, clave);
	         
	          byte textoPlano[] = texto.getBytes();
	          byte textoCifrado[] = c.doFinal(textoPlano);

	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   
		
	}
	
}
