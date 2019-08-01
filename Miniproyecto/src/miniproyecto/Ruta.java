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

import java.io.Serializable;
import java.util.ArrayList;


public class Ruta implements Serializable{
    int codigo;
    String nombre;
    String descripcion;
    String tipo;
    ArrayList<Bus> buses;
    
    public Ruta(int codigo,String nombre,String descripcion,String tipo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.tipo=tipo;
        buses=new ArrayList();
    }
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getTipo(){
        return tipo;
    }
    public ArrayList<Bus> getBuses(){
        return buses;
    }
}