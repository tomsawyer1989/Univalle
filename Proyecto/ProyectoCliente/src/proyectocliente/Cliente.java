/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocliente;

import java.awt.Button;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author OSCAR HERRERA
 */
public class Cliente {
    private Socket socket              = null;
    private DataInputStream  streamIn  = null;
    private DataOutputStream streamOut = null;
    private JTextField tfTiempo;
    //para que el cliente reciba lo del multicast
    MulticastSocket smcR = null;
    InetAddress group = null;
    Thread escuchandoM;
    Thread timer;
    
    public Cliente(String serverName, int serverPort,JTextField tfTiempo) {
      this.tfTiempo=tfTiempo;
      System.out.println("Establishing connection. Please wait ...");
      try{  
         socket = new Socket(serverName, serverPort);
         System.out.println("Connected: " + socket);
         arrancar();
         iniciarEscuchaMulticast();
         timer = new Thread(){
            @Override
            public void run(){
                getTimer();
            }
         };
         timer.start();
      }
      catch(UnknownHostException uhe){  
          System.out.println("Host unknown: " + uhe.getMessage());
      }
      catch(IOException ioe){  
          System.out.println("Unexpected exception: " + ioe.getMessage());
      }
    }
    public void getTimer() {
        while (true){
            try{
                String resultado="";
                int respondidas=streamIn.readInt();
                int segundos=streamIn.readInt();
                int minutos=streamIn.readInt();
                if((segundos==0&&minutos==0)||respondidas==10){
                    int preguntas=streamIn.readInt();
                    System.out.println(preguntas);
                    for(int i=0;i<preguntas;i++){
                        String id=streamIn.readUTF();
                        String client=streamIn.readUTF();
                        boolean isCorrect=streamIn.readBoolean();
                        resultado=resultado+"Pregunta # "+id+" respondida por "+client+": "+isCorrect+"     \n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                    break;
                }
                tfTiempo.setText(minutos+" : "+segundos);
                sleep(1000);
            } 
            catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void iniciarEscuchaMulticast() throws IOException{
        //Creamos un socket multicast en el puerto 10000:
        smcR = new MulticastSocket (10000);
        //Configuramos el grupo (IP) a la que nos conectaremos
        group = InetAddress.getByName ("230.0.0.0");
        //Nos unimos al grupo:
        smcR.joinGroup (group);
    
        //lanzo el subproceso que va a estar escuchando al multicast
        escuchandoM = new Thread(){
            @Override
            public void run(){
                escuchandoMultiast();
            }
        };
        escuchandoM.start();           
    }
    public void escuchandoMultiast(){
       while(true){
            // Los paquetes enviados son de 256 bytes de maximo
            byte [] buffer = new byte [256];

            //Creamos el datagrama en el que recibiremos el paquete del socket multicast
            DatagramPacket dgp = new DatagramPacket (buffer, buffer.length);
            try{
                // Recibimos el paquete del socket:
                 smcR.receive (dgp);
                 // Adaptamos la información al tamaño de lo que se envió por si se envió menos de 256):
                 byte [] buffer2 = new byte [dgp.getLength ()];
                 // Copiamos los datos en el nuevo array de tamaño adecuado:
                 System.arraycopy (dgp.getData (),0,buffer2,0, dgp.getLength ());

                 //Vemos los datos recibidos por pantalla:
                 String salida = new String (buffer2);
                 System.out.println (salida);
                 System.out.print("Escuchando del server");
            }
            catch(IOException e){
                System.out.println("Error en el multicast al recibir en el cliente");
                e.printStackTrace();
            }
       }
    }
    /**
    * se abren los streams para comunicarse con el servior, y se toman los valores que se van a mandar
    * al servidor desde consola
    * @throws IOException 
    */
    public void arrancar() throws IOException{   
       streamIn   = new DataInputStream(socket.getInputStream());
       streamOut = new DataOutputStream(socket.getOutputStream());
    }
    public void parar(){  
        try{  
            if (streamOut != null)  streamOut.close();
            if (socket    != null)  socket.close();
        }
        catch(IOException ioe){  
            System.out.println("Error closing ...");
        }
    }
    public void refrescar(JComboBox cbPreguntas){
        int comboBoxSize=0;
        cbPreguntas.removeAllItems();
        try{
            streamOut.writeUTF("refrescar");
            comboBoxSize=Integer.parseInt(streamIn.readUTF());
            for(int i=0;i<comboBoxSize;i++){
                cbPreguntas.addItem(streamIn.readUTF());
            }
        }
        catch(IOException ioe){  
            System.out.println("Sending error: " + ioe.getMessage());
        }
    }
    public void obtenerPregServer(JComboBox cbPreguntas,JTextArea taChat,JLabel jlTitulo,JRadioButton rbRespuesta1,JRadioButton rbRespuesta2,JRadioButton rbRespuesta3,JRadioButton rbRespuesta4,Button jbObtener,Button jbEnviar,Button jbCancelar){
        String estado="";
        String pregSelect=cbPreguntas.getSelectedItem().toString();
        System.out.println(pregSelect);
        String titulo = "";
        String texto="";
        String respuesta1="";
        String respuesta2="";
        String respuesta3="";
        String respuesta4="";
        try{
            streamOut.writeUTF("obtener");
            streamOut.writeUTF(pregSelect);
            streamOut.flush();
                                  
            //imprime lo que manda el server
            estado=streamIn.readUTF();
            if(estado.equals("disponible")){
                titulo = streamIn.readUTF();
                texto=streamIn.readUTF();
                respuesta1=streamIn.readUTF();
                respuesta2=streamIn.readUTF();
                respuesta3=streamIn.readUTF();
                respuesta4=streamIn.readUTF();
                jlTitulo.setText(titulo);
                taChat.setText(texto);
                rbRespuesta1.setText(respuesta1);
                rbRespuesta2.setText(respuesta2);
                rbRespuesta3.setText(respuesta3);
                rbRespuesta4.setText(respuesta4);
            }
            else{
                JOptionPane.showMessageDialog(null, "El estado de la pregunta es: "+estado);
                cbPreguntas.setEnabled(true);
                jbObtener.setEnabled(true);
                jbEnviar.setEnabled(false);
                jbCancelar.setEnabled(false);
                jlTitulo.setText("");
                taChat.setText("");
                rbRespuesta1.setLabel("A.");
                rbRespuesta2.setLabel("B.");
                rbRespuesta3.setLabel("C.");
                rbRespuesta4.setLabel("D.");
            }
        }
        catch(IOException ioe){  
            System.out.println("Sending error: " + ioe.getMessage());
        }
    }
    public void cancelarPregServer(){
        try{
            streamOut.writeUTF("cancelar");
            streamOut.flush();
        }
        catch(IOException ioe){  
            System.out.println("Sending error: " + ioe.getMessage());
        }
    }
    public void enviarRespServer(JComboBox cbPreguntas,JRadioButton rbRespuesta1,JRadioButton rbRespuesta2,JRadioButton rbRespuesta3,JRadioButton rbRespuesta4){
        String pregSelect=cbPreguntas.getSelectedItem().toString();
        String respuesta;
        String isCorrect;
        if(rbRespuesta1.isSelected()){
            respuesta=rbRespuesta1.getText();
        }
        else if(rbRespuesta2.isSelected()){
            respuesta=rbRespuesta2.getText();
        }
        else if(rbRespuesta3.isSelected()){
            respuesta=rbRespuesta3.getText();
        }
        else if(rbRespuesta4.isSelected()){
            respuesta=rbRespuesta4.getText();
        }
        else{
            respuesta="";
        }
        try{
            streamOut.writeUTF("enviar");
            streamOut.writeUTF(pregSelect);
            streamOut.writeUTF(respuesta);
            streamOut.flush();
            isCorrect=streamIn.readUTF();
            JOptionPane.showMessageDialog(null, isCorrect);
        }
        catch(IOException ioe){  
            System.out.println("Sending error: " + ioe.getMessage());
        }
    }
}