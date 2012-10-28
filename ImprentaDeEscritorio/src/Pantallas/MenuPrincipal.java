package Pantallas;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridBagLayout;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Color;
import Imagenes.*;
import javax.swing.JProgressBar;

@SuppressWarnings("unused")
public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem Salir = null;
	private JMenuItem ConsultaSC = null;
	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Tareas");
			jMenu.add(getJMenuItem());
			jMenu.add(getJMenuItem1());
			jMenu.add(getSalir());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Consultas");
			jMenu1.add(getJMenuItem2());
			jMenu1.add(getConsultaSC());
		}
		return jMenu1;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Cargar una OT");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {		
				
				
					
					
			   JFrame frame =new JFrame();//frame
				
				
				OrdenTrabajo ot=new OrdenTrabajo();//panel		
				//ot.setVisible(true);
				
			    frame.add(ot);
				frame.pack();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
				
				
				
					
					
				
				}				
			});
		}
		return jMenuItem;
	}
	
	
	
	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Cargar una OC");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					SoldeCompra sol=new SoldeCompra();
					sol.setVisible(true);
				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * @param args
	 */
	
	/**
	 * This is the default constructor
	 */
	public MenuPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//para que inicie maximizado...   
		this.setSize(1024, 316);
		this.setBackground(new Color(238, 238, 238));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Menu Principal");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private FondoMenuPpal getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new FondoMenuPpal("LogoOficialCMYK.png");
			jContentPane.setLayout(new BorderLayout());
			//jContentPane.add(getJPanel(), null);
		}
		return (FondoMenuPpal) jContentPane;
	}
	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Consultar OT cargadas");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ConsultaDeOT con=new ConsultaDeOT();
					con.setVisible(true);
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes Salir	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSalir() {
		if (Salir == null) {
			Salir = new JMenuItem();
			Salir.setText("Salir");
			Salir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return Salir;
	}
	
	/**
	 * This method initializes ConsultaSC	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getConsultaSC() {
		if (ConsultaSC == null) {
			ConsultaSC = new JMenuItem();
			ConsultaSC.setText("Consultar solicitudes de compra ");
			ConsultaSC.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CosultaDeOC OC=new CosultaDeOC();
					OC.setVisible(true);
					
				}
			});
		}
		return ConsultaSC;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal thisClass = new MenuPrincipal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				
				
				
			}
		});
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal thisClass = new MenuPrincipal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}*/

}  //  @jve:decl-index=0:visual-constraint="69,65"
