package Pantallas;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.SystemColor;
import javax.swing.JButton;

import com.jpcomponents.JPCalendar;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Base.metodosSql;

import java.awt.Choice;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrdenTrabajo extends JPanel {

	private static final long serialVersionUID = 1L;
	public static JTextField FechaConfeccion = null;
	private JLabel jLabel = null;
	private JTextField OrdenNro = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JTextField jTextField3 = null;
	private JLabel jLabel4 = null;
	private JTextField jTextField4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField6 = null;
	private JTextField jTextField7 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JList jList = null;
	private JLabel jLabel10 = null;
	private JTextField jTextField8 = null;
	private JLabel jLabel11 = null;
	private JTextField jTextField9 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JTextField jTextField10 = null;
	private JLabel jLabel14 = null;
	private JEditorPane jEditorPane = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JEditorPane jEditorPane1 = null;
	private JLabel jLabel17 = null;
	private JList jList1 = null;
	private JLabel jLabel18 = null;
	private JLabel jLabel19 = null;
	private JList jList2 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private Choice choiceCliente = null;
	private JButton jButton2 = null;
	/**
	 * This is the default constructor
	 */
	public OrdenTrabajo() {
		super();
		initialize();
		inicializarCampos();
	}
	private void inicializarCampos(){
		ArrayList<String >datos=null;
		metodosSql metodos=new metodosSql();
		datos=metodos.consultarUnaColumna("Select nombreContacto from imprenta.cliente");//llenar select cliente
		for(int i=0;i<datos.size();i++)choiceCliente.add(datos.get(i));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel19 = new JLabel();
		jLabel19.setBounds(new Rectangle(170, 320, 195, 17));
		jLabel19.setText("Proveedor que realizará la tarea");
		jLabel18 = new JLabel();
		jLabel18.setBounds(new Rectangle(50, 320, 111, 17));
		jLabel18.setText("Tareas del trabajo");
		jLabel17 = new JLabel();
		jLabel17.setBounds(new Rectangle(50, 300, 161, 17));
		jLabel17.setText("Sección Orden de Ejecución");
		jLabel16 = new JLabel();
		jLabel16.setBounds(new Rectangle(50, 268, 161, 21));
		jLabel16.setText("Cantidad de Planchas (nro)");
		jLabel15 = new JLabel();
		jLabel15.setBounds(new Rectangle(50, 244, 133, 21));
		jLabel15.setText("Sección PreImpresión");
		jLabel14 = new JLabel();
		jLabel14.setBounds(new Rectangle(594, 240, 135, 23));
		jLabel14.setText("Sección de Materiales");
		jLabel13 = new JLabel();
		jLabel13.setBounds(new Rectangle(674, 192, 143, 17));
		jLabel13.setText("Cant X Unidad de trabajo");
		jLabel12 = new JLabel();
		jLabel12.setBounds(new Rectangle(532, 194, 113, 15));
		jLabel12.setText("Elemento");
		jLabel11 = new JLabel();
		jLabel11.setBounds(new Rectangle(572, 172, 190, 14));
		jLabel11.setText("Sección Elementos del Producto");
		jLabel10 = new JLabel();
		jLabel10.setBounds(new Rectangle(50, 212, 142, 16));
		jLabel10.setText("Cantidad a Entregar");
		jLabel9 = new JLabel();
		jLabel9.setBounds(new Rectangle(50, 188, 134, 16));
		jLabel9.setText("Tipo de Producto");
		jLabel8 = new JLabel();
		jLabel8.setBounds(new Rectangle(296, 160, 25, 16));
		jLabel8.setText("Alto");
		jLabel7 = new JLabel();
		jLabel7.setBounds(new Rectangle(200, 160, 38, 16));
		jLabel7.setText("Ancho");
		jLabel6 = new JLabel();
		jLabel6.setBounds(new Rectangle(50, 160, 141, 16));
		jLabel6.setText("Medida Final.");
		jLabel5 = new JLabel();
		jLabel5.setBounds(new Rectangle(751, 44, 76, 16));
		jLabel5.setText("Descripción");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(50, 135, 144, 16));
		jLabel4.setText("Nombre corto del trabajo.");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(50, 112, 119, 16));
		jLabel3.setText("Fecha Prometida");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(50, 90, 117, 16));
		jLabel2.setText("Fecha de confección");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(50, 68, 78, 16));
		jLabel1.setText("Cliente");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(50, 46, 78, 16));
		jLabel.setText("Orden N°");
		this.setSize(1195, 488);
		this.setLayout(null);
		this.setBackground(SystemColor.activeCaption);
		this.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createCompoundBorder(null, null)));
		this.add(getFechaConfeccion(), null);
		this.add(jLabel, null);
		this.add(getOrdenNro(), null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(getJTextField3(), null);
		this.add(jLabel4, null);
		this.add(getJTextField4(), null);
		this.add(jLabel5, null);
		this.add(jLabel6, null);
		this.add(getJTextField6(), null);
		this.add(getJTextField7(), null);
		this.add(jLabel7, null);
		this.add(jLabel8, null);
		this.add(jLabel9, null);
		this.add(getJList(), null);
		this.add(jLabel10, null);
		this.add(getJTextField8(), null);
		this.add(jLabel11, null);
		this.add(getJTextField9(), null);
		this.add(jLabel12, null);
		this.add(jLabel13, null);
		this.add(getJTextField10(), null);
		this.add(jLabel14, null);
		this.add(getJEditorPane(), null);
		this.add(getJScrollPane(), null);
		this.add(jLabel15, null);
		this.add(jLabel16, null);
		this.add(getJEditorPane1(), null);
		this.add(jLabel17, null);
		this.add(getJList1(), null);
		this.add(jLabel18, null);
		this.add(jLabel19, null);
		this.add(getJList2(), null);
		this.add(getJButton(), null);
		this.add(getJButton1(), null);
		this.add(getChoiceCliente(), null);
		this.add(getJButton2(), null);
		
	}

	/**
	 * This method initializes FechaConfeccion	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFechaConfeccion() {
		if (FechaConfeccion == null) {
			FechaConfeccion = new JTextField();
			FechaConfeccion.setBounds(new Rectangle(244, 90, 122, 20));
		}
		return FechaConfeccion;
	}

	/**
	 * This method initializes OrdenNro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOrdenNro() {
		if (OrdenNro == null) {
			OrdenNro = new JTextField();
			OrdenNro.setBounds(new Rectangle(244, 46, 122, 20));
		}
		return OrdenNro;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(244, 112, 122, 20));
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(244, 134, 122, 21));
		}
		return jTextField4;
	}

	/**
	 * This method initializes jTextField6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(244, 160, 50, 22));
		}
		return jTextField6;
	}

	/**
	 * This method initializes jTextField7	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(322, 160, 43, 21));
		}
		return jTextField7;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
			jList.setBounds(new Rectangle(245, 187, 120, 18));
		}
		return jList;
	}

	/**
	 * This method initializes jTextField8	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(244, 208, 121, 21));
		}
		return jTextField8;
	}

	/**
	 * This method initializes jTextField9	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new Rectangle(532, 216, 115, 21));
		}
		return jTextField9;
	}

	/**
	 * This method initializes jTextField10	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setBounds(new Rectangle(678, 216, 121, 21));
		}
		return jTextField10;
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setBounds(new Rectangle(832, 43, 357, 125));
		}
		return jEditorPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(512, 264, 451, 214));
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setCellSelectionEnabled(true);
			jTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
				public void propertyChange(java.beans.PropertyChangeEvent e) {
					if ((e.getPropertyName().equals("model"))) {
						System.out.println("propertyChange(model)"); // TODO Auto-generated property Event stub "model" 
					}
				}
			});
		}
		return jTable;
	}

	/**
	 * This method initializes jEditorPane1	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane1() {
		if (jEditorPane1 == null) {
			jEditorPane1 = new JEditorPane();
			jEditorPane1.setBounds(new Rectangle(246, 268, 119, 19));
		}
		return jEditorPane1;
	}

	/**
	 * This method initializes jList1	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
			jList1.setBounds(new Rectangle(48, 340, 111, 25));
		}
		return jList1;
	}

	/**
	 * This method initializes jList2	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList2() {
		if (jList2 == null) {
			jList2 = new JList();
			jList2.setBounds(new Rectangle(172, 340, 193, 25));
		}
		return jList2;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(374, 341, 129, 25));
			jButton.setText("Agregar Tarea");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					JPCalendar cal=new JPCalendar();
					cal.setVisible(true);// TODO Auto-generated Event stub actionPerformed()
					JCalendar j=new JCalendar();
					j.setVisible(true);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(1006, 439, 179, 40));
			jButton1.setText("Finalizar carga de OT");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					JOptionPane.showMessageDialog(null,getOrdenNro().getText() );
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes choiceCliente	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCliente() {
		
		if (choiceCliente == null) {
			choiceCliente = new Choice();
			choiceCliente.setBounds(new Rectangle(244, 68, 121, 21));
			choiceCliente.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println(choiceCliente.getSelectedItem().toString());
				}
			});
			
			
		}
		return choiceCliente;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(374, 90, 20, 18));
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Calendario c=new Calendario();
					c.setVisible(true);
				
					//FechaConfeccion.setText();

				
				/*-	SimpleDateFormat fechaforma = new SimpleDateFormat("dd/MM/yyyy");
					String FfechaSystemA = fechaforma.format(fecha);


					//String f=fecha.toString();
					FechaConfeccion.setText(FfechaSystemA);*/

				
					
								
				}
			});
		}
		return jButton2;
	}
	

}  //  @jve:decl-index=0:visual-constraint="-2,58"
