/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoserver;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author jhone
 */
public class Servidor extends Thread implements Serializable{
    Timer tiempo;
    Pregunta[] preguntas;
    ArrayList<Pregunta> pgtasRefresh;
    JTextArea taChat;
    private ServerSocket     server = null;
    private ChatServerThread client = null;
    
    //para multicast
    //Creamos el MulticastSocket sin especificar puerto.
    private MulticastSocket smc=null;
    // Creamos un datagrama vacío en principio:
    byte [] vacio = new byte [0];
    private DatagramPacket dgp =null;
    
    public Servidor(int port,JTextArea taChat,Timer tiempo){
        this.tiempo=tiempo;
        preguntas=new Pregunta[10];
        pgtasRefresh=new ArrayList();
        this.taChat=taChat;
        try{
            taChat.append("Binding to port " + port + ", please wait  ...\n");
            server = new ServerSocket(port);
            taChat.append("Server started: " + server+"\n");
            iniciarMulticast();
            start();
        }
        catch(IOException ioe){
            taChat.append(ioe+"\n");
        }
        
        String[] respuestas1=new String[4];
        respuestas1[0]="10";
        respuestas1[1]="11";
        respuestas1[2]="7";
        respuestas1[3]="Ninguna de las anteriores";
        Pregunta pregunta1=new Pregunta("01","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas1);
        pregunta1.setCorrecta("10");
        preguntas[0]=pregunta1;
        
        String[] respuestas2=new String[4];
        respuestas2[0]="10";
        respuestas2[1]="11";
        respuestas2[2]="7";
        respuestas2[3]="Ninguna de las anteriores";
        Pregunta pregunta2=new Pregunta("02","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas2);
        pregunta2.setCorrecta("7");
        preguntas[1]=pregunta2;
        
        String[] respuestas3=new String[4];
        respuestas3[0]="10";
        respuestas3[1]="11";
        respuestas3[2]="7";
        respuestas3[3]="Ninguna de las anteriores";
        Pregunta pregunta3=new Pregunta("03","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas3);
        pregunta3.setCorrecta("10");
        preguntas[2]=pregunta3;
        
        String[] respuestas4=new String[4];
        respuestas4[0]="10";
        respuestas4[1]="11";
        respuestas4[2]="7";
        respuestas4[3]="Ninguna de las anteriores";
        Pregunta pregunta4=new Pregunta("04","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas4);
        pregunta4.setCorrecta("10");
        preguntas[3]=pregunta4;
        
        String[] respuestas5=new String[4];
        respuestas5[0]="10";
        respuestas5[1]="11";
        respuestas5[2]="7";
        respuestas5[3]="Ninguna de las anteriores";
        Pregunta pregunta5=new Pregunta("05","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas5);
        pregunta5.setCorrecta("10");
        preguntas[4]=pregunta5;
        
        String[] respuestas6=new String[4];
        respuestas6[0]="10";
        respuestas6[1]="11";
        respuestas6[2]="7";
        respuestas6[3]="Ninguna de las anteriores";
        Pregunta pregunta6=new Pregunta("06","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas6);
        pregunta6.setCorrecta("10");
        preguntas[5]=pregunta6;
        
        String[] respuestas7=new String[4];
        respuestas7[0]="10";
        respuestas7[1]="11";
        respuestas7[2]="7";
        respuestas7[3]="Ninguna de las anteriores";
        Pregunta pregunta7=new Pregunta("07","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas7);
        pregunta7.setCorrecta("10");
        preguntas[6]=pregunta7;
        
        String[] respuestas8=new String[4];
        respuestas8[0]="10";
        respuestas8[1]="11";
        respuestas8[2]="7";
        respuestas8[3]="Ninguna de las anteriores";
        Pregunta pregunta8=new Pregunta("08","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas8);
        pregunta8.setCorrecta("10");
        preguntas[7]=pregunta8;
        
        String[] respuestas9=new String[4];
        respuestas9[0]="10";
        respuestas9[1]="11";
        respuestas9[2]="7";
        respuestas9[3]="Ninguna de las anteriores";
        Pregunta pregunta9=new Pregunta("09","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas9);
        pregunta9.setCorrecta("10");
        preguntas[8]=pregunta9;
        
        String[] respuestas10=new String[4];
        respuestas10[0]="10";
        respuestas10[1]="11";
        respuestas10[2]="7";
        respuestas10[3]="Ninguna de las anteriores";
        Pregunta pregunta10=new Pregunta("10","¿Cual es la salida del programa?","public class Foo{"
                + "\n\tpublic static void main(String args[]){"
                + "\n\t\tint contador=0;"
                + "\n\t\tfor(int i=0;i<10;i++){"
                + "\n\t\t\tcontador=contador+1;"
                + "\n\t\t}"
                + "\n\t\tSystem.out.println(contador);"
                + "\n\t}"
                + "\n}",respuestas10);
        pregunta10.setCorrecta("10");
        preguntas[9]=pregunta10;
        for(int i=0;i<preguntas.length;i++){
            pgtasRefresh.add(preguntas[i]);
        }
    }
    public void run(){
      while (true) {
        try{
              taChat.append("Waiting for a client ...\n");
              client = new ChatServerThread(this,server.accept(),taChat,preguntas,pgtasRefresh);
              taChat.append("Client accepted: " + client.getName()+"\n");
              try{
                   client.open();
                   client.start();
              }
              catch(IOException ioe){
                    taChat.append("Error opening thread: " + ioe+"\n");
              }
              tiempo.agregarClientes(client);
        }
        catch(IOException ie){
            taChat.append("Acceptance Error: " + ie+"\n");
        }
      }
    }
    public void iniciarMulticast() throws IOException{
        smc = new MulticastSocket ();
        // Creamos el grupo multicast:
        InetAddress group = InetAddress.getByName ("230.0.0.0");
    
        dgp = new DatagramPacket(vacio, 0, group,10000);
    }
    public MulticastSocket getSmc() {
        return smc;
    }

    public DatagramPacket getDgp() {
        return dgp;
    }
    public Pregunta[] getPreguntas(){
        return preguntas;
    }
    public void setPreguntas(Pregunta[] preguntas){
        this.preguntas=preguntas;
        for(int i=0;i<preguntas.length;i++){
            pgtasRefresh.add(preguntas[i]);
        }
    }
}