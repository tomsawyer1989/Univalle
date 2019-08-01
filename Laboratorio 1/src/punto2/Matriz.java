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

import javax.swing.JOptionPane;
/**
 *
 * @author Jorge
 */
public class Matriz {
    int [][] miMatriz;
    
    //Constructor matriz aleatoria
    public Matriz(){
        miMatriz = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                miMatriz[i][j] = (int)(Math.random()*10);
            }
        }
    }
    
    //Constructor matriz base de ceros
    public Matriz(int empty){
        miMatriz = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                miMatriz[i][j] = 0;
            }
        }
    }
    
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
    
    
    public static void main(String[] args) {
        Matriz matriz1 = new Matriz(0);
        Matriz matriz2=new Matriz(0);
        int menu;
        do{
            menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una opción:\n1-Generar matrices.\n2-Imprimir matrices.\n3-Multiplicar.\n"+
                    "4-Sumar.\n5-Calcular transpuesta.\n6-Salir."));
            switch(menu){
                case 1: 
                    matriz1 = new Matriz();
                    matriz2=new Matriz();
                break;
                case 2: 
                    JOptionPane.showMessageDialog(null,matriz1.mostrar());
                    JOptionPane.showMessageDialog(null,matriz2.mostrar());
                break;
                case 3: 
                    JOptionPane.showMessageDialog(null,matriz1.multiplicar(matriz2.miMatriz));
                break;
                case 4:
                    JOptionPane.showMessageDialog(null,matriz1.sumar(matriz2.miMatriz));
                break;
                case 5:
                    JOptionPane.showMessageDialog(null,matriz1.transpuesta());
                break;
                case 6:
                break;
                default: 
                        JOptionPane.showMessageDialog(null,"Ingrese una opción correcta.");
                break;
            }  
        }
        while(menu!=6);
    }
}
