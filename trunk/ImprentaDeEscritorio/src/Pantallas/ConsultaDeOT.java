package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Base.metodosSql;
import javax.swing.JButton;
import javax.swing.JToggleButton;

@SuppressWarnings("unused")
public class ConsultaDeOT extends JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel MaterialesOT;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneOt = null;
	private JTable jTableOT = null;
	private JScrollPane jScrollPaneTareasOT = null;
	private JTable jTableTareasOT = null;
	private JScrollPane jScrollPaneMaterialesOt = null;
	private JTable jTableMaterialesOT = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;

	/**
	 * This is the default constructor
	 */
	public ConsultaDeOT() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1259, 555);
		this.setContentPane(getJContentPane());
		this.setTitle("LISTADO DE ORDENES DE TRABAJO");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(15, 371, 267, 19));
			jLabel2.setText("Tareas de la OT");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 4, 239, 19));
			jLabel1.setText("Listado de OT");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(14, 195, 221, 17));
			jLabel.setText("Materiales usados en la OT");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneOt(), null);
			jContentPane.add(getJScrollPaneTareasOT(), null);
			jContentPane.add(getJScrollPaneMaterialesOt(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButtonCambiarEstadoTarea(), null);
			jContentPane.add(getJToggleButton(), null);
			jContentPane.add(getJButtonSalir(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneOt	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneOt() {
		if (jScrollPaneOt == null) {
			jScrollPaneOt = new JScrollPane();
			jScrollPaneOt.setBounds(new Rectangle(15, 31, 1222, 156));
			jScrollPaneOt.setViewportView(getJTableOT());
		}
		return jScrollPaneOt;
	}

	/**
	 * This method initializes jTableOT	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableOT() {
		metodosSql metodos=new metodosSql();
		final metodosSql metodos2=new metodosSql();
		
		if (jTableOT == null) {
			jTableOT = new JTable();
			jTableOT=metodos.llenarJtable("Select * from imprenta.ordentrabajo where estado != 'CERRADA' order by nroorden DESC");
			jTableOT.setCellSelectionEnabled(false);
			jTableOT.setColumnSelectionAllowed(false);
			//jTableOT.is
			jTableOT.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					metodosSql metodos=new metodosSql();
					
					
					//System.out.println(jTableOT.getModel().getValueAt(jTableOT.getSelectedRow(), jTableOT.getSelectedColumn()));// TODO Auto-generated Event stub mouseClicked()
					jTableMaterialesOT.setModel(metodos2.llenarJtable("select * from imprenta.materiaprimadelaot  " +
							"where nroordentrabajo= "+jTableOT.getModel().getValueAt(jTableOT.getSelectedRow(), 0)+" ;").getModel());
					jTableTareasOT.setModel(metodos.llenarJtable("SELECT idOrdTrabajo,Descripcion,razonSocial,estado FROM "+
							"imprenta.tareaordtrabajo tao,imprenta.tarea t,imprenta.proveedor p where idOrdTrabajo= "+jTableOT.getModel().getValueAt(jTableOT.getSelectedRow(), 0)+" "+
					" and "+
					" tao.idTarea=t.idTarea "+
					" and "+
					" tao.idProveedor=p.idproveedor;").getModel()
									
								);	
					jTableTareasOT.isCellEditable(0,0);
				}
			});
		}
		return jTableOT;
	}

	/**
	 * This method initializes jScrollPaneTareasOT	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneTareasOT() {
		if (jScrollPaneTareasOT == null) {
			jScrollPaneTareasOT = new JScrollPane();
			jScrollPaneTareasOT.setBounds(new Rectangle(16, 387, 914, 128));
			jScrollPaneTareasOT.setViewportView(getJTableTareasOT());
		}
		return jScrollPaneTareasOT;
	}

	/**
	 * This method initializes jTableTareasOT	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableTareasOT() {
		if (jTableTareasOT == null) {
			jTableTareasOT = new JTable();
		}
		return jTableTareasOT;
	}

	/**
	 * This method initializes jScrollPaneMaterialesOt	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneMaterialesOt() {
		if (jScrollPaneMaterialesOt == null) {
			jScrollPaneMaterialesOt = new JScrollPane();
			jScrollPaneMaterialesOt.setBounds(new Rectangle(15, 217, 1218, 154));
			jScrollPaneMaterialesOt.setViewportView(getJTableMaterialesOT());
		}
		return jScrollPaneMaterialesOt;
	}

	/**
	 * This method initializes jTableMaterialesOT	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modeloMaterialesOT=new DefaultTableModel();
	private JButton jButtonCambiarEstadoTarea = null;
	private JToggleButton jToggleButton = null;
	private JButton jButtonSalir = null;
	private JTable getJTableMaterialesOT() {
		if (jTableMaterialesOT == null) {
			jTableMaterialesOT = new JTable(modeloMaterialesOT);
			
			
			
		}
			
			
		return jTableMaterialesOT;
		
	}

	/**
	 * This method initializes jButtonCambiarEstadoTarea	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCambiarEstadoTarea() {
		if (jButtonCambiarEstadoTarea == null) {
			jButtonCambiarEstadoTarea = new JButton();
			jButtonCambiarEstadoTarea.setBounds(new Rectangle(939, 388, 294, 62));
			jButtonCambiarEstadoTarea.setText("Cambiar estado de la tarea");
			jButtonCambiarEstadoTarea.setVisible(false);
			jButtonCambiarEstadoTarea
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							
							
							
							try{
							
							
							metodosSql metodos=new metodosSql();
							for(int i=0;i<jTableTareasOT.getRowCount();i++){
							String descripcion=jTableTareasOT.getValueAt(i, 1).toString();
							
							int idTarea=metodos.dameNombreTareaTeDoySuId(descripcion);
							
							String proveedor=jTableTareasOT.getValueAt(i, 2).toString();
							
							int nroProveedor=metodos.dameProveedorTeDoyId(proveedor);
							
							String estado=jTableTareasOT.getValueAt(i, 3).toString();//
							
							metodos.insertarOmodif("Update `imprenta`.`tareaOrdtrabajo` set `estado`= '"+estado+"'" +
									" where `idProveedor`= '"+nroProveedor+"' and `idTarea`= '"+idTarea+"';");
							}
							}catch(Exception excep){}
						
						
						
						
						
						
						
						}
					});
		}
		return jButtonCambiarEstadoTarea;
	}

	/**
	 * This method initializes jToggleButton	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton() {
		if (jToggleButton == null) {
			jToggleButton = new JToggleButton();
			jToggleButton.setBounds(new Rectangle(942, 442, 213, 18));
			jToggleButton.setText("Ver OT cerradas");
			jToggleButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					metodosSql metodos=new metodosSql();
					DefaultTableModel mod=new DefaultTableModel();
				if(jToggleButton.isSelected()){
					jToggleButton.setText("Ver OT abiertas");
					jTableOT.setModel(metodos.llenarJtable("Select * from imprenta.ordentrabajo where estado = 'CERRADA' order by nroorden DESC").getModel());
					jTableMaterialesOT.setModel(mod);
					jTableTareasOT.setModel(mod);
					
				}else{
					jToggleButton.setText("Ver OT cerradas");
					jTableOT.setModel(metodos.llenarJtable("Select * from imprenta.ordentrabajo where estado != 'CERRADA' order by nroorden DESC").getModel());
					jTableMaterialesOT.setModel(mod);
					jTableTareasOT.setModel(mod);
				}
				}
			});
		}
		return jToggleButton;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(941, 476, 213, 18));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSalir;
	}
	
}

  //  @jve:decl-index=0:visual-constraint="10,10"
