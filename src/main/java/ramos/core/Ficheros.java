package ramos.core;

import java.io.File;

/**
 *
 * @author carlu
 */
public class Ficheros {

    public boolean Check(String src) {

        File archivo = new File(src);
        
        
        return archivo.exists();
    }
    
    
    public void Crear(String archivo){
        archivo = "";
        
        
    }
    
    
}
