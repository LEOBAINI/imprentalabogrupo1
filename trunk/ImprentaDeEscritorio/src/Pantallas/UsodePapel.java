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

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Base.metodosSql;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class UsodePapel extends JFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel modeloTabla=new DefaultTableModel();
	private JPanel jContentPane = null;
	private Choice choice = null;
	private JLabel jLabel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableConsumosDeLaOT = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableStock1 = null;
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
			jLabel3.setText("Elementos utilizados hasta ahora");
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
	private void refreshTablas(int numeroOT){
		metodosSql metodos=new metodosSql();
		jTableStock1.setModel(metodos.llenarJtable("select cantidad,unidadDemedida,fechaRecepcion,hora,partida,idmaterialesDeLaSol from imprenta.stock  where NroOT ="+numeroOT).getModel());
		jTableConsumosDeLaOT.setModel(metodos.llenarJtable("select CantidadConsumida,fechaConsumo,idmaterialConsumido from imprenta.consumosdelaot where NroOT ="+numeroOT).getModel());
		
	}
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(new Rectangle(17, 49, 147, 21));
			choice.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					metodosSql metodos=new metodosSql();
					int numeroOT=Integer.parseInt(getChoice().getSelectedItem());
jTableStock1.setModel(metodos.llenarJtable("select cantidad,unidadDemedida,fechaRecepcion,hora,partida,idmaterialesDeLaSol from imprenta.stock where NroOT ="+numeroOT).getModel());
jTableConsumosDeLaOT.setModel(metodos.llenarJtable("select CantidadConsumida,fechaConsumo,idmaterialConsumido from imprenta.consumosdelaot where NroOT ="+numeroOT).getModel());

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
			jScrollPane.setViewportView(getJTableConsumosDeLaOT());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableConsumosDeLaOT	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableConsumosDeLaOT() {
		
		if (jTableConsumosDeLaOT == null) {
			jTableConsumosDeLaOT = new JTable(modeloTabla);
		}
		return jTableConsumosDeLaOT;
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
		if (jTableStock1 == null) {
			jTableStock1 = new JTable();
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
		return jTableStock1;
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
	private boolean hayErrores(int CantIN,int CantOUT){
		try{
		if(jTableStock1.getSelectedRow()==-1){
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila de la tabla");
			return true;			
		}
		if(CantIN==0){
			JOptionPane.showMessageDialog(null, "No tiene sentido pedir 0! ingrese otro valor >0");
			return true;
			
		}
		if(CantOUT==0){
			JOptionPane.showMessageDialog(null, "No hay suficiente STOCK");
			return true;
			
		}
		if(CantIN >CantOUT){
			JOptionPane.showMessageDialog(null, "El valor ingresado es mayor al existente");
			return true;				
			
		}
		if(jTextFieldCantidadQueRetira.getText().length()<=0){
			JOptionPane.showMessageDialog(null, "La cantidad está vacía!");
			return true;				
			
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ingrese valores válidos!....."+e.getMessage());
			return true;
		}
		
		
		
		return false;
	}
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(17, 173, 105, 19));
			jButtonAceptar.setText("Cargar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					metodosSql metodos=new metodosSql();
					int cantidadIngresada=0;
					int cantidadStockeado=0;
					int partida=-1;
					int numeroOT=-1;
					int idMaterialConsumido=-1;
					String fechaDeHoy=metodos.dameFechaDeHoy();
					
					if(jTextFieldCantidadQueRetira.getText().length()>0){
					 cantidadIngresada=Integer.parseInt(jTextFieldCantidadQueRetira.getText());
					}
					//int cantidadStockeado=Integer.parseInt(metodos.consultarUnaColumna("select cantidad from imprenta.stock where partida="+partida+";").get(0));
					
					
					if(jTableStock1.getSelectedRow()!=-1){
						
					
					partida=Integer.parseInt(jTableStock1.getValueAt(jTableStock1.getSelectedRow(), 4).toString());//columna 4 es partida
					idMaterialConsumido=Integer.parseInt(jTableStock1.getValueAt(jTableStock1.getSelectedRow(), 5).toString());//columna 5 es idmaterial
					
					cantidadStockeado=Integer.parseInt(metodos.consultarUnaColumna("select cantidad from imprenta.stock where partida="+partida+";").get(0));
					
					
					
					numeroOT=Integer.parseInt(choice.getSelectedItem());
					
					
					}else{
						JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
						return;
					}
					
					if(hayErrores(cantidadIngresada,cantidadStockeado)==false && partida!=-1 && numeroOT!=-1 && idMaterialConsumido!=-1){
						
					
					metodos.insertarOmodif("update imprenta.stock set cantidad=cantidad-"+cantidadIngresada+" where partida="+partida+"; ");//restar en stock
					metodos.insertarOmodif("insert into imprenta.consumosdelaot(`NroOT`,`CantidadConsumida`,`FechaConsumo`,`idMaterialConsumido`)values("+numeroOT+","+cantidadIngresada+",'"+fechaDeHoy+"',"+idMaterialConsumido+");");//agregar en materiales consumidos por la ot
					
					
					
					refreshTablas(numeroOT);
					}else{
						
					}
					}
					catch(Exception ee){
						JOptionPane.showMessageDialog(null, ee.getMessage());
						
					}
					
					
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
			jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
			}				
						
						
				
		return jButtonFinalizar;
	}
	

}  //  @jve:decl-index=0:visual-constraint="-7,-13"
