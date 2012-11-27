package Pantallas;

import java.math.*;
import java.awt.Choice;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Base.metodosSql;
import Formateador.CellNoEditableCol0y1;
import Formateador.Formato;
import Formateador.JtableNoEditable;
import Imprenta.Control;
import Imprenta.Imprenta;
import Imprenta.OrdenDeTrabajo;
import Imprenta.Producto;

import com.jpcomponents.JPCalendar;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JFrame;
import java.awt.BorderLayout;

@SuppressWarnings("unused")
public class OrdenTrabajo extends JPanel {
	
	
	public static int tiempoOrdenTrabajo;
	private static final long serialVersionUID = 1L;
	private JtableNoEditable modeloMateriales;
	private CellNoEditableCol0y1 modeloTareas;
	public static JTextField FechaConfeccion = null;
	private JLabel jLabel = null;
	private JTextField OrdenNro = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	public static JTextField FechaPrometida = null;
	private JLabel jLabel4 = null;
	private JTextField nombreTrabajo = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField ancho = null;
	private JTextField alto = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JTextField CantidadAEntregar = null;
	private JTextField cantidadUniTrabajo = null;
	private JLabel jLabel14 = null;
	private JEditorPane Descripcion = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableMateriales = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JLabel jLabel19 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JScrollPane jScrollPaneTarea = null;
	private JTable jTableTarea = null;
	private Choice choiceTareas = null;
	private Choice choiceProveedor = null;
	private Choice Producto = null;
	private Choice choiceElementoDelProducto = null;
	private Choice choiceCalidad = null;
	private Choice choiceVariante = null;
	private Choice choiceFormato = null;
	private JLabel jLabel20 = null;
	private JLabel jLabel21 = null;
	private JLabel jLabel23 = null;
	private JLabel jLabel24 = null;
	private JPanel jPanelMateriales = null;
	private JButton jButtonAgregarMaterial = null;
	private JLabel jLabel11 = null;
	private JCheckBox apaisado = null;
	private JLabel jLabel22 = null;
	private JPanel jPanel = null;
	private JLabel jLabel25 = null;
	private JLabel jLabel26 = null;
	private JLabel jLabel27 = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableElementos = null;
	private JLabel SecciónElementos = null;
	private JLabel Elemento = null;
	private JLabel Cantidad = null;
	private JTextField jTextFieldElemento = null;
	private JTextField jTextFieldCantidad = null;
	private JButton jButtonCargarElemento = null;
	/**
	 * This is the default constructor
	 */
	public OrdenTrabajo() {
		super();
		
		initialize();
		inicializarCampos();
	}
	private void inicializarCampos(){
		
		ArrayList<String >datos=null;
		metodosSql metodos=new metodosSql();
		Formato f=new Formato();
		FechaConfeccion.setText(metodos.dameFechaDeHoyConFormatoX("yyyy'-'MM'-'dd"));
		int maxNroOrden=1;
		if(!metodos.consultarUnaColumna("SELECT count(nroOrden) FROM imprenta.ordentrabajo;").get(0).equals("0")){
			maxNroOrden=maxNroOrden+Integer.parseInt(metodos.consultarUnaColumna("SELECT max(nroOrden) FROM imprenta.ordentrabajo;").get(0));
		}
		
		OrdenNro.setText(String.valueOf(f.enMascarar("0001-", String.valueOf(maxNroOrden))[0]));
		jTextFieldDesenmascarado.setText(f.enMascarar("0001-", String.valueOf(maxNroOrden))[1]);
		datos=null;
		datos=metodos.consultarUnaColumna("select descripcion from imprenta.calidad");
		for(int i=0;i<datos.size();i++){
	    choiceCalidad.add(datos.get(i));
		}
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT descripcion FROM imprenta.variante;");
		for(int i=0;i<datos.size();i++){
		choiceVariante.add(datos.get(i));
			
		}
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT descripcion FROM imprenta.formatopapel");
		for(int i=0;i<datos.size();i++){
		choiceFormato.add(datos.get(i));
			
		}
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT DESCRIPCION FROM imprenta.tarea;");
		for(int i=0;i<datos.size();i++){
		choiceTareas.add(datos.get(i));
			
		}
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT razonsocial FROM imprenta.proveedor where idproveedor != 1000;");// mil es CMYK
		for(int i=0;i<datos.size();i++){
		choiceProveedor.add(datos.get(i));
			
		}
		datos=metodos.consultarUnaColumna("SELECT razonSocial FROM imprenta.cliente;");
		for(int i=0;i<datos.size();i++){
		choiceCliente.add(datos.get(i));
			
		}
		
		
		modeloMateriales.addColumn("Elemento");
		modeloMateriales.addColumn("Cantidad");
		modeloMateriales.addColumn("Calidad");
		modeloMateriales.addColumn("Variante");
		modeloMateriales.addColumn("Gramaje");
		modeloMateriales.addColumn("Formato");
		modeloMateriales.addColumn("PXPliego");
		modeloMateriales.addColumn("Pnetos");//se debe autocalcular
		modeloMateriales.addColumn("PenDemasia");
		modeloMateriales.addColumn("PXhoja");
		modeloMateriales.addColumn("Hojas");
		
		
		
		/*Elemento (debe ser uno de los elementos del producto), Calidad, Variante, Gramaje,
		Formato, Poses x Pliego, Pliegos Netos (autocalculado), Pliegos en Demasia, Pliegos x
		Hoja, Hojas (se autocalcula).*/
		//this.jTable=new JTable(modelo);
		//setearJtable(jTable, aux);
	
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel13 = new JLabel();
		jLabel13.setText("Terceriza");
		jLabel13.setBounds(new Rectangle(117, 24, 62, 16));
		Cantidad = new JLabel();
		Cantidad.setText("Cantidad");
		Cantidad.setBounds(new Rectangle(69, 25, 53, 16));
		Elemento = new JLabel();
		Elemento.setText("Elemento");
		Elemento.setBounds(new Rectangle(6, 25, 62, 16));
		SecciónElementos = new JLabel();
		SecciónElementos.setText("Sección elementos");
		SecciónElementos.setBounds(new Rectangle(5, 5, 112, 16));
		jLabel22 = new JLabel();
		jLabel22.setText("Apaisado");
		jLabel22.setBounds(new Rectangle(115, 130, 57, 19));
		jLabel24 = new JLabel();
		jLabel24.setText("Formato");
		jLabel24.setBounds(new Rectangle(598, 24, 47, 16));
		jLabel23 = new JLabel();
		jLabel23.setText("Gramaje");
		jLabel23.setBounds(new Rectangle(383, 22, 48, 16));
		jLabel21 = new JLabel();
		jLabel21.setText("Variante");
		jLabel21.setBounds(new Rectangle(293, 22, 63, 16));
		jLabel20 = new JLabel();
		jLabel20.setText("Calidad");
		jLabel20.setBounds(new Rectangle(199, 22, 42, 16));
		jLabel19 = new JLabel();
		jLabel19.setText("Proveedor tercerizado");
		jLabel19.setBounds(new Rectangle(179, 24, 122, 16));
		jLabel19.setVisible(false);
		jLabel18 = new JLabel();
		jLabel18.setText("Tareas del trabajo");
		jLabel18.setBounds(new Rectangle(6, 24, 109, 16));
		jLabel17 = new JLabel();
		jLabel17.setText("Sección Orden de Ejecución");
		jLabel17.setBounds(new Rectangle(7, 4, 172, 17));
		jLabel16 = new JLabel();
		jLabel16.setText("Cantidad de Planchas (nro)");
		jLabel16.setBounds(new Rectangle(7, 177, 161, 21));
		jLabel15 = new JLabel();
		jLabel15.setText("Sección PreImpresión");
		jLabel15.setBounds(new Rectangle(8, 151, 133, 21));
		jLabel14 = new JLabel();
		jLabel14.setText("Sección de Materiales");
		jLabel14.setBounds(new Rectangle(171, 5, 135, 23));
		jLabel10 = new JLabel();
		jLabel10.setText("Cantidad a Entregar");
		jLabel10.setBounds(new Rectangle(8, 205, 120, 16));
		jLabel9 = new JLabel();
		jLabel9.setText("Producto");
		jLabel9.setBounds(new Rectangle(9, 181, 61, 16));
		jLabel8 = new JLabel();
		jLabel8.setText("Alto Cm");
		jLabel8.setBounds(new Rectangle(255, 130, 46, 16));
		jLabel7 = new JLabel();
		jLabel7.setText("Ancho Cm");
		jLabel7.setBounds(new Rectangle(178, 130, 60, 16));
		jLabel6 = new JLabel();
		jLabel6.setText("Medida Final.");
		jLabel6.setBounds(new Rectangle(6, 130, 81, 16));
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(826, 41, 76, 16));
		jLabel5.setText("Descripción");
		jLabel4 = new JLabel();
		jLabel4.setText("Nombre corto del trabajo.");
		jLabel4.setBounds(new Rectangle(5, 108, 144, 16));
		jLabel3 = new JLabel();
		jLabel3.setText("Fecha Prometida");
		jLabel3.setBounds(new Rectangle(5, 78, 119, 16));
		jLabel2 = new JLabel();
		jLabel2.setText("Fecha de confección");
		jLabel2.setBounds(new Rectangle(6, 56, 117, 16));
		jLabel1 = new JLabel();
		jLabel1.setText("Cliente");
		jLabel1.setBounds(new Rectangle(6, 35, 78, 16));
		jLabel = new JLabel();
		jLabel.setText("Orden N°");
		jLabel.setBounds(new Rectangle(6, 13, 51, 16));
		this.setSize(1215, 632);
		this.setLayout(null);
		this.setBackground(Color.white);
		//this.setTitle("Orden de trabajo");
		this.setName("contenedor");
		this.setBackground(SystemColor.controlHighlight);
		//this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		this.add(jLabel5, null);
		this.add(getDescripcion(), null);
		this.add(getJScrollPane(), null);
		this.add(getJButton1(), null);
		
		this.add(getJTextFieldDesenmascarado(), null);
		this.add(getJPanel1(), null);
		this.add(getJPanel2(), null);
		this.add(getJPanel3(), null);
		this.add(getJPanel5(), null);
		this.add(getJPanel4(), null);
		this.add(getJButtonTest(), null);
		
	}

	/**
	 * This method initializes FechaConfeccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFechaConfeccion() {
		if (FechaConfeccion == null) {
			FechaConfeccion = new JTextField();
			FechaConfeccion.setName("FechaConfeccion");
			FechaConfeccion.setBounds(new Rectangle(171, 58, 122, 20));
			FechaConfeccion.setEditable(false);
		}
		return FechaConfeccion;
	}

	/**
	 * This method initializes OrdenNro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOrdenNro() {
		if (OrdenNro == null) {
			OrdenNro = new JTextField();
			OrdenNro.setEditable(false);
			OrdenNro.setBounds(new Rectangle(171, 12, 122, 20));
		}
		return OrdenNro;
	}

	/**
	 * This method initializes FechaPrometida	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFechaPrometida() {
		if (FechaPrometida == null) {
			FechaPrometida = new JTextField();
			FechaPrometida.setName("Fechaprometida");
			FechaPrometida.setBounds(new Rectangle(171, 82, 122, 20));
			FechaPrometida.setEditable(false);
		}
		return FechaPrometida;
	}

	/**
	 * This method initializes nombreTrabajo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNombreTrabajo() {
		if (nombreTrabajo == null) {
			nombreTrabajo = new JTextField();
			nombreTrabajo.setBounds(new Rectangle(171, 105, 122, 21));
		}
		return nombreTrabajo;
	}

	/**
	 * This method initializes ancho	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAncho() {
		if (ancho == null) {
			ancho = new JTextField();
			ancho.setBounds(new Rectangle(189, 149, 50, 22));
			ancho.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						Control c=new Control();
						int aux=ancho.getText().length();
						if(c.esNumero(ancho.getText().charAt(aux-1))==false){
							JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
							ancho.setText("");
							
						}
						if(c.hayMasDeUnPunto(ancho.getText())){
							JOptionPane.showMessageDialog(null, "Ingrese sólo un punto!");
							ancho.setText("");
							
						}
						}catch(Exception e1){};
						
				}
			});
		}
		return ancho;
	}

	/**
	 * This method initializes alto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAlto() {
		if (alto == null) {
			alto = new JTextField();
			alto.setBounds(new Rectangle(251, 149, 50, 21));
			alto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						Control c=new Control();
						int aux=alto.getText().length();
						if(c.esNumero(alto.getText().charAt(aux-1))==false){
							JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
							alto.setText("");
							
						}
						if(c.hayMasDeUnPunto(alto.getText())){
							JOptionPane.showMessageDialog(null, "Ingrese sólo un punto!");
							alto.setText("");
							
						}
						}catch(Exception e1){};
						
				}
			});
		}
		return alto;
	}

	/**
	 * This method initializes CantidadAEntregar	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadAEntregar() {
		if (CantidadAEntregar == null) {
			CantidadAEntregar = new JTextField();
			CantidadAEntregar.setBounds(new Rectangle(172, 205, 121, 21));
			CantidadAEntregar.addKeyListener(new java.awt.event.KeyAdapter() {   
				 
				   
				public void keyReleased(java.awt.event.KeyEvent e) {
					
					try{
					Control c=new Control();
					int aux=CantidadAEntregar.getText().length();
					if(c.esNumero(CantidadAEntregar.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						CantidadAEntregar.setText("");
						
					}
					if(e.getKeyCode()==KeyEvent.VK_ENTER){
						System.out.println("estas apretando enter");
						CantidadPlanchas.requestFocus();
					}
					}catch(Exception e1){};
					
					
					
					
				}
			});
			
			
		}
		return CantidadAEntregar;
	}

	/**
	 * This method initializes cantidadUniTrabajo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
/*	private JTextField getCantidadUniTrabajo() {
		if (cantidadUniTrabajo == null) {
			cantidadUniTrabajo = new JTextField();
			cantidadUniTrabajo.setBounds(new Rectangle(641, 306, 42, 21));
		}
		return cantidadUniTrabajo;
	}*/

	/**
	 * This method initializes Descripcion	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getDescripcion() {
		if (Descripcion == null) {
			Descripcion = new JEditorPane();
			Descripcion.setBounds(new Rectangle(634, 59, 546, 65));
			Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_TAB){
						
						getChoiceElementoDelProductoCargadoAMano().requestFocus();
}
					
					
					
					
				}
			});
			
		}
		return Descripcion;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(356, 405, 824, 119));
			jScrollPane.setViewportView(getJTableMateriales());
			jScrollPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableMateriales	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMateriales() {
		
		modeloMateriales=new JtableNoEditable();
		if (jTableMateriales == null) {
			jTableMateriales = new JTable(modeloMateriales);
			jTableMateriales.setCellSelectionEnabled(true);
			
		}
		return jTableMateriales;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private boolean estaLaTarea(String tarea){
		int columna=0;
		for(int fila=0;fila<modeloTareas.getRowCount();fila++){
			if(modeloTareas.getValueAt(fila, columna).toString().equals(tarea)){
				return true;
			}
		}
		
		return false;
	}
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Agregar Tarea");
			jButton.setBounds(new Rectangle(221, 68, 101, 21));
			
				
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(estaLaTarea(getChoiceTareas().getSelectedItem())==false){
					Object[]fila=new Object[2];
					fila[0]=getChoiceTareas().getSelectedItem();
					if(jCheckBoxTerciariza.isSelected()){
					fila[1]=getChoiceProveedor().getSelectedItem();
					}else{
						fila[1]="";
					}
					modeloTareas.addRow(fila);
					}
					else{
						JOptionPane.showMessageDialog(null, "No se puede repetir la tarea");
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private boolean estaTodoOK(){
		if(jTableTarea.getRowCount()==0){
			JOptionPane.showMessageDialog(null,"Cargue al menos una tarea!");
			return false;
			
		}if(jTableMateriales.getRowCount()==0){
			JOptionPane.showMessageDialog(null,"Cargue al menos un material!");
			return false;
			
		}if(jTableElementos.getRowCount()==0){
			JOptionPane.showMessageDialog(null,"Cargue al menos un elemento!");
			return false;
			
		}
		
		return true;
	}
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(961, 542, 229, 44));
			jButton1.setText("Finalizar carga de OT");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {		
					
					/*guardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {*/
					
					try{
						if(estaTodoOK()==true){
					int status=0;
					Imprenta imprenta=new Imprenta();
					
					OrdenDeTrabajo OT=new OrdenDeTrabajo(Integer.parseInt(getJTextFieldDesenmascarado().getText()));
					
					OT.setAlto(Double.parseDouble((getAlto().getText())));
					
					OT.setAncho(Double.parseDouble(getAncho().getText()));
					
					if(getApaisado().isEnabled()){
					OT.setApaisado("Es apaisado");
					}
					
					
					
					OT.setCantidadPlanchas(Integer.parseInt(getCantidadPlanchas().getText()));
					
					OT.setCliente(choiceCliente.getSelectedItem());
					
					OT.setDescripcion(getDescripcion().getText());
					
					OT.setEstado("ACTIVO");
					
					OT.setFechaConfeccion(getFechaConfeccion().getText());
					
					OT.setFechaEntrega(getFechaPrometida().getText());
					
					Producto producto=new Producto(getJTextFieldProducto().getText(),
							
							Integer.parseInt(CantidadAEntregar.getText()),
							
							jTableMateriales);
					
					OT.setProducto(producto);
					OT.getProducto().setCantidad(Integer.parseInt(getCantidadAEntregar().getText()));
					
					
					
					OT.setNombreTrabajo(getNombreTrabajo().getText());
					
					OT.setTareas(getJTableTarea());
					int rows=getJTableElementos().getRowCount();
					
				
					status=Imprenta.llenarOrdenTrabajo(OT);
					if(status==3){
						JOptionPane.showMessageDialog(null, "datos cargados con éxito!");
					//	dispose();
						jButton1.setEnabled(false);
						jButton1.setText("Salir clickeando X");
						jButtonBorrarMaterial.setEnabled(false);
						jButtonAgregarMaterial.setEnabled(false);
						jButton.setEnabled(false);
						jButtonBorrarElemento.setEnabled(false);
						jButtonCargarElemento.setEnabled(false);
						jButtonBajar.setEnabled(false);
						jButtonSubir.setEnabled(false);
						jButtonBorrar.setEnabled(false);
						
					}else{
						JOptionPane.showMessageDialog(null, "datos no se cargaron correctamente... revise la ot cargada");
						//dispose();
					}
					
					}else{
						
					}
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null,e3.getMessage()+" linea 605 ordentrabajo");
						
						
					} catch (Throwable e20) {
						// TODO Auto-generated catch block
						((Throwable) e20).printStackTrace();
					}
					
					
					
					
				}
					
			});
			
					
					
					

		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
//	/*private JButton getJButton2() {
//		if (jButton2 == null) {
//			jButton2 = new JButton();
//			jButton2.setBounds(new Rectangle(373, 90, 20, 18));
//			jButton2.addActionListener(new java.awt.event.ActionListener() {
//				public void actionPerformed(java.awt.event.ActionEvent e) {
//					Calendario c=new Calendario(FechaConfeccion);
//					
//					c.setVisible(true);
//					//FechaConfeccion.setText(c.getFecha());
//				
//					//FechaConfeccion.setText();
//
//				
//				/*-	SimpleDateFormat fechaforma = new SimpleDateFormat("dd/MM/yyyy");
//					String FfechaSystemA = fechaforma.format(fecha);
//
//
//					//String f=fecha.toString();
//					FechaConfeccion.setText(FfechaSystemA);*/
//
//				
//					
//								
//				}
//			});
//		}
//		return jButton2;
//	}
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(294, 82, 11, 18));
			jButton3.setText("...");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Calendario c=new Calendario(FechaPrometida);
					
					c.setVisible(true);
					//FechaConfeccion.setText(c.getFecha());
				
					//FechaConfeccion.setText();

				
				/*-	SimpleDateFormat fechaforma = new SimpleDateFormat("dd/MM/yyyy");
					String FfechaSystemA = fechaforma.format(fecha);


					//String f=fecha.toString();
					FechaConfeccion.setText(FfechaSystemA);*/

				
					
								
				}
			});
		}
		return jButton3;
	}
	/**
	 * This method initializes jScrollPaneTarea	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTarea() {
		if (jScrollPaneTarea == null) {
			jScrollPaneTarea = new JScrollPane();
			jScrollPaneTarea.setBounds(new Rectangle(8, 84, 211, 95));
			jScrollPaneTarea.setViewportView(getJTableTarea());
		}
		return jScrollPaneTarea;
	}
	/**
	 * This method initializes jTableTarea	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableTarea() {
		modeloTareas=new CellNoEditableCol0y1();	
		modeloTareas.addColumn("Tarea");
		modeloTareas.addColumn("Proveedor");
		
		if (jTableTarea == null) {
			jTableTarea = new JTable(modeloTareas);
			jTableTarea.setAutoResizeMode(1);
			
			
			
			
		}
		return jTableTarea;
	}
	/**
	 * This method initializes choiceTareas	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceTareas() {
		if (choiceTareas == null) {
			choiceTareas = new Choice();
			choiceTareas.setBounds(new Rectangle(3, 43, 118, 21));
			choiceTareas.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					jButton.doClick();
					
				}
			});
		}
		return choiceTareas;
	}
	/**
	 * This method initializes choiceProveedor	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceProveedor() {
		if (choiceProveedor == null) {
			choiceProveedor = new Choice();
			choiceProveedor.setVisible(false);
			choiceProveedor.setBounds(new Rectangle(145, 43, 133, 21));
			choiceProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					jButton.doClick();
					System.out.println("keyTyped()"); // TODO Auto-generated Event stub keyTyped()
				}
			});
		}
		return choiceProveedor;
	}
	/**
	 * This method initializes Producto	
	 * 	
	 * @return java.awt.Choice	
	 */
	
	/*
	private Choice getProducto() {
		if (Producto == null) {
			Producto = new Choice();
			Producto.setBounds(new Rectangle(458, 44, 87, 21));
			Producto.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					
					
					
					try{
					metodosSql metodos=new metodosSql();
					ArrayList<String>datos=null;
						int index=metodos.teDoyNombreProductoDameNumeroID(Producto.getSelectedItem().toString());
					//choiceElementoDelProducto.add
					datos=metodos.consultarUnaColumna("SELECT descripcion FROM imprenta.elementosproducto  where idTipoproducto= "+index+";");
					choiceElementoDelProducto.removeAll();
					for(int i=0;i<datos.size();i++){
						
						choiceElementoDelProducto.add(datos.get(i));
					}
					
					}catch(Exception e2){
						choiceElementoDelProducto.removeAll();
					}
				
				
				
				}
			});
			Producto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					CantidadAEntregar.requestFocus();
					//System.out.println("keyPressed()"); // TODO Auto-generated Event stub keyPressed()
				}
			});
		}
		return Producto;
	}
	
	
	*/
	
	
	
	
	
	/**
	 * This method initializes choiceElementoDelProducto	
	 * 	
	 * @return java.awt.Choice	
	 */
	/*private Choice getChoiceElementoDelProducto() {
		if (choiceElementoDelProducto == null) {
			choiceElementoDelProducto = new Choice();
			choiceElementoDelProducto.setBounds(new Rectangle(533, 304, 96, 21));
			choiceElementoDelProducto.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					//choiceCalidad
					//System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					//choiceVariante
					//choiceGramaje
					//choiceFormato
				
				
				}
			});
		}
		return choiceElementoDelProducto;
	}*/
	/**
	 * This method initializes choiceCalidad	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCalidad() {
		if (choiceCalidad == null) {
			choiceCalidad = new Choice();
			choiceCalidad.setBounds(new Rectangle(143, 83, 143, 21));
		}
		return choiceCalidad;
	}
	/**
	 * This method initializes choiceVariante	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceVariante() {
		if (choiceVariante == null) {
			choiceVariante = new Choice();
			choiceVariante.setBackground(Color.white);
			choiceVariante.setBounds(new Rectangle(288, 83, 83, 21));
		}
		return choiceVariante;
	}
	/**
	 * This method initializes choiceFormato	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceFormato() {
		if (choiceFormato == null) {
			choiceFormato = new Choice();
			choiceFormato.setBounds(new Rectangle(452, 83, 90, 21));
		}
		return choiceFormato;
	}
	/**
	 * This method initializes jPanelMateriales	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelMateriales() {
		if (jPanelMateriales == null) {
			jLabel28 = new JLabel();
			jLabel28.setBounds(new Rectangle(454, 23, 77, 14));
			jLabel28.setText("Formato");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(13, 22, 148, 16));
			jLabel12.setText("Elemento del Producto");
			jPanelMateriales = new JPanel();
			jPanelMateriales.setLayout(null);
			jPanelMateriales.setBackground(Color.lightGray);
			jPanelMateriales.setBounds(new Rectangle(7, 32, 534, 48));
			jPanelMateriales.add(jLabel20, null);
			jPanelMateriales.add(jLabel21, null);
			jPanelMateriales.add(jLabel23, null);
			jPanelMateriales.add(jLabel24, null);
			jPanelMateriales.add(jLabel12, null);
			jPanelMateriales.add(jLabel28, null);
		}
		return jPanelMateriales;
	}
	/**
	 * This method initializes jButtonAgregarMaterial	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgregarMaterial() {
		if (jButtonAgregarMaterial == null) {
			jButtonAgregarMaterial = new JButton();
			jButtonAgregarMaterial.setText("Agregar material");
			jButtonAgregarMaterial.setBounds(new Rectangle(8, 194, 206, 21));
			jButtonAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
				
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					Object[]fila=new Object[11]; //faltan 3
					int auxCantidadAEntregar=Integer.parseInt(getCantidadAEntregar().getText());
					
					
					
					int auxCantidadElementos=Integer.parseInt(jTableElementos.getValueAt(getChoiceElementoDelProductoCargadoAMano().getSelectedIndex(),1).toString());
					
					
					
					fila[0]=choiceElementoDelProductoCargadoAMano.getSelectedItem();//elemento
					fila[1]=auxCantidadAEntregar*auxCantidadElementos;
						//jTableElementos.getValueAt(getChoiceElementoDelProductoCargadoAMano().getSelectedIndex(),1);//cantidad
					fila[2]=choiceCalidad.getSelectedItem();//calidad
					fila[3]=choiceVariante.getSelectedItem();//Variante
					fila[4]=getGramaje().getText();//gramaje
					fila[5]=choiceFormato.getSelectedItem();//formato				
					fila[6]=getPosesXpliego().getText();//posesXpliego
					//fila[7]=//plnetos(AutoCalculado)
					fila[8]=getPliegosEnDemasia().getText();//plEnDemasía					
					fila[9]=getPliegosXhojas().getText();//plXhoja					
					//fila[10]=;//hojas(AutoCalculado)
					//
					
					
					
					int auxplieNet=0;
					int auxPosesXPLiego=Integer.parseInt(fila[6].toString());
					int auxCantAentXauxCantElem=auxCantidadAEntregar*auxCantidadElementos;//
					if(auxCantAentXauxCantElem%auxPosesXPLiego>0){
						auxplieNet=(auxCantidadAEntregar*auxCantidadElementos)/auxPosesXPLiego;
						auxplieNet=auxplieNet+1;
					}else{
						auxplieNet=(auxCantidadAEntregar*auxCantidadElementos)/auxPosesXPLiego;
					}
					
					
					fila[7]=auxplieNet;
					/*totalPliegosNetos = (cantidad a Entregar * cantidadElemento) / posesXpliego.*/			
					
					int auxPliegosNetos=Integer.parseInt(fila[7].toString());
					int auxPLiegosEnDemasia=Integer.parseInt(fila[8].toString());
					int auxPliegosXhoja=Integer.parseInt(fila[9].toString());
					
					/*hojas = (pliegosEnDemasia + pliegosNetos) / pliegosXhoja*/
					int pliegosNetosMasPlEnDemasia=auxPliegosNetos+auxPLiegosEnDemasia;
					
					int auxiliarHojas=0;
					
					if(pliegosNetosMasPlEnDemasia%auxPliegosXhoja>0){
						auxiliarHojas=pliegosNetosMasPlEnDemasia/auxPliegosXhoja;
						auxiliarHojas=auxiliarHojas+1;
					}else{
						auxiliarHojas=pliegosNetosMasPlEnDemasia/auxPliegosXhoja;
					}
					fila[10]=auxiliarHojas;
					
					
					
					int errores=0;
					for(int i=0;i<fila.length;i++){
						if(fila[i]==null || fila[i].equals("")){
							JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios en ésta tabla(Materiales).");
							errores++;
							break;
						}
					}
					if(errores==0){
					modeloMateriales.addRow(fila);
					}else{
					JOptionPane.showMessageDialog(null,"No deje campos vacios!");	
					errores=0;
					}
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null,"Error "+ e3.getMessage());
					}
				}
			});
		}
		return jButtonAgregarMaterial;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void llenarSeccionMateriales(String descripcionElementoProducto){
		metodosSql metodos=new metodosSql();
		int idPapel=metodos.dameQuePapelUsa(descripcionElementoProducto);
		ArrayList<String>calidad=metodos.dameCalidades();
		ArrayList<String>variante=metodos.dameVariantes();
		ArrayList<String>formato=metodos.dameFormatos();
		ArrayList<String>gramaje;
		
		llenarChoice(choiceCalidad, calidad);
		llenarChoice(choiceVariante, variante);
		llenarChoice(choiceFormato,formato);
		
		
		int cal=metodos.dameIdCalidadPapel(idPapel);
		int vari=metodos.dameIdVariantePapel(idPapel);
		int forma=metodos.dameIdFormatoPapel(idPapel);
		int grama=metodos.dameGramajePapel(idPapel);		
		
	}
	
	
	private void llenarChoice(Choice select,ArrayList<String>datos){
		for(int i=0;i<datos.size();i++){
			select.add(datos.get(i));
			
		}
	}
	/**
	 * This method initializes jLabel11	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Orden de Trabajo");
			jLabel11.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		}
		return jLabel11;
	}
	/**
	 * This method initializes apaisado	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getApaisado() {
		if (apaisado == null) {
			apaisado = new JCheckBox();
			apaisado.setSelected(false);
			apaisado.setBounds(new Rectangle(144, 154, 19, 17));
		}
		return apaisado;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(306, 8, 164, 20));
			jLabel27.setText("Pliegos por hoja");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(127, 10, 165, 17));
			jLabel26.setText("Pliegos en demasía");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(14, 11, 99, 14));
			jLabel25.setText("Poses por pliego");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(29, 113, 486, 35));
			jPanel.add(jLabel25, null);
			jPanel.add(jLabel26, null);
			jPanel.add(jLabel27, null);
		}
		return jPanel;
	}
	
	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(6, 73, 172, 68));
			jScrollPane1.setViewportView(getJTableElementos());
		}
		return jScrollPane1;
	}
	/**
	 * This method initializes jTableElementos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modeloElem=new DefaultTableModel();
	private JTextField jTextFieldDesenmascarado = null;
	private JTextField jTextFieldProducto = null;
	private Choice choiceElementoDelProductoCargadoAMano = null;
	private JLabel jLabel12 = null;
	private JCheckBox jCheckBoxTerciariza = null;
	private JLabel jLabel13 = null;
	private JButton jButtonBorrar = null;
	private JButton jButtonSubir = null;
	private JButton jButtonBajar = null;
	private JButton jButtonBorrarElemento = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JLabel jLabel28 = null;
	private JTextField gramaje = null;
	private JTextField posesXpliego = null;
	private JTextField pliegosEnDemasia = null;
	private JTextField pliegosXhojas = null;
	private JTextField CantidadPlanchas = null;
	private JButton jButtonTest = null;
	private JButton jButtonBorrarMaterial = null;
	private Choice choiceCliente = null;
	private JTable getJTableElementos() {
		
		modeloElem.setColumnCount(2);
		Object[]nombreCol=new Object[2];
		nombreCol[0]="Elemento";
		nombreCol[1]="Cantidad";
		modeloElem.setColumnIdentifiers(nombreCol);
		if (jTableElementos == null) {
			jTableElementos = new JTable(modeloElem);
		}
		return jTableElementos;
	}
	/**
	 * This method initializes jTextFieldElemento	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldElemento() {
		if (jTextFieldElemento == null) {
			jTextFieldElemento = new JTextField();
			jTextFieldElemento.setBounds(new Rectangle(6, 43, 69, 20));
		}
		return jTextFieldElemento;
	}
	/**
	 * This method initializes jTextFieldCantidad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidad() {
		if (jTextFieldCantidad == null) {
			jTextFieldCantidad = new JTextField();
			jTextFieldCantidad.setBounds(new Rectangle(78, 43, 57, 20));
			
				
			jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					Control c=new Control();
					int aux=jTextFieldCantidad.getText().length();
					try{
					if(c.esNumero(jTextFieldCantidad.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						jTextFieldCantidad.setText("");
						
					}
					}
catch(Exception e1){
						
					}
				}
			});
			
		}
		return jTextFieldCantidad;
	}
	/**
	 * This method initializes jButtonCargarElemento	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCargarElemento() {
		if (jButtonCargarElemento == null) {
			jButtonCargarElemento = new JButton();
			jButtonCargarElemento.setText("Cargar Elemento");
			jButtonCargarElemento.setBounds(new Rectangle(121, 5, 145, 18));
			jButtonCargarElemento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTextFieldElemento.getText().length()!=0&&jTextFieldCantidad.getText().length()!=0){
					Object[]eleCant=new Object[2];
					eleCant[0]=getJTextFieldElemento().getText();
					eleCant[1]=getJTextFieldCantidad().getText();
					choiceElementoDelProductoCargadoAMano.add(getJTextFieldElemento().getText());
					jTextFieldElemento.setText("");
					jTextFieldCantidad.setText("");
					
					modeloElem.addRow(eleCant);
					}else{
						JOptionPane.showMessageDialog(null,"Complete elemento y cantidad correctamente");
						jTextFieldElemento.requestFocus();
						
					}
					
					
				}
			});
		}
		return jButtonCargarElemento;
	}
	/**
	 * This method initializes jTextFieldDesenmascarado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDesenmascarado() {
		if (jTextFieldDesenmascarado == null) {
			jTextFieldDesenmascarado = new JTextField();
			jTextFieldDesenmascarado.setBounds(new Rectangle(371, 5, 128, 21));
			jTextFieldDesenmascarado.setVisible(false);
		}
		return jTextFieldDesenmascarado;
	}
	/**
	 * This method initializes jTextFieldProducto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldProducto() {
		if (jTextFieldProducto == null) {
			jTextFieldProducto = new JTextField();
			jTextFieldProducto.setBounds(new Rectangle(82, 181, 211, 19));
		}
		return jTextFieldProducto;
	}
	/**
	 * This method initializes choiceElementoDelProductoCargadoAMano	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceElementoDelProductoCargadoAMano() {
		if (choiceElementoDelProductoCargadoAMano == null) {
			choiceElementoDelProductoCargadoAMano = new Choice();
			choiceElementoDelProductoCargadoAMano.setBounds(new Rectangle(7, 83, 133, 21));
			choiceElementoDelProductoCargadoAMano
					.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyPressed(java.awt.event.KeyEvent e) {
							if(e.getKeyCode()==KeyEvent.VK_TAB){
								System.out.println("estas apretando enter");
								choiceCalidad.requestFocus();
							}
							
						}
					});
			choiceElementoDelProductoCargadoAMano
					.addFocusListener(new java.awt.event.FocusAdapter() {
						public void focusGained(java.awt.event.FocusEvent e) {
						
							if(choiceElementoDelProductoCargadoAMano.getItemCount()==0){
								
								getJTextFieldElemento().requestFocus();
								getJTextFieldElemento().setText("COMPLETE");
								JOptionPane.showMessageDialog(null, "Cargue al menos un elemento");
								
							}
						}
					});
		}
		return choiceElementoDelProductoCargadoAMano;
	}
	/**
	 * This method initializes jCheckBoxTerciariza	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxTerciariza() {
		if (jCheckBoxTerciariza == null) {
			jCheckBoxTerciariza = new JCheckBox();
			jCheckBoxTerciariza.setBounds(new Rectangle(125, 43, 22, 20));
			jCheckBoxTerciariza.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(jCheckBoxTerciariza.isSelected()){
						jLabel19.setVisible(true);
						choiceProveedor.setVisible(true);
					}else{
						jLabel19.setVisible(false);
						choiceProveedor.setVisible(false);
						
					}
				}
			});
		}
		return jCheckBoxTerciariza;
	}
	/**
	 * This method initializes jButtonBorrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setText("Borrar");
			jButtonBorrar.setBounds(new Rectangle(221, 114, 80, 26));
			jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{DefaultTableModel tmp=(DefaultTableModel) jTableTarea.getModel();
					tmp.removeRow(jTableTarea.getSelectedRow());}
					catch(Exception ee){
						System.out.println("Se debe cargar al menos un elemento!!!");
					}
				}
			});
		}
		return jButtonBorrar;
	}
	/**
	 * This method initializes jButtonSubir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSubir() {
		if (jButtonSubir == null) {
			jButtonSubir = new JButton();
			jButtonSubir.setText("Subir");
			jButtonSubir.setBounds(new Rectangle(221, 146, 80, 25));
			jButtonSubir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{DefaultTableModel tmp=(DefaultTableModel) jTableTarea.getModel();
					tmp.moveRow(jTableTarea.getSelectedRow(),jTableTarea.getSelectedRow(),jTableTarea.getSelectedRow()-1);}
					catch(Exception e3){
						System.out.println("No se pudo mover mas!!!...");

					}
				}
			});
		}
		return jButtonSubir;
	}
	/**
	 * This method initializes jButtonBajar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBajar() {
		if (jButtonBajar == null) {
			jButtonBajar = new JButton();
			jButtonBajar.setText("Bajar");
			jButtonBajar.setBounds(new Rectangle(220, 176, 80, 27));
			jButtonBajar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{DefaultTableModel tmp=(DefaultTableModel) jTableTarea.getModel();
					tmp.moveRow(jTableTarea.getSelectedRow(),jTableTarea.getSelectedRow(),jTableTarea.getSelectedRow()+1);}
					catch(Exception e3){
						System.out.println("No se pudo bajar mas!!!...");

					}
				}
			});
		}
		return jButtonBajar;
	}
	/**
	 * This method initializes jButtonBorrarElemento	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBorrarElemento() {
		if (jButtonBorrarElemento == null) {
			jButtonBorrarElemento = new JButton();
			jButtonBorrarElemento.setText("Borrar");
			jButtonBorrarElemento.setBounds(new Rectangle(124, 24, 142, 18));
			jButtonBorrarElemento.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{DefaultTableModel tmp=(DefaultTableModel) jTableElementos.getModel();
					getChoiceElementoDelProductoCargadoAMano().remove(jTableElementos.getValueAt(jTableElementos.getSelectedRow(),0 ).toString());
					tmp.removeRow(jTableElementos.getSelectedRow());
					
					
					}
					catch(Exception ee){
						System.out.println("No podes borrar la nada!!!");
					}
				}
			});
		}
		return jButtonBorrarElemento;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBounds(new Rectangle(509, 5, 232, 40));
			jPanel1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			jPanel1.add(getJLabel11(), gridBagConstraints);
		}
		return jPanel1;
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(new Rectangle(21, 57, 327, 236));
			jPanel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel2.add(jLabel, null);
			jPanel2.add(getOrdenNro(), null);
			jPanel2.add(jLabel1, null);
			jPanel2.add(jLabel2, null);
			jPanel2.add(getFechaConfeccion(), null);
			jPanel2.add(jLabel3, null);
			jPanel2.add(getFechaPrometida(), null);
			jPanel2.add(getJButton3(), null);
			jPanel2.add(jLabel4, null);
			jPanel2.add(getNombreTrabajo(), null);
			jPanel2.add(jLabel6, null);
			jPanel2.add(jLabel7, null);
			jPanel2.add(jLabel8, null);
			jPanel2.add(getAncho(), null);
			jPanel2.add(getAlto(), null);
			jPanel2.add(jLabel9, null);
			jPanel2.add(getJTextFieldProducto(), null);
			jPanel2.add(jLabel10, null);
			jPanel2.add(getCantidadAEntregar(), null);
			jPanel2.add(getChoiceCliente(), null);
			jPanel2.add(getApaisado(), null);
			jPanel2.add(jLabel22, null);
		}
		return jPanel2;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(null);
			jPanel3.setBounds(new Rectangle(357, 58, 275, 310));
			jPanel3.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel3.add(SecciónElementos, null);
			jPanel3.add(Elemento, null);
			jPanel3.add(Cantidad, null);
			jPanel3.add(getJTextFieldElemento(), null);
			jPanel3.add(getJTextFieldCantidad(), null);
			jPanel3.add(getJButtonCargarElemento(), null);
			jPanel3.add(getJButtonBorrarElemento(), null);
			jPanel3.add(getJScrollPane1(), null);
			jPanel3.add(jLabel16, null);
			jPanel3.add(getCantidadPlanchas(), null);
			jPanel3.add(jLabel15, null);
		}
		return jPanel3;
	}
	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(null);
			jPanel4.setBounds(new Rectangle(22, 310, 327, 214));
			jPanel4.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel4.add(jLabel17, null);
			jPanel4.add(jLabel18, null);
			jPanel4.add(jLabel13, null);
			jPanel4.add(getChoiceTareas(), null);
			jPanel4.add(getJCheckBoxTerciariza(), null);
			jPanel4.add(jLabel19, null);
			jPanel4.add(getChoiceProveedor(), null);
			jPanel4.add(getJScrollPaneTarea(), null);
			jPanel4.add(getJButtonBorrar(), null);
			jPanel4.add(getJButtonSubir(), null);
			jPanel4.add(getJButtonBajar(), null);
			jPanel4.add(getJButton(), null);
		}
		return jPanel4;
	}
	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(null);
			jPanel5.setBounds(new Rectangle(635, 124, 546, 244));
			jPanel5.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel5.add(getJPanelMateriales(), null);
			jPanel5.add(getChoiceElementoDelProductoCargadoAMano(), null);
			jPanel5.add(getChoiceCalidad(), null);
			jPanel5.add(getChoiceVariante(), null);
			jPanel5.add(getJPanel(), null);
			jPanel5.add(jLabel14, null);
			jPanel5.add(getChoiceFormato(), null);
			jPanel5.add(getJButtonAgregarMaterial(), null);
			jPanel5.add(getGramaje(), null);
			jPanel5.add(getPosesXpliego(), null);
			jPanel5.add(getPliegosEnDemasia(), null);
			jPanel5.add(getPliegosXhojas(), null);
			jPanel5.add(getJButtonBorrarMaterial(), null);
		}
		return jPanel5;
	}
	/**
	 * This method initializes gramaje	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGramaje() {
		if (gramaje == null) {
			gramaje = new JTextField();
			gramaje.setBounds(new Rectangle(377, 83, 70, 21));
			gramaje.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					Control c=new Control();
					int aux=gramaje.getText().length();
					try{
					if(c.esNumero(gramaje.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						gramaje.setText("");
						
					}
					}catch(Exception e1){
						
					}
				}   
				public void keyPressed(java.awt.event.KeyEvent e) {    
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
						
						getJButtonAgregarMaterial().doClick();
					}
				}
				public void keyTyped(java.awt.event.KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_TAB){
						
						choiceFormato.requestFocus();
					}
				}
			});
			
		}
		return gramaje;
	}
	/**
	 * This method initializes posesXpliego	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPosesXpliego() {
		if (posesXpliego == null) {
			posesXpliego = new JTextField();
			posesXpliego.setBounds(new Rectangle(27, 155, 107, 21));
			posesXpliego.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					Control c=new Control();
					int aux=posesXpliego.getText().length();
					try{
					if(c.esNumero(posesXpliego.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						posesXpliego.setText("");
						
					}
					}catch(Exception e1){
						
					}
				}
				public void keyPressed(java.awt.event.KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_ENTER){
						
						getJButtonAgregarMaterial().doClick();
					}
				}
			});
			
		}
		return posesXpliego;
	}
	/**
	 * This method initializes pliegosEnDemasia	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPliegosEnDemasia() {
		if (pliegosEnDemasia == null) {
			pliegosEnDemasia = new JTextField();
			pliegosEnDemasia.setBounds(new Rectangle(161, 155, 148, 21));
			pliegosEnDemasia.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					Control c=new Control();
					int aux=pliegosEnDemasia.getText().length();
					try{
					if(c.esNumero(pliegosEnDemasia.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						pliegosEnDemasia.setText("");
						
					}
					}catch(Exception e1){
						
					}
				}
				public void keyPressed(java.awt.event.KeyEvent e) {
if(e.getKeyCode()==KeyEvent.VK_ENTER){
						
						getJButtonAgregarMaterial().doClick();
					}
				}
			});
		}
		return pliegosEnDemasia;
	}
	/**
	 * This method initializes pliegosXhojas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getPliegosXhojas() {
		if (pliegosXhojas == null) {
			pliegosXhojas = new JTextField();
			pliegosXhojas.setBounds(new Rectangle(336, 155, 180, 21));
			pliegosXhojas.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					Control c=new Control();
					int aux=pliegosXhojas.getText().length();
					try{
					if(c.esNumero(pliegosXhojas.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						pliegosXhojas.setText("");
						
					}
					}catch(Exception e1){
						
					}
				}
				public void keyPressed(java.awt.event.KeyEvent e) {
						if(e.getKeyCode()==KeyEvent.VK_ENTER){
						
						getJButtonAgregarMaterial().doClick();
					}
				}
			});
		}
		return pliegosXhojas;
	}
	/**
	 * This method initializes CantidadPlanchas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadPlanchas() {
		if (CantidadPlanchas == null) {
			CantidadPlanchas = new JTextField();
			CantidadPlanchas.setBounds(new Rectangle(173, 177, 95, 21));
			CantidadPlanchas.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyReleased(java.awt.event.KeyEvent e) {    
					Control c=new Control();
					int aux=CantidadPlanchas.getText().length();
					try{
					if(c.esNumero(CantidadPlanchas.getText().charAt(aux-1))==false){
						JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
						CantidadPlanchas.setText("");
						
					}
					}catch(Exception e1){
						
					}
				}
				public void keyPressed(java.awt.event.KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_TAB || e.getKeyCode()==KeyEvent.VK_ENTER){
						
						getChoiceElementoDelProductoCargadoAMano().requestFocus();
					}
				}
			});
		}
		return CantidadPlanchas;
	}
	/**
	 * This method initializes jButtonTest	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTest() {
		if (jButtonTest == null) {
			jButtonTest = new JButton();
			jButtonTest.setBounds(new Rectangle(441, 542, 467, 37));
			jButtonTest.setText("Llenado automático (Para testing)");
			jButtonTest.setVisible(false);
			jButtonTest.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//jTextFieldCliente.setText("Un cliente");
					FechaPrometida.setText("2013-02-16");
					nombreTrabajo.setText("Un nombre TEST");
					ancho.setText("21");
					alto.setText("59");
					jTextFieldProducto.setText("Revista");
					CantidadAEntregar.setText("5");
					Object[]fila= new Object[2];
					fila[0]="algo";
					fila[1]="3";
					//choiceElementoDelProducto.add("algo");
					
					modeloTareas.addRow(fila);
					modeloElem.addRow(fila);
					CantidadPlanchas.setText("21");
					Descripcion.setText("una breve descripción");
					gramaje.setText("21");
					posesXpliego.setText("22");
					pliegosEnDemasia.setText("4");
					pliegosXhojas.setText("5");
					//jButtonAgregarMaterial.doClick();
				}
			});
		}
		return jButtonTest;
	}
	/**
	 * This method initializes jButtonBorrarMaterial	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBorrarMaterial() {
		if (jButtonBorrarMaterial == null) {
			jButtonBorrarMaterial = new JButton();
			jButtonBorrarMaterial.setBounds(new Rectangle(312, 194, 216, 21));
			jButtonBorrarMaterial.setText("Borrar Material");
			jButtonBorrarMaterial.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						/*try{DefaultTableModel tmp=(DefaultTableModel) jTableTarea.getModel();
					tmp.removeRow(jTableTarea.getSelectedRow());}
					catch(Exception ee){
						System.out.println("Boludo no podes borrar la nada!!!");
					}
					}*/
					DefaultTableModel tmp=(DefaultTableModel) jTableMateriales.getModel();
					tmp.removeRow(jTableMateriales.getSelectedRow());
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "No hay elementos seleccionados para borrar!");
						
					}
				}
			});
		}
		return jButtonBorrarMaterial;
	}
	/**
	 * This method initializes choiceCliente	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCliente() {
		if (choiceCliente == null) {
			choiceCliente = new Choice();
			choiceCliente.setBounds(new Rectangle(171, 36, 122, 20));
		}
		return choiceCliente;
	}

}  //  @jve:decl-index=0:visual-constraint="-22,-2"
