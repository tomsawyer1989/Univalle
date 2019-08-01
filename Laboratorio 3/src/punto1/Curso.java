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

import java.io.Serializable;
import java.util.ArrayList;


public class Curso implements Serializable{
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
    
    
    public void addEstudiante(Estudiante estudiante){
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
    public void setCodigo(String codigo){
        this.codigo=codigo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCreditos(int creditos){
        this.creditos=creditos;
    }
    public ArrayList <Estudiante> getEstudiantes(){
        return estudiantes;
    }
    public void setEstudiantes(ArrayList <Estudiante> estudiantes){
        ArrayList<Estudiante> estudiantesCopia=new ArrayList(estudiantes);
        this.estudiantes=estudiantesCopia;
    }
}