package EncriptacionRSA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class EncriptarRSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			GestionArchivos arch = new GestionArchivos();
			
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		    KeyPair keyPair = keyPairGenerator.generateKeyPair();
		    PublicKey clavePublica = keyPair.getPublic();
		    PrivateKey clavePrivada = keyPair.getPrivate();
		
		      arch.guardarLlave(clavePublica, "clavepublica.dat");
		      clavePublica = arch.leerLlavePublica("clavepublica.dat");

		      arch.guardarLlave(clavePrivada, "claveprivada.dat");
		      clavePrivada = arch.leerLlavePrivada("claveprivada.dat");

		      Cipher cifrador = Cipher.getInstance("RSA");		    
		      
		      String mensaje= arch.leerFichero("mensaje.txt");
		      
		      System.out.println("Mensaje sin descifrar: "+mensaje);
		      
		      cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
		      byte[] encriptado = cifrador.doFinal(mensaje.getBytes());

		      arch.escribirFichero(encriptado,"mensajeCifrado.txt");
		      
		      System.out.println("");
		      
		      System.out.println("*Mensaje cifrado correctamente*");
		      System.out.println("");
		      
		      System.out.println("Mensaje encriptado en formato hexadecimal: ");
		      for (byte b : encriptado) {
		         System.out.print(Integer.toHexString(0xFF & b));
		      }
		      

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
