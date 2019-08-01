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

/**
 *
 * @author Jorge
 */
public class Estudiante {
    int codigo;
    String nombre;
    String plan;
    double nota;
    
    //Constructor
    public Estudiante(int codigo,String nombre,String plan){
        this.codigo=codigo;
        this.nombre=nombre;
        this.plan=plan;
        nota=0.0;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getPlan(){
        return plan;
    }
    public double getNota(){
        return nota;
    }
    public void setNota(Double nota){
        this.nota=nota;
    }
}
