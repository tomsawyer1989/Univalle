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

public class Bus implements Serializable{
    String placa;
    int modelo;
    String marca;
    String tipo;
    int capacidad;
    
    public Bus(String placa,int modelo,String marca,String tipo,int capacidad){
        this.placa=placa;
        this.modelo=modelo;
        this.marca=marca;
        this.tipo=tipo;
        this.capacidad=capacidad;
    }
    public void setPlaca(String placa){
        this.placa=placa;
    }
    public void setModelo(int modelo){
        this.modelo=modelo;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public String getPlaca(){
        return placa;
    }
    public int getModelo(){
        return modelo;
    }
    public String getMarca(){
        return marca;
    }
    public String getTipo(){
        return tipo;
    }
    public int getCapacidad(){
        return capacidad;
    }
}