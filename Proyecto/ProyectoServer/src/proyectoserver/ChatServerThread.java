/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author OSCAR HERRERA
 */
public class ChatServerThread extends Thread{
    private JTextArea taChat;
    private Pregunta[] preguntas;
    ArrayList<Pregunta> pgtasRefresh;
    private Socket          socket   = null;
    private Servidor    server   = null;
    private int             ID       = -1;
    private DataInputStream streamIn =  null;
    private DataOutputStream streamOu =  null;
    int v=0;
    boolean multi=true;
    
    public ChatServerThread(Servidor server, Socket socket, JTextArea taChat, Pregunta[] preguntas,ArrayList<Pregunta> pgtasRefresh){
       this.taChat=taChat;
       this.preguntas=preguntas;
       this.pgtasRefresh=pgtasRefresh;
       this.server = server;  this.socket = socket; 
       ID = socket.getPort();
    }
    public void run(){  
     taChat.append("Server Thread " + ID + " running.\n");
     int pgtaObtenida=0;
     String[] respuestas=new String[4];
     Pregunta pregunta=new Pregunta("","","",respuestas);
     while (true){
          try{
            String metodo=streamIn.readUTF();
            taChat.append("[s] lo que manda el cliente "+getName()+" : "+metodo+"\n");
            if(metodo.equals("refrescar")){
                streamOu.writeUTF(String.valueOf(pgtasRefresh.size()));
                for(int i=0;i<pgtasRefresh.size();i++){
                    streamOu.writeUTF(pgtasRefresh.get(i).getId());
                    streamOu.flush();
                }
            }
            else if(metodo.equals("obtener")){
                boolean isFound=false;
                String pregSelect=streamIn.readUTF();
                taChat.append("[s] lo que manda el cliente "+getName()+" : "+pregSelect+"\n");
                for(int i=0;i<pgtasRefresh.size();i++){
                    if(pregSelect.equals(pgtasRefresh.get(i).getId())&&pgtasRefresh.get(i).getDisponible()==0){
                        isFound=true;
                        streamOu.writeUTF("disponible");
                        streamOu.writeUTF(pgtasRefresh.get(i).getTitulo());
                        streamOu.writeUTF(pgtasRefresh.get(i).getTexto());
                        streamOu.flush();
                        for(int a=0;a<pgtasRefresh.get(i).getRespuestas().length;a++){
                            streamOu.writeUTF(pgtasRefresh.get(i).getRespuestas()[a]);
                            streamOu.flush();
                        }
                        pgtaObtenida=i;
                        pregunta=pgtasRefresh.get(i);
                        pgtasRefresh.remove(i);
                        i=pgtasRefresh.size();
                    }
                    else {
                        isFound=false;
                    }
                }
                if(isFound==false){
                    streamOu.writeUTF("ocupado");
                    streamOu.flush();
                }
            }
            else if(metodo.equals("cancelar")){
                pgtasRefresh.add(pgtaObtenida,pregunta);
            }
            else if(metodo.equals("enviar")){
                String pregSelect=streamIn.readUTF();
                taChat.append("[s] lo que manda el cliente "+getName()+" : "+pregSelect+"\n");
                String respuesta=streamIn.readUTF();
                taChat.append("[s] lo que manda el cliente "+getName()+" : "+respuesta+"\n");
                for(int i=0;i<preguntas.length;i++){
                    if(pregSelect.equals(preguntas[i].getId())&&preguntas[i].getCorrecta().equals(respuesta)){
                        taChat.append("*********calificando pregunta # "+pregSelect+" con respuesta '"+respuesta+"' respondida por el cliente: "+getName()+"*********\n");
                        taChat.append("*****************************************Respuesta Correcta******************************************\n\n");
                        streamOu.writeUTF("Respuesta Correcta");
                        streamOu.flush();
                        preguntas[i].setDisponible(2);
                        preguntas[i].setClient(getName());
                        preguntas[i].setIsCorrect(true);
                        i=preguntas.length;
                    }
                    else if(pregSelect.equals(preguntas[i].getId())&&!preguntas[i].getCorrecta().equals(respuesta)){
                        taChat.append("*********calificando pregunta # "+pregSelect+" con respuesta '"+respuesta+"' respondida por el cliente: "+getName()+"*********\n");
                        taChat.append("*****************************************Respuesta Incorrecta******************************************\n\n");
                        streamOu.writeUTF("Respuesta Incorrecta");
                        streamOu.flush();
                        preguntas[i].setDisponible(2);
                        preguntas[i].setClient(getName());
                        preguntas[i].setIsCorrect(false);
                        i=preguntas.length;
                    }
                }
            }
            /*
            if(multi){
                // mensaje multicast a clientes
                   String linea="[s] mensaje a todos los que estan conectados multicast!!!!"+v++;
                   //Creamos el buffer a enviar
                   byte [] buffer = linea.getBytes ();
                   //Pasamos los datos al datagrama
                   server.getDgp().setData (buffer);
                   //Establecemos la longitud
                   server.getDgp().setLength (buffer.length);
                   //Y por último enviamos:
                   server.getSmc().send (server.getDgp());
                   multi=false;
            }*/
          }
          catch(IOException ioe) {  
            // ioe.printStackTrace();
          }                 
      }
   }
    public void open() throws IOException{
       streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
       streamOu = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
       streamOu.flush();
    }
    public void close() throws IOException{
       if (socket != null)   
           socket.close();
       
       if (streamIn != null)  
           streamIn.close();
       
       if (streamOu!= null)  
           streamOu.close();
   }
   public DataOutputStream getStreamOu(){
       return streamOu;
   }
}