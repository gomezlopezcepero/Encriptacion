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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class GestionArchivos {

	

	
	
	public void escribirFichero(byte[] mensaje, String nombreArchivo) throws IOException {		
	
		Files.write(Paths.get("./"+nombreArchivo), mensaje);
		
	}
	

	
	
public String leerFichero(String msj) {
		
	String mensaje="";
	
		String filePath = new File(msj).getAbsolutePath();
        File f = new File(filePath);
        filePath= f.getParent();
        
        f = new File(filePath, msj);
        if (!f.exists()) {
            System.out.println("Fichero " + f.getName() + " no existe");
        } else {
         
              BufferedReader br = null;
              InputStreamReader fr = null;
              try {
                 fr= new InputStreamReader(new FileInputStream(f), "windows-1252");
                  br = new BufferedReader(fr);
                  
                  // Lectura del fichero
                  String linea;
                  while ((linea = br.readLine()) != null) {
                    
                	  mensaje = linea;
                  } 
                  
              } catch (Exception e) {
                  e.printStackTrace();
              } finally {
                  try {
                      if (null != fr) {
                          fr.close();
                      }
                  } catch (Exception e2) {
                      e2.printStackTrace();
                  }
              }            
        }
        
        
        return mensaje; 
            
        }
	
	

public  byte[] leerFicheroEncriptado(String nombreFichero) throws Exception {
    FileInputStream fis = new FileInputStream(nombreFichero);
    int numBtyes = fis.available();
    byte[] bytes = new byte[numBtyes];
    fis.read(bytes);
    fis.close();

    return bytes;
 }



public  PublicKey leerLlavePublica(String nombreFichero) throws Exception {
    FileInputStream fis = new FileInputStream(nombreFichero);
    int numBtyes = fis.available();
    byte[] bytes = new byte[numBtyes];
    fis.read(bytes);
    fis.close();

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    KeySpec keySpec = new X509EncodedKeySpec(bytes);
    PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
    return keyFromBytes;
 }




 public  PrivateKey leerLlavePrivada(String nombreFichero) throws Exception {
    FileInputStream fis = new FileInputStream(nombreFichero);
    int numBtyes = fis.available();
    byte[] bytes = new byte[numBtyes];
    fis.read(bytes);
    fis.close();

    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
    PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
    return keyFromBytes;
 }

 
 
 
 
 public void guardarLlave(Key key, String nombreFichero) throws Exception {
    byte[] publicKeyBytes = key.getEncoded();
    FileOutputStream fos = new FileOutputStream(nombreFichero);
    fos.write(publicKeyBytes);
    fos.close();
 }


	
}
