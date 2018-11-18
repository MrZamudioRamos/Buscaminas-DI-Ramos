package ramos.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlu
 */
public class Ficheros {

    public boolean Check(String src) {

        File archivo = new File(src);
        
        return archivo.exists();
    }
    
    
    
    public void Crear(String archivo) throws FileNotFoundException{
        
        FileInputStream fis = new FileInputStream(archivo);
        FileOutputStream fos = new FileOutputStream(archivo);
        
        DataInputStream dis = new DataInputStream(fis);
        DataOutputStream dos = new DataOutputStream(fos);
        
        
    }
    
    
    public void Escribir(String rank, Usuario user) throws FileNotFoundException, IOException{
        
        DataOutputStream dow = new DataOutputStream(new FileOutputStream(rank));
        dow.writeUTF(user.toString());
        dow.flush();
        dow.close();
    }
    
}
