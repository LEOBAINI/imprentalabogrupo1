package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Base.metodosSql;
import Formateador.JtableNoEditable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;

@SuppressWarnings("unused")
public class CosultaDeOC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableOCompras = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableMaterialesOC = null;
	private JLabel jLabelTituloSolicituddeCompra = null;
	private JLabel jLabelMaterialesdelasolicitud = null;
	private JToggleButton jToggleButton = null;
	private JButton jButtonSalir = null;

	/**
	 * This is the default constructor
	 */
	public CosultaDeOC() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1218, 582);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta Solicitud de Compra");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 317, 237, 24));
			jLabel.setText("Historial de ingresos");
			jLabelMaterialesdelasolicitud = new JLabel();
			jLabelMaterialesdelasolicitud.setBounds(new Rectangle(14, 199, 76, 16));
			jLabelMaterialesdelasolicitud.setText("Materiales ");
			jLabelTituloSolicituddeCompra = new JLabel();
			jLabelTituloSolicituddeCompra.setBounds(new Rectangle(13, 36, 170, 27));
			jLabelTituloSolicituddeCompra.setText("Solicitudes de Compra");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(jLabelTituloSolicituddeCompra, null);
			jContentPane.add(jLabelMaterialesdelasolicitud, null);
			jContentPane.add(getJToggleButton(), null);
			jContentPane.add(getJButtonSalir(), null);
			jContentPane.add(getJScrollPane2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonRechazo(), null);
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
			jScrollPane.setBounds(new Rectangle(12, 75, 1160, 117));
			jScrollPane.setViewportView(getJTableOCompras());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableOCompras	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public void inicializarCampos(){
		metodosSql metodos=new metodosSql();
		DefaultTableModel modeloSC=new DefaultTableModel();
		DefaultTableModel modeloMateriales=new DefaultTableModel();
		modeloSC=(DefaultTableModel) metodos.llenarJtable("SELECT * FROM imprenta.solicitudcompra;").getModel();
		
	}
	private JTable getJTableOCompras() {
		metodosSql metodos=new metodosSql();
		DefaultTableModel modeloSC=new DefaultTableModel();	
		
		modeloSC=(DefaultTableModel) metodos.llenarJtable("SELECT * FROM imprenta.solicitudcompra where estado !='ENTREGADO' order by idsolicitudCompra desc;").getModel();
		
		if (jTableOCompras == null) {
			jTableOCompras = new JTable(modeloSC);
			jTableOCompras.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					metodosSql metodos=new metodosSql();
					int nroSolicitudDeCompra=Integer.parseInt(getJTableOCompras().getModel().getValueAt(jTableOCompras.getSelectedRow(), 0).toString());
jTableMaterialesOC.setModel(metodos.llenarJtable("SELECT cantidad as Cantidad ,recibido as Recibido ,A_Recibir as PorRecibir,Marca,calidad as Calidad,variante "+
" as Variante,gramaje as Gramaje,concat(ancho,'X',alto) as Formato, "+
" costototal as CostoTotal,entregado as Entregado,comentario as Comentario FROM imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra="+nroSolicitudDeCompra+";").getModel());
				
				
jTableHistorialIngresos.setModel( metodos.llenarJtable("SELECT H.CANTIDADRECIBIDA as Recibido ,fecharecepcion as Fecha,horarecepcion as Hora, "+
		" Marca,calidad as Calidad,variante  as Variante,gramaje as Gramaje,concat(ancho,'X',alto) as Formato "+
  " FROM imprenta.historialrecepcion H,imprenta.materialesdelasolicituddecompra M "+
" where idmaterial=idmatsolcompra and solicitudcompranro="+nroSolicitudDeCompra+" ;").getModel());				
				
				
				
				}
			});
		}
		return jTableOCompras;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(12, 226, 1159, 88));
			jScrollPane1.setViewportView(getJTableMaterialesOC());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTableMaterialesOC	
	 * 	
	 * @return javax.swing.JTable	
	 */JtableNoEditable mod=new JtableNoEditable();
	private JScrollPane jScrollPane2 = null;
	private JTable jTableHistorialIngresos = null;
	private JLabel jLabel = null;
	private JButton jButtonRechazo = null;
	private JTable getJTableMaterialesOC() {
		if (jTableMaterialesOC == null) {
			jTableMaterialesOC = new JTable(mod);
		}
		return jTableMaterialesOC;
	}

	/**
	 * This method initializes jToggleButton	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton() {
		if (jToggleButton == null) {
			jToggleButton = new JToggleButton();
			jToggleButton.setBounds(new Rectangle(930, 461, 244, 23));
			jToggleButton.setText("Mostrar tambien SC cerradas");
			jToggleButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					metodosSql metodos=new metodosSql();
					if(jToggleButton.isSelected()){
						jToggleButton.setText("Mostrar sólo SC abiertas");
						jTableOCompras.setModel((DefaultTableModel) metodos.llenarJtable("SELECT * FROM imprenta.solicitudcompra  order by idsolicitudCompra desc;").getModel());
						jTableMaterialesOC.setModel(metodos.llenarJtable("SELECT * FROM imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra=-1;").getModel());
						jTableHistorialIngresos.setModel(metodos.llenarJtable("SELECT cantidad as CantidadPedida ,recibido as Recibido ,fecharecepcion as Fecha,horarecepcion as Hora,A_Recibir as PorRecibir," +
		" Marca,calidad as Calidad,variante  as Variante,gramaje as Gramaje,concat(ancho,'X',alto) as Formato, "+
 " costototal as CostoTotal,entregado as Entregado FROM imprenta.historialrecepcion,imprenta.materialesdelasolicituddecompra "+
" where idmaterial=idmatsolcompra and solicitudcompranro=-1;").getModel());
					}else{
						jToggleButton.setText("Mostrar tambien SC cerradas");
						jTableOCompras.setModel((DefaultTableModel) metodos.llenarJtable("SELECT * FROM imprenta.solicitudcompra where estado !='ENTREGADO' order by idsolicitudCompra desc;").getModel());
						
						jTableMaterialesOC.setModel(metodos.llenarJtable("SELECT * FROM imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra=-1;").getModel());
						jTableHistorialIngresos.setModel(metodos.llenarJtable("SELECT cantidad as CantidadPedida ,recibido as Recibido ,fecharecepcion as Fecha,horarecepcion as Hora,A_Recibir as PorRecibir," +
		" Marca,calidad as Calidad,variante  as Variante,gramaje as Gramaje,concat(ancho,'X',alto) as Formato, "+
 " costototal as CostoTotal,entregado as Entregado FROM imprenta.historialrecepcion,imprenta.materialesdelasolicituddecompra "+
" where idmaterial=idmatsolcompra and solicitudcompranro=-1;").getModel());
					
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
			jButtonSalir.setBounds(new Rectangle(930, 497, 245, 24));
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
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(new Rectangle(13, 353, 1158, 92));
			jScrollPane2.setViewportView(getJTableHistorialIngresos());
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jTableHistorialIngresos	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableHistorialIngresos() {
		if (jTableHistorialIngresos == null) {
			jTableHistorialIngresos = new JTable();
		}
		return jTableHistorialIngresos;
	}

	/**
	 * This method initializes jButtonRechazo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRechazo() {
		if (jButtonRechazo == null) {
			jButtonRechazo = new JButton();
			jButtonRechazo.setBounds(new Rectangle(737, 493, 173, 27));
			jButtonRechazo.setText("Ver Rechazos");
			jButtonRechazo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTableOCompras.getSelectedRow()!=-1){
					int nroSolicitud=Integer.parseInt(jTableOCompras.getValueAt(jTableOCompras.getSelectedRow(), 0).toString());
					
					Rechazo r=new Rechazo(nroSolicitud);
					r.setVisible(true);
					r.setLocationRelativeTo(null);
					}else{
						JOptionPane.showMessageDialog(null, "Elija una Solicitud de compra para consultar");
					}
				}
			});
		}
		return jButtonRechazo;
	}

}  //  @jve:decl-index=0:visual-constraint="100,-51"
