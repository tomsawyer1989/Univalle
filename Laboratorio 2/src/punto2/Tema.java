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
package punto2;

public class Tema {
    String nombre;
    String[] listWords;
    
    public Tema(String nombre){
        this.nombre=nombre;
        listWords=new String[8];
        
    }
    public void addWords(String word1,String word2,String word3,String word4,String word5,String word6,String word7,String word8){
        listWords[0]=word1;
        listWords[1]=word2;
        listWords[2]=word3;
        listWords[3]=word4;
        listWords[4]=word5;
        listWords[5]=word6;
        listWords[6]=word7;
        listWords[7]=word8;
    }
    public String getNombre(){
        return nombre;
    }
}
