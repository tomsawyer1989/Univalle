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

import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JTextField;


public class Fecha extends Thread{
    JTextField fecha;
    String fechaSinMs;
    
    public Fecha(JTextField fecha){
        this.fecha=fecha;
    }
    @Override
    public void run(){
        while(true){
           Date fechaActual=new Date();
           long ms=fechaActual.getTime();
           Timestamp sqlTimestamp=new Timestamp(ms);
           String[] lista=sqlTimestamp.toString().split("\\.");
           fechaSinMs=lista[0];
           //System.out.println(fechaSinMs);
           fecha.setText(fechaSinMs);
           try{
              sleep(1000); //Segundo a segundo... 
           }catch(Exception e){
              e.getMessage();
           }
       }
    }
    public String getFecha(){
        return fechaSinMs;
    }
}