package Pantallas;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Choice;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JLabel;

import Base.metodosSql;
import Formateador.Formato;

import java.awt.event.KeyEvent;
import java.awt.Font;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JButton;

public class InformeDeLaOT extends JFrame {

	private ArrayList<String> descripcion=new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> nroOT=new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> nroOTenmascarado=new ArrayList<String>(); 
	private ArrayList<String> cliente=new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> fechaEntrega=new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<String> fechaConfeccion=new ArrayList<String>();  //  @jve:decl-index=0:
	
	
	private ArrayList<String> medida=new ArrayList<String>(); //concat  //  @jve:decl-index=0:
	private ArrayList<String> apaisado=new ArrayList<String>(); 
	private ArrayList<String> cantidadAentregar=new ArrayList<String>(); 
	private ArrayList<String> cantPlanchas=new ArrayList<String>(); 
	private ArrayList<String> producto=new ArrayList<String>();  //  @jve:decl-index=0:
	private ArrayList<ArrayList<String>> matriz=null;  //  @jve:decl-index=0:
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextPane jTextPaneCliente = null;
	private JTextPane jTextPaneFecha = null;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable1 = null;
	private JTextPane jTextPane4 = null;
	private JPanel jPanel1 = null;
	private JTable jTable2 = null;
	private JTextPane jTextPane41 = null;
	private JTextPane jTextPanePautada = null;
	private JTextPane jTextPaneDescripcion = null;
	/**
	 * This is the default constructor
	 */
	public InformeDeLaOT() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		metodosSql metodos=new metodosSql();
		
		matriz=metodos.consultar("select " +
				"nroorden," +//0
				"nombre," +//1
				"cliente," +//2
				"descripcion," +//3
				"fechaentrPautada," +//4
				"fechaConfeccion, " +//5
				
				"concat(ancho,'X',alto) as Medida, " +//6
				"EsApaisado, "+//7
				"Producto, "+//8
				"CantidadAEntregar, "+//9
				"CantPlanchas "+//10
				"from imprenta.ordentrabajo;");
		
		
		
		this.setSize(1265, 719);
		this.setContentPane(getJContentPane());
		this.setTitle("Informe de la Ot");
		choiceNombreCortoOT.add("Elija nombre de la OT");
		descripcion.add("Elija una ot para consultar la descripción");
		fechaConfeccion.add("");
		fechaEntrega.add("");
		cliente.add("Elija una OT");
		nroOT.add("");
		medida.add("");
		apaisado.add("");
		cantidadAentregar.add("");
		cantPlanchas.add("");
		producto.add("");
		nroOTenmascarado.add("");
		
		Formato f=new Formato();
		for(int i=0;i<matriz.size();i++){
			
			cantPlanchas.add(matriz.get(i).get(10));
			cantidadAentregar.add(matriz.get(i).get(9));
			producto.add(matriz.get(i).get(8));
			apaisado.add(matriz.get(i).get(7));
			medida.add(matriz.get(i).get(6));
			fechaConfeccion.add(matriz.get(i).get(5));
			fechaEntrega.add(matriz.get(i).get(4));
			descripcion.add(matriz.get(i).get(3));
			cliente.add(matriz.get(i).get(2));
			choiceNombreCortoOT.add(matriz.get(i).get(1));
			nroOT.add( matriz.get(i).get(0));
			nroOTenmascarado.add(f.enMascarar("0001-", matriz.get(i).get(0))[0]);
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(SystemColor.activeCaption);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
			jContentPane.add(getJPanel2(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJPanel3(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextPaneCliente	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneCliente() {
		if (jTextPaneCliente == null) {
			jTextPaneCliente = new JTextPane();
			jTextPaneCliente.setText("");
			jTextPaneCliente.setEditable(false);
			jTextPaneCliente.setBounds(new Rectangle(203, 32, 136, 31));
		}
		return jTextPaneCliente;
	}

	/**
	 * This method initializes jTextPaneFecha	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneFecha() {
		if (jTextPaneFecha == null) {
			jTextPaneFecha = new JTextPane();
			jTextPaneFecha.setText("");
			jTextPaneFecha.setEditable(false);
			jTextPaneFecha.setBounds(new Rectangle(348, 32, 136, 31));
		}
		return jTextPaneFecha;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(28, 151, 1203, 120));
			jPanel.add(getJTextPane4(), null);
			jPanel.add(getJScrollPane(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(9, 30, 589, 72));
			jScrollPane.setViewportView(getJTable1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modelo=new DefaultTableModel();
	private JTable getJTable1() {
		/*modelo.addColumn("Tareas");
		modelo.addColumn("Avance");
		modelo.addColumn("Fecha Inicio");
		modelo.addColumn("Fecha Cierre");
		modelo.addColumn("Tercerizada");
		modelo.addColumn("Obsevación");*/

		if (jTable1 == null) {
			jTable1 = new JTable(modelo);
		}
		return jTable1;
	}

	/**
	 * This method initializes jTextPane4	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane4() {
		if (jTextPane4 == null) {
			jTextPane4 = new JTextPane();
			jTextPane4.setText("Estado De Las Tareas De La Orden De Trabajo");
			jTextPane4.setBounds(new Rectangle(10, 4, 268, 22));
		}
		return jTextPane4;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new Rectangle(29, 273, 1202, 181));
			jPanel1.add(getJTextPane41(), null);
			jPanel1.add(getJScrollPane1(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jTable2	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modelo1=new DefaultTableModel();
	private JScrollPane jScrollPane1 = null;
	private JTable jTable3 = null;
	/**
	 * This method initializes jTextPane41	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane41() {
		if (jTextPane41 == null) {
			jTextPane41 = new JTextPane();
			jTextPane41.setText("Historial de Uso de Materias Primas");
			jTextPane41.setBounds(new Rectangle(10, 4, 207, 22));
		}
		return jTextPane41;
	}

	/**
	 * This method initializes jTextPanePautada	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPanePautada() {
		if (jTextPanePautada == null) {
			jTextPanePautada = new JTextPane();
			jTextPanePautada.setText("");
			jTextPanePautada.setEditable(false);
			jTextPanePautada.setBounds(new Rectangle(493, 32, 192, 31));
		}
		return jTextPanePautada;
	}

	/**
	 * This method initializes jTextPaneDescripcion	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneDescripcion() {
		if (jTextPaneDescripcion == null) {
			jTextPaneDescripcion = new JTextPane();
			jTextPaneDescripcion.setText("");
			jTextPaneDescripcion.setEditable(false);
			jTextPaneDescripcion.setBounds(new Rectangle(550, 93, 644, 31));
		}
		return jTextPaneDescripcion;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(10, 33, 1181, 135));
			jScrollPane1.setViewportView(getJTable3());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable3	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable3() {
		/*modelo1.addColumn("Cantidad Prevista");
		modelo1.addColumn("Cantidad Usada");
		modelo1.addColumn("Solicitud Compra");
		modelo1.addColumn("Fecha SC");*/
		if (jTable3 == null) {
			jTable3 = new JTable(modelo1);
		}
		return jTable3;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modelo2=new DefaultTableModel();
	private JPanel jPanel2 = null;
	private Choice choiceNombreCortoOT = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JButton jButtonSalir = null;
	private JTextPane jTextPaneMedida = null;
	private JLabel jLabel2 = null;
	private JTextPane jTextPaneApaisado = null;
	private JLabel jLabel6 = null;
	private JTextPane jTextPaneProducto = null;
	private JLabel jLabel7 = null;
	private JTextPane jTextPaneCantidadAentregar = null;
	private JLabel jLabel8 = null;
	private JTextPane jTextPanePlanchas = null;
	private JLabel jLabel9 = null;
	private JPanel jPanel3 = null;
	private JScrollPane jScrollPane2 = null;
	private JTable jTableMaterialesPedidos = null;
	private JTextPane jTextPane = null;
	private JTextPane jTextPaneNroOT = null;
	private JLabel jLabel10 = null;
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(13, 74, 90, 19));
			jLabel10.setText("Numero de OT");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(374, 73, 141, 17));
			jLabel9.setText("Cantidad de planchas");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(202, 71, 129, 19));
			jLabel8.setText("Cantidad a entregar");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(985, 9, 171, 19));
			jLabel7.setText("Producto");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(830, 9, 147, 19));
			jLabel6.setText("Detalle Apaisado");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(696, 9, 128, 19));
			jLabel2.setText("Medida");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(550, 74, 201, 15));
			jLabel5.setText("Descripción de la orden de trabajo");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(495, 9, 198, 19));
			jLabel4.setText("Fecha pautada de entrega");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(350, 9, 140, 19));
			jLabel3.setText("Fecha de confección");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(206, 9, 135, 19));
			jLabel1.setText("Cliente");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(10, 9, 185, 19));
			jLabel.setBackground(SystemColor.activeCaption);
			jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			jLabel.setText("Nombre corto de la OT");
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(new Rectangle(27, 13, 1205, 136));
			jPanel2.add(getJTextPaneCliente(), null);
			jPanel2.add(getJTextPaneFecha(), null);
			jPanel2.add(getJTextPanePautada(), null);
			jPanel2.add(getJTextPaneDescripcion(), null);
			jPanel2.add(getChoiceNombreCortoOT(), null);
			jPanel2.add(jLabel, null);
			jPanel2.add(jLabel1, null);
			jPanel2.add(jLabel3, null);
			jPanel2.add(jLabel4, null);
			jPanel2.add(jLabel5, null);
			jPanel2.add(getJTextPaneMedida(), null);
			jPanel2.add(jLabel2, null);
			jPanel2.add(getJTextPaneApaisado(), null);
			jPanel2.add(jLabel6, null);
			jPanel2.add(getJTextPaneProducto(), null);
			jPanel2.add(jLabel7, null);
			jPanel2.add(getJTextPaneCantidadAentregar(), null);
			jPanel2.add(jLabel8, null);
			jPanel2.add(getJTextPanePlanchas(), null);
			jPanel2.add(jLabel9, null);
			jPanel2.add(getJTextPaneNroOT(), null);
			jPanel2.add(jLabel10, null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes choiceNombreCortoOT	
	 * 	
	 * @return java.awt.Choice	
	 */
	private void limpiartabla(JTable tabla){
		try{
		DefaultTableModel tmp=(DefaultTableModel) tabla.getModel();
		
		for(;tmp.getRowCount()!=0;){
			
			tmp.removeRow(tmp.getRowCount()-1);
		
		}
		}catch(Exception e){
			
		}
		
	}
	private Choice getChoiceNombreCortoOT() {
		if (choiceNombreCortoOT == null) {
			choiceNombreCortoOT = new Choice();
			choiceNombreCortoOT.setBounds(new Rectangle(9, 32, 185, 29));
			choiceNombreCortoOT.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(!choiceNombreCortoOT.equals("Elija nombre de la OT")){
					metodosSql metodos=new metodosSql();
					int indice=choiceNombreCortoOT.getSelectedIndex();
					jTextPaneCliente.setText(cliente.get(indice));
					jTextPaneFecha.setText(fechaConfeccion.get(indice));
					jTextPanePautada.setText(fechaEntrega.get(indice));
					jTextPaneDescripcion.setText(descripcion.get(indice));
					jTextPaneMedida.setText(medida.get(indice));
					jTextPaneApaisado.setText(apaisado.get(indice));
					jTextPaneProducto.setText(producto.get(indice));
					jTextPaneCantidadAentregar.setText(cantidadAentregar.get(indice));
					jTextPanePlanchas.setText(cantPlanchas.get(indice));
					jTextPaneNroOT.setText(nroOTenmascarado.get(indice));
					
					
					
					if(indice!=0){
String sentencia="select ta.descripcion as Descripcion,tao.estado as Estado,if(pro.idproveedor!=1000,pro.razonsocial,'')" +
		" as Proveedor,tao.fechadecierre as FechaCierre FROM imprenta.tareaordtrabajo tao,imprenta.tarea ta,imprenta.proveedor" +
		" pro where tao.idordtrabajo="+nroOT.get(indice)+" and tao.idtarea=ta.idtarea and tao.idproveedor=pro.idproveedor " +
				" order by ta.idtarea;";
					
String sentenciaHistorial="select mat.nroSolicitudDeCompra as SC,con.CantidadConsumida as Consumida,mat.marca as" +
		" Marca,mat.calidad as Calidad ,mat.variante as Variante,mat.gramaje as Gramaje,concat(mat.ancho,'X',mat.alto) as Formato, "+
		" con.fechaconsumo as FechaConsumo,con.horaDelConsumo as HoraConsumo from imprenta.consumosdelaot con," +
		" imprenta.materialesdelasolicituddecompra mat where con.nroot="+nroOT.get(indice)+" "+
		" and mat.idmatsolcompra=con.idmaterialconsumido;";

String sentenciaMatPedidos="SELECT elementodelproducto as Elemento,cantidadxunidadtrabajo as Cant,Calidaddescripcion as Calidad,variantedescripcion as Variante, "+
" gramaje as Gramaje, formatodescripcion as Formato,posesXpliego as PXPliego,pliegosnetos as PLnetos,pliegosendemasia as PLdemas, "+
" pliegosxhoja as PLhoja,hojas as Hojas "+
" FROM imprenta.materiaprimadelaot where nroOrdentrabajo="+nroOT.get(indice);
/*String sentenciaStock="SELECT s.nroSolicitudCompra as SC,s.cantidad as QuedaEnStock, "+
" mat.marca as Marca,mat.calidad as Calidad "+
" ,mat.variante as Variante,mat.gramaje as Gramaje,concat(mat.ancho,'X',mat.alto) as Formato FROM "+
" imprenta.stock s,imprenta.materialesdelasolicituddecompra mat where nroOT="+nroOT.get(indice)+" "+
" and mat.idmatsolcompra=s.idmaterialesdelasol;";
//System.out.println(indice);*/



jTable1.setModel(metodos.llenarJtable(sentencia).getModel());
jTable3.setModel(metodos.llenarJtable(sentenciaHistorial).getModel());
jTableMaterialesPedidos.setModel(metodos.llenarJtable(sentenciaMatPedidos).getModel());

					}else{
						limpiartabla(jTable1);
						limpiartabla(jTableMaterialesPedidos);
						limpiartabla(jTable3);
						
					}
					}
				}
			});
		}
		return choiceNombreCortoOT;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(1087, 651, 144, 28));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSalir;
	}

	/**
	 * This method initializes jTextPaneMedida	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneMedida() {
		if (jTextPaneMedida == null) {
			jTextPaneMedida = new JTextPane();
			jTextPaneMedida.setBounds(new Rectangle(694, 32, 127, 31));
			jTextPaneMedida.setEditable(false);
		}
		return jTextPaneMedida;
	}

	/**
	 * This method initializes jTextPaneApaisado	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneApaisado() {
		if (jTextPaneApaisado == null) {
			jTextPaneApaisado = new JTextPane();
			jTextPaneApaisado.setBounds(new Rectangle(830, 32, 147, 31));
			jTextPaneApaisado.setEditable(false);
		}
		return jTextPaneApaisado;
	}

	/**
	 * This method initializes jTextPaneProducto	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneProducto() {
		if (jTextPaneProducto == null) {
			jTextPaneProducto = new JTextPane();
			jTextPaneProducto.setBounds(new Rectangle(986, 32, 208, 31));
			jTextPaneProducto.setEditable(false);
		}
		return jTextPaneProducto;
	}

	/**
	 * This method initializes jTextPaneCantidadAentregar	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneCantidadAentregar() {
		if (jTextPaneCantidadAentregar == null) {
			jTextPaneCantidadAentregar = new JTextPane();
			jTextPaneCantidadAentregar.setBounds(new Rectangle(202, 93, 165, 31));
			jTextPaneCantidadAentregar.setEditable(false);
		}
		return jTextPaneCantidadAentregar;
	}

	/**
	 * This method initializes jTextPanePlanchas	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPanePlanchas() {
		if (jTextPanePlanchas == null) {
			jTextPanePlanchas = new JTextPane();
			jTextPanePlanchas.setBounds(new Rectangle(374, 93, 168, 31));
			jTextPanePlanchas.setEditable(false);
		}
		return jTextPanePlanchas;
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
			jPanel3.setBounds(new Rectangle(29, 457, 1201, 189));
			jPanel3.add(getJScrollPane2(), null);
			jPanel3.add(getJTextPane(), null);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(11, 30, 1177, 139));
			jScrollPane2.setViewportView(getJTableMaterialesPedidos());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jTableMaterialesPedidos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMaterialesPedidos() {
		if (jTableMaterialesPedidos == null) {
			jTableMaterialesPedidos = new JTable();
		}
		return jTableMaterialesPedidos;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			jTextPane = new JTextPane();
			jTextPane.setBounds(new Rectangle(11, 4, 184, 23));
			jTextPane.setText("Materiales solicitados por la OT");
		}
		return jTextPane;
	}

	/**
	 * This method initializes jTextPaneNroOT	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JTextPane getJTextPaneNroOT() {
		if (jTextPaneNroOT == null) {
			jTextPaneNroOT = new JTextPane();
			jTextPaneNroOT.setBounds(new Rectangle(12, 94, 183, 31));
			jTextPaneNroOT.setEditable(false);
		}
		return jTextPaneNroOT;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

