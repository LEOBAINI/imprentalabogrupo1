package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import javax.swing.JButton;

public class SoldeCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane1 = null;
	private JLabel NroSolicitudCompra = null;
	private JEditorPane nrosc = null;
	private JLabel NumeroOT = null;
	private JList NroOT = null;
	private JLabel NrodeStokeo = null;
	private JList NumStokeo = null;
	private JLabel Fecha = null;
	private JEditorPane Fechadeldìa = null;
	private JLabel Proveedor = null;
	private JList NombredeProveedor = null;
	private JLabel Vendedor = null;
	private JEditorPane NVendedor = null;
	private JPanel jPanel = null;
	private JCheckBox EnviaProv = null;
	private JLabel EnvVendedor = null;
	private JCheckBox TildeRetirar = null;
	private JLabel jLabel211 = null;
	private JEditorPane DomiciliodeRetiro = null;
	private JLabel Dom = null;
	private JLabel FecEntrega = null;
	private JEditorPane FechadeEntrega = null;
	private JLabel Horario = null;
	private JCheckBox TildeMañana = null;
	private JCheckBox TildeTarde = null;
	private JLabel Mañana = null;
	private JLabel Tarde = null;
	private JPanel jPanel1 = null;
	private JLabel Cantidad = null;
	private JLabel Marca = null;
	private JLabel jLabel222 = null;
	private JLabel jLabel2212 = null;
	private JLabel jLabel22112 = null;
	private JLabel jLabel221111 = null;
	private JLabel jLabel2211112 = null;
	private JLabel jLabel2211113 = null;
	private JLabel jLabel2211114 = null;
	private JEditorPane Cantid = null;
	private JEditorPane DesMArca = null;
	private JEditorPane jEditorPane2212 = null;
	private JEditorPane jEditorPane22121 = null;
	private JEditorPane jEditorPane221211 = null;
	private JEditorPane jEditorPane2212111 = null;
	private JLabel por = null;
	private JEditorPane Sedoformato = null;
	private JEditorPane jEditorPane221211111 = null;
	private JEditorPane jEditorPane2212111111 = null;
	private JEditorPane jEditorPane2212111112 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton11 = null;
	private JLabel jLabel22111121 = null;
	private JEditorPane jEditorPane22121111121 = null;
	private JLabel jLabel22111122 = null;
	private JEditorPane jEditorPane221211111211 = null;
	private JLabel jLabel221111221 = null;
	private JEditorPane jEditorPane221211111212 = null;
	/**
	* This is the default constructor
	*/
	public SoldeCompra() {
		super();
		initialize();
	}

	/**
	* This method initializes this
	* 
	* @return void
	*/
	private void initialize() {
		this.setSize(1035, 431);
		this.setContentPane(getJContentPane1());
		this.setTitle("Solicitud de Compra");
	}

	/**
	* This method initializes jContentPane1	
	* 	
	* @return javax.swing.JPanel	
	*/
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel221111221 = new JLabel();
			jLabel221111221.setBounds(new Rectangle(869, 363, 71, 16));
			jLabel221111221.setText("Total");
			jLabel22111122 = new JLabel();
			jLabel22111122.setBounds(new Rectangle(869, 339, 68, 16));
			jLabel22111122.setText(" IVA 21 %");
			jLabel22111121 = new JLabel();
			jLabel22111121.setBounds(new Rectangle(870, 313, 67, 16));
			jLabel22111121.setText("Subtotal");
			jLabel222 = new JLabel();
			jLabel222.setText("Calidad");
			jLabel222.setBounds(new Rectangle(225, 3, 136, 16));
			Vendedor = new JLabel();
			Vendedor.setBounds(new Rectangle(657, 33, 92, 16));
			Vendedor.setText("Vendedor");
			Proveedor = new JLabel();
			Proveedor.setBounds(new Rectangle(291, 32, 64, 16));
			Proveedor.setText("Proveedor");
			Fecha = new JLabel();
			Fecha.setBounds(new Rectangle(17, 34, 46, 16));
			Fecha.setText("Fecha");
			NrodeStokeo = new JLabel();
			NrodeStokeo.setBounds(new Rectangle(658, 15, 90, 16));
			NrodeStokeo.setText("Nro de Stockeo");
			NumeroOT = new JLabel();
			NumeroOT.setBounds(new Rectangle(294, 12, 139, 16));
			NumeroOT.setText("Orden de Trabajo");
			NroSolicitudCompra = new JLabel();
			NroSolicitudCompra.setBounds(new Rectangle(15, 10, 45, 16));
			NroSolicitudCompra.setText("Numero");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.add(NroSolicitudCompra, null);
			jContentPane1.add(getNrosc(), null);
			jContentPane1.add(NumeroOT, null);
			jContentPane1.add(getNroOT(), null);
			jContentPane1.add(NrodeStokeo, null);
			jContentPane1.add(getNumStokeo(), null);
			jContentPane1.add(Fecha, null);
			jContentPane1.add(getFechadeldìa(), null);
			jContentPane1.add(Proveedor, null);
			jContentPane1.add(getNombredeProveedor(), null);
			jContentPane1.add(Vendedor, null);
			jContentPane1.add(getNVendedor(), null);
			jContentPane1.add(getJPanel(), null);
			jContentPane1.add(getJPanel1(), null);
			jContentPane1.add(getJButton(), null);
			jContentPane1.add(getJButton1(), null);
			jContentPane1.add(getJButton11(), null);
			jContentPane1.add(jLabel22111121, null);
			jContentPane1.add(getJEditorPane22121111121(), null);
			jContentPane1.add(jLabel22111122, null);
			jContentPane1.add(getJEditorPane221211111211(), null);
			jContentPane1.add(jLabel221111221, null);
			jContentPane1.add(getJEditorPane221211111212(), null);
		}
		return jContentPane1;
	}

	/**
	* This method initializes nrosc	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getNrosc() {
		if (nrosc == null) {
			nrosc = new JEditorPane();
			nrosc.setBounds(new Rectangle(74, 10, 156, 16));
			nrosc.setText("Aca va el número de SC autonu");
		}
		return nrosc;
	}

	/**
	* This method initializes NroOT	
	* 	
	* @return javax.swing.JList	
	*/
	private JList getNroOT() {
		if (NroOT == null) {
			NroOT = new JList();
			NroOT.setBounds(new Rectangle(457, 11, 171, 15));
		}
		return NroOT;
	}

	/**
	* This method initializes NumStokeo	
	* 	
	* @return javax.swing.JList	
	*/
	private JList getNumStokeo() {
		if (NumStokeo == null) {
			NumStokeo = new JList();
			NumStokeo.setBounds(new Rectangle(778, 11, 173, 15));
		}
		return NumStokeo;
	}

	/**
	* This method initializes Fechadeldìa	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getFechadeldìa() {
		if (Fechadeldìa == null) {
			Fechadeldìa = new JEditorPane();
			Fechadeldìa.setBounds(new Rectangle(77, 33, 154, 16));
			Fechadeldìa.setText("Fecha del día DD/MM/AAAA");
		}
		return Fechadeldìa;
	}

	/**
	* This method initializes NombredeProveedor	
	* 	
	* @return javax.swing.JList	
	*/
	private JList getNombredeProveedor() {
		if (NombredeProveedor == null) {
			NombredeProveedor = new JList();
			NombredeProveedor.setBounds(new Rectangle(364, 32, 264, 17));
		}
		return NombredeProveedor;
	}

	/**
	* This method initializes NVendedor	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getNVendedor() {
		if (NVendedor == null) {
			NVendedor = new JEditorPane();
			NVendedor.setBounds(new Rectangle(778, 33, 240, 18));
			NVendedor.setText("Ingresa Nombre de Vendedor");
		}
		return NVendedor;
	}

	/**
	* This method initializes jPanel	
	* 	
	* @return javax.swing.JPanel	
	*/
	private JPanel getJPanel() {
		if (jPanel == null) {
			Tarde = new JLabel();
			Tarde.setBounds(new Rectangle(936, 21, 42, 16));
			Tarde.setText("Tarde");
			Mañana = new JLabel();
			Mañana.setBounds(new Rectangle(936, 0, 57, 16));
			Mañana.setText("Mañana");
			Horario = new JLabel();
			Horario.setBounds(new Rectangle(844, 7, 48, 16));
			Horario.setText("Horario");
			FecEntrega = new JLabel();
			FecEntrega.setBounds(new Rectangle(640, 10, 89, 16));
			FecEntrega.setText("Fecha  Entrega");
			Dom = new JLabel();
			Dom.setBounds(new Rectangle(216, 9, 107, 16));
			Dom.setText("Domicilio de Retiro");
			jLabel211 = new JLabel();
			jLabel211.setBounds(new Rectangle(166, 8, 46, 16));
			jLabel211.setText("Retirar");
			EnvVendedor = new JLabel();
			EnvVendedor.setBounds(new Rectangle(37, 8, 94, 16));
			EnvVendedor.setText("Envia Proveedor");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(16, 61, 1008, 41));
			jPanel.add(getEnviaProv(), null);
			jPanel.add(EnvVendedor, null);
			jPanel.add(getTildeRetirar(), null);
			jPanel.add(jLabel211, null);
			jPanel.add(getDomiciliodeRetiro(), null);
			jPanel.add(Dom, null);
			jPanel.add(FecEntrega, null);
			jPanel.add(getFechadeEntrega(), null);
			jPanel.add(Horario, null);
			jPanel.add(getTildeMañana(), null);
			jPanel.add(getTildeTarde(), null);
			jPanel.add(Mañana, null);
			jPanel.add(Tarde, null);
		}
		return jPanel;
	}

	/**
	* This method initializes EnviaProv	
	* 	
	* @return javax.swing.JCheckBox	
	*/
	private JCheckBox getEnviaProv() {
		if (EnviaProv == null) {
			EnviaProv = new JCheckBox();
			EnviaProv.setBounds(new Rectangle(6, 5, 21, 21));
		}
		return EnviaProv;
	}

	/**
	* This method initializes TildeRetirar	
	* 	
	* @return javax.swing.JCheckBox	
	*/
	private JCheckBox getTildeRetirar() {
		if (TildeRetirar == null) {
			TildeRetirar = new JCheckBox();
			TildeRetirar.setBounds(new Rectangle(139, 5, 21, 21));
		}
		return TildeRetirar;
	}

	/**
	* This method initializes DomiciliodeRetiro	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getDomiciliodeRetiro() {
		if (DomiciliodeRetiro == null) {
			DomiciliodeRetiro = new JEditorPane();
			DomiciliodeRetiro.setBounds(new Rectangle(325, 5, 299, 22));
			DomiciliodeRetiro.setText("Si tilde en Retirar entonces escribir domicilio de retiro");
		}
		return DomiciliodeRetiro;
	}

	/**
	* This method initializes FechadeEntrega	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getFechadeEntrega() {
		if (FechadeEntrega == null) {
			FechadeEntrega = new JEditorPane();
			FechadeEntrega.setBounds(new Rectangle(735, 4, 106, 22));
			FechadeEntrega.setText(" DD/MM/AAAA");
		}
		return FechadeEntrega;
	}

	/**
	* This method initializes TildeMañana	
	* 	
	* @return javax.swing.JCheckBox	
	*/
	private JCheckBox getTildeMañana() {
		if (TildeMañana == null) {
			TildeMañana = new JCheckBox();
			TildeMañana.setBounds(new Rectangle(904, -3, 21, 21));
		}
		return TildeMañana;
	}

	/**
	* This method initializes TildeTarde	
	* 	
	* @return javax.swing.JCheckBox	
	*/
	private JCheckBox getTildeTarde() {
		if (TildeTarde == null) {
			TildeTarde = new JCheckBox();
			TildeTarde.setBounds(new Rectangle(904, 20, 21, 21));
		}
		return TildeTarde;
	}

	/**
	* This method initializes jPanel1	
	* 	
	* @return javax.swing.JPanel	
	*/
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			por = new JLabel();
			por.setBounds(new Rectangle(677, 30, 11, 16));
			por.setText("X");
			jLabel2211114 = new JLabel();
			jLabel2211114.setBounds(new Rectangle(916, 2, 86, 16));
			jLabel2211114.setText("ImporteTotal");
			jLabel2211113 = new JLabel();
			jLabel2211113.setBounds(new Rectangle(821, 2, 87, 16));
			jLabel2211113.setText("UnidadMedida");
			jLabel2211112 = new JLabel();
			jLabel2211112.setBounds(new Rectangle(733, 2, 81, 16));
			jLabel2211112.setText("Importe");
			jLabel221111 = new JLabel();
			jLabel221111.setBounds(new Rectangle(639, 3, 77, 16));
			jLabel221111.setText("Formato");
			jLabel22112 = new JLabel();
			jLabel22112.setBounds(new Rectangle(502, 1, 126, 16));
			jLabel22112.setText("Gramaje");
			jLabel2212 = new JLabel();
			jLabel2212.setBounds(new Rectangle(370, 2, 121, 16));
			jLabel2212.setText("Variante");
			Marca = new JLabel();
			Marca.setBounds(new Rectangle(73, 4, 140, 16));
			Marca.setText("Marca");
			Cantidad = new JLabel();
			Cantidad.setBounds(new Rectangle(9, 5, 53, 16));
			Cantidad.setText("Cantidad");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBounds(new Rectangle(15, 106, 1007, 204));
			jPanel1.add(Cantidad, null);
			jPanel1.add(Marca, null);
			jPanel1.add(jLabel222, null);
			jPanel1.add(jLabel2212, null);
			jPanel1.add(jLabel22112, null);
			jPanel1.add(jLabel221111, null);
			jPanel1.add(jLabel2211112, null);
			jPanel1.add(jLabel2211113, null);
			jPanel1.add(jLabel2211114, null);
			jPanel1.add(getCantid(), null);
			jPanel1.add(getDesMArca(), null);
			jPanel1.add(getJEditorPane2212(), null);
			jPanel1.add(getJEditorPane22121(), null);
			jPanel1.add(getJEditorPane221211(), null);
			jPanel1.add(getJEditorPane2212111(), null);
			jPanel1.add(por, null);
			jPanel1.add(getSedoformato(), null);
			jPanel1.add(getJEditorPane221211111(), null);
			jPanel1.add(getJEditorPane2212111111(), null);
			jPanel1.add(getJEditorPane2212111112(), null);
		}
		return jPanel1;
	}

	/**
	* This method initializes Cantid	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getCantid() {
		if (Cantid == null) {
			Cantid = new JEditorPane();
			Cantid.setBounds(new Rectangle(11, 29, 52, 15));
			Cantid.setText("#");
		}
		return Cantid;
	}

	/**
	* This method initializes DesMArca	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getDesMArca() {
		if (DesMArca == null) {
			DesMArca = new JEditorPane();
			DesMArca.setBounds(new Rectangle(75, 28, 139, 16));
			DesMArca.setText("De la tabla de Marca");
		}
		return DesMArca;
	}

	/**
	* This method initializes jEditorPane2212	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane2212() {
		if (jEditorPane2212 == null) {
			jEditorPane2212 = new JEditorPane();
			jEditorPane2212.setBounds(new Rectangle(227, 29, 134, 18));
			jEditorPane2212.setText("De la tabla de Calidad");
		}
		return jEditorPane2212;
	}

	/**
	* This method initializes jEditorPane22121	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane22121() {
		if (jEditorPane22121 == null) {
			jEditorPane22121 = new JEditorPane();
			jEditorPane22121.setBounds(new Rectangle(368, 30, 125, 17));
			jEditorPane22121.setText("De la tabla de Variante");
		}
		return jEditorPane22121;
	}

	/**
	* This method initializes jEditorPane221211	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane221211() {
		if (jEditorPane221211 == null) {
			jEditorPane221211 = new JEditorPane();
			jEditorPane221211.setBounds(new Rectangle(510, 30, 119, 16));
			jEditorPane221211.setText("Carga a mano");
		}
		return jEditorPane221211;
	}

	/**
	* This method initializes jEditorPane2212111	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane2212111() {
		if (jEditorPane2212111 == null) {
			jEditorPane2212111 = new JEditorPane();
			jEditorPane2212111.setBounds(new Rectangle(643, 29, 29, 18));
			jEditorPane2212111.setText("999");
		}
		return jEditorPane2212111;
	}

	/**
	* This method initializes Sedoformato	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getSedoformato() {
		if (Sedoformato == null) {
			Sedoformato = new JEditorPane();
			Sedoformato.setBounds(new Rectangle(694, 27, 27, 17));
			Sedoformato.setText("999");
		}
		return Sedoformato;
	}

	/**
	* This method initializes jEditorPane221211111	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane221211111() {
		if (jEditorPane221211111 == null) {
			jEditorPane221211111 = new JEditorPane();
			jEditorPane221211111.setBounds(new Rectangle(737, 31, 79, 17));
			jEditorPane221211111.setText("999,999.99");
		}
		return jEditorPane221211111;
	}

	/**
	* This method initializes jEditorPane2212111111	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane2212111111() {
		if (jEditorPane2212111111 == null) {
			jEditorPane2212111111 = new JEditorPane();
			jEditorPane2212111111.setBounds(new Rectangle(827, 31, 80, 17));
			jEditorPane2212111111.setText("999,999.99");
		}
		return jEditorPane2212111111;
	}

	/**
	* This method initializes jEditorPane2212111112	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane2212111112() {
		if (jEditorPane2212111112 == null) {
			jEditorPane2212111112 = new JEditorPane();
			jEditorPane2212111112.setBounds(new Rectangle(913, 26, 90, 22));
			jEditorPane2212111112.setText("999,999.99");
		}
		return jEditorPane2212111112;
	}

	/**
	* This method initializes jButton	
	* 	
	* @return javax.swing.JButton	
	*/
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
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
			jButton1.setBounds(new Rectangle(32, 334, 77, 26));
			jButton1.setText("Limpiar");
		}
		return jButton1;
	}

	/**
	* This method initializes jButton11	
	* 	
	* @return javax.swing.JButton	
	*/
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setBounds(new Rectangle(122, 333, 87, 26));
			jButton11.setText("Guardar");
		}
		return jButton11;
	}

	/**
	* This method initializes jEditorPane22121111121	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane22121111121() {
		if (jEditorPane22121111121 == null) {
			jEditorPane22121111121 = new JEditorPane();
			jEditorPane22121111121.setBounds(new Rectangle(946, 312, 73, 22));
			jEditorPane22121111121.setText("999,999.99");
		}
		return jEditorPane22121111121;
	}

	/**
	* This method initializes jEditorPane221211111211	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane221211111211() {
		if (jEditorPane221211111211 == null) {
			jEditorPane221211111211 = new JEditorPane();
			jEditorPane221211111211.setBounds(new Rectangle(943, 334, 78, 22));
			jEditorPane221211111211.setText("999,999.99");
		}
		return jEditorPane221211111211;
	}

	/**
	* This method initializes jEditorPane221211111212	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getJEditorPane221211111212() {
		if (jEditorPane221211111212 == null) {
			jEditorPane221211111212 = new JEditorPane();
			jEditorPane221211111212.setBounds(new Rectangle(944, 361, 78, 20));
			jEditorPane221211111212.setText("999,999.99");
		}
		return jEditorPane221211111212;
	}

}  //  @jve:decl-index=0:visual-constraint="-1,-3"
