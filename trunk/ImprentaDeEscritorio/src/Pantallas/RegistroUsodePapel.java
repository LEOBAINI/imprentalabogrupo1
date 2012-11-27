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
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import Base.metodosSql;
import Formateador.Formato;
import Formateador.JtableNoEditable;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

@SuppressWarnings("unused")
public class RegistroUsodePapel extends JFrame {

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
	public RegistroUsodePapel() {
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
		ArrayList<String> numerosDeOT=metodos.consultarUnaColumna("SELECT NroOrden FROM imprenta.ordentrabajo where estado !='CERRADA';");
		choice.add("");
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
			jLabelElemento = new JLabel();
			jLabelElemento.setBounds(new Rectangle(16, 208, 105, 16));
			jLabelElemento.setText("Elemento");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(203, 317, 421, 35));
			jLabel3.setText("Elementos utilizados hasta ahora");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(16, 283, 112, 20));
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
			jContentPane.add(getChoiceElemento(), null);
			jContentPane.add(jLabelElemento, null);
			jContentPane.add(getJScrollPane2(), null);
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
		jTableStock1.setModel(metodos.llenarJtable("select nroot,s.cantidad,marca,calidad,variante,gramaje,concat(alto,'X',ancho) as Formato,fechaRecepcion,hora,partida,idmaterialesDeLaSol "+
				" from imprenta.stock s,imprenta.materialesdelasolicituddecompra m "+
				" where idmatsolcompra=idmaterialesdelasol "+
				"and s.cantidad!=0 "+
				" and nroOt="+numeroOT+" "+
				" or nroot=0 "+
				" group by partida;").getModel());
		jTableConsumosDeLaOT.setModel(metodos.llenarJtable("SELECT c.elemento,cantidadConsumida,fechaconsumo,horaDelConsumo,marca,calidad,variante,gramaje,concat(alto,'X',ancho) as Formato " +
				" FROM imprenta.consumosdelaot c,imprenta.materialesdelasolicituddecompra s "+
				" where c.idMaterialConsumido=s.idMatSolCompra " +
				" and  c.NroOT ="+numeroOT+";").getModel());
		
	}
	
	
	
	
	
	
	
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(new Rectangle(17, 49, 147, 21));
			try{
			choice.addItemListener(new java.awt.event.ItemListener() {
				
				public void itemStateChanged(java.awt.event.ItemEvent e)  {
					if(!getChoice().getSelectedItem().equals("")){
						limpiartabla(jTableElemento);
					int numeroOT=-1;
					
					
					metodosSql metodos=new metodosSql();

						
					
					numeroOT=Integer.parseInt(getChoice().getSelectedItem());

					
					
					jTableStock1.setModel(metodos.llenarJtable("select nroot,s.cantidad,marca,calidad,variante,gramaje,concat(ancho,'X',alto) as Formato,fechaRecepcion,hora,partida," +
							" idmaterialesDeLaSol "+
							" from imprenta.stock s,imprenta.materialesdelasolicituddecompra m "+
							" where "+
							" idmatsolcompra=idmaterialesdelasol "+
							"and s.cantidad!=0 "+
							" and " +
							" nroOt="+numeroOT+" "+
							" or nroot=0 "+
							
					" group by partida;").getModel());
					
					
					
					
					

					jTableConsumosDeLaOT.setModel(metodos.llenarJtable("SELECT elemento,cantidadConsumida,fechaconsumo,horaDelConsumo,marca,calidad,variante,gramaje,concat(ancho,'X',alto) as Formato" +
							" FROM imprenta.consumosdelaot c,imprenta.materialesdelasolicituddecompra s "+
							" where c.idMaterialConsumido=s.idMatSolCompra " +
							" and  c.NroOT ="+numeroOT+" " +
									" order by c.idconsumo;").getModel());
					choiceElemento.removeAll();
					ArrayList<String>elementos=metodos.consultarUnaColumna("select elementodelproducto from materiaprimadelaot where nroordentrabajo ="+numeroOT+";");
					choiceElemento.add("");
					for(int i=0;i<elementos.size();i++){
						choiceElemento.add(elementos.get(i));

					}
					}else{
					limpiartabla(jTableStock1);
					limpiartabla(jTableConsumosDeLaOT);
					limpiartabla(jTableElemento);
				}
			
				}
					
				});
			
			
			}catch(Exception e){
				
			}
			
		}
		return choice;
	}
	private void limpiartabla(JTable tabla){
		try{
		DefaultTableModel tmp=(DefaultTableModel) tabla.getModel();
		
		for(;tmp.getRowCount()!=0;){
			
			tmp.removeRow(tmp.getRowCount()-1);
		
		}
		}catch(Exception e){
			
		}
		
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(203, 359, 1028, 166));
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
			jScrollPane1.setBounds(new Rectangle(201, 58, 1026, 167));
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
			jTableStock1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if(modeloDetalle.getRowCount()!=0)
					modeloDetalle.removeRow(0);
					metodosSql metodos=new metodosSql();
					ArrayList<ArrayList<String>>matriz=null;
					int idMaterial=Integer.parseInt(jTableStock1.getValueAt(jTableStock1.getSelectedRow(),10 ).toString());
					matriz=metodos.consultar("SELECT marca,calidad,variante,concat(ancho,'X',alto) as Formato FROM imprenta.materialesdelasolicituddecompra "+
" where idmatSolCompra="+idMaterial+";");
					
					
					
				}
			});
			
			
							
							
						
							
						
				
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
			jTextFieldCantidadQueRetira.setBounds(new Rectangle(16, 311, 105, 20));
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
			jButtonAceptar.setBounds(new Rectangle(16, 340, 105, 19));
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
					String elemento=choiceElemento.getSelectedItem();
					String fechaDeHoy=metodos.dameFechaDeHoy();
					
					if(jTextFieldCantidadQueRetira.getText().length()>0){
					 cantidadIngresada=Integer.parseInt(jTextFieldCantidadQueRetira.getText());
					}
					//int cantidadStockeado=Integer.parseInt(metodos.consultarUnaColumna("select cantidad from imprenta.stock where partida="+partida+";").get(0));
					
					
					if(jTableStock1.getSelectedRow()!=-1){
						
					
					partida=Integer.parseInt(jTableStock1.getValueAt(jTableStock1.getSelectedRow(), 9).toString());//columna 4 es partida
					idMaterialConsumido=Integer.parseInt(jTableStock1.getValueAt(jTableStock1.getSelectedRow(), 10).toString());//columna 10 es idmaterial
					
					cantidadStockeado=Integer.parseInt(metodos.consultarUnaColumna("select cantidad from imprenta.stock where partida="+partida+";").get(0));
					
					
					
					numeroOT=Integer.parseInt(choice.getSelectedItem());
					
					
					}else{
						JOptionPane.showMessageDialog(null, "Elija una fila de la tabla");
						return;
					}
					int contador=0;
					for(int i=0;i<=3;i++){
						if(jTableStock1.getValueAt(jTableStock1.getSelectedRow(), i+3).equals(jTableElemento.getValueAt(0, i))){
							contador++;
						}
						
					}
					int seleccion=0;
					
					if(	contador!=4){

						Object o[]=new Object[2];
						o[0]="Si";
						o[1]="No";
						 seleccion = JOptionPane.showOptionDialog(null,"Confirma","EL elemento no coincide", JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null,o,"Si");
						
						// si elije no =1 si si =0
						
						
					
						System.out.println(seleccion);
					}
					
					
					if(hayErrores(cantidadIngresada,cantidadStockeado)==false && partida!=-1 && numeroOT!=-1 && idMaterialConsumido!=-1 && seleccion==0){
						Formato f=new Formato();
						String hora=f.darHoraBonita();
					
					metodos.insertarOmodif("update imprenta.stock set cantidad=cantidad-"+cantidadIngresada+" where partida="+partida+"; ");//restar en stock
					metodos.insertarOmodif("insert into imprenta.consumosdelaot(`NroOT`,`Elemento`,`CantidadConsumida`,`FechaConsumo`,`idMaterialConsumido`,`HoraDelConsumo`)values("+numeroOT+",'"+elemento+"',"+cantidadIngresada+",'"+fechaDeHoy+"',"+idMaterialConsumido+",'"+hora+"');");//agregar en materiales consumidos por la ot
					
					
					
					refreshTablas(numeroOT);
					}else{
						JOptionPane.showMessageDialog(null,"Los datos no se cargaron, seleccione nuevamente");
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
			jButtonFinalizar.setBounds(new Rectangle(16, 370, 105, 19));
			jButtonFinalizar.setText("Finalizar");
			jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
			}				
						
						
				
		return jButtonFinalizar;
	}

	/**
	 * This method initializes jTableDetalleElemento	
	 * 	
	 * @return javax.swing.JTable	
	 */
	JtableNoEditable modeloDetalle= new JtableNoEditable();
	private Choice choiceElemento = null;
	private JLabel jLabelElemento = null;
	private JTable jTableElemento = null;
	/**
	 * This method initializes choiceElemento	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceElemento() {
		if (choiceElemento == null) {
			choiceElemento = new Choice();
			choiceElemento.setBounds(new Rectangle(16, 234, 105, 21));
			choiceElemento.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					metodosSql metodos=new metodosSql();
					if(!choiceElemento.getSelectedItem().equals("")){
					jTableElemento.setModel(metodos.llenarJtable("select calidaddescripcion as Calidad, variantedescripcion as Variante," +
							" gramaje as Gramaje, formatodescripcion as Formato  from imprenta.materiaprimadelaot " +
							" where nroOrdentrabajo ="+Integer.parseInt(choice.getSelectedItem())+" and ElementoDelProducto='"+choiceElemento.getSelectedItem()+"';").getModel());
				
					}else{
						try{
							DefaultTableModel tmp=(DefaultTableModel) jTableElemento.getModel();
						tmp.removeRow(0);
						}catch(Exception es){
							
						}
					}
				
					
				}
			});
		}
		return choiceElemento;
	}

	/**
	 * This method initializes jTableElemento	
	 * 	
	 * @return javax.swing.JTable	
	 */
	JtableNoEditable modeloElem=new JtableNoEditable();
	private JScrollPane jScrollPane2 = null;
	private JTable getJTableElemento() {
		modeloElem.addColumn("Calidad");
		modeloElem.addColumn("Variante");
		modeloElem.addColumn("Gramaje");
		modeloElem.addColumn("Formato");
		
		if (jTableElemento == null) {
			jTableElemento = new JTable(modeloElem);
		}
		return jTableElemento;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(202, 234, 644, 45));
			jScrollPane2.setViewportView(getJTableElemento());
		}
		return jScrollPane2;
	}
	

}  //  @jve:decl-index=0:visual-constraint="-7,-13"
