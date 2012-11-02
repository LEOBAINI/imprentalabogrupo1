package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import java.awt.Rectangle;
import javax.swing.JList;
import java.awt.Choice;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Base.metodosSql;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class UsodePapel extends JFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel modeloTabla=new DefaultTableModel();
	private JPanel jContentPane = null;
	private Choice choice = null;
	private JLabel jLabel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableStock = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableMaterialesDeLaSolicitudDeCompra = null;
	private JLabel jLabel1 = null;
	private JTextField jTextFieldCantidadQueRetira = null;
	private JLabel jLabel2 = null;
	private JButton jButtonAceptar = null;
	/**
	 * This is the default constructor
	 */
	public UsodePapel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1264, 572);
		this.setContentPane(getJContentPane());
		this.setTitle("Registro de Uso de Papel");
		metodosSql metodos=new metodosSql();
		ArrayList<String> numerosDeOT=metodos.consultarUnaColumna("SELECT NroOrden FROM imprenta.ordentrabajo where estado !='TERMINADO';");
		for(int i=0;i<numerosDeOT.size();i++){
			choice.add(numerosDeOT.get(i));
			
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(794, 14, 421, 35));
			jLabel3.setText("Elementos que se van a utilizar ahora");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(17, 90, 120, 20));
			jLabel2.setText("Cantidad que retira");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(201, 14, 580, 38));
			jLabel1.setText("Materiales de la solicitud de compra (Sólo figuran los materiales aceptados que están stockeados)");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(17, 14, 147, 20));
			jLabel.setText("Nrode Orden de Trabajo");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getChoice(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextFieldCantidadQueRetira(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJButtonFinalizar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes choice	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(new Rectangle(17, 49, 147, 21));
			choice.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					metodosSql metodos=new metodosSql();
					int numeroSC=Integer.parseInt(getChoice().getSelectedItem());
jTableMaterialesDeLaSolicitudDeCompra.setModel(metodos.llenarJtable("SELECT idMatSolCompra,recibido,marca,calidad,variante,gramaje,alto,ancho,umedida FROM "+
" imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra= "+numeroSC+" and "+
" entregado='ENTREGADO';").getModel());

					/*SELECT recibido,marca,calidad,variante,gramaje,alto,ancho,umedida FROM 
imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra= 6 and
entregado='ENTREGADO';*/
				}
			});
		}
		return choice;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(790, 59, 433, 166));
			jScrollPane.setViewportView(getJTableStock());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableStock	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableStock() {
		modeloTabla.addColumn("Cantidad");
		modeloTabla.addColumn("Marca");
		modeloTabla.addColumn("Calidad");
		modeloTabla.addColumn("Variante");
		modeloTabla.addColumn("Gramaje");
		modeloTabla.addColumn("Alto");
		modeloTabla.addColumn("Ancho");
		modeloTabla.addColumn("Umedida");
		modeloTabla.addColumn("id");
		if (jTableStock == null) {
			jTableStock = new JTable(modeloTabla);
		}
		return jTableStock;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(201, 58, 582, 167));
			jScrollPane1.setViewportView(getJTableMaterialesDeLaSolicitudDeCompra());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTableMaterialesDeLaSolicitudDeCompra	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMaterialesDeLaSolicitudDeCompra() {
		if (jTableMaterialesDeLaSolicitudDeCompra == null) {
			jTableMaterialesDeLaSolicitudDeCompra = new JTable();
			/*jTableMaterialesDeLaSolicitudDeCompra
					.addMouseListener(new java.awt.event.MouseAdapter() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							System.out.println(jTableMaterialesDeLaSolicitudDeCompra.getValueAt(0, 0).toString());
							Object[] fila=new Object[8];
							fila[0]=jTableMaterialesDeLaSolicitudDeCompra.getValueAt(0, 0);
							fila[1]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 1);
							fila[2]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 2);
							fila[3]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 3);
							fila[4]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 4);
							fila[5]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 5);
							fila[6]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 6);
							fila[7]=jTableMaterialesDeLaSolicitudDeCompra.getModel().getValueAt(0, 7);
							modeloFila.setValueAt("hola", 1, 1);
						}
					});*/
			
							
							
						
							
						
				
		}
		return jTableMaterialesDeLaSolicitudDeCompra;
	}

	/**
	 * This method initializes jTextFieldCantidadQueRetira	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCantidadQueRetira() {
		if (jTextFieldCantidadQueRetira == null) {
			jTextFieldCantidadQueRetira = new JTextField();
			jTextFieldCantidadQueRetira.setBounds(new Rectangle(17, 131, 151, 20));
		}
		return jTextFieldCantidadQueRetira;
	}

	/**
	 * This method initializes jTableFocus	
	 * 	
	 * @return javax.swing.JTable	
	 */DefaultTableModel modeloFila=new DefaultTableModel();
	private JLabel jLabel3 = null;
	private JButton jButtonFinalizar = null;
	 
	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(17, 173, 105, 19));
			jButtonAceptar.setText("Cargar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Object[] fila=new Object[9];
					int filaElegida=getJTableMaterialesDeLaSolicitudDeCompra().getSelectedRow();
					fila[0]=getJTextFieldCantidadQueRetira().getText();//campito llenado a mano 
					//datos que vienen de la tabla imprenta.materialesdelasolicituddecompra
					//tambien hace falta el dato IdMatSolCompra
					fila[1]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 2);//marca
					fila[2]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 3);//calidad
					fila[3]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 4);//variante
					fila[4]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 5);//gramaje
					fila[5]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 6);//alto
					fila[6]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 7);//ancho
					fila[7]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 8);//umedida
					fila[8]=getJTableMaterialesDeLaSolicitudDeCompra().getValueAt(filaElegida, 0);//idmatsolCompra
					
					modeloTabla.addRow(fila);// carga en la tabla stock (la que está al lado de la de materiales)
					
					//cuando se le de finalizar tiene que guardar consumos de la ot y hacer la resta en stock
					
				}
			});
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonFinalizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFinalizar() {
		if (jButtonFinalizar == null) {
			jButtonFinalizar = new JButton();
			jButtonFinalizar.setBounds(new Rectangle(18, 203, 105, 19));
			jButtonFinalizar.setText("Finalizar");
		}
			/*jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					metodosSql metodos=new metodosSql();
					
					//se puede cargar solo una ot a la vez
					int nroDeOT=Integer.parseInt(choice.getSelectedItem());
					int filas=jTableStock.getRowCount();
					int cantidad=0;
					String marca=null;
					String calidad=null;
					String variante=null;
					int gramaje=0;
					int alto=0;
					int ancho=0;
					String unidadMedida=null;
					int identificadorDeMaterial;
					for(int i=0;i<filas;i++){
						cantidad=Integer.parseInt(jTableStock.getValueAt(i, 0).toString());
						marca=jTableStock.getValueAt(i, 1).toString();
						calidad=jTableStock.getValueAt(i,2).toString();
						variante=jTableStock.getValueAt(i,3).toString();
						gramaje=Integer.parseInt(jTableStock.getValueAt(i,4).toString());
						alto=Integer.parseInt(jTableStock.getValueAt(i, 5).toString());
						ancho=Integer.parseInt(jTableStock.getValueAt(i, 6).toString());
						unidadMedida=jTableStock.getValueAt(i, 7).toString();
						identificadorDeMaterial=Integer.parseInt(jTableStock.getValueAt(i, 8).toString());
						System.out.println(cantidad + marca + calidad + variante + gramaje + alto + ancho + unidadMedida +identificadorDeMaterial);
						//agregar en consumosDeLaOT con el id del elemento consumido
						//INSERT INTO `imprenta`.`consumosdelaot` (`NroOT`, `CantidadConsumida`,
						  // `FechaConsumo`, `idMaterialConsumido`)
						   //VALUES (nroOt, Cantidad, 'Fecha', IdMaterialConsumido);*/
/*metodos.insertarOmodif("INSERT INTO `imprenta`.`consumosdelaot` (`NroOT`, `CantidadConsumida`,"+
" `FechaConsumo`, `idMaterialConsumido`)"+
"  VALUES ("+nroDeOT+", "+cantidad+", '"+metodos.dameFechaDeHoy()+"',"+identificadorDeMaterial+");");*/
						
						//restar de stock la cantidad donde el idDelmaterial=a el id consumido
//metodos.insertarOmodif("");*/
						
						
						
						
						
						
				/*	}
				}
			});
		}*/
		return jButtonFinalizar;
	}
	

}  //  @jve:decl-index=0:visual-constraint="-7,-13"
