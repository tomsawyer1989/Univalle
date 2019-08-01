/*
 * ESTUDIANTE N°1:
 *  Nombre: Jorge Leonardo Herrera
 *  Codigo: 1628189
 *  Email: herrera.jorge@correounivalle.edu.co
 *
 * ESTUDIANTE N°2:
 *  Nombre: Jhon Edwin Saa
 *  Codigo: 1630907
 *  Email: jhon.saa@correounivalle.edu.co
 *    
 */
package punto1;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Sala {
    int hora;
     ArrayList<Computador> listaComputadores=new ArrayList();
     
     //constructor
     public Sala(int cantidadComputadores){
         for(int i=0;i<cantidadComputadores;i++){
             Computador computador=new Computador();
             listaComputadores.add(computador);
         }
         hora=12;
     }
}
