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
package punto3;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Universidad {
    ArrayList <Periodo> periodos;
    
    //Constructor
    public Universidad(){
        periodos=new ArrayList();
    }
    
    //Crear periodo
    public void addPeriodo(){
        String mesInicio=JOptionPane.showInputDialog(null,"Digite el mes inicial del periodo.");
        String mesFinal=JOptionPane.showInputDialog(null,"Digite el mes final del periodo.");
        String ano=JOptionPane.showInputDialog(null,"Digite el año del periodo."); 
        Periodo periodo=new Periodo(mesInicio,mesFinal,ano);
        periodos.add(periodo);
    }
    
    //Inscribir un estudiante a un curso
    public void InscribirEstudiante(){
        if(periodos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay periodos creados.");
        }
        else{
            String listaCursos="";
            for(int i=periodos.size()-1;i<periodos.size();i++){
                listaCursos=listaCursos+"Mes inicial: "+periodos.get(i).getMesInicio()+"\n"+
                                        "Mes Final: "+periodos.get(i).getMesFinal()+"\n"+
                                        "Año: "+periodos.get(i).getAno()+
                                        "\n\nCursos abiertos para este periodo:\n";
                for(int a=0;a<periodos.get(i).getCursos().size();a++){
                    listaCursos=listaCursos+periodos.get(i).getCursos().get(a).codigo+" "+periodos.get(i).getCursos().get(a).nombre+" "+
                        "Créditos: "+periodos.get(i).getCursos().get(a).creditos+"\n";
                }
            }
            listaCursos=listaCursos+"Ingrese el código del curso al que desea matricular el estudiante.";
            String codigo=JOptionPane.showInputDialog(null,listaCursos,"Inscripciones periodo actual",1);
            boolean isFound=false;
            for(int i=periodos.size()-1;i<periodos.size();i++){
                for(int a=0;a<periodos.get(i).getCursos().size();a++){
                    if(periodos.get(i).cursos.get(a).getCodigo().equals(codigo)){
                        periodos.get(i).cursos.get(a).addEstudiante();
                        isFound=true;
                        a=periodos.get(i).getCursos().size();
                    }
                    else{
                        isFound=false;
                    }
                }
            }
            if(isFound==false){
                JOptionPane.showMessageDialog(null,"El código ingresado no pertenece a ningún curso.");
            }
        } 
    }
    
    //Registrar notas, calcular promedio de notas de un curso, mejor estudiante y estudiantes matriculados a un curso
    public void notas(boolean registrar,boolean promCurso,boolean mejorEstd,boolean matriculados){
        String mesInicio=JOptionPane.showInputDialog(null,"Digite el mes inicial del periodo.");
        String mesFinal=JOptionPane.showInputDialog(null,"Digite el mes final del periodo.");
        String ano=JOptionPane.showInputDialog(null,"Digite el año del periodo.");
        for(int i=0;i<periodos.size();i++){
            if(periodos.get(i).getMesInicio().equals(mesInicio)&&periodos.get(i).getMesFinal().equals(mesFinal)&&periodos.get(i).getAno().equals(ano)){
                String codigo=JOptionPane.showInputDialog(null,"Digite el código del curso.");
                for(int a=0;a<periodos.get(i).getCursos().size();a++){
                    if(periodos.get(i).getCursos().get(a).getCodigo().equals(codigo)){
                        int codEstudiante=0;
                        double promedio=0.0;
                        String mjEstd="";
                        double mejorNota=0.0;
                        String inscritos="";
                        if(registrar==true){
                            codEstudiante=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el código del estudiante."));
                        }
                        for(int b=0;b<periodos.get(i).getCursos().get(a).getEstudiantes().size();b++){
                            if(registrar==true){
                                if(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()==codEstudiante){
                                    double nota=Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la nota definitiva del estudiante."));
                                    periodos.get(i).getCursos().get(a).getEstudiantes().get(b).setNota(nota);
                                }
                            }
                            if(promCurso==true){
                                promedio=promedio+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota(); 
                            }
                            if(mejorEstd==true){
                                if(mejorNota<periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota()){
                                    mejorNota=periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota();
                                    mjEstd=Integer.toString(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo())+" "+
                                        periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+" "+
                                        periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+" "+
                                        Double.toString(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota());
                                }
                            }
                            if(matriculados==true){
                                inscritos=inscritos+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()+" "+
                                                    periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+" "+
                                                    periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+"\n";
                            }
                        }
                        if(promCurso==true){
                            promedio=promedio/periodos.get(i).getCursos().get(a).getEstudiantes().size();
                            JOptionPane.showMessageDialog(null,"El promedio del curso en este periodo fue de: "+promedio);
                        }
                        if(mejorEstd==true){
                            JOptionPane.showMessageDialog(null,mjEstd,"Mejor estudiante del curso",1);
                        }
                        if(matriculados==true){
                            JOptionPane.showMessageDialog(null,inscritos,"Estudiantes matriculados en el curso",1);
                        }
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"opcion invalida");
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Universidad universidad=new Universidad();
        int menu;
        do{
            menu=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una opción:\n"
                    + "1-Crear Periodo.\n"
                    + "2-Matricular estudiantes.\n"
                    + "3-Registrar calificaciones.\n"
                    + "4-Promedio de nota por curso.\n"
                    + "5-Mejor estudiante de un determinado curso.\n"
                    + "6-Estudiantes matriculados en un determinado curso.\n"
                    + "7-Salir."));
            switch(menu){
                case 1: 
                    universidad.addPeriodo();
                break;
                case 2:
                    universidad.InscribirEstudiante();
                break;
                case 3: 
                    universidad.notas(true,false,false,false);//Registrar calificaciones
                break;
                case 4:
                    universidad.notas(false,true,false,false);//Promedio de nota por curso
                break;
                case 5:
                    universidad.notas(false,false,true,false);//Mejor estudiante de un determinado curso
                break;
                case 6:
                    universidad.notas(false,false,false,true);//Estudiantes matriculados en un determinado curso
                break;
                case 7:
                break;
                default: 
                        JOptionPane.showMessageDialog(null,"Ingrese una opción correcta.");
                break;
            }  
        }
        while(menu!=7);
    }
    
}
