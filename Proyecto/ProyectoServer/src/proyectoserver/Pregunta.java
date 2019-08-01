/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoserver;

import java.io.Serializable;

/**
 *
 * @author jhone
 */
public class Pregunta implements Serializable{
    String id;
    String titulo;
    String texto;
    int disponible;
    String[] respuestas;
    String correcta;
    String client;
    boolean isCorrect;
    
    public Pregunta (String id,String titulo,String texto,String[] respuestas){
        disponible=0;
        this.id=id;
        this.titulo=titulo;
        this.texto=texto;
        this.respuestas=respuestas;
    }
    public String getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getTexto(){
        return texto;
    }
    public int getDisponible(){
        return disponible;
    }
     public String[] getRespuestas(){
        return respuestas;
    }
    public String getCorrecta(){
        return correcta;
    }
    public String getClient(){
        return client;
    }
    public boolean getIsCorrect(){
        return isCorrect;
    }
    public void setDisponible(int disponible){
        this.disponible=disponible;
    }
    public void setCorrecta(String correcta){
        this.correcta=correcta;
    }
    public void setClient(String client){
        this.client=client;
    }
    public void setIsCorrect(boolean isCorrect){
        this.isCorrect=isCorrect;
    }
}