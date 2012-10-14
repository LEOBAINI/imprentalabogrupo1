package Pantallas;

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
import Imprenta.Control;
import Imprenta.Imprenta;
import Imprenta.OrdenDeTrabajo;

import com.jpcomponents.JPCalendar;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JCheckBox;

public class OrdenTrabajo extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modeloMateriales;
	private DefaultTableModel modeloTareas;
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
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField cantidadUniTrabajo = null;
	private JLabel jLabel14 = null;
	private JEditorPane Descripcion = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JEditorPane CantidadPlanchas = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JLabel jLabel19 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private Choice choiceCliente = null;
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
	private JEditorPane gramaje = null;
	private JPanel jPanel = null;
	private JEditorPane posesXpliego = null;
	private JEditorPane pliegosEnDemasia = null;
	private JEditorPane pliegosXhoja = null;
	private JLabel jLabel25 = null;
	private JLabel jLabel26 = null;
	private JLabel jLabel27 = null;
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
		int maxNroOrden=1;
		if(!metodos.consultarUnaColumna("SELECT count(nroOrden) FROM imprenta.ordentrabajo;").get(0).equals("0")){
			maxNroOrden=maxNroOrden+Integer.parseInt(metodos.consultarUnaColumna("SELECT max(nroOrden) FROM imprenta.ordentrabajo;").get(0));
		}
		OrdenNro.setText(String.valueOf(maxNroOrden));
		datos=metodos.consultarUnaColumna("Select nombreContacto from imprenta.cliente");//llenar select cliente
		for(int i=0;i<datos.size();i++)choiceCliente.add(datos.get(i));
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT Descripcion  FROM imprenta.tarea;");
		for(int i=0;i<datos.size();i++)choiceTareas.add(datos.get(i));
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT razonSocial FROM imprenta.proveedor;");
		for(int i=0;i<datos.size();i++)choiceProveedor.add(datos.get(i));
		datos=null;
		datos=metodos.consultarUnaColumna("SELECT nombreproducto FROM imprenta.producto;");
		datos.add(0, "");
		for(int i=0;i<datos.size();i++)Producto.add(datos.get(i));
		datos=null;
		//modelo=new DefaultTableModel();
		llenarSeccionMateriales(Producto.getSelectedItem());
		modeloMateriales.addColumn("Elemento");
		modeloMateriales.addColumn("Calidad");
		modeloMateriales.addColumn("Variante");
		modeloMateriales.addColumn("Gramaje");
		modeloMateriales.addColumn("Formato");
		modeloMateriales.addColumn("PXPliego");
		modeloMateriales.addColumn("Pnetos");//se debe autocalcular
		modeloMateriales.addColumn("PenDemasia");
		modeloMateriales.addColumn("PXhoja");
		modeloMateriales.addColumn("Hojas");
		modeloMateriales.addColumn("CantXuniTrabajo");
		modeloTareas.addColumn("Tarea");
		modeloTareas.addColumn("Proveedor");
		
		
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
		jLabel22 = new JLabel();
		jLabel22.setBounds(new Rectangle(270, 235, 94, 19));
		jLabel22.setText("Apaisado");
		jLabel24 = new JLabel();
		jLabel24.setText("Formato");
		jLabel24.setBounds(new Rectangle(598, 24, 47, 16));
		jLabel23 = new JLabel();
		jLabel23.setText("Gramaje");
		jLabel23.setBounds(new Rectangle(460, 24, 48, 16));
		jLabel21 = new JLabel();
		jLabel21.setText("Variante");
		jLabel21.setBounds(new Rectangle(355, 24, 48, 16));
		jLabel20 = new JLabel();
		jLabel20.setText("Calidad");
		jLabel20.setBounds(new Rectangle(245, 24, 42, 16));
		jLabel19 = new JLabel();
		jLabel19.setBounds(new Rectangle(170, 320, 195, 17));
		jLabel19.setText("Proveedor que realizará la tarea");
		jLabel18 = new JLabel();
		jLabel18.setBounds(new Rectangle(50, 320, 111, 17));
		jLabel18.setText("Tareas del trabajo");
		jLabel17 = new JLabel();
		jLabel17.setBounds(new Rectangle(50, 300, 161, 17));
		jLabel17.setText("Sección Orden de Ejecución");
		jLabel16 = new JLabel();
		jLabel16.setBounds(new Rectangle(50, 268, 161, 21));
		jLabel16.setText("Cantidad de Planchas (nro)");
		jLabel15 = new JLabel();
		jLabel15.setBounds(new Rectangle(50, 244, 133, 21));
		jLabel15.setText("Sección PreImpresión");
		jLabel14 = new JLabel();
		jLabel14.setBounds(new Rectangle(797, 169, 135, 23));
		jLabel14.setText("Sección de Materiales");
		jLabel13 = new JLabel();
		jLabel13.setText("Cant X Unidad de trabajo");
		jLabel13.setBounds(new Rectangle(94, 23, 148, 17));
		jLabel12 = new JLabel();
		jLabel12.setText("Elemento");
		jLabel12.setBounds(new Rectangle(5, 25, 113, 15));
		jLabel10 = new JLabel();
		jLabel10.setBounds(new Rectangle(50, 212, 142, 16));
		jLabel10.setText("Cantidad a Entregar");
		jLabel9 = new JLabel();
		jLabel9.setBounds(new Rectangle(50, 188, 134, 16));
		jLabel9.setText("Producto");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(296, 160, 25, 16));
		jLabel8.setText("Alto");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(200, 160, 38, 16));
		jLabel7.setText("Ancho");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(50, 160, 141, 16));
		jLabel6.setText("Medida Final.");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(826, 41, 76, 16));
		jLabel5.setText("Descripción");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(50, 135, 144, 16));
		jLabel4.setText("Nombre corto del trabajo.");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(50, 112, 119, 16));
		jLabel3.setText("Fecha Prometida");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(50, 90, 117, 16));
		jLabel2.setText("Fecha de confección");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(50, 68, 78, 16));
		jLabel1.setText("Cliente");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(50, 46, 78, 16));
		jLabel.setText("Orden N°");
		this.setSize(1195, 568);
		this.setLayout(null);
		this.setBackground(SystemColor.activeCaption);
		this.setBackground(SystemColor.controlHighlight);
		this.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createCompoundBorder(null, null)));
		this.add(getFechaConfeccion(), null);
		this.add(jLabel, null);
		this.add(getOrdenNro(), null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(getFechaPrometida(), null);
		this.add(jLabel4, null);
		this.add(getNombreTrabajo(), null);
		this.add(jLabel5, null);
		this.add(jLabel6, null);
		this.add(getAncho(), null);
		this.add(getAlto(), null);
		this.add(jLabel7, null);
		this.add(jLabel8, null);
		this.add(jLabel9, null);
		this.add(jLabel10, null);
		this.add(getCantidadAEntregar(), null);
		this.add(getCantidadUniTrabajo(), null);
		this.add(jLabel14, null);
		this.add(getDescripcion(), null);
		this.add(getJScrollPane(), null);
		this.add(jLabel15, null);
		this.add(jLabel16, null);
		this.add(getCantidadPlanchas(), null);
		this.add(jLabel17, null);
		this.add(jLabel18, null);
		this.add(jLabel19, null);
		this.add(getJButton(), null);
		this.add(getJButton1(), null);
		this.add(getChoiceCliente(), null);
		this.add(getJButton2(), null);
		this.add(getJButton3(), null);
		this.add(getJScrollPaneTarea(), null);
		this.add(getChoiceTareas(), null);
		this.add(getChoiceProveedor(), null);
		this.add(getProducto(), null);
		this.add(getChoiceElementoDelProducto(), null);
		this.add(getChoiceCalidad(), null);
		
		this.add(getChoiceVariante(), null);
		this.add(getChoiceFormato(), null);
		this.add(getJPanelMateriales(), null);
		this.add(getJButtonAgregarMaterial(), null);
		this.add(getJLabel11(), null);
		this.add(getApaisado(), null);
		this.add(jLabel22, null);
		this.add(getGramaje(), null);
		this.add(getJPanel(), null);
		this.add(getPosesXpliego(), null);
		this.add(getPliegosEnDemasia(), null);
		this.add(getPliegosXhoja(), null);
		
	}

	/**
	 * This method initializes FechaConfeccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFechaConfeccion() {
		if (FechaConfeccion == null) {
			FechaConfeccion = new JTextField();
			FechaConfeccion.setBounds(new Rectangle(244, 90, 122, 20));
			FechaConfeccion.setName("FechaConfeccion");
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
			OrdenNro.setBounds(new Rectangle(244, 46, 122, 20));
			OrdenNro.setEditable(false);
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
			FechaPrometida.setBounds(new Rectangle(244, 112, 122, 20));
			FechaPrometida.setName("Fechaprometida");
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
			nombreTrabajo.setBounds(new Rectangle(244, 134, 122, 21));
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
			ancho.setBounds(new Rectangle(244, 160, 50, 22));
			ancho.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						Control c=new Control();
						int aux=ancho.getText().length();
						if(c.esNumero(ancho.getText().charAt(aux-1))==false){
							JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
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
			alto.setBounds(new Rectangle(322, 160, 43, 21));
			alto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						Control c=new Control();
						int aux=alto.getText().length();
						if(c.esNumero(alto.getText().charAt(aux-1))==false){
							JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
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
			CantidadAEntregar.setBounds(new Rectangle(244, 208, 121, 21));
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
	private JTextField getCantidadUniTrabajo() {
		if (cantidadUniTrabajo == null) {
			cantidadUniTrabajo = new JTextField();
			cantidadUniTrabajo.setBounds(new Rectangle(664, 249, 42, 21));
		}
		return cantidadUniTrabajo;
	}

	/**
	 * This method initializes Descripcion	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getDescripcion() {
		if (Descripcion == null) {
			Descripcion = new JEditorPane();
			Descripcion.setBounds(new Rectangle(526, 99, 664, 65));
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
			jScrollPane.setBounds(new Rectangle(528, 348, 662, 112));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		modeloMateriales=new DefaultTableModel();
		if (jTable == null) {
			jTable = new JTable(modeloMateriales);
			jTable.setCellSelectionEnabled(true);
			
		}
		return jTable;
	}
	/**
	 * This method initializes CantidadPlanchas	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getCantidadPlanchas() {
		if (CantidadPlanchas == null) {
			CantidadPlanchas = new JEditorPane();
			CantidadPlanchas.setBounds(new Rectangle(246, 268, 119, 19));
			CantidadPlanchas.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						Control c=new Control();
						int aux=CantidadPlanchas.getText().length();
						if(c.esNumero(CantidadPlanchas.getText().charAt(aux-1))==false){
							JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
							CantidadPlanchas.setText("");
							
						}
						}catch(Exception e1){};
						
				}
			});
		}
		return CantidadPlanchas;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(50, 465, 315, 21));
			jButton.setText("Agregar Tarea con su proveedor asociado");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					JPCalendar cal=new JPCalendar();
					cal.setVisible(true);// TODO Auto-generated Event stub actionPerformed()
					JCalendar j=new JCalendar();
					j.setVisible(true);
				}
			});
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[]fila=new Object[2];
					fila[0]=getChoiceTareas().getSelectedItem();
					fila[1]=getChoiceProveedor().getSelectedItem();
					modeloTareas.addRow(fila);
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
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(1011, 519, 179, 40));
			jButton1.setText("Finalizar carga de OT");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					
					
					
					
					try{
					int status=0;
					Imprenta imprenta=new Imprenta();

					OrdenDeTrabajo OT=new OrdenDeTrabajo(Integer.parseInt(getOrdenNro().getText()));
					OT.setAlto(Integer.parseInt(getAlto().getText()));
					OT.setAncho(Integer.parseInt(getAncho().getText()));
					if(getApaisado().isEnabled()){
					OT.setApaisado("Es apaisado");
					}
					OT.setCantidadAentregar(getCantidadAEntregar().getText());
					OT.setCantidadPlanchas(Integer.parseInt(getCantidadPlanchas().getText()));
					OT.setCliente(getChoiceCliente().getSelectedItem());
					OT.setDescripcion(getDescripcion().getText());
					OT.setEstado("ACTIVO");
					OT.setFechaConfeccion(getFechaConfeccion().getText());
					OT.setFechaEntrega(getFechaPrometida().getText());
					OT.setMateriales(getJTable());
					//OT.setMedidaFinal(medidaFinal);
					OT.setNombreTrabajo(getNombreTrabajo().getText());
					OT.setProducto(getProducto().getSelectedItem());
					OT.setTareas(getJTableTarea());
					OT.setElementoDelProducto(getChoiceElementoDelProducto().getSelectedItem());
					status=imprenta.llenarOrdenTrabajo(OT);
					if(status==3){
						JOptionPane.showMessageDialog(null, "datos cargados con éxito!");
						
					}else{
						JOptionPane.showMessageDialog(null, "datos no se cargaron correctamente... revise la ot cargada");
					}
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null, e3.getMessage());
						
					}
					
					
					
					
				}
					
			});
			
					
					
					

		}
		return jButton1;
	}

	/**
	 * This method initializes choiceCliente	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCliente() {
		
		if (choiceCliente == null) {
			choiceCliente = new Choice();
			choiceCliente.setBounds(new Rectangle(244, 68, 121, 21));
			choiceCliente.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println(choiceCliente.getSelectedItem().toString());
				}
			});
			
			
		}
		return choiceCliente;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(373, 90, 20, 18));
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Calendario c=new Calendario(FechaConfeccion);
					
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
		return jButton2;
	}
	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(373, 113, 20, 18));
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
			jScrollPaneTarea.setBounds(new Rectangle(51, 366, 315, 95));
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
		modeloTareas=new DefaultTableModel();
		
		
		
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
			choiceTareas.setBounds(new Rectangle(51, 342, 118, 27));
			choiceTareas.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					jButton.doClick();
					//System.out.println("keyTyped()"); // TODO Auto-generated Event stub keyTyped()
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
			choiceProveedor.setBounds(new Rectangle(170, 342, 194, 25));
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
	private Choice getProducto() {
		if (Producto == null) {
			Producto = new Choice();
			Producto.setBounds(new Rectangle(244, 186, 120, 19));
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
	/**
	 * This method initializes choiceElementoDelProducto	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceElementoDelProducto() {
		if (choiceElementoDelProducto == null) {
			choiceElementoDelProducto = new Choice();
			choiceElementoDelProducto.setBounds(new Rectangle(532, 249, 96, 21));
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
	}
	/**
	 * This method initializes choiceCalidad	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCalidad() {
		if (choiceCalidad == null) {
			choiceCalidad = new Choice();
			choiceCalidad.setBounds(new Rectangle(739, 249, 100, 21));
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
			choiceVariante.setBounds(new Rectangle(871, 249, 88, 21));
			choiceVariante.setBackground(Color.white);
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
			choiceFormato.setBounds(new Rectangle(1102, 249, 90, 21));
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
			jPanelMateriales = new JPanel();
			jPanelMateriales.setLayout(null);
			jPanelMateriales.setBounds(new Rectangle(526, 193, 666, 48));
			jPanelMateriales.setBackground(Color.lightGray);
			jPanelMateriales.add(jLabel20, null);
			jPanelMateriales.add(jLabel21, null);
			jPanelMateriales.add(jLabel23, null);
			jPanelMateriales.add(jLabel24, null);
			jPanelMateriales.add(jLabel12, null);
			jPanelMateriales.add(jLabel13, null);
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
			jButtonAgregarMaterial.setBounds(new Rectangle(529, 465, 657, 21));
			jButtonAgregarMaterial.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[]fila=new Object[11];
					fila[0]=choiceElementoDelProducto.getSelectedItem();
					fila[1]=choiceCalidad.getSelectedItem();
					fila[2]=choiceVariante.getSelectedItem();
					fila[3]=getGramaje().getText();
					fila[4]=choiceFormato.getSelectedItem();
					fila[5]=getPosesXpliego().getText();
					fila[7]=getPliegosEnDemasia().getText();
					fila[8]=getPliegosXhoja().getText();
					fila[10]=getCantidadUniTrabajo().getText();
					modeloMateriales.addRow(fila);
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
			jLabel11.setFont(new Font("Dialog", Font.BOLD, 18));
			jLabel11.setBounds(new Rectangle(452, 5, 165, 29));
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
			apaisado.setBounds(new Rectangle(245, 236, 19, 17));
		}
		return apaisado;
	}
	/**
	 * This method initializes gramaje	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getGramaje() {
		if (gramaje == null) {
			gramaje = new JEditorPane();
			gramaje.setBounds(new Rectangle(980, 250, 90, 20));
		}
		return gramaje;
	}
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(286, 8, 164, 20));
			jLabel27.setText("Pliegos por hoja");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(115, 10, 165, 17));
			jLabel26.setText("Pliegos en demasía");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(5, 11, 99, 14));
			jLabel25.setText("Poses por pliego");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(526, 275, 665, 35));
			jPanel.add(jLabel25, null);
			jPanel.add(jLabel26, null);
			jPanel.add(jLabel27, null);
		}
		return jPanel;
	}
	/**
	 * This method initializes posesXpliego	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getPosesXpliego() {
		if (posesXpliego == null) {
			posesXpliego = new JEditorPane();
			posesXpliego.setBounds(new Rectangle(527, 313, 106, 22));
		}
		return posesXpliego;
	}
	/**
	 * This method initializes pliegosEnDemasia	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getPliegosEnDemasia() {
		if (pliegosEnDemasia == null) {
			pliegosEnDemasia = new JEditorPane();
			pliegosEnDemasia.setBounds(new Rectangle(643, 313, 152, 23));
		}
		return pliegosEnDemasia;
	}
	/**
	 * This method initializes pliegosXhoja	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getPliegosXhoja() {
		if (pliegosXhoja == null) {
			pliegosXhoja = new JEditorPane();
			pliegosXhoja.setBounds(new Rectangle(802, 314, 172, 22));
		}
		return pliegosXhoja;
	}

}  //  @jve:decl-index=0:visual-constraint="-66,12"
