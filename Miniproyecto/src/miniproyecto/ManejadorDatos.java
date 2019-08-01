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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManejadorDatos {
    FachadaBD fachada;
    Connection conn;
    
    public ManejadorDatos(){
        fachada= new FachadaBD();
    }
    public int addRutaBD(int codigo,String nombre,String descripcion,String tipo){
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO ruta (codigo,nombre,descripcion,tipo) VALUES (" +
                codigo + ", '" + nombre +  "', '" +
                descripcion + "', '" + tipo + "')";
        System.out.print("sql = " + sql_guardar);
        try{
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    public int addBusBD(String placa,int modelo,String marca,String tipo,int capacidad){
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO bus (placa, modelo, marca, tipo, capacidad ) VALUES ('" +
                placa + "', " + modelo +  ", '" +
                marca + "', '" + tipo + "', "+capacidad+")";
        System.out.print("sql = " + sql_guardar);
        try{
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    public int addTarjetaBD(int numero,int idt,String nombre,String direccion,String fecha,int saldo){
        String sql_guardar;
        int numFilas=0;

        sql_guardar="INSERT INTO tarjeta (numero,idt,nombre,direccion,fecha,saldo) VALUES (" +
                numero + ", " + idt +  ", '" +
                nombre + "', '" + direccion +"', '" + fecha+"', " +saldo+")";
        System.out.print("sql = " + sql_guardar);
        try{
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    public Bus consultarBBD(String placa){
        Bus bus = null;
        String sql_select;
        sql_select="SELECT placa,modelo,marca,tipo,capacidad FROM  bus WHERE placa='" + placa +  "'";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
           
            while(tabla.next()){
               bus= new Bus("",0,"","",0);
               bus.setPlaca(tabla.getString(1));              
               bus.setModelo(tabla.getInt(2));               
               bus.setMarca(tabla.getString(3));              
               bus.setTipo(tabla.getString(4));
               bus.setCapacidad(tabla.getInt(5));
              
              System.out.println("Programa encontrado");
            }
           
            return bus;
         }
         catch(SQLException e){ System.out.println(e); 
             System.out.println("Programa No encontrado");
         }
         catch(Exception e){ System.out.println(e);
            System.out.println("Programa No encontrado");
         }
        return null;
    }
    public Ruta consultarRBD(String nombre){
        Ruta ruta = null;
        String sql_select;
        sql_select="SELECT codigo,nombre,descripcion,tipo FROM  ruta WHERE nombre='" + nombre +  "'";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
           
            while(tabla.next()){
               ruta= new Ruta(0,"","","");
               ruta.setCodigo(tabla.getInt(1));              
               ruta.setNombre(tabla.getString(2));               
               ruta.setDescripcion(tabla.getString(3));              
               ruta.setTipo(tabla.getString(4));
              
              System.out.println("Programa encontrado");
            }
           
            return ruta;
         }
         catch(SQLException e){ System.out.println(e); 
             System.out.println("Programa No encontrado");
         }
         catch(Exception e){ System.out.println(e);
            System.out.println("Programa No encontrado");
         }
        return null;
    }
    public Tarjeta consultarTBD(int numero){
        Tarjeta tarjeta = null;
        String sql_select;
        sql_select="SELECT numero,idt,nombre,direccion,fecha,saldo FROM  tarjeta WHERE numero='" + numero +  "'";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
           
            while(tabla.next()){
               tarjeta= new Tarjeta(0,0,"","","",0);
               tarjeta.setNumero(tabla.getInt(1));              
               tarjeta.setId(tabla.getInt(2));               
               tarjeta.setNombre(tabla.getString(3));              
               tarjeta.setDireccion(tabla.getString(4));
               tarjeta.setFecha(tabla.getString(5));
               tarjeta.setSaldo(tabla.getInt(6));
              
              System.out.println("Programa encontrado");
            }
           
            return tarjeta;
         }
         catch(SQLException e){ System.out.println(e); 
             System.out.println("Programa No encontrado");
         }
         catch(Exception e){ System.out.println(e);
            System.out.println("Programa No encontrado");
         }
        return null;
    }
    public String  listarBBD(){
        
        String resultado="";
        
        String sql_select;
        sql_select="SELECT placa,modelo,marca,tipo,capacidad FROM  bus ";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){                            
               resultado = resultado +"Placa: " +tabla.getString(1) + "\n";          
               resultado = resultado +"Modelo: " + tabla.getInt(2) + "\n";               
               resultado = resultado +"Marca: " + tabla.getString(3) + "\n" ;              
               resultado = resultado +"Tipo: " + tabla.getString(4)+ "\n";
               resultado = resultado +"Capacidad: " +tabla.getInt(5)+ "\n\n";
            }
           
           return resultado;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    public String  listarRBD(){
        
        String resultado="";
        
        String sql_select;
        sql_select="SELECT codigo,nombre,descripcion,tipo FROM  ruta ";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){                            
              
               resultado = resultado +"Codigo: " + tabla.getInt(1) +  "\n";          
               resultado = resultado +"Nombre: " + tabla.getString(2) +  "\n";               
               resultado = resultado +"Descripcion: " + tabla.getString(3) +  "\n" ;              
               resultado = resultado +"Tipo: " + tabla.getString(4)+  "\n\n";
            }
           
           return resultado;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    public String  listarTBD(){
        
        String resultado="";
        
        String sql_select;
        sql_select="SELECT numero,idt,nombre,direccion,fecha,saldo FROM  tarjeta ";
         try{
           
            System.out.println("consultando en la base de datos");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){                            
              
               resultado = resultado +"Numero: " + tabla.getInt(1) + "\n";          
               resultado = resultado +"Id: " + tabla.getInt(2) + "\n";               
               resultado = resultado +"Nombre: " + tabla.getString(3) + "\n" ;              
               resultado = resultado +"Direccion: " + tabla.getString(4)+ "\n";
               resultado = resultado +"Fecha: " + tabla.getString(5)+ "\n";
               resultado = resultado +"Saldo: " + tabla.getInt(6)+ "\n\n";
            }
           
           return resultado;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    public void abrirConexionBD(){
        conn= fachada.getConnetion();
        
    }
    public void cerrarConexionBD(){
        fachada.closeConection(conn);
        
    }
}
