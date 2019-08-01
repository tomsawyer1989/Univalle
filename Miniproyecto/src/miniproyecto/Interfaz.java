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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Interfaz extends JFrame implements ActionListener{
    Sit sit;
    ManejadorDatos manDatos;
    ArchObj archObj;
    Fecha fecha;
    String[] listaTipo;
    String[] listaMeses;
    Container contenedor;
    JPanel jpPpal,jpCrear,jpAsignar,jpConsultar,jpListar,jpCrearB,jpCrearR,jpCrearT,jpConsultaB, jpConsultaR, jpConsultaT,
            jpOpcionesT, jpListarB, jpListarT, jpListarR, jpOperacionesT, jpAreaOperT,jpBotones;
    JTextField tfCodigoR,tfNombreR,tfDescripcionR,/*tfTipoR,*/tfPlacaB,tfModeloB,tfMarcaB,tfTipoB,tfCapacidadB,tfNumeroT,tfIdT,tfNombreT,tfDireccionT,tfFechaT,tfSaldoT, tfAsignarPlaca, tfAsignarRuta, tfConsultarB, tfConsultarR, tfConsultarT,
            tfOpcionesNumT;
    JLabel jlCodigoR,jlNombreR,jlDescripcionR,jlTipoR,jlPlacaB,jlModeloB,jlMarcaB,jlTipoB,jlCapacidadB,jlNumeroT,jlIdT,jlNombreT,jlDireccionT,jlFechaT,jlSaldoT, jlAsignarPlaca, jlAsignarRuta, jlConsultarB, jlConsultarR, jlConsultarT,
            jlOpcionesNumT, jlPasajerosMes, jlRecargasMes, jlMes;
    JButton jbCrearB,jbCrearR,jbCrearT, jbAsignarB, jbAceptar, jbCancelar, jbConsultarB,jbConsultarBBD, jbConsultarR,jbConsultarRBD, jbConsultarT,jbConsultarTBD, jbOpcionesT,
            jbRecargarT, JbDescontarT, jbCancelarOpc, jbListarB,jbListarBBD, jbListarT,jbListarTBD, jbListarR,jbListarRBD, jbOperacionesT, jbPasajerosMes, jbRecargasMes,
            jbCancelarOperT,jbGuardar,jbSalir;
    JTabbedPane tpPestanas;
    JComboBox jcbTipoB, jcbTipoR, jcbMeses;
    JTextArea areaConsultaB, areaConsultaR, areaConsultaT, areaListarB, areaListarT, areaListarR, areaOperT;
    JScrollPane spAreaConsultaB,spAreaConsultaT,spAreaConsultaR, spListarR, spListarB, spListarT, spAreaOperT; 
    public Interfaz() throws ClassNotFoundException{
        sit=new Sit();
        manDatos=new ManejadorDatos();
        manDatos.abrirConexionBD();
        archObj=new ArchObj();
        //sit=archObj.leer();
        listaTipo=new String[4];
        listaTipo[0]="Seleccionar";
        listaTipo[1]="Troncal";
        listaTipo[2]="Pre-Troncal";
        listaTipo[3]="Alimentadora";
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
        contenedor=getContentPane();
        contenedor.setLayout(new BorderLayout());
        jpPpal=new JPanel();
        jpPpal.setLayout(new BorderLayout());
        tpPestanas=new JTabbedPane();
        jpCrear();
        jpConsultar();
        jpListar();
        tpPestanas.addTab("Crear", jpCrear);
        tpPestanas.addTab("Consultar", jpConsultar);
        tpPestanas.addTab("Listar", jpListar);
        jpPpal.add(tpPestanas, BorderLayout.CENTER);
        jpBotones=new JPanel();
        jpBotones.setLayout(new GridLayout(1,2));
        jbGuardar=new JButton("Guardar");
        jbGuardar.addActionListener(this);
        jbSalir=new JButton("Salir");
        jbSalir.addActionListener(this);
        jpBotones.add(jbGuardar);
        jpBotones.add(jbSalir);
        contenedor.add(jpPpal);
        contenedor.add(jpBotones, BorderLayout.SOUTH);
        fecha=new Fecha(tfFechaT);
        fecha.start();
    }
    public void jpCrear(){
        jpCrear=new JPanel();
        jpCrearR=new JPanel();
        jpCrearR.setLayout(new GridLayout(5,2));
        jpCrearR.setBorder(BorderFactory.createTitledBorder("Crear ruta"));
        jpCrearB=new JPanel();
        jpCrearB.setLayout(new GridLayout(6,2));
        jpCrearB.setBorder(BorderFactory.createTitledBorder("Crear Bus"));
        jpCrearT=new JPanel();
        jpCrearT.setLayout(new GridLayout(7,2));
        jpCrearT.setBorder(BorderFactory.createTitledBorder("Crear Tarjeta"));
        jpCrear.add(jpCrearB);
        jpCrear.add(jpCrearR);
        jpCrear.add(jpCrearT);
        tfCodigoR=new JTextField(11);
        tfNombreR=new JTextField(11);
        tfDescripcionR=new JTextField(11);
        //tfTipoR=new JTextField(10);
        tfPlacaB=new JTextField(11);
        tfModeloB=new JTextField(11);
        tfMarcaB=new JTextField(11);
        tfTipoB=new JTextField(11);
        tfCapacidadB=new JTextField(11);
        tfCapacidadB.setEditable(false);
        tfNumeroT=new JTextField(11);
        tfIdT=new JTextField(11);
        tfNombreT=new JTextField(11);
        tfDireccionT=new JTextField(11);
        tfFechaT=new JTextField(11);
        tfFechaT.setEditable(false);
        tfSaldoT=new JTextField(10);
        jlCodigoR=new JLabel("Codigo: ");
        jlNombreR=new JLabel("Nombre: ");
        jlDescripcionR=new JLabel("Descripción: ");
        jlTipoR=new JLabel("Tipo: ");
        jlPlacaB=new JLabel("Placa: ");
        jlModeloB=new JLabel("Modelo: ");
        jlMarcaB=new JLabel("Marca: ");
        jlTipoB=new JLabel("Tipo: ");
        jlCapacidadB=new JLabel("Capacidad: ");
        jlNumeroT=new JLabel("Numero: ");
        jlIdT=new JLabel("Identificación: ");
        jlNombreT=new JLabel("Nombre: ");
        jlDireccionT=new JLabel("Dirección: ");
        jlFechaT=new JLabel("Fecha: ");
        jlSaldoT=new JLabel("Saldo: ");
        jbCrearR=new JButton("Crear");
        jbCrearR.addActionListener(this);
        jbCrearB=new JButton("Crear");
        jbCrearB.addActionListener(this);
        jbCrearT=new JButton("Crear");
        jbCrearT.addActionListener(this);
        jbAsignarB=new JButton("Asignar Bus");
        jbOpcionesT=new JButton("Opciones");
        jbOpcionesT.addActionListener(this);
        jbAsignarB.addActionListener(this);
        jcbTipoB=new JComboBox(listaTipo);
        jcbTipoB.addActionListener(this);
        jcbTipoR=new JComboBox(listaTipo);
        jcbTipoR.addActionListener(this);
        jpCrearR.add(jlCodigoR);
        jpCrearR.add(tfCodigoR);
        jpCrearR.add(jlNombreR);
        jpCrearR.add(tfNombreR);
        jpCrearR.add(jlDescripcionR);
        jpCrearR.add(tfDescripcionR);
        jpCrearR.add(jlTipoR);
        jpCrearR.add(jcbTipoR);
        jpCrearR.add(jbCrearR);
        jpCrearR.add(jbAsignarB);
        jpCrearB.add(jlPlacaB);
        jpCrearB.add(tfPlacaB);
        jpCrearB.add(jlModeloB);
        jpCrearB.add(tfModeloB);
        jpCrearB.add(jlMarcaB);
        jpCrearB.add(tfMarcaB);
        jpCrearB.add(jlTipoB);
        jpCrearB.add(jcbTipoB);
        jpCrearB.add(jlCapacidadB);
        jpCrearB.add(tfCapacidadB);
        jpCrearB.add(jbCrearB);
        jpCrearT.add(jlNumeroT);
        jpCrearT.add(tfNumeroT);
        jpCrearT.add(jlIdT);
        jpCrearT.add(tfIdT);
        jpCrearT.add(jlNombreT);
        jpCrearT.add(tfNombreT);
        jpCrearT.add(jlDireccionT);
        jpCrearT.add(tfDireccionT);
        jpCrearT.add(jlFechaT);
        jpCrearT.add(tfFechaT);
        jpCrearT.add(jlSaldoT);
        jpCrearT.add(tfSaldoT);
        jpCrearT.add(jbCrearT);
        jpCrearT.add(jbOpcionesT);
    }
    public void jpConsultar(){
        jpConsultar=new JPanel();
        jpConsultar.setLayout(new GridLayout(3,1));
        jpConsultaB=new JPanel();
        jpConsultaB.setBorder(BorderFactory.createTitledBorder("Consultar Bus"));
        jpConsultaR=new JPanel();
        jpConsultaR.setBorder(BorderFactory.createTitledBorder("Consultar Ruta"));
        jpConsultaT=new JPanel();
        jpConsultaT.setBorder(BorderFactory.createTitledBorder("Consultar Tarjeta"));
        areaConsultaB=new JTextArea(5,25);
        spAreaConsultaB=new JScrollPane(areaConsultaB);
        areaConsultaR=new JTextArea(5,25);
        spAreaConsultaR=new JScrollPane(areaConsultaR);
        areaConsultaT=new JTextArea(5,25);
        spAreaConsultaT=new JScrollPane(areaConsultaT);
        jlConsultarB =new JLabel("Placa");
        jlConsultarR=new JLabel("Nombre");
        jlConsultarT=new JLabel("Numero");
        tfConsultarB=new JTextField(10);
        tfConsultarR=new JTextField(10);
        tfConsultarT=new JTextField(10);
        jbConsultarB=new JButton("Consultar");
        jbConsultarB.addActionListener(this);
        jbConsultarBBD=new JButton("Consultar BD");
        jbConsultarBBD.addActionListener(this);
        jbConsultarR=new JButton("Consultar");
        jbConsultarR.addActionListener(this);
        jbConsultarRBD=new JButton("Consultar BD");
        jbConsultarRBD.addActionListener(this);
        jbConsultarT=new JButton("Consultar");
        jbConsultarT.addActionListener(this);
        jbConsultarTBD=new JButton("Consultar BD");
        jbConsultarTBD.addActionListener(this);
        jbOperacionesT=new JButton("Operaciones");
        jbOperacionesT.addActionListener(this);
        jpConsultar.add(jpConsultaB);
        jpConsultar.add(jpConsultaR);
        jpConsultar.add(jpConsultaT);
        jpConsultaB.add(jlConsultarB);
        jpConsultaB.add(tfConsultarB);
        jpConsultaB.add(jbConsultarB);
        jpConsultaB.add(jbConsultarBBD);
        jpConsultaB.add(spAreaConsultaB);
        jpConsultaR.add(jlConsultarR);
        jpConsultaR.add(tfConsultarR);
        jpConsultaR.add(jbConsultarR);
        jpConsultaR.add(jbConsultarRBD);
        jpConsultaR.add(spAreaConsultaR);
        jpConsultaT.add(jlConsultarT);
        jpConsultaT.add(tfConsultarT);
        jpConsultaT.add(jbConsultarT);
        jpConsultaT.add(jbConsultarTBD);
        jpConsultaT.add(jbOperacionesT);
        jpConsultaT.add(spAreaConsultaT);
        
    }
    public void jpListar(){
        jpListar=new JPanel();
        jpListar.setLayout(new GridLayout(3,1));
        jpListarB=new JPanel();
        jpListarB.setBorder(BorderFactory.createTitledBorder("Buses"));
        jpListarR=new JPanel();
        jpListarR.setBorder(BorderFactory.createTitledBorder("Rutas"));
        jpListarT=new JPanel();
        jpListarT.setBorder(BorderFactory.createTitledBorder("Tarjetas"));
        jbListarB=new JButton("Listar Buses");
        jbListarB.addActionListener(this);
        jbListarR=new JButton("Listar Rutas");
        jbListarR.addActionListener(this);
        jbListarT=new JButton("Listar Tarjetas");
        jbListarT.addActionListener(this);
        jbListarBBD=new JButton("Listar Buses BD");
        jbListarBBD.addActionListener(this);
        jbListarRBD=new JButton("Listar Rutas BD");
        jbListarRBD.addActionListener(this);
        jbListarTBD=new JButton("Listar Tarjetas BD");
        jbListarTBD.addActionListener(this);
        areaListarB=new JTextArea(7,25);
        spListarB=new JScrollPane(areaListarB);
        areaListarR=new JTextArea(7,25);
        spListarR=new JScrollPane(areaListarR);
        areaListarT=new JTextArea(7,25);
        spListarT=new JScrollPane(areaListarT);
        jpListar.add(jpListarB);
        jpListar.add(jpListarR);
        jpListar.add(jpListarT);
        jpListarB.add(jbListarB);
        jpListarB.add(jbListarBBD);
        jpListarB.add(spListarB);
        jpListarR.add(jbListarR);
        jpListarR.add(jbListarRBD);
        jpListarR.add(spListarR);
        jpListarT.add(jbListarT);
        jpListarT.add(jbListarTBD);
        jpListarT.add(spListarT);
    }
    /**
     * @param args the command line arguments
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==jcbTipoB){
            int index=jcbTipoB.getSelectedIndex();
            if(index==1){
                tfCapacidadB.setText("160");
            }
            else if(index==2){
                tfCapacidadB.setText("80");
            }
            else if(index==3){
                tfCapacidadB.setText("60");
            }  
        }
        if (e.getSource()==jbCrearB){
            try{
            sit.addBus(tfPlacaB.getText(),Integer.parseInt(tfModeloB.getText()),tfMarcaB.getText(),jcbTipoB.getSelectedItem().toString(),Integer.parseInt(tfCapacidadB.getText()));
            manDatos.addBusBD(tfPlacaB.getText(),Integer.parseInt(tfModeloB.getText()),tfMarcaB.getText(),jcbTipoB.getSelectedItem().toString(),Integer.parseInt(tfCapacidadB.getText()));
            }
            catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos");
            }
            
        }
        if (e.getSource()==jbCrearR){
            try{
            sit.addRuta(Integer.parseInt(tfCodigoR.getText()),tfNombreR.getText(),tfDescripcionR.getText(),jcbTipoR.getSelectedItem().toString());
            manDatos.addRutaBD(Integer.parseInt(tfCodigoR.getText()),tfNombreR.getText(),tfDescripcionR.getText(),jcbTipoR.getSelectedItem().toString());
            }
            catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos");
            }   
        }
        if (e.getSource()==jbCrearT){
            try{
            sit.addTarjeta(Integer.parseInt(tfNumeroT.getText()),Integer.parseInt(tfIdT.getText()),tfNombreT.getText(),tfDireccionT.getText(),tfFechaT.getText(),Integer.parseInt(tfSaldoT.getText()));
            manDatos.addTarjetaBD(Integer.parseInt(tfNumeroT.getText()),Integer.parseInt(tfIdT.getText()),tfNombreT.getText(),tfDireccionT.getText(),tfFechaT.getText(),Integer.parseInt(tfSaldoT.getText()));
            }
            catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Por favor ingrese valores validos");
            } 
            
        }
        if (e.getSource()==jbAsignarB){
            tpPestanas.setEnabledAt(1, false);
            tpPestanas.setEnabledAt(2, false);
            setSize(375,260);
            jpAsignar=new JPanel();
            jpAsignar.setLayout(new GridLayout(3,2));
            jpAsignar.setBorder(BorderFactory.createTitledBorder("Asignar Bus a una Ruta"));
            jpCrearR.setVisible(false);
            jpCrearB.setVisible(false);
            jpCrearT.setVisible(false);
            jlAsignarPlaca=new JLabel("Placa del Bus: ");
            jlAsignarRuta=new JLabel("Nombre de la Ruta: ");
            tfAsignarPlaca=new JTextField(10);
            tfAsignarRuta=new JTextField(10);
            jbAceptar=new JButton("Aceptar");
            jbAceptar.addActionListener(this);
            jbCancelar=new JButton("Cancelar");
            jbCancelar.addActionListener(this);
            jpAsignar.add(jlAsignarPlaca);
            jpAsignar.add(tfAsignarPlaca);
            jpAsignar.add(jlAsignarRuta);
            jpAsignar.add(tfAsignarRuta);
            jpAsignar.add(jbAceptar);
            jpAsignar.add(jbCancelar);
            jpCrear.add(jpAsignar);
        }
        if (e.getSource()==jbAceptar){
            tpPestanas.setEnabledAt(1, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpCrearR.setVisible(true);
            jpCrearB.setVisible(true);
            jpCrearT.setVisible(true);
            jpAsignar.setVisible(false);
            sit.addBusRuta(tfAsignarPlaca.getText(),tfAsignarRuta.getText());
        }
        if (e.getSource()==jbCancelar){
            tpPestanas.setEnabledAt(1, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpCrearR.setVisible(true);
            jpCrearB.setVisible(true);
            jpCrearT.setVisible(true); 
            jpAsignar.setVisible(false);
        }
        if (e.getSource()==jbConsultarB){
            areaConsultaB.setText(sit.consultarB(tfConsultarB.getText()));
        }
        if (e.getSource()==jbConsultarBBD){
            String texto="";
            Bus bus=null;
            bus=manDatos.consultarBBD(tfConsultarB.getText());
            if (bus==null){
                JOptionPane.showMessageDialog(this, "Bus no encontrado");
                System.out.print("Bus no encontrado");       
            }
            else{
                texto=  "placa: "+bus.getPlaca()+
                        "\nModelo: "+bus.getModelo()+
                        "\nMarca: "+bus.getMarca()+
                        "\nTipo "+bus.getTipo()+
                        "\nCapacidad: "+bus.getCapacidad();
                areaConsultaB.setText(texto);
                System.out.print(bus.getPlaca()+bus.getModelo()+bus.getMarca()+bus.getTipo()+bus.getCapacidad());
            }
        }
        if (e.getSource()==jbConsultarR){
            areaConsultaR.setText(sit.consultarR(tfConsultarR.getText()));
        }
        if (e.getSource()==jbConsultarRBD){
            String texto="";
            Ruta ruta=null;
            ruta=manDatos.consultarRBD(tfConsultarR.getText());
            if (ruta==null){
                JOptionPane.showMessageDialog(this, "Ruta no encontrada");
                System.out.print("Ruta no encontrada");       
            }
            else{
                texto=  "Codigo: "+ruta.getCodigo()+
                        "\nNombre: "+ruta.getNombre()+
                        "\nDescripcion: "+ruta.getDescripcion()+
                        "\nTipo: "+ruta.getTipo();
                areaConsultaR.setText(texto);
                System.out.print(ruta.getCodigo()+ruta.getNombre()+ruta.getDescripcion()+ruta.getTipo());
            }
        }
        if (e.getSource()==jbConsultarT){
            areaConsultaT.setText(sit.consultarT(Integer.parseInt(tfConsultarT.getText())));
        }
        if (e.getSource()==jbConsultarTBD){
            String texto="";
            Tarjeta tarjeta=null;
            tarjeta=manDatos.consultarTBD(Integer.parseInt(tfConsultarT.getText()));
            if (tarjeta==null){
                JOptionPane.showMessageDialog(this, "Tarjeta no encontrada");
                System.out.print("Tarjeta no encontrada");       
            }
            else{
                texto=  "Numero: "+tarjeta.getNumero()+
                        "\nId: "+tarjeta.getId()+
                        "\nNombre: "+tarjeta.getNombre()+
                        "\nDireccion: "+tarjeta.getDireccion()+
                        "\nFecha: "+tarjeta.getFecha()+
                        "\nSaldo: "+tarjeta.getSaldo();
                areaConsultaT.setText(texto);
                System.out.print(tarjeta.getNumero()+tarjeta.getId()+tarjeta.getNombre()+tarjeta.getDireccion()+tarjeta.getFecha()+tarjeta.getSaldo());
            }
        }
        if (e.getSource()==jbOpcionesT){
            tpPestanas.setEnabledAt(1, false);
            tpPestanas.setEnabledAt(2, false);
            setSize(375,260);
            jpOpcionesT=new JPanel();
            jpOpcionesT.setLayout(new GridLayout(3,2));
            jpOpcionesT.setBorder(BorderFactory.createTitledBorder("Opciones de tarjeta"));
            jpCrearR.setVisible(false);
            jpCrearB.setVisible(false);
            jpCrearT.setVisible(false);
            jlOpcionesNumT=new JLabel("Numero de tarjeta");
            jbRecargarT=new JButton("Recargar");
            jbRecargarT.addActionListener(this);
            JbDescontarT=new JButton("Descontar");
            JbDescontarT.addActionListener(this);
            jbCancelarOpc=new JButton("Cancelar");
            jbCancelarOpc.addActionListener(this);
            tfOpcionesNumT=new JTextField(10);
            jpOpcionesT.add(jlOpcionesNumT);
            jpOpcionesT.add(tfOpcionesNumT);
            jpOpcionesT.add(jbRecargarT);
            jpOpcionesT.add(JbDescontarT);
            jpOpcionesT.add(jbCancelarOpc);
            jpCrear.add(jpOpcionesT);
        }
        if (e.getSource()==jbCancelarOpc){
            tpPestanas.setEnabledAt(1, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpCrearR.setVisible(true);
            jpCrearB.setVisible(true);
            jpCrearT.setVisible(true); 
            jpOpcionesT.setVisible(false);
        }
        if (e.getSource()==jbRecargarT){
            String valor=JOptionPane.showInputDialog(null,"Digite el valor de la recarga.");
            if(valor==null){
            }
            else{
               try{
                   sit.recargarT(Integer.parseInt(tfOpcionesNumT.getText()), Integer.parseInt(valor),fecha.getFecha());
               } 
               catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null,"Compruebe que el número de la tarjeta y el valor de la recarga sean válidos.");
               } 
            }
            tpPestanas.setEnabledAt(1, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpCrearR.setVisible(true);
            jpCrearB.setVisible(true);
            jpCrearT.setVisible(true); 
            jpOpcionesT.setVisible(false);
        }
        if (e.getSource()==JbDescontarT){
            String nPasajes=JOptionPane.showInputDialog(null,"Digite el número de pasajes a descontar (cada pasaje vale $2000).");
            if(nPasajes==null){
            }
            else{
               try{
                   sit.descontarT(Integer.parseInt(tfOpcionesNumT.getText()), Integer.parseInt(nPasajes),fecha.getFecha());
               } 
               catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(null,"Compruebe que el número de la tarjeta y el número de pasajes sean válidos.");
               } 
            }
            tpPestanas.setEnabledAt(1, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpCrearR.setVisible(true);
            jpCrearB.setVisible(true);
            jpCrearT.setVisible(true); 
            jpOpcionesT.setVisible(false);
        }
        if (e.getSource()==jbListarT){
            areaListarT.setText(sit.listarT());
        }
        if (e.getSource()==jbListarB){
            areaListarB.setText(sit.listarB());
        }
        if (e.getSource()==jbListarR){
            areaListarR.setText(sit.listarR());
        }
        if (e.getSource()==jbListarTBD){
            areaListarT.setText(manDatos.listarTBD());
        }
        if (e.getSource()==jbListarBBD){
            areaListarB.setText(manDatos.listarBBD());
        }
        if (e.getSource()==jbListarRBD){
            areaListarR.setText(manDatos.listarRBD());
        }
        if (e.getSource()==jbOperacionesT){
            setSize(375,405);
            tpPestanas.setEnabledAt(0, false);
            tpPestanas.setEnabledAt(2, false);
            jpConsultar.setLayout(new FlowLayout());
            jpOperacionesT=new JPanel();
            jpOperacionesT.setLayout(new GridLayout(4,2));
            jpOperacionesT.setBorder(BorderFactory.createTitledBorder("Operaciones"));
            jpAreaOperT=new JPanel();
            jpAreaOperT.setLayout(new FlowLayout());
            jpAreaOperT.setBorder(BorderFactory.createTitledBorder("Operaciones"));
            jpConsultaR.setVisible(false);
            jpConsultaB.setVisible(false);
            jpConsultaT.setVisible(false);
            jlMes=new JLabel("Por favor seleccione un mes    ");
            jlPasajerosMes=new JLabel("Pasajeros movilizados");
            jlRecargasMes=new JLabel("Recargas realizadas");
            jbPasajerosMes=new JButton("Consultar");
            jbPasajerosMes.addActionListener(this);
            jbRecargasMes=new JButton("Consultar");
            jbRecargasMes.addActionListener(this);
            jbCancelarOperT=new JButton("Cancelar");
            jbCancelarOperT.addActionListener(this);
            jcbMeses= new JComboBox(listaMeses);
            areaOperT=new JTextArea(9,31);
            spAreaOperT=new JScrollPane(areaOperT);
            jpOperacionesT.add(jlMes);
            jpOperacionesT.add(jcbMeses);
            jpOperacionesT.add(jlRecargasMes);
            jpOperacionesT.add(jbRecargasMes);
            jpOperacionesT.add(jlPasajerosMes);
            jpOperacionesT.add(jbPasajerosMes);
            jpOperacionesT.add(jbCancelarOperT);
            jpAreaOperT.add(spAreaOperT);
            
            
            jpConsultar.add(jpOperacionesT);
            jpConsultar.add(jpAreaOperT);
        }
        if (e.getSource()==jbCancelarOperT){
            jpConsultar.setLayout(null);
            tpPestanas.setEnabledAt(0, true);
            tpPestanas.setEnabledAt(2, true);
            setSize(375,650);
            jpConsultaR.setVisible(true);
            jpConsultaB.setVisible(true);
            jpConsultaT.setVisible(true);
            jpOperacionesT.setVisible(false);
            jpAreaOperT.setVisible(false);
        }
        if (e.getSource()==jbPasajerosMes){
            areaOperT.setText(sit.usersMensual(jcbMeses.getSelectedIndex()));
        }
        if (e.getSource()==jbRecargasMes){
            areaOperT.setText(sit.recargasMensual(jcbMeses.getSelectedIndex()));
        }
        if (e.getSource()==jbGuardar){
            archObj.escribir(sit);
        }
        if (e.getSource()==jbSalir){
            manDatos.cerrarConexionBD();
            System.exit(0);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Interfaz control=new Interfaz();
        control.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        control.setSize(375,650);
        control.setLocationRelativeTo(null);
        control.setTitle( "Sistema Integrado de Transporte (SIT)" );
        control.setResizable(false);//no redimensionar ventana
        control.setUndecorated(true);
        control.setVisible(true);
    }
}
