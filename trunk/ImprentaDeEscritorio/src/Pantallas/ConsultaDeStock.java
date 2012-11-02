package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;

import Base.metodosSql;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.Color;

public class ConsultaDeStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableConsultaStock = null;
	private JLabel jLabel = null;

	/**
	 * This is the default constructor
	 */
	public ConsultaDeStock() {
		super();
		initialize();
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(918, 286);
		this.setContentPane(getJContentPane());
		this.setTitle("Consultas de Stock");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 6, 342, 29));
			jLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			jLabel.setText("Tabla de consultas del Stock");
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
			jScrollPane.setBounds(new Rectangle(14, 45, 770, 193));
			jScrollPane.setViewportView(getJTableConsultaStock());
			jScrollPane.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableConsultaStock	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableConsultaStock() {
		metodosSql metodos=new metodosSql();
		if (jTableConsultaStock == null) {
			jTableConsultaStock = new JTable();
			jTableConsultaStock.setModel(metodos.llenarJtable("SELECT * FROM imprenta.stock order by fechaRecepcion desc;").getModel());
		}
		return jTableConsultaStock;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
