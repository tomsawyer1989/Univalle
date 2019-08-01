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
package punto2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jorge
 */
public class Ahorcado extends JFrame implements ActionListener{
    int fallidos;
    int acertados;
    int clicks;
    String wordPlay;
    Tema[] listTemas;
    char[] listaLetras;
    char[] letrasDig;
    Container contenedor;
    FlowLayout contFlow;
    JPanel panel1,panel2,panel3,panel4;
    JLabel jlTema,jlImagen,jlRepetida;
    JTextField tfWordPlay,tfEntrada;
    JButton[][] teclado;
    JButton jbSalir,jbAyuda,jbJugar,jbConfirmar;
    
    public Ahorcado(){
        listTemas=new Tema[5];
        Tema tema1=new Tema("Países");
        tema1.addWords("australia", "alemania", "colombia", "uruguay", "argentina", "paraguay", "italia", "inglaterra");
        Tema tema2=new Tema("Ciudades");
        tema2.addWords("berlin", "bogota", "paris", "montevideo", "barcelona", "medellin", "londres", "liverpool");
        Tema tema3=new Tema("Celebridades");
        tema3.addWords("shakira", "messi", "ronaldo", "schwarzenegger", "madonna", "juanes", "fonseca", "khalifa");
        Tema tema4=new Tema("Deportes");
        tema4.addWords("futbol", "tennis", "baloncesto", "golf", "rugby", "alpinismo", "natacion", "atletismo");
        Tema tema5=new Tema("Generos Musicales");
        tema5.addWords("jazz", "rock", "merengue", "vallenato", "blues", "reggae", "bachata", "techno");
        listTemas[0]=tema1;
        listTemas[1]=tema2;
        listTemas[2]=tema3;
        listTemas[3]=tema4;
        listTemas[4]=tema5;
        contenedor=getContentPane();
        contFlow=new FlowLayout();
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel4=new JPanel();
        jlTema=new JLabel("");
        tfWordPlay=new JTextField();
        tfEntrada=new JTextField(1);
        tfEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()!=e.VK_BACK_SPACE){
                    if(tfEntrada.getText().length()>0){
                        JOptionPane.showMessageDialog(null,"Ingrese solamente un caracter.","Error",0);
                        tfEntrada.setText("");
                    }
                }
            }          
        });
        jbConfirmar=new JButton("Aceptar");
        jbConfirmar.addActionListener(this);
        panel1.add(jlTema);
        panel1.add(tfWordPlay);
        panel1.add(tfEntrada);
        panel1.add(jbConfirmar);
        jlImagen=new JLabel("");
        jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado8.jpg")));
        jlRepetida=new JLabel("        ¡¡Bienvenido al juego de Ahorcado!!");
        panel2.add(jlRepetida);
        panel2.add(jlImagen);
        panel2.setLayout(new GridLayout(1,2,16,0));
        teclado=new JButton[3][9];
        for(int i=0;i<3;i++){
            for(int a=0;a<9;a++){
                teclado[i][a]=new JButton();
                teclado[i][a].addActionListener(this);
                panel3.add(teclado[i][a]);
            }
        }
        teclado[0][0].setLabel("a");
        teclado[0][1].setLabel("b");
        teclado[0][2].setLabel("c");
        teclado[0][3].setLabel("d");
        teclado[0][4].setLabel("e");
        teclado[0][5].setLabel("f");
        teclado[0][6].setLabel("g");
        teclado[0][7].setLabel("h");
        teclado[0][8].setLabel("i");
        teclado[1][0].setLabel("j");
        teclado[1][1].setLabel("k");
        teclado[1][2].setLabel("l");
        teclado[1][3].setLabel("m");
        teclado[1][4].setLabel("n");
        teclado[1][5].setLabel("ñ");
        teclado[1][6].setLabel("o");
        teclado[1][7].setLabel("p");
        teclado[1][8].setLabel("q");
        teclado[2][0].setLabel("r");
        teclado[2][1].setLabel("s");
        teclado[2][2].setLabel("t");
        teclado[2][3].setLabel("u");
        teclado[2][4].setLabel("v");
        teclado[2][5].setLabel("w");
        teclado[2][6].setLabel("x");
        teclado[2][7].setLabel("y");
        teclado[2][8].setLabel("z");
        panel3.setLayout(new GridLayout(3,9));
        jbJugar=new JButton("Jugar");
        jbJugar.addActionListener(this);
        jbAyuda=new JButton("Ayuda");
        jbAyuda.addActionListener(this);
        jbSalir=new JButton("Salir");
        jbSalir.addActionListener(this);
        panel4.add(jbJugar);
        panel4.add(jbAyuda);
        panel4.add(jbSalir);
        panel4.setLayout(new GridLayout(3,1));
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        contenedor.add(panel4);
        contenedor.setLayout(contFlow);
        panel1.setVisible(false);
        panel3.setVisible(false);
        jbSalir.setVisible(false);
    }
    public void bienvenida(){
        jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado8.jpg")));
        jbJugar.setLabel("Jugar");
        panel1.setVisible(false);
        jlRepetida.setText("        ¡¡Bienvenido al juego de Ahorcado!!");
        panel3.setVisible(false);
        jbSalir.setVisible(false);
    }
    public void iniciar(){
        jbJugar.setLabel("Reiniciar");
        jbSalir.setVisible(true);
        jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado1.jpg")));
        panel1.setVisible(true);
        panel3.setVisible(true);
        jlRepetida.setVisible(true);
        jlRepetida.setText("");
        fallidos=0;
        acertados=0;
        clicks=0;
        String guiones="";
        int tema=(int)(Math.random()*5);
        int palabra=(int)(Math.random()*8);
        wordPlay=listTemas[tema].listWords[palabra];
        jlTema.setText("Tema: "+listTemas[tema].getNombre()+", palabra de "+wordPlay.length()+" letras.");
        listaLetras=new char[wordPlay.length()];
        letrasDig=new char[wordPlay.length()+7];
        for(int i=0;i<listaLetras.length;i++){
            listaLetras[i]='_';
            guiones=guiones+"_ ";
        }
        for(int i=0;i<letrasDig.length;i++){
            letrasDig[i]='_';
        }
        tfWordPlay.setText(guiones);
    }
    public void comparar(char letra){
        boolean click=false;
        if(letrasDig[0]=='_'){
            clicks=clicks+1;
            letrasDig[0]=letra;
            jugar(letra);
        }
        else{
            for(int i=0;i<clicks;i++){
                if(letrasDig[i]==letra){
                    JOptionPane.showMessageDialog(null,"Ya has ingresado esa letra.","Error",0);
                    click=false;
                    i=clicks;
                }
                else{
                    click=true;
                }
            }
            if(click==true){
                clicks=clicks+1;
                letrasDig[clicks-1]=letra;
                jugar(letra);
            }
        }
    }
    public void jugar(char letra){
        int repetida=0;
        boolean fallo=true;
        fallidos=fallidos+1;
        String letraFound="";
        char caracteres[];
        caracteres=wordPlay.toCharArray();
        for(int i=0;i<caracteres.length;i++){
            if(letra==caracteres[i]){
                listaLetras[i]=letra;
                fallo=false;
                repetida=repetida+1;
                acertados=acertados+1;
            }
            letraFound=letraFound+listaLetras[i]+" ";
        }
        tfWordPlay.setText(letraFound);
        if(fallo==false){
            fallidos=fallidos-1;
        }
        if(repetida==0){
            String repetida0="            ("+letra+")"+" no está en la palabra. Tienes "+(7-fallidos)+" turnos.";
            jlRepetida.setText(repetida0);
        }
        else{
            String repetida0="            ("+letra+")"+" se encuentra "+repetida+" veces. Tienes "+(7-fallidos)+" turnos.";
            jlRepetida.setText(repetida0);
        }
        if(fallidos==1){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado2.jpg")));
        }
        if(fallidos==2){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado3.jpg")));
        }
        if(fallidos==3){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado4.jpg")));
        }
        if(fallidos==4){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado5.jpg")));
        }
        if(fallidos==5){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado6.jpg")));
        }
        if(fallidos==6){
            jlImagen.setIcon(new ImageIcon(getClass().getResource("ahorcado7.jpg")));
        }
        if(fallidos==7){
            JOptionPane.showMessageDialog(null, "Juego terminado, PERDISTE. La palabra era "+wordPlay);
            bienvenida();
        }
        if(acertados==wordPlay.length()){
            JOptionPane.showMessageDialog(null, "Juego terminado, ¡¡GANASTE!!.\nTurnos usados: "+fallidos+"\nTurnos restantes: "+(7-fallidos));
            bienvenida();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<3;i++){
            for(int a=0;a<9;a++){
                if(e.getSource()==teclado[i][a]){
                    comparar(teclado[i][a].getLabel().charAt(0));
                    teclado[i][a].setEnabled(false);
                }
            }
        }
        if(e.getSource()==jbConfirmar){
            try{
                comparar(tfEntrada.getText().charAt(0));
                for(int i=0;i<3;i++){
                    for(int a=0;a<9;a++){
                        if(tfEntrada.getText().equals(teclado[i][a].getLabel())){
                            teclado[i][a].setEnabled(false);
                        }
                    }
                }
            }
            catch (StringIndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null,"Ingrese un caracter.","Error",0);
            }
        }
        if(e.getSource()==jbJugar){
            iniciar();
            for(int i=0;i<3;i++){
                for(int a=0;a<9;a++){
                        teclado[i][a].setEnabled(true);
                }
            }
        }
        if(e.getSource()==jbAyuda){
            JOptionPane.showMessageDialog(null, "Bienvenido al juego de Ahorcado...\n\n"+
                "El juego es fácil de jugar, solo debes adivinar las letras de la palabra oculta, pero tienes\n"+
                "7 turnos para lograrlo.\n"+
                "Contiene 5 temas (Países, Ciudades, Celebridades, Deportes y Géneros Musicales) y\n"+
                "cada tema contiene 8 palabras, para un total de 40 palabras.");
        }
        if(e.getSource()==jbSalir){
            bienvenida();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ahorcado ahorcado=new Ahorcado();
        ahorcado.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ahorcado.setSize(540,452);
        ahorcado.setVisible(true);
    }    
}