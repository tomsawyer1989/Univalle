/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoserver;

/**
 *
 * @author jhone
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class ArchObj {
    Pregunta[] preguntas;
    
    public ArchObj(){
    }
    public void escribir(Pregunta[] preguntas){
        try {
            ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("fichero.obj"));
            write.writeObject(preguntas);
            write.close();
            JOptionPane.showMessageDialog(null,"Datos guardados con exito!");
            } 
        catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Pregunta[] leer() throws ClassNotFoundException{
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("fichero.obj"));
            preguntas=(Pregunta[])read.readObject();
            read.close();
            } 
        catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error durante la lectura del archivo!");
        }
        catch ( ClassNotFoundException ex){
            System.err.println( "No se pudo crear el objeto." );
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error");
        }
        return preguntas;
    }
}
