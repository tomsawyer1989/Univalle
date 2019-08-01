/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoserver;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author OSCAR HERRERA
 */
public class Timer extends Thread{
    ArrayList<ChatServerThread> clientes;
    Pregunta[] preguntas;
    JTextField tfTiempo;
    int segundos;
    int minutos;
    
    public Timer(JTextField tfTiempo){
        clientes=new ArrayList();
        this.tfTiempo=tfTiempo;
        segundos=59;
        minutos=59;
    }
    @Override
    public void run(){
        while (true){
            try{
                int respondidas=0;
                for(int i=0;i<preguntas.length;i++){
                    if(preguntas[i].getDisponible()==2){
                        respondidas=respondidas+1;
                    }
                }
                if(segundos>0&&respondidas!=10){
                    segundos--;
                    for(int i=0;i<clientes.size();i++){
                        clientes.get(i).getStreamOu().writeInt(respondidas);
                        clientes.get(i).getStreamOu().writeInt(segundos);
                        clientes.get(i).getStreamOu().writeInt(minutos);
                        clientes.get(i).getStreamOu().flush();
                    }
                }
                else if((segundos==0&&minutos==0)||respondidas==10){
                    for(int i=0;i<clientes.size();i++){
                        clientes.get(i).getStreamOu().writeInt(respondidas);
                        clientes.get(i).getStreamOu().writeInt(segundos);
                        clientes.get(i).getStreamOu().writeInt(minutos);
                        clientes.get(i).getStreamOu().writeInt(preguntas.length);
                        for(int a=0;a<preguntas.length;a++){
                            clientes.get(i).getStreamOu().writeUTF(preguntas[a].getId());
                            clientes.get(i).getStreamOu().writeUTF(preguntas[a].getClient());
                            clientes.get(i).getStreamOu().writeBoolean(preguntas[a].getIsCorrect());
                            clientes.get(i).getStreamOu().flush();
                        }
                    }
                    break;
                }
                else{
                    segundos=59;
                    minutos--;
                    for(int i=0;i<clientes.size();i++){
                        clientes.get(i).getStreamOu().writeInt(respondidas);
                        clientes.get(i).getStreamOu().writeInt(segundos);
                        clientes.get(i).getStreamOu().writeInt(minutos);
                        clientes.get(i).getStreamOu().flush();
                    }
                }
                tfTiempo.setText(minutos+" : "+segundos);
                sleep(1000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void agregarClientes(ChatServerThread client){
        clientes.add(client);
    }
    public void setPreguntas(Pregunta[] preguntas){
        this.preguntas=preguntas;
    }
    public int getSegundos(){
        return segundos;
    }
    public int getMinutos(){
        return minutos;
    }
    public void setMinutos(int minutos){
        this.minutos=minutos;
    }
}