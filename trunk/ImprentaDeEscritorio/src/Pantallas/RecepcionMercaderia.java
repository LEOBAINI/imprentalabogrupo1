package Pantallas;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Choice;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Base.metodosSql;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import java.awt.Color;

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
" (SELECT  nroSolicituddeCompra from imprenta.materialesDeLasolicituddeCompra where `entregado` != 'ENTREGADO');");
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
		}
		return jContentPane;
	}

	/**
	 * This method initializes choiceDescripcionSC	
	 * 	
	 * @return java.awt.Choice	
	 */
	private Choice getChoiceDescripcionSC() {
		if (choiceDescripcionSC == null) {
			choiceDescripcionSC = new Choice();
			choiceDescripcionSC.setBounds(new Rectangle(15, 32, 155, 20));
			//choiceDescripcionSC.add("prueba");
			choiceDescripcionSC.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
				int numeroDeOT=0;
				int numeroDeSC=Integer.parseInt(getChoiceDescripcionSC().getSelectedItem());
				String nombreDeLaOT=null;
				metodosSql metodos=new metodosSql();
				numeroDeOT=Integer.parseInt(metodos.consultarUnaColumna("select idOrdTrabajo from imprenta.solicitudCompra where idSolicitudCompra = "+getChoiceDescripcionSC().getSelectedItem()).get(0));
				getJTextFieldOTnro().setText(metodos.consultarUnaColumna("select nombre from imprenta.ordenTrabajo where nroorden= "+numeroDeOT).get(0));
				jTableElementosPapel.setModel(metodos.llenarJtable("SELECT" +
						" idMatSolCompra,calidad,marca,variante,ancho,alto,gramaje,umedida,cantidad,recibido,entregado FROM" +
						" imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra= "+numeroDeSC+" and entregado!= 'ENTREGADO';").getModel());
				getJTextFieldComentario().setText(metodos.consultarUnaColumna("select comentario from imprenta.materialesdelasolicituddecompra where nroSolicitudDeCompra = "+numeroDeSC+";").get(0));
				jTableEstadoStock.setModel(metodos.llenarJtable("SELECT * FROM imprenta.stock where nroSolicitudCompra= "+numeroDeSC+";").getModel());
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
		}
		return jTableElementosPapel;
	}

	/**
	 * This method initializes jButtonAceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
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
						/*Al recibir < que cantidad entregado poner el campo "Entregado" en parcial y borrar
						 * comentarios si los hay
						 * */
						try{
						metodosSql metodos=new metodosSql();
						/*hacer el comit de lo que se haya modificado en la tabla (jtable)*/
						
						
						String numeroDeSC=null;
						numeroDeSC=getChoiceDescripcionSC().getSelectedItem();
						int auxNumeroSC=Integer.parseInt(getChoiceDescripcionSC().getSelectedItem());
						int numeroDeOT=Integer.parseInt(metodos.consultarUnaColumna("SELECT idOrdTrabajo FROM imprenta.solicitudcompra "+
" where idSolicitudCompra="+auxNumeroSC+";").get(0));
						
						for(int i=0;i<jTableElementosPapel.getRowCount();i++){
							String recibido=null;
							String pedido=null;//si el recibido < cantidad ponerle parcial.(pedido es la cantidad en la tabla)
							String uMedida=null;
							String recibidoHastaAhora=metodos.consultarUnaColumna("SELECT recibido FROM imprenta.materialesdelasolicituddecompra "+
" where idMatSolCompra="+getJTableElementosPapel().getValueAt(i, 0)+";").get(0);
							String fechaRecepcion=metodos.dameFechaDeHoy();
							Calendar Hora= Calendar.getInstance();

							String hora=Hora.get(Calendar.HOUR_OF_DAY) +	":" + Hora.get(Calendar.MINUTE) ;
							int auxCantidadPedida=0;
							int auxCantidadRecibidaViaJtable=0;
							int banderaParcial=0;
							
							recibido=getJTableElementosPapel().getValueAt(i, 9).toString();
							pedido=getJTableElementosPapel().getValueAt(i, 8).toString();
							uMedida=getJTableElementosPapel().getValueAt(i, 7).toString();
							auxCantidadPedida=Integer.parseInt(pedido);//es lo que se pidio 
							auxCantidadRecibidaViaJtable=Integer.parseInt(recibido)+Integer.parseInt(recibidoHastaAhora);//lo que entra
							/////////////////////////////////////PARCIAL//////////////////////////////////////////
							if(auxCantidadPedida>auxCantidadRecibidaViaJtable && Integer.parseInt(getJTableElementosPapel().getValueAt(i, 9).toString())!=0){//actualizar el estado en entregado y ponerle parcial
								int status1=0;
								//int tablarecibido=Integer.parseInt(recibido);
								status1=status1+metodos.insertarOmodif("Update imprenta.materialesdelasolicituddecompra set `recibido`= "+auxCantidadRecibidaViaJtable+", `entregado` = 'PARCIAL'" +
										",`comentario`= 'RECIBIDO EN FORMA PARCIAL' where idMatSolCompra="+getJTableElementosPapel().getValueAt(i, 0)+";");
								                      status1=status1+metodos.insertarOmodif("INSERT INTO `imprenta`.`stock` (`nroSolicitudCompra`, `NroOT`, `cantidad`, `UnidadDeMedida`, `fechaRecepcion`, `hora`)" +
		                        " VALUES ("+auxNumeroSC+", "+numeroDeOT+", "+auxCantidadRecibidaViaJtable+", '"+uMedida+"', '"+fechaRecepcion+"', '"+hora+"');");
							if(status1!=2){
								JOptionPane.showMessageDialog(null, "Error de grabado en tabla stock o materialesDeLaSolicitud...");
								//hacer rollback
								
								
							}
							JOptionPane.showMessageDialog(null, "RECIBIDO EN FORMA PARCIAL Ejecutado OK!");
							banderaParcial=1;
							dispose();
							}
							
							////////////////////////////////////////////////////////TOTAL///////////////////////////////////////////////////////////////////
							
							
							if(auxCantidadPedida==auxCantidadRecibidaViaJtable && banderaParcial==0 && Integer.parseInt(getJTableElementosPapel().getValueAt(i, 9).toString())!=0){
								metodos.insertarOmodif("Update imprenta.materialesdelasolicituddecompra set `entregado` = 'ENTREGADO'" +
										",`comentario`= 'RECEPCIÓN COMPLETA' where idMatSolCompra="+getJTableElementosPapel().getValueAt(i, 0)+";");
								
								
								metodos.insertarOmodif("INSERT INTO `imprenta`.`stock` (`nroSolicitudCompra`, `NroOT`, `cantidad`, `UnidadDeMedida`, `fechaRecepcion`, `hora`)" +
										" VALUES ("+auxNumeroSC+", "+numeroDeOT+", "+recibido+", '"+uMedida+"', '"+fechaRecepcion+"', '"+hora+"');");
								
							
							//redundante<<<<<-------------------------------
							metodos.insertarOmodif("Update imprenta.materialesdelasolicituddecompra set `recibido` = '"+auxCantidadRecibidaViaJtable+"'" +
									" where idMatSolCompra="+getJTableElementosPapel().getValueAt(i, 0)+";");
							
							JOptionPane.showMessageDialog(null, "RECEPCIÓN COMPLETA Ejecutado OK!");
							dispose();
							
							}
							
							if(auxCantidadPedida<auxCantidadRecibidaViaJtable){
								JOptionPane.showMessageDialog(null, "ERROR RECEPCIÓN MAYOR AL PEDIDO INTENTE DE NUEVO!");
								dispose();
							}
							
						}
						
						
						
						
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
					String comentario=null;
					metodosSql metodos=new metodosSql();
					comentario=JOptionPane.showInputDialog(null, "Escriba motivo del rechazo");
metodos.insertarOmodif("update materialesdelasolicituddecompra set `entregado`= 'RECHAZADO', `comentario` = '"+comentario+"' where nroSolicitudDeCompra = '"+Integer.parseInt(getChoiceDescripcionSC().getSelectedItem())+"';");
metodos.insertarOmodif("Update imprenta.materialesdelasolicituddecompra set `recibido` = '0'" +
		" where nroSolicitudDeCompra = "+Integer.parseInt(getChoiceDescripcionSC().getSelectedItem())+";");		
					//dispose();
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
			jPanel.setBounds(new Rectangle(842, 51, 247, 36));
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

}  //  @jve:decl-index=0:visual-constraint="10,10"
