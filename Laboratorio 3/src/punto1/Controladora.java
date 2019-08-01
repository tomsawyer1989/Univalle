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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora extends JFrame implements ActionListener{
    ArchObj archObj;
    ArchTxt archTxt;
    ArchBin archBin;
    Universidad universidad;
    String[] listaMeses;
    Container contenedor;
    private JTabbedPane tabbedPane;
    JPanel topPanel, panelUniversidad, panelEstudiantes, panelPeriodos, panelCursos,panelMatricula,
                panelNotas, panelInfo, panelListados, panelPeriodoNotas, panelAddNotas, panelAreaNotas,
            panelListadosPeriodo, panelListadosArea, panelFiles, panelCargarFiles;
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
            bMejorEstudianteCurso, bEstudiantesMatriculadosCurso,bGuardarObj,bGuardarTxt,bGuardarBin,
            bCargarTxt, bCargarBin, bCargarObj;
    JTextArea areaInfo = new JTextArea(5,28), areaInfoPeriodo= new JTextArea(10,30), areaListados= new JTextArea(6,25);
    JScrollPane scrollAreaInfoPeriodo = new JScrollPane(areaInfoPeriodo);
    JScrollPane scrollAreaListados = new JScrollPane(areaListados);
    
    //Constructor
    public Controladora() throws IOException, FileNotFoundException, ClassNotFoundException{
        universidad=new Universidad();
        archObj=new ArchObj();
        archTxt=new ArchTxt(universidad);
        archBin=new ArchBin(universidad);
        /*universidad=archObj.leer();*/
        /*archTxt.leer();*/
        //archBin.leer();
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
        topPanel = new JPanel();
	topPanel.setLayout(new BorderLayout());
        panelFiles=new JPanel();
        panelFiles.setLayout(new GridLayout(1,3));
        
        bGuardarObj=new JButton("Guardar .obj");
        bGuardarObj.addActionListener(this);
        bGuardarTxt=new JButton("Guardar .txt");
        bGuardarTxt.addActionListener(this);
        bGuardarBin=new JButton("Guardar .bin");
        bGuardarBin.addActionListener(this);
        bCargarObj=new JButton("Cargar .obj");
        bCargarObj.addActionListener(this);
        bCargarBin=new JButton("Cargar .bin");
        bCargarBin.addActionListener(this);
        bCargarTxt=new JButton("Cargar .txt");
        bCargarTxt.addActionListener(this);
       
        jtpCargar();
        jtpPeriodos();
	jtpEstudiantes();
	jtpMatricula();
        jtpNotas();
        jtpListados();
        
	tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Eliga un tipo de archivo a cargar", panelCargarFiles);
        topPanel.add(tabbedPane, BorderLayout.CENTER);
        
        panelFiles.add(bGuardarObj);
        panelFiles.add(bGuardarTxt);
        panelFiles.add(bGuardarBin);
	contenedor.add(topPanel);
        contenedor.add(panelFiles, BorderLayout.SOUTH);
        panelFiles.setVisible(false);
    }
    
    public void mostrarPestañas(){
        setSize(400,465);
        setLocationRelativeTo(null);
        tabbedPane.remove(0);
        tabbedPane.addTab("Periodos", panelUniversidad);
	tabbedPane.addTab("Estudiantes", panelEstudiantes);
	tabbedPane.addTab("Matriculas", panelMatricula);
        tabbedPane.addTab("Notas", panelNotas);
        tabbedPane.addTab("Listados", panelListados);
        topPanel.add(tabbedPane, BorderLayout.CENTER);
        panelFiles.setVisible(true);
    }
    //Pestaña elegir archivo a cargar
    public void jtpCargar(){
        panelCargarFiles = new JPanel();
        panelCargarFiles.setLayout(null);
        panelCargarFiles.add(bCargarObj);
        panelCargarFiles.add(bCargarTxt);
        panelCargarFiles.add(bCargarBin);
        bCargarObj.setBounds(70, 30, 120, 30);
        bCargarTxt.setBounds(70, 80, 120, 30);
        bCargarBin.setBounds(70, 130, 120, 30);
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
        cbMesInicial = new JComboBox(listaMeses);lMesFinal = new JLabel( "Ingrese el mes final" );
	cbMesFinal = new JComboBox(listaMeses);lAnho = new JLabel("Digite el año para el periodo");
        tfAnho = new JTextField(4);bCrearPeriodo = new JButton("Crear periodo");
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
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bCrearCurso){ 
            universidad.addCurso(tfCodigoCurso,tfNombreCurso,tfCreditosCurso);
        }
        if (e.getSource()==bCrearPeriodo){ 
            universidad.addPeriodo(cbMesInicial,cbMesFinal,tfAnho,tfCantidadCursos);
        }
        if (e.getSource()==bCrearEstudiante){ 
            universidad.registrarEstudiante(tfRegistrarCodigoEstudiante,tfRegistrarNombreEstudiante,tfRegistrarPlanEstudiante);
        }
        if (e.getSource()==bMostrarCursos){ 
            if(universidad.getPeriodos().isEmpty()){
                areaInfoPeriodo.setText("No se han añadido periodos");}
            else{
                String listaCursos="";
                for(int i=0;i<universidad.getPeriodos().size();i++){
                    listaCursos=listaCursos+"Periodo N°"+(i+1)+":\n   Mes inicial: "+universidad.getPeriodos().get(i).getMesInicio()+"\n"+
                                            "   Mes Final: "+universidad.getPeriodos().get(i).getMesFinal()+"\n"+
                                            "   Año: "+universidad.getPeriodos().get(i).getAno()+"\n     Cursos abiertos para este periodo:\n";
                    for(int a=0;a<universidad.getPeriodos().get(i).getCursos().size();a++){
                        listaCursos=listaCursos+"        Codigo: "+universidad.getPeriodos().get(i).getCursos().get(a).codigo+" "+
                                               "\n        Nombre: "+universidad.getPeriodos().get(i).getCursos().get(a).nombre+" "+
                                               "\n        Créditos: "+universidad.getPeriodos().get(i).getCursos().get(a).creditos+"\n";
                    }
                }
            areaInfoPeriodo.setText(listaCursos);
            }
        }
        if (e.getSource()==bInscribirEstudiante)
		{ 
		   universidad.inscribirEstudiante(areaInfoPeriodo,tfCompararCodigoCurso,tfCodigoEstudiante,tfNombreEstudiante,tfPlanEstudiante);
                }
        if (e.getSource()==bRegistrarNotas)
		{ 
		   universidad.registrarNotas(cbMesInicial,cbMesFinal,tfAnho,tfCompararCodigoCursoNotas,tfCompararCodigoEstudianteNotas,tfnotaEstudiante);
                }
        if (e.getSource()==bPromedioCurso)
		{ 
		   universidad.listados(cbMesInicialListados,cbMesFinalListados,tfAnhoListados,tfCodigoCursoListados,areaListados,true,false,false);
                }
        if (e.getSource()==bMejorEstudianteCurso)
		{ 
		   universidad.listados(cbMesInicialListados,cbMesFinalListados,tfAnhoListados,tfCodigoCursoListados,areaListados,false,true,false);
                }
        if (e.getSource()==bEstudiantesMatriculadosCurso)
		{ 
		   universidad.listados(cbMesInicialListados,cbMesFinalListados,tfAnhoListados,tfCodigoCursoListados,areaListados,false,false,true);
                }
        if (e.getSource()==bGuardarObj){
            archObj.escribir(universidad);
        }
        if (e.getSource()==bGuardarTxt){
            archTxt.setUniversidad(universidad);
            archTxt.escribir();
        }
        if (e.getSource()==bGuardarBin){
            archBin.setUniversidad(universidad);
            archBin.escribir();
        }
        if (e.getSource()==bCargarTxt){
            archTxt.leer();
            mostrarPestañas();
          }
        if (e.getSource()==bCargarObj){
            try {
                universidad=archObj.leer();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarPestañas();
          }
        if (e.getSource()==bCargarBin){
            archBin.leer();
            mostrarPestañas();
          }
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Controladora controladora=new Controladora();
        controladora.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        controladora.setSize(280,250);
        controladora.setLocationRelativeTo(null);
        controladora.setTitle( "Gestion de matriculas" );
        controladora.setVisible(true); 
    }
}