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

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Parqueadero {
    Auto[][] parking;
    int ingresados;
    int retirados;
    ArrayList<Integer> tarifaList;
    
    //Constructor
    public Parqueadero(){
        parking=new Auto[6][6];
        ingresados=0;
        retirados=0;
        tarifaList=new ArrayList();
    }
    
    //Ingresar auto
    public void ingresar(){
        String tipo=JOptionPane.showInputDialog(null,"Digite el tipo de automovil que desea ingresar:\n"
                + "-pequeño\n-monovolumen\n-furgon\n-pickup");
        boolean isFree=true;
        for(int i=0;i<6;i++){
            for(int a=0;a<6;a++){
                if(parking[i][a]==null){
                    if(tipo.equals("pequeño")||tipo.equals("monovolumen")){
                        if(i>=1){
                            String placa=JOptionPane.showInputDialog(null,"Digite la placa del automovil que desea ingresar: ");
                            Auto auto=new Auto(tipo,placa);
                            long tiempoIng=System.currentTimeMillis();
                            auto.setTiempoIng(tiempoIng);
                            parking[i][a]=auto;
                            ingresados=ingresados+1;
                            a=6;
                            i=6;
                            isFree=true;
                        }
                    }
                    else if(tipo.equals("furgon")||tipo.equals("pickup")){
                        if(i<1){
                            String placa=JOptionPane.showInputDialog(null,"Digite la placa del automovil que desea ingresar: ");
                            Auto auto=new Auto(tipo,placa);
                            long tiempoIng=System.currentTimeMillis();
                            auto.setTiempoIng(tiempoIng);
                            parking[i][a]=auto;
                            ingresados=ingresados+1;
                            a=6;
                            i=6;
                            isFree=true;
                        }
                        else{
                            isFree=false;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Ingrese un tipo de automóvil válido.");
                        a=6;
                        i=6;
                    }
                }
                else{
                    isFree=false; 
                }
            }
        }
        if(isFree==false){
            JOptionPane.showMessageDialog(null,"No hay espacio libre en el parqueadero para su tipo de vehículo.");
        }
    }
    
    //Consultar si un auto esta en el parqueadero y retirar auto 
    public void consultar(boolean retirar){
        String placa=JOptionPane.showInputDialog(null,"Digite la placa del automovil que desea consultar: ");
        int contador=0;
        boolean isFound=false;
        for(int i=0;i<6;i++){
            for(int a=0;a<6;a++){
                contador=contador+1;
                if(parking[i][a]==null){
                }
                else{
                    if(parking[i][a].getPlaca().equals(placa)){
                        JOptionPane.showMessageDialog(null,"El auto se encuentra parqueado en el puesto # "+contador);
                        isFound=true;
                        if(retirar==true){
                            int tarifa=0;
                            long tiempoRet=System.currentTimeMillis();
                            parking[i][a].setTiempoRet(tiempoRet);
                            String duracion0=Long.toString((parking[i][a].getTiempoRet()-parking[i][a].getTiempoIng())/1000);
                            int duracion=Integer.parseInt(duracion0);
                            if(duracion<=7200){
                                tarifa=1500;
                                tarifaList.add(tarifa);
                            }
                            else{
                                tarifa=1500+1000*((duracion-7200)/3600);
                            }
                            JOptionPane.showMessageDialog(null,"Duración: "+duracion+" segundos.\nValor: "+tarifa);
                            parking[i][a]=null;
                            retirados=retirados+1;
                            JOptionPane.showMessageDialog(null,"Auto retirado del parqueadero con éxito.");
                        }
                        a=6;
                        i=6;
                }
                    else{
                        isFound=false;
                    }
                } 
            }
        }
        if(isFound==false){
            JOptionPane.showMessageDialog(null,"El auto no se encuentra en el parqueadero. Asegúrese de haber digitado bien la placa.");
        }
    }
    
    //Visualizar el parqueadero en forma de matriz
    public void showParking(){
        int contador=0;
        String lista="";
        for(int i=0;i<6;i++){
            for(int a=0;a<6;a++){
                contador=contador+1;
                if(parking[i][a]==null){
                    if(contador<10){
                        lista=lista+"0"+contador+"|                        ";
                    
                    }
                    else{
                        lista=lista+contador+"|                        "; 
                    }
                }
                else{
                    if(contador<10){
                        lista=lista+"0"+contador+"|";
                    
                    }
                    else{
                        lista=lista+contador+"|"; 
                    }
                    lista=lista+parking[i][a].getPlaca()+"        ";
                }
            }
            lista=lista+"\n\n";
        }
        JOptionPane.showMessageDialog(null,lista,"Parqueadero",1);
    }
    
    //Arqueo de caja
    public void arqueo(){
        int parqueados=0;
        for(int i=0;i<6;i++){
            for(int a=0;a<6;a++){
                if(parking[i][a]==null){  
                }
                else{
                    parqueados=parqueados+1;
                }
            }
        }
        int total=0;
        for(int i=0;i<tarifaList.size();i++){
            total=total+tarifaList.get(i);
        }
        JOptionPane.showMessageDialog(null,"Ingresados: "+ingresados+"\nRetirados: "+retirados+"\nParqueados: "+parqueados+"\nTotal: $"+total);
    }
    
    
    public static void main(String[] args){
        Parqueadero parqueadero=new Parqueadero();
        int menu;
        do{
            menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una opción:\n1-Ingresar auto.\n2-Consultar auto.\n3-Visualizar parqueadero.\n"+
                    "4-Retirar auto.\n5-Arquedo de caja.\n6-salir."));
            switch(menu){
                case 1: 
                    parqueadero.ingresar();
                break;
                case 2:
                    parqueadero.consultar(false);
                break;
                case 3: 
                    parqueadero.showParking();
                break;
                case 4:
                    parqueadero.consultar(true);
                break;
                case 5:
                    parqueadero.arqueo();
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
