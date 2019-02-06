package EncriptacionRSA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class DesencriptarRSA {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GestionArchivos arch = new GestionArchivos();
		
	      PrivateKey clavePrivada = arch.leerLlavePrivada("claveprivada.dat");
		
	      byte[] mensajeCifrado= arch.leerFicheroEncriptado("mensajeCifrado.txt");
		
		  Cipher cifrador = Cipher.getInstance("RSA");
		
	      cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
	      byte[] bytesDesencriptados = cifrador.doFinal(mensajeCifrado);
	      String mensajeDesencriptado = new String(bytesDesencriptados);

	      System.out.println("*Mensaje descifrado correctamente*");
	      
	      System.out.println(mensajeDesencriptado);

		
		
	}
	


	
}
