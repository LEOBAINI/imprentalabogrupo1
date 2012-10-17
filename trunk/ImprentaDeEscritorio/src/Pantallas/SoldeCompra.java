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
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JButton;

import Base.metodosSql;

import java.awt.Choice;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SoldeCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane1 = null;
	private JLabel NroSolicitudCompra = null;
	private JEditorPane nrosc = null;
	private JLabel NumeroOT = null;
	private JLabel Fecha = null;
	private JEditorPane Fechadeldìa = null;
	private JLabel Proveedor = null;
	private JLabel Vendedor = null;
	private JPanel jPanel = null;
	private JCheckBox EnviaProv = null;
	private JLabel EnvVendedor = null;
	private JCheckBox TildeRetirar = null;
	private JLabel jLabel211 = null;
	private JEditorPane DomiciliodeRetiro = null;
	private JLabel Dom = null;
	private JLabel FecEntrega = null;
	private JLabel Horario = null;
	private JCheckBox TildeMañana = null;
	private JCheckBox TildeTarde = null;
	private JLabel Mañana = null;
	private JLabel Tarde = null;
	private JPanel jPanel1 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton11 = null;
	private JLabel jLabel22111121 = null;
	private JLabel jLabel22111122 = null;
	private JLabel jLabel221111221 = null;
	private Choice choiceRazonSocialproveedor = null;
	public static JTextField jTextFieldfechaEntrega = null;
	private JButton jButtonCalendario = null;
	private Choice choiceMarca = null;
	private Choice choiceCalidad = null;
	private Choice choiceVariante = null;
	private JTextField campoGramaje = null;
	private JTextField campoImporte = null;
	private JTextField campoImporteTotal = null;
	private JTextField campoAlto = null;
	private JTextField campoAncho = null;
	private JLabel jLabel = null;
	private JLabel marca = null;
	private JLabel Calidad = null;
	private JLabel Variante = null;
	private JLabel jLabelGramaje = null;
	private JLabel jLabelformato = null;
	private JLabel jLabelImporte = null;
	private JLabel jLabelUmedida = null;
	private JLabel jLabelimporteTotal = null;
	private JPanel jPanel2 = null;
	private JTextField campoCantidad = null;
	private JLabel jLabel1 = null;
	private Choice choiceIva = null;
	private JTextField campoSubTotal = null;
	private JTextField campoIva = null;
	private JTextField campoTotal = null;
	private JButton cargar = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableMateriales = null;
	private JTextField campoUnidadDeMedida = null;
	/**
	* This is the default constructor
	*/
	public SoldeCompra() {
		super();
		initialize();
	}

	private void setChoiceRazonSocialproveedor(ArrayList <String> proveedores) {
		try{
			for(int i=0;i<proveedores.size();i++){
				this.choiceRazonSocialproveedor.add(proveedores.get(i));
			
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Proveedores no se puede cargar, compruebe su conexión.");
		}
		
	}

	private void inicializarCampos(){
		metodosSql metodos=new metodosSql();
		setChoiceRazonSocialproveedor(metodos.consultarUnaColumna("select razonSocial from imprenta.proveedor"));
		//modificar este select porque arrojará todos los proveedores y falta filtrar solo
		//los que proveen papel...
		
		//esto deberia solo mostrar las ot que no tienen oc hecha.
		//setChoiceVendedor(metodos.consultarUnaColumna("SELECT nombre FROM imprenta.vendedor;"));
		setFechadeldìa(metodos.dameFechaDeHoyConFormatoX("dd'-'MM'-'yyyy"));
		setChoiceMarca(metodos.consultarUnaColumna("select marca from imprenta.marcapapel"));
		setChoiceCalidad(metodos.consultarUnaColumna("select descripcion from imprenta.calidad"));
		setChoiceVariante(metodos.consultarUnaColumna("select descripcion from imprenta.variante"));
		setChoiceNroOrden(metodos.consultarUnaColumna("select nombre from imprenta.ordenTrabajo"));
		int max=0;
		ArrayList <String> aux=metodos.consultarUnaColumna("SELECT max(idsolicitudCompra) FROM imprenta.solicitudcompra;");
		if(aux.get(0)==null){
			max=1;
			setNrosc(max);
		}else{
			max=Integer.parseInt(aux.get(0));
			max=max+1;
			setNrosc(max);
			
			
		}
	
	}
	private void setChoiceMarca(ArrayList<String>marcas) {
		for(int i=0;i<marcas.size();i++){
			this.choiceMarca.add(marcas.get(i));	
		}
		
	}

	private void setChoiceCalidad(ArrayList<String>calidades) {
		for(int i=0;i<calidades.size();i++){

			this.choiceCalidad.add(calidades.get(i));	
		}
		
		
	}

	private void setChoiceVariante(ArrayList<String>variantes) {
		for(int i=0;i<variantes.size();i++){
			
			this.choiceVariante.add(variantes.get(i));
		}	
		
	}
	

	private void setChoiceIva(Choice choiceIva) {
		this.choiceIva = choiceIva;
	}

	private void setFechadeldìa(String fecha) {
		this.Fechadeldìa.setText(fecha);
	}

	/**
	* This method initializes this
	* 
	* @return void
	*/
	private void initialize() {
		this.setSize(1153, 520);
		this.setContentPane(getJContentPane1());
		this.setTitle("Solicitud de Compra");
		inicializarCampos();
	}

	/**
	* This method initializes jContentPane1	
	* 	
	* @return javax.swing.JPanel	
	*/
	private JPanel getJContentPane1() {
		if (jContentPane1 == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(414, 10, 142, 14));
			jLabel2.setText("Es compra para Stock");
			jLabel221111221 = new JLabel();
			jLabel221111221.setText("Total");
			jLabel221111221.setBounds(new Rectangle(17, 58, 71, 17));
			jLabel22111122 = new JLabel();
			jLabel22111122.setText(" IVA ");
			jLabel22111122.setBounds(new Rectangle(19, 32, 33, 19));
			jLabel22111121 = new JLabel();
			jLabel22111121.setText("Subtotal");
			jLabel22111121.setBounds(new Rectangle(18, 10, 67, 20));
			Vendedor = new JLabel();
			Vendedor.setBounds(new Rectangle(657, 33, 92, 16));
			Vendedor.setText("Vendedor");
			Proveedor = new JLabel();
			Proveedor.setBounds(new Rectangle(291, 32, 64, 16));
			Proveedor.setText("Proveedor");
			Fecha = new JLabel();
			Fecha.setBounds(new Rectangle(17, 34, 46, 16));
			Fecha.setText("Fecha");
			NumeroOT = new JLabel();
			NumeroOT.setBounds(new Rectangle(656, 10, 162, 17));
			NumeroOT.setText("Nombre Orden de Trabajo");
			NroSolicitudCompra = new JLabel();
			NroSolicitudCompra.setBounds(new Rectangle(15, 10, 45, 17));
			NroSolicitudCompra.setText("Numero");
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jContentPane1.add(NroSolicitudCompra, null);
			jContentPane1.add(getNrosc(), null);
			jContentPane1.add(NumeroOT, null);
			jContentPane1.add(Fecha, null);
			jContentPane1.add(getFechadeldìa(), null);
			jContentPane1.add(Proveedor, null);
			jContentPane1.add(Vendedor, null);
			jContentPane1.add(getJPanel(), null);
			jContentPane1.add(getJButton(), null);
			jContentPane1.add(getJButton1(), null);
			jContentPane1.add(getJButton11(), null);
			jContentPane1.add(getChoiceRazonSocialproveedor(), null);
			jContentPane1.add(getJPanel1(), null);
			jContentPane1.add(getJPanel2(), null);
			jContentPane1.add(getCargar(), null);
			jContentPane1.add(getJScrollPane(), null);
			jContentPane1.add(getChoiceNroOrden(), null);
			jContentPane1.add(getJCheckBoxParaStock(), null);
			jContentPane1.add(jLabel2, null);
			jContentPane1.add(getCampoVendedor(), null);
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
			nrosc.setBounds(new Rectangle(74, 10, 156, 17));
			nrosc.setEditable(false);
			nrosc.setText("");
		}
		return nrosc;
	}

	private void setNrosc(int numeroMax) {
		this.nrosc.setText(String.valueOf(numeroMax));
	}

	/**
	* This method initializes Fechadeldìa	
	* 	
	* @return javax.swing.JEditorPane	
	*/
	private JEditorPane getFechadeldìa() {
		if (Fechadeldìa == null) {
			Fechadeldìa = new JEditorPane();
			Fechadeldìa.setBounds(new Rectangle(77, 33, 67, 16));
			Fechadeldìa.setEditable(false);
			Fechadeldìa.setFont(new Font("Perpetua Titling MT", Font.BOLD, 12));
			Fechadeldìa.setText("Fecha del día DD/MM/AAAA");
		}
		return Fechadeldìa;
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
			Horario.setBounds(new Rectangle(846, 11, 48, 16));
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
			jPanel.setBounds(new Rectangle(16, 61, 1003, 41));
			jPanel.setBackground(SystemColor.controlHighlight);
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(getEnviaProv(), null);
			jPanel.add(EnvVendedor, null);
			jPanel.add(getTildeRetirar(), null);
			jPanel.add(jLabel211, null);
			jPanel.add(getDomiciliodeRetiro(), null);
			jPanel.add(Dom, null);
			jPanel.add(FecEntrega, null);
			jPanel.add(Horario, null);
			jPanel.add(getTildeMañana(), null);
			jPanel.add(getTildeTarde(), null);
			jPanel.add(Mañana, null);
			jPanel.add(Tarde, null);
			jPanel.add(getJTextFieldfechaEntrega(), null);
			jPanel.add(getJButtonCalendario(), null);
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
			EnviaProv.setSelected(true);
			EnviaProv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
			    if(EnviaProv.isSelected()){
			    	TildeRetirar.setSelected(false);
			    	
			    }else{
			    	TildeRetirar.setSelected(true);
			    }
					
					
				}
			});
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
			TildeRetirar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(TildeRetirar.isSelected()){
						DomiciliodeRetiro.setEnabled(true);
						EnviaProv.setSelected(false);
					}else
					if(!TildeRetirar.isSelected()){
						DomiciliodeRetiro.setEnabled(false);
						EnviaProv.setSelected(true);
					}
				}
			});
			TildeRetirar.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(TildeRetirar.isSelected()){
						DomiciliodeRetiro.setEnabled(true);
						EnviaProv.setSelected(false);
					}else
					if(!TildeRetirar.isSelected()){
						DomiciliodeRetiro.setEnabled(false);
						EnviaProv.setSelected(true);
					}
				}
			});
			
			
			
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
			DomiciliodeRetiro.setEnabled(false);
		}//
		return DomiciliodeRetiro;
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
			TildeMañana.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(getTildeMañana().isSelected()){
						TildeTarde.setSelected(false);
						}else {
							TildeTarde.setSelected(true);
						}
					}
			});
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
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(5, 2, 55, 21));
			jLabel1.setText("Cantidad");
			jLabelimporteTotal = new JLabel();
			jLabelimporteTotal.setBounds(new Rectangle(917, 2, 85, 21));
			jLabelimporteTotal.setText("Importe Total");
			jLabelUmedida = new JLabel();
			jLabelUmedida.setBounds(new Rectangle(795, 2, 107, 21));
			jLabelUmedida.setText("Unidad de medida");
			jLabelImporte = new JLabel();
			jLabelImporte.setBounds(new Rectangle(694, 2, 88, 21));
			jLabelImporte.setText("Importe");
			jLabelformato = new JLabel();
			jLabelformato.setBounds(new Rectangle(575, 2, 52, 21));
			jLabelformato.setText("Formato");
			jLabelGramaje = new JLabel();
			jLabelGramaje.setBounds(new Rectangle(445, 2, 71, 21));
			jLabelGramaje.setText("Gramaje");
			Variante = new JLabel();
			Variante.setBounds(new Rectangle(310, 2, 120, 21));
			Variante.setText("Variante");
			Calidad = new JLabel();
			Calidad.setBounds(new Rectangle(160, 2, 134, 21));
			Calidad.setText("Calidad");
			marca = new JLabel();
			marca.setBounds(new Rectangle(64, 2, 80, 21));
			marca.setText("Marca");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(593, 22, 26, 17));
			jLabel.setText("X");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBackground(SystemColor.controlHighlight);
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel1.setBounds(new Rectangle(17, 109, 1003, 46));
			
			jPanel1.add(getChoiceMarca(), null);
			jPanel1.add(getChoiceCalidad(), null);
			jPanel1.add(getChoiceVariante(), null);
			jPanel1.add(getCampoGramaje(), null);
			jPanel1.add(getCampoImporte(), null);
			jPanel1.add(getCampoImporteTotal(), null);
			jPanel1.add(getCampoAlto(), null);
			jPanel1.add(getCampoAncho(), null);
			jPanel1.add(jLabel, null);
			jPanel1.add(marca, null);
			jPanel1.add(Calidad, null);
			jPanel1.add(Variante, null);
			jPanel1.add(jLabelGramaje, null);
			jPanel1.add(jLabelformato, null);
			jPanel1.add(jLabelImporte, null);
			jPanel1.add(jLabelUmedida, null);
			jPanel1.add(jLabelimporteTotal, null);
			jPanel1.add(getCampoCantidad(), null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(getCampoUnidadDeMedida(), null);
		}
		return jPanel1;
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
			jButton1.setBounds(new Rectangle(32, 333, 77, 26));
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
	 * This method initializes choiceRazonSocialproveedor	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceRazonSocialproveedor() {
		if (choiceRazonSocialproveedor == null) {
			choiceRazonSocialproveedor = new Choice();
			choiceRazonSocialproveedor.setBounds(new Rectangle(361, 32, 268, 16));
		}
		return choiceRazonSocialproveedor;
	}

	

	/**
	 * This method initializes jTextFieldfechaEntrega	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldfechaEntrega() {
		if (jTextFieldfechaEntrega == null) {
			jTextFieldfechaEntrega = new JTextField();
			jTextFieldfechaEntrega.setBounds(new Rectangle(736, 10, 98, 16));
			jTextFieldfechaEntrega.setName("fechaEntregaOC");
		}
		return jTextFieldfechaEntrega;
	}

	/**
	 * This method initializes jButtonCalendario	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCalendario() {
		if (jButtonCalendario == null) {
			jButtonCalendario = new JButton();
			jButtonCalendario.setBounds(new Rectangle(737, 26, 97, 15));
			jButtonCalendario.setText("Calendario");
			jButtonCalendario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
                Calendario c=new Calendario(jTextFieldfechaEntrega);	
			    c.setVisible(true);
					//System.out.println(jTextFieldfechaEntrega.getName());
				}
			});
		}
		return jButtonCalendario;
	}

	/**
	 * This method initializes choiceMarca	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceMarca() {
		if (choiceMarca == null) {
			choiceMarca = new Choice();
			choiceMarca.setBounds(new Rectangle(64, 20, 80, 21));
			
			
			
			
			
		}
		return choiceMarca;
	}

	/**
	 * This method initializes choiceCalidad	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceCalidad() {
		if (choiceCalidad == null) {
			choiceCalidad = new Choice();
			choiceCalidad.setBounds(new Rectangle(159, 20, 135, 20));
		}
		return choiceCalidad;
	}

	/**
	 * This method initializes choiceVariante	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceVariante() {
		if (choiceVariante == null) {
			choiceVariante = new Choice();
			choiceVariante.setBounds(new Rectangle(309, 20, 121, 20));
		}
		return choiceVariante;
	}

	/**
	 * This method initializes campoGramaje	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoGramaje() {
		Dimension gramaje=new Dimension();
		gramaje.setSize(3, 4);
		
		if (campoGramaje == null) {
			campoGramaje = new JTextField();
			campoGramaje.setBounds(new Rectangle(445, 21, 70, 20));
			campoGramaje.setMaximumSize(gramaje);
		}
		return campoGramaje;
	}

	/**
	 * This method initializes campoImporte	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoImporte() {
		if (campoImporte == null) {
			campoImporte = new JTextField();
			campoImporte.setBounds(new Rectangle(693, 21, 90, 20));
		}
		return campoImporte;
	}

	/**
	 * This method initializes campoImporteTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoImporteTotal() {
		if (campoImporteTotal == null) {
			campoImporteTotal = new JTextField();
			campoImporteTotal.setBounds(new Rectangle(917, 21, 87, 20));
		}
		return campoImporteTotal;
	}

	/**
	 * This method initializes campoAlto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoAlto() {
		if (campoAlto == null) {
			campoAlto = new JTextField();
			campoAlto.setBounds(new Rectangle(541, 21, 42, 20));
			campoAlto.setText("Alto");
			campoAlto.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
					campoAlto.setText("");
				}
			});
		}
		return campoAlto;
	}

	/**
	 * This method initializes campoAncho	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoAncho() {
		if (campoAncho == null) {
			campoAncho = new JTextField();
			campoAncho.setBounds(new Rectangle(626, 21, 54, 20));
			campoAncho.setText("Ancho");
			campoAncho.addFocusListener(new java.awt.event.FocusAdapter() {
				public void focusGained(java.awt.event.FocusEvent e) {
				campoAncho.setText("");
				}
			});
		}
		return campoAncho;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBounds(new Rectangle(787, 273, 233, 97));
			jPanel2.add(jLabel22111121, null);
			jPanel2.add(jLabel22111122, null);
			jPanel2.add(jLabel221111221, null);
			jPanel2.add(getChoiceIva(), null);
			jPanel2.add(getCampoSubTotal(), null);
			jPanel2.add(getCampoIva(), null);
			jPanel2.add(getCampoTotal(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes campoCantidad	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoCantidad() {
		if (campoCantidad == null) {
			campoCantidad = new JTextField();
			campoCantidad.setBounds(new Rectangle(3, 20, 59, 21));
		}
		return campoCantidad;
	}

	/**
	 * This method initializes choiceIva	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceIva() {
		if (choiceIva == null) {
			choiceIva = new Choice();
			choiceIva.setBounds(new Rectangle(59, 32, 50, 19));
		}
		return choiceIva;
	}

	/**
	 * This method initializes campoSubTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoSubTotal() {
		if (campoSubTotal == null) {
			campoSubTotal = new JTextField();
			campoSubTotal.setBounds(new Rectangle(134, 10, 86, 20));
		}
		return campoSubTotal;
	}

	/**
	 * This method initializes campoIva	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoIva() {
		if (campoIva == null) {
			campoIva = new JTextField();
			campoIva.setBounds(new Rectangle(135, 32, 85, 19));
		}
		return campoIva;
	}

	/**
	 * This method initializes campoTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoTotal() {
		if (campoTotal == null) {
			campoTotal = new JTextField();
			campoTotal.setBounds(new Rectangle(136, 58, 86, 17));
		}
		return campoTotal;
	}

	/**
	 * This method initializes cargar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCargar() {
		if (cargar == null) {
			cargar = new JButton();
			cargar.setBounds(new Rectangle(1025, 109, 90, 46));
			cargar.setText("Agregar");
			cargar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				Object[]fila=new Object[10];
				fila[0]=campoCantidad.getText();
			    fila[1]=choiceMarca.getSelectedItem();
			    fila[2]=choiceCalidad.getSelectedItem();
			    fila[3]=choiceVariante.getSelectedItem();	
			    fila[4]=campoGramaje.getText();
			    fila[5]=campoAlto.getText();
			    fila[6]=campoAncho.getText();
			    fila[7]=campoImporte.getText();
			    fila[8]=campoUnidadDeMedida.getText();
			    fila[9]=campoImporteTotal.getText();
				modeloTabla.addRow(fila);
				}
			});
		}
		return cargar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(17, 159, 1004, 104));
			jScrollPane.setViewportView(getJTableMateriales());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableMateriales	
	 * 	
	 * @return javax.swing.JTable	
	 */
	DefaultTableModel modeloTabla=new DefaultTableModel();
	private Choice choiceNroOrden = null;
	private JCheckBox jCheckBoxParaStock = null;
	private JLabel jLabel2 = null;
	private JTextField campoVendedor = null;
	private JTable getJTableMateriales() {
		modeloTabla.addColumn("Cantidad");
		modeloTabla.addColumn("Marca");
		modeloTabla.addColumn("Calidad");
		modeloTabla.addColumn("Variante");
		modeloTabla.addColumn("Gramaje");
		modeloTabla.addColumn("Alto");
		modeloTabla.addColumn("Ancho");
		modeloTabla.addColumn("Importe");
		modeloTabla.addColumn("Unidad de medida");
		modeloTabla.addColumn("Importe total");
		
		
		if (jTableMateriales == null) {
			jTableMateriales = new JTable(modeloTabla);
		}
		return jTableMateriales;
	}

	/**
	 * This method initializes campoUnidadDeMedida	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoUnidadDeMedida() {
		if (campoUnidadDeMedida == null) {
			campoUnidadDeMedida = new JTextField();
			campoUnidadDeMedida.setBounds(new Rectangle(796, 22, 106, 20));
			campoUnidadDeMedida.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					double cantidad=Double.parseDouble(getCampoCantidad().getText());
					double importe=Double.parseDouble(getCampoImporte().getText());
					double importeTotal=cantidad*importe;
					campoImporteTotal.setText(String.valueOf(importeTotal));
					/*if(getCampoCantidad().getText().equals("0") || getCampoCantidad().getText().equals("")){
						
						JOptionPane.showMessageDialog(null, "Corrija la cantidad");
						
						campoCantidad.requestFocus();
						
						campoUnidadDeMedida=new JTextField();
						
						}*/
				}
			});
			
			
					
			
					
						
					
					
					
					
					
					
					
					
					
				
			
		}
		return campoUnidadDeMedida;
	}

	private void setChoiceNroOrden(ArrayList<String>nrosOrden) {
		for(int i=0;i<nrosOrden.size();i++){
			
			this.choiceNroOrden.add(nrosOrden.get(i));	
		}
		
		
		
	}

	/**
	 * This method initializes choiceNroOrden	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceNroOrden() {
		if (choiceNroOrden == null) {
			choiceNroOrden = new Choice();
			choiceNroOrden.setBounds(new Rectangle(844, 10, 172, 21));
		}
		return choiceNroOrden;
	}

	/**
	 * This method initializes jCheckBoxParaStock	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxParaStock() {
		if (jCheckBoxParaStock == null) {
			jCheckBoxParaStock = new JCheckBox();
			jCheckBoxParaStock.setBounds(new Rectangle(571, 8, 23, 16));
		}
		return jCheckBoxParaStock;
	}

	/**
	 * This method initializes campoVendedor	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoVendedor() {
		if (campoVendedor == null) {
			campoVendedor = new JTextField();
			campoVendedor.setBounds(new Rectangle(846, 32, 168, 19));
		}
		return campoVendedor;
	}

}  //  @jve:decl-index=0:visual-constraint="-1,-3"
