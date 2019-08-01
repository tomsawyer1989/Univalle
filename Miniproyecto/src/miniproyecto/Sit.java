/**
 ESTUDIANTE N°1:
 *  Nombre: Jorge Leonardo Herrera
 *  Codigo: 1628189
 *  Email: herrera.jorge@correounivalle.edu.co
 *
 * ESTUDIANTE N°2:
 *  Nombre: Jhon Edwin Saa
 *  Codigo: 1630907
 *  Email: jhon.saa@correounivalle.edu.co
 */
package miniproyecto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Sit implements Serializable{
    ArrayList<Ruta> rutas;
    ArrayList<Bus> buses;
    ArrayList<Tarjeta> tarjetas;
    ArrayList<String> fechasR;
    ArrayList<Integer> recargas;
    ArrayList<String> fechasD;
    ArrayList<Integer> pasajes;
    
    public Sit(){
        rutas=new ArrayList();
        buses=new ArrayList();
        tarjetas=new ArrayList();
        fechasR=new ArrayList();
        recargas=new ArrayList();
        fechasD=new ArrayList();
        pasajes=new ArrayList();
    }
    public void addRuta(int codigo,String nombre,String descripcion,String tipo){
        boolean existeR=false;
        for(int i=0; i<rutas.size(); i++){
            if(rutas.get(i).getNombre().equals(nombre) || rutas.get(i).getCodigo()==codigo){
                existeR=true;
                i=rutas.size();
            }
        }
        if(existeR==false){
            Ruta ruta=new Ruta(codigo,nombre,descripcion,tipo);
            rutas.add(ruta); 
            JOptionPane.showMessageDialog(null,"Ruta añadida con exito");
        }
        if(existeR==true){
            JOptionPane.showMessageDialog(null,"La ruta ya existe");
        }
    }
    public void addBus(String placa,int modelo,String marca,String tipo,int capacidad){
        boolean existeB=false;
        for(int i=0; i<buses.size(); i++){
            if(buses.get(i).getPlaca().equals(placa)){
                existeB=true;
                i=buses.size();
            }
        }
        if(existeB==false){
            Bus bus=new Bus(placa,modelo,marca,tipo,capacidad);
            buses.add(bus);  
            JOptionPane.showMessageDialog(null,"Bus añadido con exito");
        }
        if(existeB==true){
            JOptionPane.showMessageDialog(null,"El bus ya existe");
        }
        
    }
    public void addTarjeta(int numero,int id,String nombre,String direccion,String fecha,int saldo){
        boolean existeT=false;
        
        for(int i=0; i<tarjetas.size(); i++){
            if(tarjetas.get(i).getNumero()==numero){
                existeT=true;
                i=tarjetas.size();
            }
        }
        if(existeT==false){
           
            Tarjeta tarjeta=new Tarjeta(numero,id,nombre,direccion,fecha,saldo);
            tarjetas.add(tarjeta);  
            JOptionPane.showMessageDialog(null,"Tarjeta añadida con exito");
        }
        if(existeT==true){
            JOptionPane.showMessageDialog(null,"La tarjeta ya existe");
        }
    }
    public void addBusRuta(String placa,String Ruta){
        Bus bus=new Bus("",0,"","",0);
        boolean isFoundB=false;
        boolean isFoundR=false;
        boolean asignadoB=false;
        for(int i=0;i<buses.size();i++){
            if(buses.get(i).getPlaca().equals(placa)){
                bus=buses.get(i);
                isFoundB=true;
                i=buses.size();
            }
            else{
                isFoundB=false; 
            }
        }
        for(int i=0;i<rutas.size();i++){
            if(rutas.get(i).getNombre().equals(Ruta)){
                    isFoundR=true;
                    i=rutas.size();
            }
        }
        for(int i=0;i<rutas.size();i++){
            for(int a=0; a<rutas.get(i).getBuses().size(); a++){
                if(rutas.get(i).getBuses().get(a).getPlaca().equals(placa)){
                    asignadoB=true;
                    a=rutas.get(i).getBuses().size();
                }
            }
        }
        
        for(int i=0;i<rutas.size();i++){
                if(isFoundR==true && asignadoB==false){
                    rutas.get(i).getBuses().add(bus);
                    i=rutas.size();
                    JOptionPane.showMessageDialog(null,"Bus asignado a la ruta con exito");
                }
                    
            
        }
        if(isFoundB==false){
            JOptionPane.showMessageDialog(null,"El bus no existe.");
        }
        if(isFoundR==false){
            JOptionPane.showMessageDialog(null,"La ruta no existe.");
        }
        if(asignadoB==true){
            JOptionPane.showMessageDialog(null,"El bus ya ha sido asignado anteriormente");
        }
        
    }
    public String consultarB(String bus){
        String texto="";
        boolean isFoundB=false;
        for(int i=0;i<rutas.size();i++){
            for(int a=0;a<rutas.get(i).getBuses().size();a++){
                if(bus.equals(rutas.get(i).getBuses().get(a).getPlaca())){
                    texto=texto+rutas.get(i).getBuses().get(a).getPlaca()+" "+rutas.get(i).getBuses().get(a).getModelo()+" "+
                          rutas.get(i).getBuses().get(a).getMarca()+" "+rutas.get(i).getBuses().get(a).getTipo()+" "+
                          rutas.get(i).getBuses().get(a).getCapacidad()+" Ruta: "+rutas.get(i).getNombre()+"\n";
                    isFoundB=true;
                    a=rutas.get(i).getBuses().size();
                }
            }
            if(isFoundB==true){
                i=rutas.size();
            }
        }
        if(isFoundB==false){
            for(int i=0;i<buses.size();i++){
                if(bus.equals(buses.get(i).getPlaca())){
                    texto=texto+buses.get(i).getPlaca()+" "+buses.get(i).getModelo()+" "+buses.get(i).getMarca()+" "+
                          buses.get(i).getTipo()+" "+buses.get(i).getCapacidad()+" Ruta: Sin asignar\n";
                } 
            }
        }
        return texto;
    }
    public String consultarR(String ruta){
        String texto="";
        for(int i=0;i<rutas.size();i++){
            if(ruta.equals(rutas.get(i).getNombre())){
                texto=texto+rutas.get(i).getCodigo()+" "+rutas.get(i).getNombre()+" "+rutas.get(i).getDescripcion()+" "+
                      rutas.get(i).getTipo()+"\nBuses:\n";
                for(int a=0;a<rutas.get(i).getBuses().size();a++){
                    texto=texto+rutas.get(i).getBuses().get(a).getPlaca()+" "+rutas.get(i).getBuses().get(a).getModelo()+" "+
                          rutas.get(i).getBuses().get(a).getMarca()+" "+rutas.get(i).getBuses().get(a).getTipo()+" "+
                          rutas.get(i).getBuses().get(a).getCapacidad()+"\n";
                } 
            }
        }
        return texto;
    }
    public String consultarT(int tarjeta){
        String texto="";
        for(int i=0; i<tarjetas.size(); i++){
            if(tarjeta==tarjetas.get(i).getNumero()){
                texto=texto+"Numero: "+tarjetas.get(i).getNumero()+
                            " \nId: "+ Integer.toString(tarjetas.get(i).getId())+
                            " \nNombre: "+tarjetas.get(i).getNombre()+
                            " \nDireccion: "+tarjetas.get(i).getDireccion()+
                            " \nFecha: "+ tarjetas.get(i).getFecha()+
                            " \nSaldo: "+Integer.toString(tarjetas.get(i).getSaldo())+"\n\n";
            }
        }
        return texto;
    }
    public void recargarT(int tarjeta, int recarga, String fechaR){
        boolean existeT=false;
        if(recarga>=2000 && recarga<=50000){
            for(int i=0; i<tarjetas.size(); i++){
                if(tarjeta==tarjetas.get(i).getNumero() && recarga>=2000 && recarga<=50000){
                    tarjetas.get(i).setSaldoR(recarga);
                    fechasR.add(fechaR);
                    recargas.add(recarga);
                    existeT=true;
                    i=tarjetas.size();
                    JOptionPane.showMessageDialog(null,"Tarjeta recargada con exito!");
                }
            }
            if(existeT==false){
                JOptionPane.showMessageDialog(null,"La tarjeta no existe");
            }
        }    
        else{
            JOptionPane.showMessageDialog(null,"ingresar un valor de la recarga entre $2.000 y $50.000");
        }
    }
    public void descontarToriginal(int tarjeta,int nPasajes,String fechaD){
        for(int i=0; i<tarjetas.size(); i++){
            if(tarjeta==tarjetas.get(i).getNumero()){
                tarjetas.get(i).setSaldoD(nPasajes);
                fechasD.add(fechaD);
                pasajes.add(nPasajes);
                i=tarjetas.size();
            }
        }
    }
    public void descontarT(int tarjeta,int nPasajes,String fechaD){
        boolean existeT=false;
        
        for(int i=0; i<tarjetas.size(); i++){
            if(tarjeta==tarjetas.get(i).getNumero()){
                existeT=true;
                if(nPasajes>0 && nPasajes*2000<=tarjetas.get(i).getSaldo()){
                    tarjetas.get(i).setSaldoD(nPasajes);
                    fechasD.add(fechaD);
                    pasajes.add(nPasajes);
                    i=tarjetas.size();
                    JOptionPane.showMessageDialog(null,"Pasaje descontado con exito!");
                }
                else{
                    if(nPasajes<0){
                        JOptionPane.showMessageDialog(null,"Ingrese un numero valido de pasajes");
                    }
                    if(nPasajes*2000>tarjetas.get(i).getSaldo()){
                        JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                    }
                }
            }
        }
        if(existeT==false){
            JOptionPane.showMessageDialog(null,"La tarjeta no existe.");
        }
    }
    public String listarT(){
        int c=0;
        String texto="";
        for(int i=0; i<tarjetas.size(); i++){
            c=c+1;
            texto=texto+"Tarjeta N°"+c+
                    "\nNumero: "+tarjetas.get(i).getNumero()+
                    "\nId: "+ Integer.toString(tarjetas.get(i).getId())+
                    "\nNombre: "+tarjetas.get(i).getNombre()+
                    "\nDireccion: "+tarjetas.get(i).getDireccion()+
                    "\nFecha: "+ tarjetas.get(i).getFecha()+
                    "\nSaldo: "+Integer.toString(tarjetas.get(i).getSaldo())+"\n\n";
        }
        return texto;
    }
    public String listarB(){
        int c=0;
        String texto="";
        for(int i=0; i<buses.size(); i++){
            c=c+1;
            texto=texto+"Bus N°"+c+
                    "\nPlaca: "+buses.get(i).getPlaca()+
                    "\nModelo: "+buses.get(i).getModelo()+
                    "\nMarca: "+buses.get(i).getMarca()+
                    "\nTipo: "+buses.get(i).getTipo()+
                    "\nCapacidad: "+buses.get(i).getCapacidad()+"\n\n";
        }
        return texto;
    }
    public String listarR(){
        int c=0;
        String texto="";
        for(int i=0;i<rutas.size();i++){
            c=c+1;
            texto=texto+"Ruta N°"+c+
                        "\nCodigo: "+rutas.get(i).getCodigo()+
                        "\nNombre:  "+rutas.get(i).getNombre()+
                        "\nDescripcion: "+rutas.get(i).getDescripcion()+
                        "\nTipo: "+rutas.get(i).getTipo()+
                        "\nBuses:\n";
            if(rutas.get(i).getBuses().isEmpty()){
                texto=texto+"   No hay buses asignados a esta Ruta.\n";
            }
            else{
                for(int a=0;a<rutas.get(i).getBuses().size();a++){
                    texto=texto+"     Placa: "+rutas.get(i).getBuses().get(a).getPlaca()+
                              "\n     Modelo: "+rutas.get(i).getBuses().get(a).getModelo()+
                              "\n     Marca "+rutas.get(i).getBuses().get(a).getMarca()+
                              "\n     Tipo: "+rutas.get(i).getBuses().get(a).getTipo()+
                              "\n     Capacidad: "+rutas.get(i).getBuses().get(a).getCapacidad()+"\n\n";
                }
            }
        }
        return texto;
    }
    public String usersMensual(int month){
        String texto;
        int users=0;
        String mes="";
        switch (month) {
            case 0:
                mes="01";
                break;
            case 1:
                mes="02";
                break;
            case 2:
                mes="03";
                break;
            case 3:
                mes="04";
                break;
            case 4:
                mes="05";
                break;
            case 5:
                mes="06";
                break;
            case 6:
                mes="07";
                break;
            case 7:
                mes="08";
                break;
            case 8:
                mes="09";
                break;
            case 9:
                mes="10";
                break;
            case 10:
                mes="11";
                break;
            case 11:
                mes="12";
                break;
            default:
                break;
        }
        for(int i=0;i<fechasD.size();i++){
            String[] lista=fechasD.get(i).split("-");
            if(lista[1].equals(mes)){
                users=users+pasajes.get(i);
            }
        }
        texto="El total de pasajeros movilizados en el mes es de: "+users;
        return texto;
    }
    public String recargasMensual(int month){
        String texto;
        int total=0;
        String mes="";
        switch (month) {
            case 0:
                mes="01";
                break;
            case 1:
                mes="02";
                break;
            case 2:
                mes="03";
                break;
            case 3:
                mes="04";
                break;
            case 4:
                mes="05";
                break;
            case 5:
                mes="06";
                break;
            case 6:
                mes="07";
                break;
            case 7:
                mes="08";
                break;
            case 8:
                mes="09";
                break;
            case 9:
                mes="10";
                break;
            case 10:
                mes="11";
                break;
            case 11:
                mes="12";
                break;
            default:
                break;
        }
        for(int i=0;i<fechasR.size();i++){
            String[] lista=fechasR.get(i).split("-");
            if(lista[1].equals(mes)){
                total=total+recargas.get(i);
            }
        }
        texto="El total de las recargas en el mes es de: $"+total;
        return texto;
    }
}