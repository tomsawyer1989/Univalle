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
package Punto1;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Comparator;

public class Universidad extends JFrame implements ActionListener{
    ArrayList <Periodo> periodos;
    ArrayList <Curso> cursos;
    ArrayList <Estudiante> estudiantes;
   
    String[] listaMeses;
    Container contenedor;
    private JTabbedPane tabbedPane;
    private JPanel topPanel, panelUniversidad, panelEstudiantes, panelPeriodos, panelCursos,panelMatricula,
                panelNotas, panelInfo, panelListados, panelPeriodoNotas, panelAddNotas, panelAreaNotas,
            panelListadosPeriodo, panelListadosArea;
    JLabel lMesInicial, lMesFinal, lAnho, lCantidadCursos, lCodigoCurso, lNombreCurso, lCreditosCurso,
            lInfoPeriodo, lInfoCurso, lCodigoEstudiante, lNombreEstudiante, lPlanEstudiante, lCompararCodigoCurso,
            lCompararCodigoEstudiante, lNotaEstudiante, lCompararCodigoCursoNotas,
            lRegistrarCodigoEstudiante, lRegistrarNombreEstudiante, lRegistrarPlanEstudiante, lAnhoListados,
            lMesInicialListados, lMesFinalListados, lCodigoCursoListados;
    JComboBox cbMesInicial, cbMesFinal, cbMesInicialNotas, cbMesFinalNotas, cbMesInicialListados, cbMesFinalListados;
    JTextField tfAnho, tfCantidadCursos, tfCodigoCurso, tfNombreCurso, tfCreditosCurso,
            tfCodigoEstudiante, tfNombreEstudiante, tfPlanEstudiante, tfCompararCodigoCurso, tfCompararCodigoEstudiante,
            tfAnhoNotas, tfCompararCodigoEstudianteNotas, tfnotaEstudiante, tfCompararCodigoCursoNotas,
            tfRegistrarPlanEstudiante, tfRegistrarNombreEstudiante, tfRegistrarCodigoEstudiante, tfAnhoListados, tfCodigoCursoListados;
    JButton bCrearCurso,bCrearPeriodo, bCrearEstudiante, bMostrarCursos, bInscribirEstudiante, bRegistrarNotas, bPromedioCurso,
            bMejorEstudianteCurso, bEstudiantesMatriculadosCurso;
    JTextArea areaInfo = new JTextArea(5,30), areaInfoPeriodo= new JTextArea(10,25), areaListados= new JTextArea(6,25);
    JScrollPane scrollAreaInfoPeriodo = new JScrollPane(areaInfoPeriodo);
    JScrollPane scrollAreaListados = new JScrollPane(areaListados);
    
    //Constructor
    public Universidad(){
        periodos=new ArrayList();
        cursos=new ArrayList();
        estudiantes=new ArrayList();
        listaMeses = new String[12];
        listaMeses[0]= "Enero";
        listaMeses[1]= "Febrero";
        listaMeses[2]= "Marzo";
        listaMeses[3]= "Abril";
        listaMeses[4]= "Mayo";
        listaMeses[5]= "junio";
        listaMeses[6]= "Julio";
        listaMeses[7]= "Agosto";
        listaMeses[8]= "Septiembre";
        listaMeses[9]= "Octubre";
        listaMeses[10]= "Noviembre";
        listaMeses[11]= "Diciembre";
        contenedor = getContentPane();
        
        setTitle( "Gestion de matriculas" );
        setSize(400,450);
	//setBackground(Color.red);
        topPanel = new JPanel();
	topPanel.setLayout(new BorderLayout());
	contenedor.add(topPanel);
	// Create the tab pages
        jtpPeriodos();
	jtpEstudiantes();
	jtpMatricula();
        jtpNotas();
        jtpListados();
        // Create a tabbed pane
	tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Periodos", panelUniversidad);
	tabbedPane.addTab("Estudiantes", panelEstudiantes);
	tabbedPane.addTab("Matriculas", panelMatricula);
        tabbedPane.addTab("Notas", panelNotas);
        tabbedPane.addTab("Listados", panelListados);
        topPanel.add(tabbedPane, BorderLayout.CENTER);
    }
    //Pestaña: Periodos
    public void jtpPeriodos(){
        panelUniversidad = new JPanel();
        panelUniversidad.setLayout(new GridLayout(3,1));
        
        panelPeriodos = new JPanel();
        panelPeriodos.setLayout(new GridLayout(4,2));
        panelPeriodos.setBorder(BorderFactory.createTitledBorder("Crear periodo"));
        panelCursos = new JPanel();
        panelCursos.setLayout(new GridLayout(4,2));
        panelCursos.setBorder(BorderFactory.createTitledBorder("Crear cursos para el periodo actual"));
        panelInfo= new JPanel();
        panelInfo.setLayout(new FlowLayout());
        panelInfo.setBorder(BorderFactory.createTitledBorder("Instrucciones"));
        lMesInicial = new JLabel( "Ingrese el mes de inicio" );
        cbMesInicial = new JComboBox(listaMeses);
                
        lMesFinal = new JLabel( "Ingrese el mes final" );
	cbMesFinal = new JComboBox(listaMeses);
                
	lAnho = new JLabel("Digite el año para el periodo");
        tfAnho = new JTextField(4);
                
        bCrearPeriodo = new JButton("Crear periodo");
        bCrearPeriodo.addActionListener(this);
        
        bCrearCurso = new JButton("Crear curso");
        bCrearCurso.addActionListener(this);
        
        lCantidadCursos = new JLabel("Cantidad de cursos");
        tfCantidadCursos = new JTextField(4);
        
        lCodigoCurso = new JLabel("Digite el codigo del curso");
        tfCodigoCurso = new JTextField(4);
        
        lNombreCurso = new JLabel("Digite el nombre del curso");
        tfNombreCurso = new JTextField(4);
        
        lCreditosCurso = new JLabel("Digite los creditos del curso");
        tfCreditosCurso = new JTextField(4);
        
        areaInfo.setText("1. Ingrese la informacion del periodo a crear."
                     + "\n2. Ingrese la informacion de los cursos a adicionar\n     en el periodo y oprima el boton Crear curso."
                     + "\n3. Finalmente oprima el boton Crear periodo.");
        
        panelUniversidad.add(panelPeriodos);
        panelUniversidad.add(panelCursos);
        panelUniversidad.add(panelInfo);
        
        panelPeriodos.add(lMesInicial);
        panelPeriodos.add(cbMesInicial);
        panelPeriodos.add(lMesFinal);
        panelPeriodos.add(cbMesFinal);
        panelPeriodos.add(lAnho);
        panelPeriodos.add(tfAnho);
        panelPeriodos.add(lCantidadCursos);
        panelPeriodos.add(tfCantidadCursos);
        
        panelCursos.add(lCodigoCurso);
        panelCursos.add(tfCodigoCurso);
        panelCursos.add(lNombreCurso);
        panelCursos.add(tfNombreCurso);
        panelCursos.add(lCreditosCurso);
        panelCursos.add(tfCreditosCurso);
        panelCursos.add(bCrearCurso);        
        panelCursos.add(bCrearPeriodo);
        
        panelInfo.add(areaInfo);
	}
    //Pestaña: Estudiantes
    public void jtpEstudiantes(){
        panelEstudiantes = new JPanel();
        panelEstudiantes.setLayout(new GridLayout(10,2));
        panelEstudiantes.setBorder(BorderFactory.createTitledBorder("Registar estudiantes"));
        lRegistrarCodigoEstudiante =new JLabel("Codigo del estudiante");
        tfRegistrarCodigoEstudiante = new JTextField(4);
        lRegistrarNombreEstudiante =new JLabel("Nombre del estudiante");
        tfRegistrarNombreEstudiante = new JTextField(4);
        lRegistrarPlanEstudiante =new JLabel("Plan del estudiante");
        tfRegistrarPlanEstudiante = new JTextField(4);
        
        
        bCrearEstudiante = new JButton("Registrar estudiante");
        bCrearEstudiante.addActionListener(this);
        
        panelEstudiantes.add(lRegistrarCodigoEstudiante);
        panelEstudiantes.add(tfRegistrarCodigoEstudiante);
        panelEstudiantes.add(lRegistrarNombreEstudiante);
        panelEstudiantes.add(tfRegistrarNombreEstudiante);
        panelEstudiantes.add(lRegistrarPlanEstudiante);
        panelEstudiantes.add(tfRegistrarPlanEstudiante);
        panelEstudiantes.add(bCrearEstudiante);
	}
    //Pestaña: Matricula
    public void jtpMatricula(){
        panelMatricula = new JPanel();
        panelMatricula.setLayout(new FlowLayout());
        panelMatricula.setBorder(BorderFactory.createTitledBorder("Matricular estudiantes"));
        bMostrarCursos = new JButton("Mostrar informacion de periodos y cursos");
        bMostrarCursos.addActionListener(this);
        
        lCompararCodigoCurso = new JLabel("Codigo del curso");
        tfCompararCodigoCurso = new JTextField(4);
        lCodigoEstudiante = new JLabel("Codigo del estudiante");
        tfCodigoEstudiante = new JTextField(4);
        lNombreEstudiante = new JLabel("Nombre del estudiante");
        tfNombreEstudiante = new JTextField(4);
        lPlanEstudiante = new JLabel("Plan del estudiante");
        tfPlanEstudiante = new JTextField(4);
        bInscribirEstudiante = new JButton("Inscribir");
        bInscribirEstudiante.addActionListener(this);
        
        panelMatricula.add(bMostrarCursos);
        panelMatricula.add(scrollAreaInfoPeriodo);  
        panelMatricula.add(lCompararCodigoCurso);
        panelMatricula.add(tfCompararCodigoCurso);
        
        panelMatricula.add(lCodigoEstudiante);
        panelMatricula.add(tfCodigoEstudiante);
        panelMatricula.add(lNombreEstudiante);
        panelMatricula.add(tfNombreEstudiante);
        panelMatricula.add(lPlanEstudiante);
        panelMatricula.add(tfPlanEstudiante);
        panelMatricula.add(bInscribirEstudiante);
	}
    //Pestaña: Notas
    public void jtpNotas(){
        panelNotas = new JPanel();
        panelNotas.setLayout(new GridLayout(3,1));
        panelPeriodoNotas = new JPanel();
        panelPeriodoNotas.setLayout(new GridLayout(4,2));
        panelPeriodoNotas.setBorder(BorderFactory.createTitledBorder("Informacion del periodo"));
        panelAddNotas = new JPanel();
        panelAddNotas.setLayout(new GridLayout(4,2));
        panelAddNotas.setBorder(BorderFactory.createTitledBorder("Informacion de notas"));
       
        panelAreaNotas = new JPanel();
        panelAreaNotas.setLayout(new FlowLayout());
        
        lMesInicial = new JLabel( "Ingrese el mes de inicio" );
        cbMesInicialNotas = new JComboBox(listaMeses);
        lMesFinal = new JLabel( "Ingrese el mes final" );
	cbMesFinalNotas = new JComboBox(listaMeses);
        lAnho = new JLabel("Digite el año para el periodo");
        tfAnhoNotas = new JTextField(4);
        
        lCompararCodigoCursoNotas = new JLabel ("Codigo del curso");
        tfCompararCodigoCursoNotas = new JTextField(4);
        lCompararCodigoEstudiante = new JLabel("Digite codigo de estudiante");
        tfCompararCodigoEstudianteNotas = new JTextField(4);
        lNotaEstudiante = new JLabel("Digite la nota del estudiante");
        tfnotaEstudiante = new JTextField(4);
        bRegistrarNotas = new JButton("Registrar nota");
        bRegistrarNotas.addActionListener(this);
        
        bPromedioCurso = new JButton("Promedio por cursos");
        bPromedioCurso.addActionListener(this);
        bMejorEstudianteCurso = new JButton("Mejor estudiante");
        bMejorEstudianteCurso.addActionListener(this);
        bEstudiantesMatriculadosCurso = new JButton("Estudiantes del curso");
        bEstudiantesMatriculadosCurso.addActionListener(this);
        
        panelNotas.add(panelPeriodoNotas);
        panelNotas.add(panelAddNotas);
        panelNotas.add(panelAreaNotas);
        
        panelPeriodoNotas.add(lMesInicial);
        panelPeriodoNotas.add(cbMesInicialNotas);
        panelPeriodoNotas.add(lMesFinal);
        panelPeriodoNotas.add(cbMesFinalNotas);
        panelPeriodoNotas.add(lAnho);
        panelPeriodoNotas.add(tfAnhoNotas);
        panelPeriodoNotas.add(lCompararCodigoCursoNotas);
        panelPeriodoNotas.add(tfCompararCodigoCursoNotas);
        
        panelAddNotas.add(lCompararCodigoEstudiante);
        panelAddNotas.add(tfCompararCodigoEstudianteNotas);
        panelAddNotas.add(lNotaEstudiante);
        panelAddNotas.add(tfnotaEstudiante);
        panelAddNotas.add(bRegistrarNotas );
        }
    //Pestaña: Listados
    public void jtpListados(){
        panelListados = new JPanel();
        panelListados.setLayout(new GridLayout(3,1));
        panelListadosPeriodo= new JPanel();
        panelListadosPeriodo.setLayout(new GridLayout(6,2));
        panelListadosArea=new JPanel();
        panelListadosArea.setLayout(new GridLayout(1,1));
        panelListadosArea.setBorder(BorderFactory.createTitledBorder("Listados"));
        lMesInicialListados = new JLabel("Ingrese el mes inicial del periodo");
        cbMesInicialListados=new JComboBox(listaMeses);
        lMesFinalListados = new JLabel("Ingrese el mes final del periodo");
        cbMesFinalListados=new JComboBox(listaMeses);
        lAnhoListados = new JLabel("Ingrese el año del periodo");
        tfAnhoListados = new JTextField(4);
        lCodigoCursoListados = new JLabel("Ingrese el codigo del curso");
        tfCodigoCursoListados = new JTextField(4);
        
        bPromedioCurso = new JButton("Promedio por cursos");
        bPromedioCurso.addActionListener(this);
        bMejorEstudianteCurso = new JButton("Mejor estudiante");
        bMejorEstudianteCurso.addActionListener(this);
        bEstudiantesMatriculadosCurso = new JButton("Estudiantes del curso");
        bEstudiantesMatriculadosCurso.addActionListener(this);
        
        panelListados.add(panelListadosPeriodo);
        panelListados.add(panelListadosArea);
        
        panelListadosPeriodo.add(lMesInicialListados);
        panelListadosPeriodo.add(cbMesInicialListados);
        panelListadosPeriodo.add(lMesFinalListados);
        panelListadosPeriodo.add(cbMesFinalListados);
        panelListadosPeriodo.add(lAnhoListados);
        panelListadosPeriodo.add(tfAnhoListados);
        panelListadosPeriodo.add(lCodigoCursoListados);
        panelListadosPeriodo.add(tfCodigoCursoListados);
        panelListadosPeriodo.add(bPromedioCurso);
        panelListadosPeriodo.add(bMejorEstudianteCurso);
        panelListadosPeriodo.add(bEstudiantesMatriculadosCurso);
        panelListadosArea.add(scrollAreaListados);
	}
    
    //Crear un periodo
    public void addPeriodo(){
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
    public void addCurso(){
        try{
            String codigo = tfCodigoCurso.getText();
            String nombre = tfNombreCurso.getText();
            int creditos =(Integer.parseInt(tfCreditosCurso.getText()));
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
    public void registrarEstudiante(){
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
    public void inscribirEstudiante(){
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
    
    public void registrarNotas(){
        try{
        String mesInicio = cbMesInicial.getSelectedItem().toString();
        String mesFinal = cbMesFinal.getSelectedItem().toString();
        int ano = Integer.parseInt(tfAnho.getText());
        boolean isFoundP=false;
        boolean isFoundC=false;
        for(int i=0;i<periodos.size();i++){
            if(periodos.get(i).getMesInicio().equals(mesInicio)&&periodos.get(i).getMesFinal().equals(mesFinal)&&periodos.get(i).getAno()==(ano)){
                //String codigo=JOptionPane.showInputDialog(null,"Digite el código del curso.");
                isFoundP=true;
                String codigo = tfCompararCodigoCursoNotas.getText();
                for(int a=0;a<periodos.get(i).getCursos().size();a++){
                    if(periodos.get(i).getCursos().get(a).getCodigo().equals(codigo)){
                        int codEstudiante=0;
                        codEstudiante= Integer.parseInt(tfCompararCodigoEstudianteNotas.getText());
                        isFoundC=true;
                        for(int b=0;b<periodos.get(i).getCursos().get(a).getEstudiantes().size();b++){
                            if(periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getCodigo()==codEstudiante){
                                //double nota=Double.parseDouble(JOptionPane.showInputDialog(null,"Digite la nota definitiva del estudiante."));
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
    public void listados(boolean promCurso,boolean mejorEstd,boolean matriculados){
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
                                                        "\tNombre: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNombre()+
                                                        "\tPlan: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getPlan()+
                                                        "\tNota: "+periodos.get(i).getCursos().get(a).getEstudiantes().get(b).getNota()+"\n";
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bCrearCurso){ 
            addCurso();
        }
        if (e.getSource()==bCrearPeriodo){ 
            addPeriodo();
        }
        if (e.getSource()==bCrearEstudiante){ 
            registrarEstudiante();
        }
        if (e.getSource()==bMostrarCursos){ 
            if(periodos.isEmpty()){
                areaInfoPeriodo.setText("No se han añadido periodos");}
            else{
                String listaCursos="";
                for(int i=0;i<periodos.size();i++){
                    listaCursos=listaCursos+"Periodo N°"+(i+1)+":\n   Mes inicial: "+periodos.get(i).getMesInicio()+"\n"+
                                            "   Mes Final: "+periodos.get(i).getMesFinal()+"\n"+
                                            "   Año: "+periodos.get(i).getAno()+"\n     Cursos abiertos para este periodo:\n";
                    for(int a=0;a<periodos.get(i).getCursos().size();a++){
                        listaCursos=listaCursos+"        Codigo: "+periodos.get(i).getCursos().get(a).codigo+" "+
                                               "\n        Nombre: "+periodos.get(i).getCursos().get(a).nombre+" "+
                                               "\n        Créditos: "+periodos.get(i).getCursos().get(a).creditos+"\n";
                    }
                }
            areaInfoPeriodo.setText(listaCursos);
            }
        }
        if (e.getSource()==bInscribirEstudiante)
		{ 
		   inscribirEstudiante();
                }
        if (e.getSource()==bRegistrarNotas)
		{ 
		   registrarNotas();
                }
        if (e.getSource()==bPromedioCurso)
		{ 
		   listados(true,false,false);
                }
        if (e.getSource()==bMejorEstudianteCurso)
		{ 
		   listados(false,true,false);
                }
        if (e.getSource()==bEstudiantesMatriculadosCurso)
		{ 
		   listados(false,false,true);
                }
    }
    
    public static void main(String[] args) {
        Universidad universidad=new Universidad();
        universidad.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        universidad.setVisible(true);
    }
}
