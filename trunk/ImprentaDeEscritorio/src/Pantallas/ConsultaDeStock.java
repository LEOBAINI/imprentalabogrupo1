package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import javax.swing.JTable;

import Base.metodosSql;
import Formateador.JtableNoEditable;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

@SuppressWarnings("unused")
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
	 *//*select nroot,s.cantidad,marca,calidad,variante,gramaje,concat(alto,'X',ancho),fechaRecepcion,hora,partida,
idmaterialesDeLaSol from imprenta.stock s,imprenta.materialesdelasolicituddecompra m 
where idmatsolcompra=idmaterialesdelasol  group by partida;*/
	JtableNoEditable mod=new JtableNoEditable();
	private JButton jButtonSalir = null;
	private JTable getJTableConsultaStock() {
		metodosSql metodos=new metodosSql();
		mod.addColumn("OT");
		mod.addColumn("Cantidad");
		mod.addColumn("Marca");
		mod.addColumn("Calidad");
		mod.addColumn("Variante");
		mod.addColumn("Gramaje");
		mod.addColumn("Formato");
		mod.addColumn("Fecha recepción");
		mod.addColumn("Hora");
		mod.addColumn("Partida");
		ArrayList<ArrayList<String>>matriz=null;
		matriz=metodos.consultar("select nroot,s.cantidad,marca,calidad,variante,gramaje,concat(alto,'X',ancho),fechaRecepcion,hora,partida,"+
" idmaterialesDeLaSol from imprenta.stock s,imprenta.materialesdelasolicituddecompra m "+
" where idmatsolcompra=idmaterialesdelasol  group by partida;");
		
		int filas=matriz.size();
		for(int i=0;i<filas;i++){
		String [] fila=new String[10];
		fila[0]=matriz.get(i).get(0);
		fila[1]=matriz.get(i).get(1);
		fila[2]=matriz.get(i).get(2);
		fila[3]=matriz.get(i).get(3);
		fila[4]=matriz.get(i).get(4);
		fila[5]=matriz.get(i).get(5);
		fila[6]=matriz.get(i).get(6);
		fila[7]=matriz.get(i).get(7);
		fila[8]=matriz.get(i).get(8);
		fila[9]=matriz.get(i).get(9);
		mod.addRow(fila);
		}
		
		
		if (jTableConsultaStock == null) {
			jTableConsultaStock = new JTable(mod);
			
		}
		return jTableConsultaStock;
	}

	/**
	 * This method initializes jButtonSalir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSalir() {
		if (jButtonSalir == null) {
			jButtonSalir = new JButton();
			jButtonSalir.setBounds(new Rectangle(793, 45, 103, 35));
			jButtonSalir.setText("Salir");
			jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSalir;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
