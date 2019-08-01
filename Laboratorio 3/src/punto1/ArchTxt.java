/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class ArchTxt {
    Universidad universidad;
    
    public ArchTxt(Universidad universidad){
        this.universidad=universidad;
    }
    public void setUniversidad(Universidad universidad){
        this.universidad=universidad;
    }
    public void escribir(){
        try{
            File file=new File("Fichero.txt");
            FileWriter writer=new FileWriter(file);
            BufferedWriter bWriter=new BufferedWriter(writer);
            PrintWriter pWriter=new PrintWriter(bWriter);
            for(int j=0;j<universidad.getEstudiantes().size();j++){
                pWriter.write(universidad.getEstudiantes().get(j).getCodigo()+","+
                universidad.getEstudiantes().get(j).getNombre()+","+
                universidad.getEstudiantes().get(j).getPlan()+",registrado"+"\r\n");
            }
            for(int i=0;i<universidad.getPeriodos().size();i++){
                pWriter.write(universidad.getPeriodos().get(i).getMesInicio()+","+
                universidad.getPeriodos().get(i).getMesFinal()+","+
                universidad.getPeriodos().get(i).getAno()+",periodo"+"\r\n");
                for(int a=0;a<universidad.getPeriodos().get(i).getCursos().size();a++){
                    pWriter.write(universidad.getPeriodos().get(i).getCursos().get(a).getCodigo()+","+
                    universidad.getPeriodos().get(i).getCursos().get(a).getNombre()+","+
                    universidad.getPeriodos().get(i).getCursos().get(a).getCreditos()+",curso"+"\r\n");
                    for(int b=0;b<universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().size();b++){
                        pWriter.write(universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()+","+
                        universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+","+
                        universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+","+
                        universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getNota()+",estudiante"+"\r\n");
                    } 
                }
            }
            pWriter.close();
            bWriter.close();
            JOptionPane.showMessageDialog(null,"Datos guardados con exito!");
        }
        catch(IOException e){
        }
    }
    public void leer(){
        try {
            String cadena;
            FileReader reader = new FileReader("Fichero.txt");
            BufferedReader bReader = new BufferedReader(reader);
            ArrayList<Estudiante> registrados=new ArrayList();
            ArrayList<Periodo> periodos=new ArrayList();
            ArrayList<Curso> cursos=new ArrayList();
            ArrayList<Estudiante> estudiantes=new ArrayList();
            int a=-1;
            int b=-1;
            while((cadena = bReader.readLine())!=null) {
                String[] lista = cadena.split(",");
                System.out.println(cadena);
                
                for(int j=0;j<lista.length;j++){
                    if(lista[j].equals("registrado")){
                        Estudiante estudiante=new Estudiante(Integer.parseInt(lista[0]),lista[1],lista[2]);
                        estudiantes.add(estudiante);
                        universidad.setEstudiantes(estudiantes);
                    }
                    else if(lista[j].equals("periodo")){
                        a=a+1;
                        b=-1;
                        Periodo periodo=new Periodo(lista[0],lista[1],Integer.parseInt(lista[2]),0);
                        periodos.add(periodo);
                        universidad.setPeriodos(periodos);
                        cursos.clear();
                    }
                    else if(lista[j].equals("curso")){
                        b=b+1;
                        Curso curso=new Curso(lista[0],lista[1],Integer.parseInt(lista[2]));
                        cursos.add(curso);
                        universidad.getPeriodos().get(a).setCursos(cursos);
                        estudiantes.clear();
                    }
                    else if(lista[j].equals("estudiante")){
                        Estudiante estudiante=new Estudiante(Integer.parseInt(lista[0]),lista[1],lista[2]);
                        estudiante.setNota(Double.parseDouble(lista[3]));
                        estudiantes.add(estudiante);
                        universidad.getPeriodos().get(a).getCursos().get(b).setEstudiantes(estudiantes);
                    }
                }
            }
            bReader.close();
        }   
        catch (IOException ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}