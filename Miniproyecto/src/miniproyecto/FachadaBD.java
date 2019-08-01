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
import java.sql.*;
public class FachadaBD {
        String url, usuario, password;
        Connection conexion =null;
        Statement instruccion;
        ResultSet tabla;
        FachadaBD(){
            url="jdbc:postgresql://localhost:5432/sit";
            usuario="postgres";
            //password="53050476";
            password="jhonedwin05";
        }
        
        public Connection conectar(){
            try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.out.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.out.println( "Conexion  exitosa con la base de datos" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.out.println( "Error: No se pudo conectar a la Base de datos" );
                return null;
             }

        }//end connectar

        public Connection getConnetion(){
            if (conexion == null) {
                return this.conectar();
            }
            else{
                  return conexion;      
            }
            
        }
        
        public void closeConection(Connection c){
            try{
                if (conexion != null){
                    c.close();
                }
                 
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar." );
            }
        }
        public static void main(String a[]){
            FachadaBD f= new FachadaBD();
            f.conectar();
            f.closeConection(f.getConnetion());
        }
}
