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

package punto2GUI;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager.LookAndFeelInfo;


public class MatrizGUI extends JFrame implements ActionListener{

    int [][] miMatriz;
    
    Container contenedor;
    
    FlowLayout miFlow;
    JPanel  panel1, panel2, panel3, panel4, panel5;
    JLabel LMatriz1, LMatriz2, LMatrizResultado, LGuion;//etiquetas
    JTextField TF1A, TF2A, TF3A, TF4A, TF5A, TF6A, TF7A, TF8A, TF9A,
               TF1B, TF2B, TF3B, TF4B, TF5B, TF6B, TF7B, TF8B, TF9B,
               TF1C, TF2C, TF3C, TF4C, TF5C, TF6C, TF7C, TF8C, TF9C;//campos de texto
    JButton BGenerar, BImprimir, BSumar, BMultiplicar, BTranspuesta, BSalir;//botones
    //JTextArea miArea = new JTextArea(6,40);
    //JScrollPane miScroll = new JScrollPane(miArea);
    
    
    MatrizGUI(){
        LMatriz1 = new JLabel("Matriz N°1");
        LMatriz2 = new JLabel("Matriz N°2");
        LMatrizResultado = new JLabel("M. Resultante");
        LGuion = new JLabel("-");
        
        
        BGenerar = new JButton("Generar");
        BGenerar.addActionListener(this);
        BImprimir = new JButton("Imprimir");
        BImprimir.addActionListener(this);
        BSumar = new JButton("Sumar");
        BSumar.addActionListener(this);
        BMultiplicar = new JButton("Multiplicar");
        BMultiplicar.addActionListener(this);
        BTranspuesta = new JButton("Transpuesta");
        BTranspuesta.addActionListener(this);
        BSalir = new JButton("Salir");
        BTranspuesta.addActionListener(this);
        
        TF1A = new JTextField(2);
        TF2A = new JTextField(2);
        TF3A = new JTextField(2);
        TF4A = new JTextField(2);
        TF5A = new JTextField(2);
        TF6A = new JTextField(2);
        TF7A = new JTextField(2);
        TF8A = new JTextField(2);
        TF9A = new JTextField(2);
        
        TF1B = new JTextField(2);
        TF2B = new JTextField(2);
        TF3B = new JTextField(2);
        TF4B = new JTextField(2);
        TF5B = new JTextField(2);
        TF6B = new JTextField(2);
        TF7B = new JTextField(2);
        TF8B = new JTextField(2);
        TF9B = new JTextField(2);
        
        TF1C = new JTextField(2);
        TF2C = new JTextField(2);
        TF3C = new JTextField(2);
        TF4C = new JTextField(2);
        TF5C = new JTextField(2);
        TF6C = new JTextField(2);
        TF7C = new JTextField(2);
        TF8C = new JTextField(2);
        TF9C = new JTextField(2);
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,3));
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,3));
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,3));
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(3,3));
        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1,3));
        
        contenedor = getContentPane();
        miFlow = new FlowLayout();
        contenedor.setLayout(miFlow);
        
        
        panel1.add(BGenerar);
        panel1.add(BImprimir);
        panel1.add(BSumar);
        panel1.add(BMultiplicar);
        panel1.add(BTranspuesta);
        panel1.add(BSalir);
        
        panel2.add(TF1A);
        panel2.add(TF2A);
        panel2.add(TF3A);
        panel2.add(TF4A);
        panel2.add(TF5A);
        panel2.add(TF6A);
        panel2.add(TF7A);
        panel2.add(TF8A);
        panel2.add(TF9A);
        //panel2.add(LGuion);
        panel3.add(TF1B);
        panel3.add(TF2B);
        panel3.add(TF3B);
        panel3.add(TF4B);
        panel3.add(TF5B);
        panel3.add(TF6B);
        panel3.add(TF7B);
        panel3.add(TF8B);
        panel3.add(TF9B);
        
        panel4.add(TF1C);
        panel4.add(TF2C);
        panel4.add(TF3C);
        panel4.add(TF4C);
        panel4.add(TF5C);
        panel4.add(TF6C);
        panel4.add(TF7C);
        panel4.add(TF8C);
        panel4.add(TF9C);
        
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        contenedor.add(panel4);
    }
    
    
    //Constructor matriz aleatoria
    public MatrizGUI(int empty){
        miMatriz = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                miMatriz[i][j] = (int)(Math.random()*10);
            }
        }
    }
    
    //Constructor matriz base de ceros
    /*public MatrizGUI(int empty){
        miMatriz = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                miMatriz[i][j] = 0;
            }
        }
    }*/
    
    //Imprimir la matriz
    public String mostrar(){
        String matriz="";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matriz=matriz+miMatriz[i][j]+" "; 
            }
            matriz=matriz+"\n";
        }
        return matriz;
    }
    
    //Multiplicar las matrices aleatorias
    public String multiplicar(int[][]matriz2){
        int matriz0[][]=new int[3][3];
        int resultado=0;
        String matriz="";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                for(int k=0;k<3;k++){
                   resultado+= miMatriz[i][k] * matriz2[k][j];
                }
                matriz0[i][j]=resultado;
                matriz=matriz+matriz0[i][j]+" ";
                resultado=0;
            }
            matriz=matriz+"\n";
        }
        return matriz;
    }
    
    //Sumar las matrices aleatorias
    public String sumar(int[][]matriz2){
        int matriz0[][]=new int[3][3];
        String matriz="";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                   matriz0[i][j]+= miMatriz[i][j] + matriz2[i][j];
                   matriz=matriz+matriz0[i][j]+" ";
            }
            matriz=matriz+"\n";
        }
        return matriz;
    }
    
    //Calcular la matriz transpuesta
    public String transpuesta(){
        int matriz0[][]=new int[3][3];
        String matriz="";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                matriz0[i][j] = miMatriz[j][i];
                matriz=matriz+matriz0[i][j]+" ";
            }
            matriz=matriz+"\n";
        }
        return matriz;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==BGenerar)
		{ 
		  MatrizGUI matriz1 = new MatrizGUI(0);
                  //MatrizGUI matriz2=new MatrizGUI(0); 
		}
    }
    
    public static void main(String[] args) {
        //MatrizGUI matriz1 = new MatrizGUI(0);
        //MatrizGUI matriz2=new MatrizGUI(0);
        //matriz1.mostrar();
        //matriz2.mostrar();
        
        MatrizGUI miMatrizGUI = new MatrizGUI();
        miMatrizGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        miMatrizGUI.setSize(350,350);
        miMatrizGUI.setVisible(true);
    }
}