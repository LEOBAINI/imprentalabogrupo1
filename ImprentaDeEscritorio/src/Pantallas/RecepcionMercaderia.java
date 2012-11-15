package Pantallas;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Base.metodosSql;

public class RecepcionMercaderia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private Choice choiceDescripcionSC = null;
	private JLabel jLabel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableElementosPapel = null;
	private JButton jButtonAceptar = null;
	private JButton jButtonRechazar = null;
	private JTextField jTextFieldOTnro = null;
	private JLabel jLabel2 = null;
	private JTextField jTextFieldComentario = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel3 = null;
	private JPanel jPanel = null;
	private JScrollPane jScrollPane1 = null;
	private JTable jTableEstadoStock = null;
	private JLabel jLabel4 = null;
	private JTextField CantidadIngresada = null;

	/**
	 * This is the default constructor
	 */
	public RecepcionMercaderia() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		metodosSql metodos=new metodosSql();
		
		
		this.setSize(1181, 466);
		this.setContentPane(getJContentPane());
		this.setTitle("Recepción de Mercadería");
		ArrayList<String>numerosDeSC=null;
		numerosDeSC=metodos.consultarUnaColumna("select idSolicitudCompra from imprenta.solicitudCompra where idsolicitudCompra  IN " +
" (SELECT  nroSolicituddeCompra from imprenta.materialesDeLasolicituddeCompra);");
		for(int i=0;i<numerosDeSC.size();i++){
			getChoiceDescripcionSC().add(numerosDeSC.get(i));
			
		}
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(17, 236, 262, 26));
			jLabel4.setText("Material Recibido");
			jLabel3 = new JLabel();
			jLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			jLabel3.setBackground(SystemColor.inactiveCaption);
			jLabel3.setText("Editar cantidad recibida");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 170, 239, 21));
			jLabel1.setText("Comentario del rechazo");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(259, 3, 201, 19));
			jLabel2.setText("Nombre de OT a la que pertenece");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 4, 159, 18));
			jLabel.setText("Numero de SC");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getChoiceDescripcionSC(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJButtonAceptar(), null);
			jContentPane.add(getJButtonRechazar(), null);
			jContentPane.add(getJTextFieldOTnro(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJTextFieldComentario(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getCantidadIngresada(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes choiceDescripcionSC	
	 * 	
	 * @return java.awt.Choice	
	 */
	private void refrescoTablas(){
		int numeroDeOT=0;
		int numeroDeSC=Integer.parseInt(getChoiceDescripcionSC().getSelectedItem());
		
		metodosSql metodos=new metodosSql();
		numeroDeOT=Integer.parseInt(metodos.consultarUnaColumna("select idOrdTrabajo from imprenta.solicitudCompra where idSolicitudCompra = "+getChoiceDescripcionSC().getSelectedItem()).get(0));
		if(numeroDeOT==0){
			getJTextFieldOTnro().setText("Stockeo");
		}else{
		getJTextFieldOTnro().setText(metodos.consultarUnaColumna("select nombre from imprenta.ordenTrabajo where nroorden= "+numeroDeOT).get(0));
		
		} 
		 
		//esta tabla es la que tiene el campo editable de la cantidad que se recibe
		jTableElementosPapel.setModel(metodos.llenarJtable2("SELECT" +
				" idMatSolCompra,calidad,marca,variante,ancho,alto,gramaje,umedida,cantidad,recibido,A_RECIBIR,entregado FROM" +
				" imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra= "+numeroDeSC+";").getModel());
		
		
		getJTextFieldComentario().setText(metodos.consultarUnaColumna("select comentario from imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra = "+numeroDeSC+";").get(0));
		
		jTableEstadoStock.setModel(metodos.llenarJtable("SELECT * FROM imprenta.stock where nroSolicitudCompra= "+numeroDeSC+" order by partida desc;").getModel());
		
		
	}

	private Choice getChoiceDescripcionSC() {
		if (choiceDescripcionSC == null) {
			choiceDescripcionSC = new Choice();
			choiceDescripcionSC.setBounds(new Rectangle(15, 32, 155, 20));
			//choiceDescripcionSC.add("prueba");
			choiceDescripcionSC.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					refrescoTablas();
				}
			});
			
		}
		return choiceDescripcionSC;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 90, 1139, 78));
			jScrollPane.setViewportView(getJTableElementosPapel());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableElementosPapel	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableElementosPapel() {
		DefaultTableModel modelo=new DefaultTableModel();
		/*
Cantidad
Marca
Calidad
Variante
Gramaje
Alto
Ancho
Umedida
costoTotal
entregado*/
		/*modelo.addColumn("Calidad");
		modelo.addColumn("Marca");
		modelo.addColumn("Variante");
		modelo.addColumn("Ancho");
		modelo.addColumn("Alto");
		modelo.addColumn("Gramaje");
		modelo.addColumn("Umedida");
		modelo.addColumn("Cantidad Pedida");
		modelo.addColumn("Cantidad Recibida");
		modelo.addColumn("Estado");*/
		
		if (jTableElementosPapel == null) {
			jTableElementosPapel = new JTable(modelo);
			jTableElementosPapel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					metodosSql metodos=new metodosSql();
					int idmaterial=Integer.parseInt(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(),0).toString());
					jTextFieldComentario.setText(metodos.consultarUnaColumna("SELECT comentario FROM imprenta.materialesdelasolicituddecompra where idmatsolcompra="+idmaterial+";").get(0));
				}
			});
		}
		return jTableElementosPapel;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private boolean controlarGuardado(){
		if(jTableElementosPapel.getSelectedRow()==-1){
			JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila de la tabla");
			return false;
			
		}if(CantidadIngresada.getText().equals("")||Integer.parseInt(CantidadIngresada.getText())<=0){
			JOptionPane.showMessageDialog(null, "Ingrese un valor mayor que 0 para poder recibir!");
			CantidadIngresada.setText("");
			CantidadIngresada.requestFocus();
			return false;
		}if(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 10)==null){
			//JOptionPane.showMessageDialog(null, "Fila A_RECIBIR está vacía!");
			jTableElementosPapel.setValueAt(0, jTableElementosPapel.getSelectedRow(), 10);
			//return false;
			
		}
		if(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 9)==null){
			//JOptionPane.showMessageDialog(null, "Fila A_RECIBIR está vacía!");
			jTableElementosPapel.setValueAt(0, jTableElementosPapel.getSelectedRow(), 9);
			//return false;
			
		}
		if(Integer.parseInt(CantidadIngresada.getText()) +
		Integer.parseInt(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 9).toString())>Integer.parseInt(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 8).toString())){
			JOptionPane.showMessageDialog(null, "No se puede recibir más de lo que se pide!");
			CantidadIngresada.setText("");
			CantidadIngresada.requestFocus();
			return false;
			
		}
		
		
		return true;
		
	}
	

	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton();
			jButtonAceptar.setBounds(new Rectangle(499, 196, 169, 30));
			jButtonAceptar.setText("Aceptar");
			//tiene que sumar al stock
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			
					/*Al recibir < que cantidad entregado poner el campo "Entregado" en parcial y borrar
					 * comentarios si los hay*/
					public void actionPerformed(java.awt.event.ActionEvent e) {
						
						try{
						if(controlarGuardado()){
						metodosSql metodos=new metodosSql();
						


						int nroSolicitudCompra=Integer.parseInt(choiceDescripcionSC.getSelectedItem());
                        int NroOT=Integer.parseInt(metodos.consultarUnaColumna("SELECT idOrdTrabajo" +
		                " FROM imprenta.solicitudcompra where idsolicitudCompra= "+nroSolicitudCompra+";").get(0));
						int cantidad=Integer.parseInt(CantidadIngresada.getText());
						String UnidadDeMedida=jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 7).toString();//7 jtable
						String fechaRecepcion=metodos.dameFechaDeHoy();
						Calendar Hora= Calendar.getInstance();
						String hora=Hora.get(Calendar.HOUR_OF_DAY) +	":" + Hora.get(Calendar.MINUTE) ;
						
						int iDmaterialesdelasol=Integer.parseInt(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 0).toString());//0Integer.P jtable;
	                    metodos.insertarOmodif("INSERT INTO `imprenta`.`stock` (`nroSolicitudCompra`, `NroOT`, `cantidad`, `UnidadDeMedida`,"+
						 " `fechaRecepcion`, `hora`, `iDmaterialesdelasol`) VALUES ("+nroSolicitudCompra+","+ NroOT+","+cantidad+", "+
						 "  '"+UnidadDeMedida+"', '"+fechaRecepcion+"', '"+hora+"', "+iDmaterialesdelasol+");");				
						
	                    String cantidadViejaDeMaterialesDeLaSol=metodos.consultarUnaColumna("select recibido from imprenta.materialesdelasolicituddecompra where idmatsolcompra="+iDmaterialesdelasol).get(0);
						int parsCantidadVieja=Integer.parseInt(cantidadViejaDeMaterialesDeLaSol);
						int nuevoRecibido=parsCantidadVieja+cantidad;
						metodos.insertarOmodif("UPDATE imprenta.materialesdelasolicituddecompra set recibido="+nuevoRecibido+", A_Recibir=Cantidad-Recibido where idmatsolcompra="+iDmaterialesdelasol);
	                    metodos.insertarOmodif("CALL imprenta.setearEstadoMatSolComP();");
	                    metodos.insertarOmodif("CALL imprenta.setearParcial();");
	                    metodos.insertarOmodif("CALL imprenta.setNoRecibidoMatSC();");
	                   refrescoTablas();
						}
						else{}
						}catch(Exception e2){
						JOptionPane.showMessageDialog(null, e2.getMessage());
						JOptionPane.showMessageDialog(null, e2.getStackTrace());
						JOptionPane.showMessageDialog(null, e2.getLocalizedMessage());
					}
					
				
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					}
					
						
					
			});
			
			
		}
		return jButtonAceptar;
	}

	/**
	 * This method initializes jButtonRechazar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRechazar() {
		if (jButtonRechazar == null) {
			jButtonRechazar = new JButton();
			jButtonRechazar.setBounds(new Rectangle(672, 196, 168, 30));
			jButtonRechazar.setText("Rechazar");
			jButtonRechazar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jTableElementosPapel.getSelectedRow()!=-1){
						
					int idmaterial=0;
					idmaterial=Integer.parseInt(jTableElementosPapel.getValueAt(jTableElementosPapel.getSelectedRow(), 0).toString());
					String comentario=null;
					metodosSql metodos=new metodosSql();
					comentario=JOptionPane.showInputDialog(null, "Escriba motivo del rechazo");
					
metodos.insertarOmodif("update materialesdelasolicituddecompra set `entregado`= 'RECHAZADO', `comentario` = '"+comentario+"' where" +
		" nroSolicitudDeCompra = '"+Integer.parseInt(getChoiceDescripcionSC().getSelectedItem())+"' and idmatsolcompra = "+idmaterial+";");
refrescoTablas();
	
					//dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar al menos una fila de la tabla");
						
					}
				}
			});
			
			//Resta stock y hay que meter un campo de motivo de rechazo
		}
		return jButtonRechazar;
	}

	/**
	 * This method initializes jTextFieldOTnro	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldOTnro() {
		if (jTextFieldOTnro == null) {
			jTextFieldOTnro = new JTextField();
			jTextFieldOTnro.setBounds(new Rectangle(261, 33, 198, 20));
			jTextFieldOTnro.setEditable(false);
		}
		return jTextFieldOTnro;
	}

	/**
	 * This method initializes jTextFieldComentario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldComentario() {
		if (jTextFieldComentario == null) {
			jTextFieldComentario = new JTextField();
			jTextFieldComentario.setBounds(new Rectangle(15, 195, 468, 31));
			jTextFieldComentario.setEditable(false);
		}
		return jTextFieldComentario;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBounds(new Rectangle(760, 51, 247, 36));
			jPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
			jPanel.add(jLabel3, gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(18, 267, 524, 141));
			jScrollPane1.setViewportView(getJTableEstadoStock());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTableEstadoStock	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableEstadoStock() {
		if (jTableEstadoStock == null) {
			jTableEstadoStock = new JTable();
		}
		return jTableEstadoStock;
	}

	/**
	 * This method initializes CantidadIngresada	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCantidadIngresada() {
		if (CantidadIngresada == null) {
			CantidadIngresada = new JTextField();
			CantidadIngresada.setBounds(new Rectangle(1012, 52, 77, 32));
		}
		return CantidadIngresada;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
