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

import java.io.Serializable;
import java.util.ArrayList;


public class Periodo implements Serializable{
    String mesInicio;
    String mesFinal;
    int ano;
    int cantidadCursos;
    ArrayList <Curso> cursos;
    
    //Constructor
    public Periodo(String mesInicio,String mesFinal,int ano, int  cantidadCursos){
        cursos=new ArrayList();
        this.mesInicio=mesInicio;
        this.mesFinal=mesFinal;
        this.ano=ano;
    }
    public void setCursos(ArrayList <Curso> cursos){
        ArrayList<Curso> cursosCopia=new ArrayList(cursos);
        this.cursos=cursosCopia;
    }
    public String getMesInicio(){
        return mesInicio;
    }
    public String getMesFinal(){
        return mesFinal;
    }
    public int getAno(){
        return ano;
    }
    public void setMesInicio(String mesInicio){
        this.mesInicio=mesInicio;
    }
    public void setMesFinal(String mesFinal){
        this.mesFinal=mesFinal;
    }
    public void setAno(int ano){
        this.ano=ano;
    }
    public ArrayList <Curso> getCursos(){
        return cursos;
    }
    public int getCantidadCursos(){
        return cantidadCursos;
    }
}