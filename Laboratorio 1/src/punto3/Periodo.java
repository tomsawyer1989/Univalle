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
package punto3;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Periodo {
    String mesInicio;
    String mesFinal;
    String ano;
    ArrayList <Curso> cursos;
    
    //Constructor
    public Periodo(String mesInicio,String mesFinal,String ano){
        cursos=new ArrayList();
        this.mesInicio=mesInicio;
        this.mesFinal=mesFinal;
        this.ano=ano;
        int cantidadCursos=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de cursos que desea abrir este periodo."));
        for(int i=0;i<cantidadCursos;i++){
            String codigo=JOptionPane.showInputDialog(null,"Digite el código del curso.");
            String nombre=JOptionPane.showInputDialog(null,"Digite el nombre del curso.");
            int creditos=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número de créditos del curso.")); 
            Curso curso=new Curso(codigo,nombre,creditos);
            cursos.add(curso);
        }
    }
    public String getMesInicio(){
        return mesInicio;
    }
    public String getMesFinal(){
        return mesFinal;
    }
    public String getAno(){
        return ano;
    }
    public ArrayList <Curso> getCursos(){
        return cursos;
    }
}
