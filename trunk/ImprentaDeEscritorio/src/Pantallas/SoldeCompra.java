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
import Formateador.JtableNoEditable;
import Imprenta.Control;
import Imprenta.Imprenta;
import Imprenta.OrdenDeCompra;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.GridBagConstraints;

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
	private JLabel jLabel22111121 = null;
	private JLabel jLabel22111122 = null;
	private JLabel jLabel221111221 = null;
	private Choice choiceRazonSocialproveedor = null;
	public static JTextField jTextFieldfechaEntrega = null;
	private JButton jButtonCalendario = null;
	private Choice choiceCalidad = null;
	private Choice choiceVariante = null;
	private JTextField campoGramaje = null;
	private JTextField campoImporte = null;
	private JTextField campoImporteTotal = null;
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
		ArrayList<String >datos=new ArrayList<String>();
		
		datos=metodos.consultarUnaColumna("SELECT descripcion FROM imprenta.formatopapel");
		for(int i=0;i<datos.size();i++){
		choiceFormato.add(datos.get(i));
			
		}
		setChoiceRazonSocialproveedor(metodos.consultarUnaColumna("select razonSocial from imprenta.proveedor where idProveedor != 1000"));
		//modificar este select porque arrojará todos los proveedores y falta filtrar solo
		//los que proveen papel...
		
		//esto deberia solo mostrar las ot que no tienen oc hecha.
		//setChoiceVendedor(metodos.consultarUnaColumna("SELECT nombre FROM imprenta.vendedor;"));
		setFechadeldìa(metodos.dameFechaDeHoyConFormatoX("yyyy'-'MM'-'dd"));
		//setChoiceMarca(metodos.consultarUnaColumna("select marca from imprenta.marcapapel"));
		setChoiceCalidad(metodos.consultarUnaColumna("select descripcion from imprenta.calidad"));
		setChoiceVariante(metodos.consultarUnaColumna("select descripcion from imprenta.variante"));
		setChoiceNroOrden(metodos.consultarUnaColumna("" +
				"SELECT nombre FROM imprenta.ordentrabajo o where nroOrden "+
" in(select NROORDEN from imprenta.ORDENTRABAJO where estado = 'ACTIVA') "+
" and o.nombre!='';"));
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
			jContentPane1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jContentPane1.add(NroSolicitudCompra, null);
			jContentPane1.add(getNrosc(), null);
			jContentPane1.add(NumeroOT, null);
			jContentPane1.add(Fecha, null);
			jContentPane1.add(getFechadeldìa(), null);
			jContentPane1.add(Proveedor, null);
			jContentPane1.add(Vendedor, null);
			jContentPane1.add(getJPanel(), null);
			jContentPane1.add(getJButton(), null);
			
			jContentPane1.add(getChoiceRazonSocialproveedor(), null);
			jContentPane1.add(getJPanel1(), null);
			jContentPane1.add(getCargar(), null);
			jContentPane1.add(getJScrollPane(), null);
			jContentPane1.add(getChoiceNroOrden(), null);
			jContentPane1.add(getJCheckBoxParaStock(), null);
			jContentPane1.add(jLabel2, null);
			jContentPane1.add(getCampoVendedor(), null);
			jContentPane1.add(getCampoUnidadDeMedida(), null);
			jContentPane1.add(getJButtonBorrar(), null);
			jContentPane1.add(getJPanel2(), null);
			jContentPane1.add(getGuardar(), null);
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
			jPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
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
		}
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
			TildeTarde.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(getTildeTarde().isSelected()){
						TildeMañana.setSelected(false);
						}else{
							TildeMañana.setSelected(true);
						}
					
				}
			});
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
			jLabelformato.setBounds(new Rectangle(575, 2, 52, 18));
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
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBackground(SystemColor.controlHighlight);
			jPanel1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel1.setBounds(new Rectangle(17, 109, 1003, 46));
			
			jPanel1.add(getChoiceCalidad(), null);
			jPanel1.add(getChoiceVariante(), null);
			jPanel1.add(getCampoGramaje(), null);
			jPanel1.add(getCampoImporte(), null);
			jPanel1.add(getCampoImporteTotal(), null);
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
			jPanel1.add(getChoiceUnidadDeMedida(), null);
			jPanel1.add(getJTextFieldMarca(), null);
			jPanel1.add(getChoiceFormato(), null);
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
			jTextFieldfechaEntrega.setEditable(false);
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
			campoImporteTotal.setBounds(new Rectangle(917, 21, 82, 20));
			campoImporteTotal.setEditable(false);
		}
		return campoImporteTotal;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(90, 31, 17, 20));
			jLabel.setText("%");
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel2.setBounds(new Rectangle(892, 296, 233, 97));
			jPanel2.add(jLabel22111121, null);
			jPanel2.add(jLabel22111122, null);
			jPanel2.add(jLabel221111221, null);
			jPanel2.add(getCampoSubTotal(), null);
			jPanel2.add(getCampoIva(), null);
			jPanel2.add(getCampoTotal(), null);
			jPanel2.add(getJTextFieldIva(), null);
			jPanel2.add(jLabel, null);
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
	 * This method initializes campoSubTotal	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoSubTotal() {
		if (campoSubTotal == null) {
			campoSubTotal = new JTextField();
			campoSubTotal.setBounds(new Rectangle(136, 11, 86, 17));
			campoSubTotal.setEditable(false);
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
			campoIva.setBounds(new Rectangle(136, 39, 86, 17));
			campoIva.setEditable(false);
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
			campoTotal.setBounds(new Rectangle(136, 67, 86, 17));
			campoTotal.setEditable(false);
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
			cargar.setBounds(new Rectangle(1025, 109, 109, 31));
			cargar.setText("Agregar Fila");
			cargar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(controlarAgregarFila()){
					String S_alto=null;
					String S_ancho=null;
					StringTokenizer parseador=new StringTokenizer(choiceFormato.getSelectedItem());
					
					double cantidad=Double.parseDouble(getCampoCantidad().getText());
					double importe=Double.parseDouble(getCampoImporte().getText());
					double importeTotal=0;
					if(getChoiceUnidadDeMedida().getSelectedItem().equals("Hojas")){
						 					 
						 importeTotal=cantidad*importe;
							S_ancho=parseador.nextToken("X");
							//System.out.println("este es el ancho = "+S_ancho);
							S_alto=parseador.nextToken("X");
							//System.out.println("este es el alto = "+S_alto);
							
							double alto=Double.parseDouble(S_alto);
							
							double ancho=Double.parseDouble(S_ancho);
					}else if(getChoiceUnidadDeMedida().getSelectedItem().equals("KG")){
						//((gramos/cm2 "es (alto*ancho)") *importe)*cantidad
 						double gramos=Double.parseDouble(getCampoGramaje().getText());
						
						
						S_ancho=parseador.nextToken("X");
						//System.out.println("este es el ancho = "+S_ancho);
						S_alto=parseador.nextToken("X");
						//System.out.println("este es el alto = "+S_alto);
						
						double alto=Double.parseDouble(S_alto);
						
						double ancho=Double.parseDouble(S_ancho);
						
						
						
						importeTotal=(((gramos*((alto/100)*(ancho/100)))/1000)*importe)*cantidad;	
						importeTotal=Math.rint(importeTotal*100)/100;  
						
						
						
					}else if(getChoiceUnidadDeMedida().getSelectedItem().equals("Resma")){
						//(cantidad /500)*importe
						S_ancho=parseador.nextToken("X");
						//System.out.println("este es el ancho = "+S_ancho);
						S_alto=parseador.nextToken("X");
						//System.out.println("este es el alto = "+S_alto);
						
						double alto=Double.parseDouble(S_alto);
						
						double ancho=Double.parseDouble(S_ancho);
						importeTotal=(cantidad/500)*importe;
						importeTotal=Math.rint(importeTotal*100)/100;  
					}
					
					
					
					
					
					campoImporteTotal.setText(String.valueOf(importeTotal));	
					System.out.println("El importe total es = "+importeTotal);
					
					
					
					
					
				
				Object[]fila=new Object[10];
				fila[0]=campoCantidad.getText();
			    fila[1]=jTextFieldMarca.getText();
			    fila[2]=choiceCalidad.getSelectedItem();
			    fila[3]=choiceVariante.getSelectedItem();	
			    fila[4]=campoGramaje.getText();
			    fila[5]=S_ancho;
			    fila[6]=S_alto;
			    fila[7]=campoImporte.getText();
			    fila[8]=getChoiceUnidadDeMedida().getSelectedItem();//campoUnidadDeMedida.getText();
			    fila[9]=campoImporteTotal.getText();
				modeloTabla.addRow(fila);
				double sumaSubtotal=0.0;
				for(int i=0;i<modeloTabla.getRowCount();i++){
					sumaSubtotal=sumaSubtotal+Double.parseDouble(modeloTabla.getValueAt(i, 9).toString());
					
				}
				campoSubTotal.setText(String.valueOf(sumaSubtotal));
					}else
					{}
				//terminar else
				
				
				
				
				
				
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
	JtableNoEditable modeloTabla=new JtableNoEditable();
	private Choice choiceNroOrden = null;
	private JCheckBox jCheckBoxParaStock = null;
	private JLabel jLabel2 = null;
	private JTextField campoVendedor = null;
	private JTextField jTextFieldIva = null;
	private JButton guardar = null;
	private Choice choiceUnidadDeMedida = null;
	private JButton jButtonBorrar = null;
	private JTextField jTextFieldMarca = null;
	private Choice choiceFormato = null;
	private JLabel jLabel = null;
	private JTable getJTableMateriales() {
		modeloTabla.addColumn("Cantidad");
		modeloTabla.addColumn("Marca");
		modeloTabla.addColumn("Calidad");
		modeloTabla.addColumn("Variante");
		modeloTabla.addColumn("Gramaje");
		modeloTabla.addColumn("Ancho");
		modeloTabla.addColumn("Alto");		
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
			campoUnidadDeMedida.setBounds(new Rectangle(1030, 183, 106, 20));
			campoUnidadDeMedida.setVisible(false);
			
				/*
					double cantidad=Double.parseDouble(getCampoCantidad().getText());
					double importe=Double.parseDouble(getCampoImporte().getText());
					double importeTotal=0;
					if(getChoiceUnidadDeMedida().getSelectedItem().equals("Hojas")){
						 					 
						 importeTotal=cantidad*importe;
						
					}else if(getChoiceUnidadDeMedida().getSelectedItem().equals("KG")){
						//((gramos/cm2 "es (alto*ancho)") *importe)*cantidad
						double gramos=Double.parseDouble(getCampoGramaje().getText());
						double alto=Double.parseDouble(getCampoAlto().getText());
						double ancho=Double.parseDouble(getCampoAncho().getText());
						importeTotal=((gramos*(alto*ancho))*importe)*cantidad;						
						
					}else if(getChoiceUnidadDeMedida().getSelectedItem().equals("Resma")){
						//(cantidad /500)*importe
						importeTotal=(cantidad/500)*importe;
					}
					
					
					
					
					
					*/
			//campoImporteTotal.setText(String.valueOf(importeTotal));
					
					/*if(getCampoCantidad().getText().equals("0") || getCampoCantidad().getText().equals("")){
						
						JOptionPane.showMessageDialog(null, "Corrija la cantidad");
						
						campoCantidad.requestFocus();
						
						campoUnidadDeMedida=new JTextField();
						
						}*/}					
				
			
		//}
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

	/**
	 * This method initializes jTextFieldIva	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldIva() {
		if (jTextFieldIva == null) {
			jTextFieldIva = new JTextField();
			jTextFieldIva.setBounds(new Rectangle(55, 32, 29, 19));
			jTextFieldIva.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					try{
						
									Control c=new Control();
									int aux=jTextFieldIva.getText().length();
									if(c.esNumero(jTextFieldIva.getText().charAt(aux-1))==true && c.hayMasDeUnPunto(jTextFieldIva.getText())==false){
										
									
										if(!c.esPunto(jTextFieldIva.getText().charAt(aux-1))){
									
						
						
						double subtotal=0;
						double _campoIva=0;
						double iva=0;
						double total=0;
						iva=Double.parseDouble(getJTextFieldIva().getText());
						subtotal=Double.parseDouble(getCampoSubTotal().getText());
						_campoIva=(subtotal*(iva/100));
						_campoIva=Math.rint(_campoIva*100)/100;  
						campoIva.setText(String.valueOf(_campoIva));
						total=subtotal+_campoIva;
						total=Math.rint(total*100)/100; 
						campoTotal.setText(String.valueOf(total));
										}
										else{
											
										}
									}else{
										double sumaSubtotal=0;
										JOptionPane.showMessageDialog(null, "Ingrese sólo números!!!");
										jTextFieldIva.setText("");
										campoSubTotal.setText("");
										campoIva.setText("");
										campoTotal.setText("");
										for(int i=0;i<modeloTabla.getRowCount();i++){
											sumaSubtotal=sumaSubtotal+Double.parseDouble(modeloTabla.getValueAt(i, 9).toString());
											
										}
										campoSubTotal.setText(String.valueOf(sumaSubtotal));
										
									}
						
						
						
						
						
						
						
						}catch(Exception er){
							System.out.println(er.getMessage());
						}
						
					
				}
			});
			
				
			
		}
		return jTextFieldIva;
	}

	/**
	 * This method initializes guardar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	
	private boolean controlarAgregarFila(){
		int errorCampos=0;
		if(campoCantidad.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor no deje vacío el campo cantidad");
			campoCantidad.requestFocus();
			errorCampos++;
			
		}if(jTextFieldMarca.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Seleccione una marca");
			jTextFieldMarca.requestFocus();
			errorCampos++;
			
		}
		if(campoGramaje.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese un gramaje");
			campoGramaje.requestFocus();
			errorCampos++;
			
		}
		if(campoImporte.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese un importe");
			campoImporte.requestFocus();
			errorCampos++;
			
		}
		return errorCampos==0;
		
	}
	private boolean controlarCamposParaBotonGuardar(){
		int errorCampos=0;
		
		///////////////////////////////////////////////////////////////
		if(!TildeMañana.isSelected()&&! TildeTarde.isSelected()){
			JOptionPane.showMessageDialog(null, "Seleccione tilde mañana o tarde");
			TildeMañana.requestFocus();
			errorCampos++;
		}else{
			
		}
		
		if(jTextFieldfechaEntrega.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor, complete la fecha de entrega");
			jTextFieldfechaEntrega.requestFocus();
			errorCampos++;
		}
		if(TildeRetirar.isSelected() && DomiciliodeRetiro.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ha seleccionado el tilde RETIRAR, indique direccion de retiro");
			DomiciliodeRetiro.requestFocus();
			errorCampos++;
		}
		if(campoVendedor.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor complete el campo vendedor");
			campoVendedor.requestFocus();
			errorCampos++;
		}
		
		if(jTableMateriales.getRowCount()==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese al menos una fila");
			campoCantidad.requestFocus();
			errorCampos++;
			
			
		}
		if(jTextFieldIva.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Complete el campo IVA");
			jTextFieldIva.requestFocus();
			errorCampos++;
			
		}
		return errorCampos==0;
	}
	
	
	private JButton getGuardar() {
		if (guardar == null) {
			guardar = new JButton();
			guardar.setText("Guardar");
			guardar.setBounds(new Rectangle(1045, 441, 80, 26));
			guardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						if(controlarCamposParaBotonGuardar()){
						
						
						
						
						
						
						
						
					int status=0;
					Imprenta imp=new Imprenta();
					
					//OrdenDeCompra OC=new OrdenDeCompra(getChoiceNroOrden().getSelectedItem().toString(), Integer.parseInt(getNrosc().toString()), getFechadeldìa().toString());
					OrdenDeCompra OC=new OrdenDeCompra();
					
					OC.setNombreDeLaOT(getChoiceNroOrden().getSelectedItem().toString());
					
					OC.setNroOrdenCompra(Integer.parseInt(getNrosc().getText()));
					
					OC.setFechaConfeccion(getFechadeldìa().getText());
					
					OC.setMateriales(jTableMateriales);
					OC.setDomicilioEntrega(getDomiciliodeRetiro().getText());
					OC.setEsParaStock(getJCheckBoxParaStock().isSelected());
					OC.setFechaEntrega(getJTextFieldfechaEntrega().getText());
					if(getTildeMañana().isSelected()){
					OC.setHorarioEntrega("MAÑANA");
					}else{
						OC.setHorarioEntrega("TARDE");
					}
					OC.setIva(Double.parseDouble(getJTextFieldIva().getText()));
					OC.setLoEnviaProveedor(getEnviaProv().isSelected());
					OC.setProveedor(getChoiceRazonSocialproveedor().getSelectedItem());
					OC.setTotal(Double.parseDouble(getCampoTotal().getText()));
					OC.setVendedor(getCampoVendedor().getText());
					status=imp.llenarOrdenCompra(OC);
					if(status==2){
						JOptionPane.showMessageDialog(null, "Datos cargados con éxito!");
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Error al cargar los datos");
						
					}
			}else{
				
			}
					}
					
					
					catch(Exception e20){
						JOptionPane.showMessageDialog(null, e20.getMessage()+ "Error al setear OC linea 1072SolDeCompra");
					}
					
					
				}
			});
		}
		return guardar;
	}

	/**
	 * This method initializes choiceUnidadDeMedida	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceUnidadDeMedida() {
		if (choiceUnidadDeMedida == null) {
			choiceUnidadDeMedida = new Choice();
			choiceUnidadDeMedida.setBounds(new Rectangle(795, 20, 107, 18));
			choiceUnidadDeMedida.add("Resma");
			choiceUnidadDeMedida.add("KG");
			choiceUnidadDeMedida.add("Hojas");
		}
		return choiceUnidadDeMedida;
	}

	/**
	 * This method initializes jButtonBorrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonBorrar() {
		if (jButtonBorrar == null) {
			jButtonBorrar = new JButton();
			jButtonBorrar.setBounds(new Rectangle(1025, 157, 109, 31));
			jButtonBorrar.setText("Borrar Fila");
			jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
					double sumaSubtotal=0.0;
					DefaultTableModel tmp=(DefaultTableModel) jTableMateriales.getModel();
					tmp.removeRow(jTableMateriales.getSelectedRow());
					if(modeloTabla.getRowCount()>0){
					for(int i=0;i<modeloTabla.getRowCount();i++){
						sumaSubtotal=sumaSubtotal+Double.parseDouble(modeloTabla.getValueAt(i, 9).toString());
						
					}
					}
					campoSubTotal.setText(String.valueOf(sumaSubtotal));
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "No hay elementos seleccionados para borrar!");
						
					}
				}
			});
		}
		return jButtonBorrar;
	}

	/**
	 * This method initializes jTextFieldMarca	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMarca() {
		if (jTextFieldMarca == null) {
			jTextFieldMarca = new JTextField();
			jTextFieldMarca.setBounds(new Rectangle(66, 22, 89, 18));
		}
		return jTextFieldMarca;
	}

	/**
	 * This method initializes choiceFormato	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceFormato() {
		if (choiceFormato == null) {
			choiceFormato = new Choice();
			choiceFormato.setBounds(new Rectangle(549, 20, 109, 21));
		}
		return choiceFormato;
	}

}  //  @jve:decl-index=0:visual-constraint="-1,-3"
