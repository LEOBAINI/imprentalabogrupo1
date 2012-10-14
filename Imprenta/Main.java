package Imprenta;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Pantallas.MenuPrincipal;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPrincipal thisClass = new MenuPrincipal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});// TODO Auto-generated method stub

	}

}
