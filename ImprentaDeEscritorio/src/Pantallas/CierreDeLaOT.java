package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;

import Base.metodosSql;
import Formateador.JtableNoEditable;

import java.awt.Color;
import java.util.ArrayList;

public class CierreDeLaOT extends JFrame {

	private static final long serialVersionUID = 1L;
	private String nombre=null;
	JtableNoEditable modelo=new JtableNoEditable(); 	
	private String estado=null;
	private String fecha=null;
	private int numeroDeOT=0;
	private int numeroTarea=0;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableTareas = null;
	private Choice choiceNombreDeOT = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JButton jButtonFinalizarTarea = null;
	private JTextField jTextFieldFecha = null;
	private JLabel jLabel2 = null;
	private JPanel jPanel = null;
	private JButton jButtonSalir = null;
	private ArrayList<ArrayList<String>>_matriz;
	/**
	 * This is the default constructor
	 */
	public CierreDeLaOT() {
		super();
		initialize();
		inicializar();
		
	}

	private void inicializar() {
		metodosSql metodos=new metodosSql();
		ArrayList<String> nombresOT=metodos.consultarUnaColumna("Select nombre from imprenta.ordenTrabajo where ESTADO!='CERRADA';");
		
		for(int i=0;i<nombresOT.size();i++)
		choiceNombreDeOT.add(nombresOT.get(i));
		jTextFieldFecha.setText(metodos.dameFechaDeHoyConFormatoX("dd'-'MM'-'yyyy"));
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(828, 492);
		this.setSize(new Dimension(1063, 411));
	
		this.setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setTitle("Cierre de Orden de Trabajo");
		
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Fecha");
			jLabel2.setBounds(new Rectangle(434, 15, 195, 26));
			jLabel1 = new JLabel();
			jLabel1.setText("Tareas de la Orden de trabajo");
			jLabel1.setBounds(new Rectangle(13, 15, 276, 26));
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(33, 4, 240, 18));
			jLabel.setText("Nombre de la Orden de trabajo");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jContentPane.add(getChoiceNombreDeOT(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(14, 51, 407, 140));
			jScrollPane.setViewportView(getJTableTareas());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableTareas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableTareas() {
		modelo.addColumn("Nombre");
		modelo.addColumn("Estado");
		modelo.addColumn("Fecha de cierre");
		
		if (jTableTareas == null) {
			jTableTareas = new JTable(modelo);
		
			
		}
		return jTableTareas;
	}

	/**
	 * This method initializes choiceNombreDeOT	
	 * 	
	 * @return java.awt.Choice	
	 */
	private void llenarLaTablaDeTareas(){
		JtableNoEditable modelo1=new JtableNoEditable(); 
		modelo1.addColumn("Nombre");
		modelo1.addColumn("Estado");
		modelo1.addColumn("Fecha de cierre");
		JTable aux=new JTable(modelo1);
		metodosSql metodos=new metodosSql();
		
		int filasMatriz=0;
		int nroOrdenTrabajo=metodos.dameNombreOTteDoyNroOT(choiceNombreDeOT.getSelectedItem());
		ArrayList<ArrayList<String>>matriz=null;
		String SentenciaSql=null;
		SentenciaSql="Select idOrdTrabajo,tao.idTarea,descripcion," +
				" estado,fechaDeCierre from imprenta.tareaOrdTrabajo tao," +
				"imprenta.tarea ta where tao.idTarea=ta.idtarea " +
				"and idOrdTrabajo="+nroOrdenTrabajo+" ;";
		
		
		matriz=metodos.consultar(SentenciaSql);
		_matriz=matriz;
		filasMatriz=matriz.size();
		//JtableNoEditable modelo1; 
		
	//	modelo1=(JtableNoEditable) jTableTareas.getModel();
		
		for(int i=0;i<filasMatriz;i++){
		
		nombre=matriz.get(i).get(2);
		estado=matriz.get(i).get(3);
		fecha=matriz.get(i).get(4);
		Object[] fila=new Object[3];
		fila[0]=nombre;
		fila[1]=estado;
		fila[2]=fecha;
		modelo1.addRow(fila);
		}
		jTableTareas.setModel(aux.getModel());
	}
	private Choice getChoiceNombreDeOT() {
		if (choiceNombreDeOT == null) {
			choiceNombreDeOT = new Choice();
			choiceNombreDeOT.setBounds(new Rectangle(31, 29, 242, 29));
			choiceNombreDeOT.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					
					if(choiceNombreDeOT.getSelectedItem()!=""){
						
						llenarLaTablaDeTareas();
					}
					else{
						
						
							
							
						//JOptionPane.showMessageDialog(null, "Seleccone un elemento no vacio por favor.");
						
					
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
			});
		}
		return choiceNombreDeOT;
	}

	/**
	 * This method initializes jButtonFinalizarTarea	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private boolean lasTareasAnterioresEstanCerradas(int indiceElegido){
		
		for(int i=0;i<indiceElegido;i++){
			
			
			  if(!_matriz.get(i).get(3).equals("CERRADA")){
				JOptionPane.showMessageDialog(null,"Tiene tareas anteriores por cerrar, hágalo primero antes de cerrar la actual");
				return false;
				
			}
		}
		
		return true;
	}//Seguir revisando,...........................
	
	
	
	
	private JButton getJButtonFinalizarTarea() {
		if (jButtonFinalizarTarea == null) {
			jButtonFinalizarTarea = new JButton();
			jButtonFinalizarTarea.setText("Finalizar Tarea");
			jButtonFinalizarTarea.setBounds(new Rectangle(434, 154, 196, 34));
			jButtonFinalizarTarea.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTableTareas.getSelectedRow()!=-1){//si hay al menos una fila elegida....
						if(lasTareasAnterioresEstanCerradas(jTableTareas.getSelectedRow())){// y si las anteriores tareas estan cerradas....
						try{
						metodosSql metodos=new metodosSql();
						numeroTarea=Integer.parseInt( _matriz.get(jTableTareas.getSelectedRow()).get(1));
						numeroDeOT=Integer.parseInt(_matriz.get(jTableTareas.getSelectedRow()).get(0));
						metodos.insertarOmodif("update tareaOrdTrabajo set estado='CERRADA',fechaDeCierre= '"+metodos.dameFechaDeHoy()+"'" +
								" where idOrdTrabajo="+numeroDeOT+" and idTarea= "+numeroTarea+";");
						
						llenarLaTablaDeTareas();//refrescar............
						if(cerrarLaOTSitodasLasTareasEstanCerradas()){
							try{
							metodos.insertarOmodif("update ordentrabajo set Estado= 'CERRADA' WHERE NroOrden= "+numeroDeOT+";");
							metodos.insertarOmodif("update stock set NroOT=0 where NroOT= "+numeroDeOT+";");
							}
							catch(Exception er){
								JOptionPane.showMessageDialog(null,"Problema al UPDATE ordenTrabajo o Stock al cerrar la OT "+numeroDeOT);
							}
						}
						}
						catch(Exception ex){//rollback!
							metodosSql metodos=new metodosSql();
							JOptionPane.showMessageDialog(null,ex.getMessage()+" linea 255 cierredelaot");
							metodos.insertarOmodif("update tareaOrdTrabajo set estado='ABIERTA',fechaDeCierre= null" +
									" where idOrdTrabajo="+numeroDeOT+" and idTarea= "+numeroTarea+";");
						}
						}
						else{
							JOptionPane.showMessageDialog(null,"No se ha cerrado la tarea anterior");//no hacer nada... mensaje se muestra en la funcion lasTareasAnterioresEstanCerradas
						}
					}else{
						JOptionPane.showMessageDialog(null,"Seleccione una tarea para cerrar...");
					}
				}

				
			});
		}
		return jButtonFinalizarTarea;
	}
	
	
	private boolean cerrarLaOTSitodasLasTareasEstanCerradas() {
		int contador=0;
		int largoDeLasTareas=_matriz.size();//columna 3= estado de las tareas en la consulta que llena la matriz
		for(int i=0;i<largoDeLasTareas;i++){
			if(_matriz.get(i).get(3).equals("CERRADA")){
				contador++;
				
			}
			
		}
		return contador==largoDeLasTareas;

		
	}

	/**
	 * This method initializes jTextFieldFecha	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFecha() {
		if (jTextFieldFecha == null) {
			jTextFieldFecha = new JTextField();
			jTextFieldFecha.setBounds(new Rectangle(434, 53, 89, 19));
			jTextFieldFecha.setEditable(false);
		}
		return jTextFieldFecha;
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
			jPanel.setBounds(new Rectangle(28, 79, 653, 215));
			jPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel.add(jLabel2, null);
			jPanel.add(getJTextFieldFecha(), null);
			jPanel.add(getJButtonFinalizarTarea(), null);
			jPanel.add(getJScrollPane(), null);
			jPanel.add(jLabel1, null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(460, 310, 199, 32));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonSalir;
	}

}  //  @jve:decl-index=0:visual-constraint="1,1"
