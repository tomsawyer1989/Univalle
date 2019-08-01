/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class ArchBin {
    Universidad universidad;
    
    public ArchBin(Universidad universidad){
        this.universidad=universidad;
    }
    public void setUniversidad(Universidad universidad){
        this.universidad=universidad;
    }
    public void escribir(){
        try{
            FileOutputStream file=new FileOutputStream("Fichero.bin");
            DataOutputStream pWriter=new DataOutputStream(file);
            for(int j=0;j<universidad.getEstudiantes().size();j++){
                pWriter.writeChar('r');
                pWriter.writeChar(',');
                pWriter.writeInt(universidad.getEstudiantes().get(j).getCodigo());
                pWriter.writeChar(',');
                pWriter.writeUTF(universidad.getEstudiantes().get(j).getNombre());
                pWriter.writeChar(',');
                pWriter.writeUTF(universidad.getEstudiantes().get(j).getPlan());
                pWriter.writeChar('\n');
            }
            for(int i=0;i<universidad.getPeriodos().size();i++){
                pWriter.writeChar('p');
                pWriter.writeChar(',');
                pWriter.writeUTF(universidad.getPeriodos().get(i).getMesInicio());
                pWriter.writeChar(',');
                pWriter.writeUTF(universidad.getPeriodos().get(i).getMesFinal());
                pWriter.writeChar(',');
                pWriter.writeInt(universidad.getPeriodos().get(i).getAno());
                pWriter.writeChar('\n');
                for(int a=0;a<universidad.getPeriodos().get(i).getCursos().size();a++){
                    pWriter.writeChar('c');
                    pWriter.writeChar(',');
                    pWriter.writeUTF(universidad.getPeriodos().get(i).getCursos().get(a).getCodigo());
                    pWriter.writeChar(',');
                    pWriter.writeUTF(universidad.getPeriodos().get(i).getCursos().get(a).getNombre());
                    pWriter.writeChar(',');
                    pWriter.writeInt(universidad.getPeriodos().get(i).getCursos().get(a).getCreditos());
                    pWriter.writeChar('\n');
                    for(int b=0;b<universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().size();b++){
                        pWriter.writeChar('e');
                        pWriter.writeChar(',');
                        pWriter.writeInt(universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo());
                        pWriter.writeChar(',');
                        pWriter.writeUTF(universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getNombre());
                        pWriter.writeChar(',');
                        pWriter.writeUTF(universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getPlan());
                        pWriter.writeChar(',');
                        pWriter.writeDouble(universidad.getPeriodos().get(i).getCursos().get(a).getEstudiantes().get(b).getNota());
                        pWriter.writeChar('\n');
                    } 
                }
            }
            pWriter.writeChar('*');
            pWriter.close();
            JOptionPane.showMessageDialog(null,"Datos guardados con exito!");
        }
        catch(IOException e){
        }
    }
    public void leer(){
        try {
            char c;
            DataInputStream bReader = new DataInputStream(new FileInputStream("Fichero.bin"));
            ArrayList<Estudiante> registrados=new ArrayList();
            ArrayList<Periodo> periodos=new ArrayList();
            ArrayList<Curso> cursos=new ArrayList();
            ArrayList<Estudiante> estudiantes=new ArrayList();
            int a=-1;
            int b=-1;
            while((c = bReader.readChar())!='*') {
                System.out.println(c);
                if(c=='r'){
                    bReader.readChar();
                    int codigo=bReader.readInt();
                    System.out.println(codigo);
                    bReader.readChar();
                    String nombre=bReader.readUTF();
                    System.out.println(nombre);
                    bReader.readChar();
                    String plan=bReader.readUTF();
                    System.out.println(plan);
                    bReader.readChar();
                    Estudiante estudiante=new Estudiante(codigo,nombre,plan);
                    estudiantes.add(estudiante);
                    universidad.setEstudiantes(estudiantes);
                    System.out.println("verreg");
                }
                else if(c=='p'){
                    a=a+1;
                    b=-1;
                    bReader.readChar();
                    String mesInicio=bReader.readUTF();
                    System.out.println(mesInicio);
                    bReader.readChar();
                    String mesFinal=bReader.readUTF();
                    System.out.println(mesFinal);
                    bReader.readChar();
                    int ano=bReader.readInt();
                    System.out.println(ano);
                    bReader.readChar();
                    Periodo periodo=new Periodo(mesInicio,mesFinal,ano,0);
                    periodos.add(periodo);
                    universidad.setPeriodos(periodos);
                    cursos.clear();
                    System.out.println("verper");
                }
                else if(c=='c'){
                    b=b+1;
                    bReader.readChar();
                    String codigo=bReader.readUTF();
                    System.out.println(codigo);
                    bReader.readChar();
                    String nombre=bReader.readUTF();
                    System.out.println(nombre);
                    bReader.readChar();
                    int creditos=bReader.readInt();
                    System.out.println(creditos);
                    bReader.readChar();
                    Curso curso=new Curso(codigo,nombre,creditos);
                    cursos.add(curso);
                    universidad.getPeriodos().get(a).setCursos(cursos);
                    estudiantes.clear();
                    System.out.println("vercur");
                }
                else if(c=='e'){
                    bReader.readChar();
                    int codigo=bReader.readInt();
                    System.out.println(codigo);
                    bReader.readChar();
                    String nombre=bReader.readUTF();
                    System.out.println(nombre);
                    bReader.readChar();
                    String plan=bReader.readUTF();
                    System.out.println(plan);
                    bReader.readChar();
                    Double nota=bReader.readDouble();
                    System.out.println(nota);
                    bReader.readChar();
                    Estudiante estudiante=new Estudiante(codigo,nombre,plan);
                    estudiante.setNota(nota);
                    estudiantes.add(estudiante);
                    universidad.getPeriodos().get(a).getCursos().get(b).setEstudiantes(estudiantes);
                    System.out.println("verest");
                }
            }
            bReader.close();
        }   
        catch (IOException ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}