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


public class Curso {
    String codigo;
    String nombre;
    int creditos;
    ArrayList <Estudiante> estudiantes;
    
    //Constructor
    public Curso(String codigo,String nombre,int creditos){
        estudiantes=new ArrayList();
        this.codigo=codigo;
        this.nombre=nombre;
        this.creditos=creditos;
    }
    
    //Adicionar estudiante
    public void addEstudiante(){
        int codEstudiante=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el código del estudiante."));
        String nomEstudiante=JOptionPane.showInputDialog(null,"Digite el nombre del estudiante."); 
        String plan=JOptionPane.showInputDialog(null,"Digite el plan del estudiante.");
        Estudiante estudiante=new Estudiante(codEstudiante,nomEstudiante,plan);
        estudiantes.add(estudiante);
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCreditos(){
        return creditos;
    }
    public ArrayList <Estudiante> getEstudiantes(){
        return estudiantes;
    }
}
