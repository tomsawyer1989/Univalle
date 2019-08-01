/**
 ESTUDIANTE N°1:
 *  Nombre: Jorge Leonardo Herrera
 *  Codigo: 1628189
 *  Email: herrera.jorge@correounivalle.edu.co
 *
 * ESTUDIANTE N°2:
 *  Nombre: Jhon Edwin Saa
 *  Codigo: 1630907
 *  Email: jhon.saa@correounivalle.edu.co
 */
package miniproyecto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchObj {
    Sit sit;
    
    public ArchObj(){
    }
    public void escribir(Sit sit){
        try {
            ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("fichero.obj"));
            write.writeObject(sit);
            write.close();
            } 
        catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Sit leer() throws ClassNotFoundException{
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("fichero.obj"));
            sit=(Sit)read.readObject();
            read.close();
            } 
        catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sit;
    }
}