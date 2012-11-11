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
import javax.swing.JLabel;

public class CosultaDeOC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableOCompras = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableMaterialesOC = null;
	private JLabel jLabelTituloSolicituddeCompra = null;
	private JLabel jLabelMaterialesdelasolicitud = null;

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
		this.setSize(1218, 421);
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
		
		modeloSC=(DefaultTableModel) metodos.llenarJtable("SELECT * FROM imprenta.solicitudcompra order by idsolicitudCompra desc;").getModel();
		
		if (jTableOCompras == null) {
			jTableOCompras = new JTable(modeloSC);
			jTableOCompras.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					metodosSql metodos=new metodosSql();
					int nroSolicitudDeCompra=Integer.parseInt(getJTableOCompras().getModel().getValueAt(jTableOCompras.getSelectedRow(), 0).toString());
jTableMaterialesOC.setModel(metodos.llenarJtable("SELECT * FROM imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra="+nroSolicitudDeCompra+";").getModel());
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
			jScrollPane1.setBounds(new Rectangle(12, 226, 964, 88));
			jScrollPane1.setViewportView(getJTableMaterialesOC());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTableMaterialesOC	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableMaterialesOC() {
		if (jTableMaterialesOC == null) {
			jTableMaterialesOC = new JTable();
		}
		return jTableMaterialesOC;
	}

}  //  @jve:decl-index=0:visual-constraint="100,-51"
