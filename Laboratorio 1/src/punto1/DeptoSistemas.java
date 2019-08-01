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
package punto1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DeptoSistemas {
    ArrayList<Sala> listaSalas=new ArrayList();
    
    //constructor
    public DeptoSistemas(int cantidadSalas){
        for(int i=0;i<cantidadSalas;i++){
             Sala sala=new Sala(30);
             listaSalas.add(sala);
         }
    }
    
    //Asignar un turno
    public void asignar(int numSala,int numComputador){
        int hora=listaSalas.get(numSala-1).hora;
        if(hora>=12||hora<=2){
            if(listaSalas.get(numSala-1).listaComputadores.get(numComputador-1).getEstado().equals("L")){
                listaSalas.get(numSala-1).listaComputadores.get(numComputador-1).setEstado("O");
            }
            else{
                JOptionPane.showMessageDialog(null,"El computador se encuentra ocupado. No se puede hacer la reserva.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Sala cerrada, no se puede asignar turno. Horario de atención de 12pm a 2pm");
        }
    }
    
    //Cancelar un turno
    public void cancelar(int numSala,int numComputador){
        if(listaSalas.get(numSala-1).listaComputadores.get(numComputador-1).getEstado().equals("L")){
            JOptionPane.showMessageDialog(null,"El turno ya se encuentra libre, no es necesario cancelarlo.");
        }
        else{ 
            listaSalas.get(numSala-1).listaComputadores.get(numComputador-1).setEstado("L");
        }
    }
    
    //Consultar computadores disponibles
    public String disponibles(){
        String lista="";
        int libre=0;
        for(int i=0;i<listaSalas.size();i++){
            lista=lista+"Sala "+(i+1)+" Pc# ";
            for(int a=0;a<listaSalas.get(i).listaComputadores.size();a++){
                lista=lista+" "+(a+1)+" "+listaSalas.get(i).listaComputadores.get(a).getEstado()+" ";
                if(listaSalas.get(i).listaComputadores.get(a).getEstado().equals("L")){
                    libre=libre+1;
                }
            }
            lista=lista+" Diponibles: "+libre+"\n";
            libre=0;
        }
        return lista;
    }
    
    //Consultar computadores ocupados
    public String asignados(){
        String lista="";
        int asignado=0;
        int totalAsignado=0;
        for(int i=0;i<listaSalas.size();i++){
            lista=lista+"Sala "+(i+1)+" Pc# ";
            for(int a=0;a<listaSalas.get(i).listaComputadores.size();a++){
                lista=lista+" "+(a+1)+" "+listaSalas.get(i).listaComputadores.get(a).getEstado()+" ";
                if(listaSalas.get(i).listaComputadores.get(a).getEstado().equals("O")){
                    asignado=asignado+1;
                    totalAsignado=totalAsignado+1;
                }
            }
            lista=lista+" Asignados: "+asignado+"\n";
            asignado=0;
        }
        lista=lista+"Total Asignados: "+totalAsignado;
        return lista;
    }
    
    
    public static void main(String[] args) {
        DeptoSistemas deptoSistemas=new DeptoSistemas(3);
        int menu;
        do{
            menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una opción:\n1-Asignar turno.\n2-Cancelar turno.\n3-Equipos disponibles.\n"+
                    "4-Equipos asignados.\n5-Salir."));
            switch(menu){
                case 1: 
                    int numSala=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número de la Sala."));
                    int numComputador=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número del computador."));  
                    deptoSistemas.asignar(numSala, numComputador);
                break;
                case 2: 
                    numSala=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número de la Sala."));
                    numComputador=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número del computador."));  
                    deptoSistemas.cancelar(numSala, numComputador);
                break;
                case 3: 
                    JOptionPane.showMessageDialog(null,deptoSistemas.disponibles());
                break;
                case 4:
                    JOptionPane.showMessageDialog(null,deptoSistemas.asignados());
                break;
                case 5:
                break;
                default: 
                        JOptionPane.showMessageDialog(null,"Ingrese una opción correcta.");
                break;
            }  
        }
        while(menu!=5);
    }
}
