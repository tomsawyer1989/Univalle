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

public class Tarjeta implements Serializable{
    int numero;
    int id;
    String nombre;
    String direccion;
    String fecha;
    int saldo;
    
    
    public Tarjeta(int numero,int id,String nombre,String direccion,String fecha,int saldo){
        this.numero=numero;
        this.id=id;
        this.nombre=nombre;
        this.direccion=direccion;
        this.fecha=fecha;
        this.saldo=saldo;
    }
    public int getNumero(){
        return numero;
    }
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getFecha(){
        return fecha;
    }
    public int getSaldo(){
        return saldo;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public void setSaldo(int saldo){
        this.saldo=saldo;
    }
    public void setSaldoR(int recarga){
        this.saldo=saldo+recarga;
    }
    public void setSaldoD(int nPasajes){
        int descontar=nPasajes*2000;
        this.saldo=saldo-descontar;
    }
}