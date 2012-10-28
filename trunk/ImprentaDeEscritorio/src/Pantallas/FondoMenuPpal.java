package Pantallas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Color;

public class FondoMenuPpal extends JPanel {
	ImageIcon imagen;

	private static final long serialVersionUID = 1L;

	public static JProgressBar jProgressBar = null;

	/**
	 * This is the default constructor
	 */
	
	public FondoMenuPpal(String nombre) {
		super();
		imagen=new ImageIcon(getClass().getResource(nombre));
		setSize(imagen.getIconWidth(), imagen.getIconHeight());
		initialize();
	}
	protected void paintComponent(Graphics g){
		Dimension d= getSize();
		g.drawImage(imagen.getImage(),0,0,d.width,d.height,null);
		this.setOpaque(false);
		super.paintComponent(g);
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(714, 200);
		this.setLayout(null);
		
	}

	

}  //  @jve:decl-index=0:visual-constraint="10,10"
