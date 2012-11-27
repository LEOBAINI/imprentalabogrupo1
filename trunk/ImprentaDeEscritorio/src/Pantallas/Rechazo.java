package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;
import javax.swing.JLabel;

import Base.metodosSql;

public class Rechazo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableRechazo = null;
	private JLabel jLabel = null;
	private int nroSolicitudCompra=0;

	/**
	 * This is the default constructor
	 */
	public Rechazo() {
		super();
		
		initialize();
		
	}
	public Rechazo(int nroSC) {
		super();
		this.nroSolicitudCompra=nroSC;
		initialize();
		
	}

	private int getNroSolicitudCompra() {
		return nroSolicitudCompra;
	}

	private void setNroSolicitudCompra(int nroSolicitudCompra) {
		this.nroSolicitudCompra = nroSolicitudCompra;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		metodosSql metodos=new metodosSql();
		this.setSize(783, 259);
		this.setContentPane(getJContentPane());
		this.setTitle("Historial de rechazo de ésta SC");
		jTableRechazo.setModel(metodos.llenarJtable("" +
				" SELECT fecha,hora,marca,calidad,variante,gramaje,concat(ancho,'X',alto) as Formato," +
				" motivoRechazo FROM imprenta.materialesdelasolicituddecompra," +
				" imprenta.rechazo where idmaterialrechazado=idmatsolcompra and" +
				" nrosolicitudDeCompra="+getNroSolicitudCompra()).getModel());
		  


	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(16, 10, 69, 24));
			jLabel.setText("Rechazos");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabel, null);
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
			jScrollPane.setBounds(new Rectangle(15, 44, 737, 158));
			jScrollPane.setViewportView(getJTableRechazo());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableRechazo	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableRechazo() {
		if (jTableRechazo == null) {
			jTableRechazo = new JTable();
		}
		return jTableRechazo;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
