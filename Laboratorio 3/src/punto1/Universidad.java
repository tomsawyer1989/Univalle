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
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Universidad implements Serializable{
    ArrayList <Periodo> periodos;
    ArrayList <Curso> cursos;
    ArrayList <Estudiante> estudiantes;
    
    public Universidad(){
        periodos=new ArrayList();
        cursos=new ArrayList();
        estudiantes=new ArrayList();
    }
   
    public ArrayList <Periodo> getPeriodos(){
        return periodos;
    }
    public ArrayList <Estudiante> getEstudiantes(){
        return estudiantes;
    }
    public void setPeriodos(ArrayList <Periodo> periodos){
        this.periodos=periodos;
    }
    public void setEstudiantes(ArrayList <Estudiante> estudiantes){
        this.estudiantes=estudiantes;
    }
     //Crear un periodo
    public void addPeriodo(JComboBox cbMesInicial,JComboBox cbMesFinal,JTextField tfAnho,JTextField tfCantidadCursos){
        try{
            ArrayList<Curso> cursosCopia=new ArrayList(cursos);
            String mesInicio = cbMesInicial.getSelectedItem().toString();
            String mesFinal = cbMesFinal.getSelectedItem().toString();
            int ano = Integer.parseInt(tfAnho.getText());
            int cantidadCursos = (Integer.parseInt(tfCantidadCursos.getText()));
            Periodo periodo=new Periodo(mesInicio,mesFinal,ano,cantidadCursos);
            periodo.setCursos(cursosCopia);
            periodos.add(periodo);
            cursos.clear();
            JOptionPane.showMessageDialog(null,"Periodo Creado con exito!");
            }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos en el campo de año");
        }
    }
    //Crear un curso
    public void addCurso(JTextField tfCodigoCurso,JTextField tfNombreCurso,JTextField tfCreditosCurso){
        try{
            String codigo = tfCodigoCurso.getText();
            String nombre = tfNombreCurso.getText();
            int creditos =Integer.parseInt(tfCreditosCurso.getText());
            if(cursos.isEmpty()){
                Curso curso=new Curso(codigo,nombre,creditos);
                cursos.add(curso);
                JOptionPane.showMessageDialog(null,"Curso Creado con exito!");
            }   
            else{
                for(int i=0; i<cursos.size(); i++){
                    if(cursos.get(i).getCodigo().equals(codigo) || cursos.get(i).getNombre().equals(nombre)){
                        JOptionPane.showMessageDialog(null,"El curso especificado ya existe!");
                    }
                    else{
                        Curso curso=new Curso(codigo,nombre,creditos);
                        cursos.add(curso);
                        i=cursos.size();
                        JOptionPane.showMessageDialog(null,"Curso Creado con exito!");
                    }
                }
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos:\n"
                                             + "En el campo de creditos solo se permiten valores numericos");
        }
    }
    //Registrar un estudiante a la unversidad
    public void registrarEstudiante(JTextField tfRegistrarCodigoEstudiante,JTextField tfRegistrarNombreEstudiante,JTextField tfRegistrarPlanEstudiante){
        try{
            int codigo = Integer.parseInt(tfRegistrarCodigoEstudiante.getText());
            String nombre = tfRegistrarNombreEstudiante.getText();
            String plan = tfRegistrarPlanEstudiante.getText();
            boolean estaRegistrado=false;
            for(int i=0; i<estudiantes.size(); i++){
                if(estudiantes.get(i).getCodigo()==(codigo)){
                    estaRegistrado=true;
                    i=estudiantes.size();
                }
            }
            if(estaRegistrado==false){
                Estudiante estudiante=new Estudiante(codigo,nombre,plan);
                estudiantes.add(estudiante);
                JOptionPane.showMessageDialog(null,"Estudiante registrado con exito!");
            }
            if(estaRegistrado==true){
                JOptionPane.showMessageDialog(null,"El estudiante ya esta registrado");
            }
            
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos.\n"
                                             + "En el campo de codigo solo se permiten valores numericos");
        }
    }
    
    //Matricular un estudiante a un curso
    public void inscribirEstudiante(JTextArea areaInfoPeriodo,JTextField tfCompararCodigoCurso,JTextField tfCodigoEstudiante,JTextField tfNombreEstudiante,JTextField tfPlanEstudiante){
        try{
            if(periodos.isEmpty()){
                areaInfoPeriodo.setText("No se han añadido periodos");
            }
            else{   
                String codigoCurso = tfCompararCodigoCurso.getText();
                int codigoEstudiante = (Integer.parseInt(tfCodigoEstudiante.getText()));
                String nombreEstudiante = tfNombreEstudiante.getText();
                String planEstudiante = tfPlanEstudiante.getText();
                boolean isFound=false;
                boolean isRegistrado=false;
                Estudiante estudiante=new Estudiante(0,"","");
                for(int i=0;i<estudiantes.size();i++){
                    if((codigoEstudiante==estudiantes.get(i).getCodigo())&&(nombreEstudiante.equals(estudiantes.get(i).getNombre()))&&(planEstudiante.equals(estudiantes.get(i).getPlan()))){
                        isRegistrado=true;
                        estudiante=estudiantes.get(i);
                        i=estudiantes.size();
                    }
                    else{
                        isRegistrado=false;
                    }
                }
                for(int i=periodos.size()-1; i<periodos.size(); i++){
                    for(int a=0; a<periodos.get(i).getCursos().size() ;a++){
                        if(periodos.get(i).getCursos().get(a).getCodigo().equals(codigoCurso)&&isRegistrado==true){
                            periodos.get(i).getCursos().get(a).addEstudiante(estudiante);
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
                else{
                    JOptionPane.showMessageDialog(null,"Estudiante matriculado con exito!");   
                }
            } 
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos.\n"
                                             + "En el campode codigo solo se permiten valores numericos");
        }
    }
    //Registrar notas de un estudiante en un curso
    public void registrarNotas(JComboBox cbMesInicial,JComboBox cbMesFinal,JTextField tfAnho,JTextField tfCompararCodigoCursoNotas,JTextField tfCompararCodigoEstudianteNotas,JTextField tfnotaEstudiante){
        try{
        String mesInicio = cbMesInicial.getSelectedItem().toString();
        String mesFinal = cbMesFinal.getSelectedItem().toString();
        int ano = Integer.parseInt(tfAnho.getText());
        boolean isFoundP=false;
        boolean isFoundC=false;
        for(int i=0;i<periodos.size();i++){
            if(periodos.get(i).getMesInicio().equals(mesInicio)&&periodos.get(i).getMesFinal().equals(mesFinal)&&periodos.get(i).getAno()==(ano)){
                isFoundP=true;
                String codigo = tfCompararCodigoCursoNotas.getText();
                for(int a=0;a<periodos.get(i).getCursos().size();a++){
                    if(periodos.get(i).getCursos().get(a).getCodigo().equals(codigo)){
                        int codEstudiante=0;
                        codEstudiante= Integer.parseInt(tfCompararCodigoEstudianteNotas.getText());
                        isFoundC=true;
                        for(int b=0;b<periodos.get(i).getCursos().get(a).getEstudiantes().size();b++){
                            if(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()==codEstudiante){
                                double nota= Double.parseDouble(tfnotaEstudiante.getText());
                                periodos.get(i).getCursos().get(a).getEstudiantes().get(b).setNota(nota);
                                JOptionPane.showMessageDialog(null,"Nota registrada con exito!");
                            }
                            else{
                              JOptionPane.showMessageDialog(null,"El codigo ingresado no existe!");  
                            }
                        } 
                    }
                    else{
                        isFoundC=false;
                    }
                }
            }
            else {
                isFoundP=false;
            }
        }
        if(isFoundP==false){
            JOptionPane.showMessageDialog(null,"El periodo ingresado no existe.");
        }
        if(isFoundC==false){
            JOptionPane.showMessageDialog(null,"El curso ingresado no existe en este periodo.");
        }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos:\n"
                                             + "En los campos de caodigo de estudiante y\n"
                                             + "nota solo se permiten valores numericos");
        }
    }
    
    //calcular promedio de notas de un curso, mejor estudiante y estudiantes matriculados a un curso
    public void listados(JComboBox cbMesInicialListados,JComboBox cbMesFinalListados,JTextField tfAnhoListados,JTextField tfCodigoCursoListados,JTextArea areaListados,boolean promCurso,boolean mejorEstd,boolean matriculados){
        try{
            String mesInicio = cbMesInicialListados.getSelectedItem().toString();
            String mesFinal = cbMesFinalListados.getSelectedItem().toString();
            int ano = Integer.parseInt(tfAnhoListados.getText());
            boolean isFoundP=false;
            boolean isFoundC=false;
            for(int i=0;i<periodos.size();i++){
                if(periodos.get(i).getMesInicio().equals(mesInicio)&&periodos.get(i).getMesFinal().equals(mesFinal)&&periodos.get(i).getAno()==ano){
                    String codigo =tfCodigoCursoListados.getText();
                    isFoundP=true;
                    for(int a=0;a<periodos.get(i).getCursos().size();a++){
                        if(periodos.get(i).getCursos().get(a).getCodigo().equals(codigo)){
                            double promedio=0.0;
                            String mjEstd="";
                            double mejorNota=0.0;
                            String inscritos="";
                            isFoundC=true;
                            for(int b=0;b<periodos.get(i).getCursos().get(a).getEstudiantes().size();b++){
                                if(promCurso==true){
                                    promedio=promedio+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota(); 
                                }
                                if(mejorEstd==true){
                                    if(mejorNota<periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota()){
                                        mejorNota=periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota();
                                        mjEstd="Codigo: "+Integer.toString(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo())+
                                               "\nNombre: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+
                                               "\nPlan: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+
                                               "\nNota: "+Double.toString(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota());
                                    }   
                                }
                                if(matriculados==true){
                                    Collections.sort(periodos.get(i).getCursos().get(a).getEstudiantes(), new Comparator<Estudiante>() {
                                        @Override
                                        public int compare(Estudiante e1, Estudiante e2){
                                            return new Double(e2.getNota()).compareTo(new Double(e1.getNota()));
                                        }
                                    });
                                    inscritos=inscritos+"Codigo: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()+
                                                        "  -  Nombre: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+
                                                        "  -  Plan: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+
                                                        "  -  Nota: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota()+"\n";
                                }
                            }
                            if(promCurso==true){
                                promedio= promedio/periodos.get(i).getCursos().get(a).getEstudiantes().size();
                                areaListados.setText("Promedio del curso: "+Double.toString(promedio));
                            }
                            if(mejorEstd==true){
                                areaListados.setText("Mejor estudiante:\n"+mjEstd);
                            }
                            if(matriculados==true){
                                areaListados.setText("Estudiantes matriculados con orden de mayor nota a menor nota:\n"+inscritos);
                                }
                        }
                        else{
                            isFoundC=false;
                        }
                    }   
                }
                else{
                    isFoundP=false;
                }
            }
            if(isFoundP==false){
                JOptionPane.showMessageDialog(null,"El periodo ingresado no existe.");
            }
            if(isFoundC==false){
                JOptionPane.showMessageDialog(null,"El curso ingresado no existe en este periodo.");
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos.\n"
                                             + "En el campo de codigo de estudiante solo se permiten valores numericos");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }    
    }
}