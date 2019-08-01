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
package punto4;


public class Auto {
    String tipo;
    String placa;
    long tiempoIng;
    long tiempoRet;
    
    //Constructor
    public Auto(String tipo,String placa){
        this.tipo=tipo;
        this.placa=placa;
    }
    public String getPlaca(){
        return placa;
    }
    public String getTipo(){
        return tipo;
    }
    public long getTiempoIng(){
        return tiempoIng;
    }
    public long getTiempoRet(){
        return tiempoRet;
    }
    public void setTiempoIng(long tiempoIng){
        this.tiempoIng=tiempoIng;
    }
    public void setTiempoRet(long tiempoRet){
        this.tiempoRet=tiempoRet;
    }
}
