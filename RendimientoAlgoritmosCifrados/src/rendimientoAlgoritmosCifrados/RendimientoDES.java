package rendimientoAlgoritmosCifrados;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RendimientoDES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto = "Las islas Kuriles fueron habitadas por los ain�es desde tiempo inmemorial, hasta que fueron expulsados por los rusos en el siglo XVIII. Jap�n se qued� con ellas en 1875 (Tratado de San Petersburgo) a cambio de ceder la isla de Sajal�n a Rusia. ";
		System.out.println("Texto a encriptar: "+texto);
		
		System.out.println("========================");
		System.out.println("Probando encriptaci�n DES...");
		
		
		long startTime = System.currentTimeMillis();

		cifradoDES(texto);

		long endTime = System.currentTimeMillis();

		System.out.println("DES tard� " + (endTime - startTime) + " milisegundos en encriptar");
		
		
		
		
	}
	
	
	static public void cifradoDES(String texto) {
		
		 try {
		         KeyGenerator keygen = KeyGenerator.getInstance("DES");
		         keygen.init (56);
		         SecretKey key = keygen.generateKey();
		         Cipher desCipher = Cipher.getInstance("DES");
		         desCipher.init(Cipher.ENCRYPT_MODE, key);
		         String mensajeCifrado = new String(desCipher.doFinal(texto.getBytes()));
		         String mensajeCifrado2 = new String(desCipher.doFinal(mensajeCifrado.getBytes()));
		         String mensajeCifrado3 = new String(desCipher.doFinal(mensajeCifrado2.getBytes()));


		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}
	

}
