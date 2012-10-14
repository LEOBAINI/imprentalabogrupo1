package Imprenta;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Base.metodosSql;





public  class Imprenta {
	
	
	public static int llenarOrdenTrabajo(OrdenDeTrabajo OT){
		int status=0;
		try{
		
		metodosSql metodos=new metodosSql();
		
		//***************************************Tabla ot***************************************************************
		int numeroOrden=OT.getNumeroOrdenDeTrabajo();
		String cliente=OT.getCliente();
		String fechaConfeccion=OT.getFechaConfeccion();//parsear
		String fechaEntrega=OT.getFechaEntrega();//parsear aaaa-mm-dd
		String nombreTrabajo=OT.getNombreTrabajo();
		int alto=OT.getAlto();
		int ancho=OT.getAncho();
																String tipoProducto=OT.getTipoProducto();
		String cantAentregar=OT.getCantidadAentregar();
		String estado=OT.getEstado();
        String apaisado=OT.getApaisado();
        String descripcion=OT.getDescripcion();
		int cantPlanchas=OT.getCantidadPlanchas();
																String medidaFinal=OT.getMedidaFinal();
		String producto=OT.getProducto();
		
		
		
		
		/*INSERT INTO `imprenta`.`ordentrabajo` (`NroOrden`, `Cliente`, `FechaEntrPautada`,
		 *  `Descripcion`, `Estado`, `EsApaisado`, `idTipoProducto`, `FechaConfeccion`, `Nombre`,
		 *   `Ancho`, `Alto`, `CantidadAEntregar`, `CantPlanchas`) VALUES (10, cliente, '2012-06-06',
		 *    'descripcion', 'estado', 'apaisado', 1, '2012-06-09', 'nombre', ancho, alto, cantidadEntrgar, cantPlanchas);

*/		
		
		
		
		
		status=metodos.insertarOmodif("INSERT INTO `imprenta`.`ordentrabajo` (`NroOrden`, `Cliente`, `FechaEntrPautada`, "+
		  " `Descripcion`, `Estado`, `EsApaisado`, `Producto`, `FechaConfeccion`, `Nombre`, "+
		  " `Ancho`, `Alto`, `CantidadAEntregar`, `CantPlanchas`) VALUES ("+numeroOrden+", '"+cliente+"', '"+fechaEntrega+"', "+
		   "  '"+descripcion+"', '"+estado+"', '"+apaisado+"', '"+producto+"', '"+fechaConfeccion+"', '"+nombreTrabajo+"', "+ancho+", "+alto+"," +
		   		" "+cantAentregar+", "+cantPlanchas+");");

		//***************************************Tabla ot***************************************************************		
	
		
		//*******************MateriaprimaDeLaOT***************************
		
		
			
		int nroProducto=metodos.dameNroProducto(OT.getProducto());
		int nroElementoproducto=metodos.dameNroElementoproducto(OT.getTipoProducto());
		JTable materiales=OT.getMateriales();
		//int columnas=materiales.getModel().getColumnCount();
		int filas=materiales.getModel().getRowCount();
		for(int fila=0;fila<filas;fila++){
			
				
				//System.out.println(materiales.getModel().getValueAt(fila, columna));
		status=status+	metodos.insertarOmodif("INSERT INTO `imprenta`.`materiaprimadelaot` (`NroOrdenTrabajo`, `NroDeProducto`, "+
		  " `NroDeElemento`, `MarcaDescripcion`, `CalidadDescripcion`, `VarianteDescripcion`, "+
		 "  `FormatoDescripcion`, `posesXpliego`, `pliegosnetos`, `pliegosEnDemasia`, `pliegosXhoja`," +
		 "   `hojas`, `gramaje`, `CantidadXunidadTrabajo`) VALUES ("+numeroOrden+", "+nroProducto+", "+
		 metodos.dameNroElementoproducto(materiales.getModel().getValueAt(fila, 0).toString())/*numeroDelelemento*/+", " +
		 		" 'Definir',"+
		" '"+materiales.getModel().getValueAt(fila, 1)/*calidad*/+"', '"
			+materiales.getModel().getValueAt(fila, 2)/*variante*/+"', " 
		+"'"+materiales.getModel().getValueAt(fila, 4)/*formato*/+"', "
			+materiales.getModel().getValueAt(fila, 5)/*pporpliego*/+"," 
		+" "+materiales.getModel().getValueAt(fila, 6)/*pliegosnetos*/
	   +", "+materiales.getModel().getValueAt(fila, 7)/*pliegosenDemasia*/+","
	     +""+materiales.getModel().getValueAt(fila, 8)/*plXhoja*/+", "
			+materiales.getModel().getValueAt(fila, 9)/*hojas*/+", "
			+materiales.getModel().getValueAt(fila, 3)/*Gramaje*/+","
			+materiales.getModel().getValueAt(fila, 10)/*CantXunidad*/
			+");");
			
		}
		status=status-(filas-1);
		
		
		/*INSERT INTO `imprenta`.`materiaprimadelaot` (`NroOrdenTrabajo`, `NroDeProducto`,
		 *  `NroDeElemento`, `MarcaDescripcion`, `CalidadDescripcion`, `VarianteDescripcion`,
		 *   `FormatoDescripcion`, `posesXpliego`, `pliegosnetos`, `pliegosEnDemasia`, `pliegosXhoja`,
		 *    `hojas`, `gramaje`, `CantidadXunidadTrabajo`) VALUES (nroOrden, nroProducto, nroelemento, 'marca',
		'calidad', 'variante', 'formato', poses, pliegosnetos, pliegosenDemasia, pliegosXhoja, hojas, gramaje, cantidadXunidadtrabajo);

		 */
		//*************************************************************
		
		
		//*****************TareasOT*****************************
	
			JTable tareas=OT.getTareas();
			int filasTarea=tareas.getModel().getRowCount();
			
			for(int i=0;i<filasTarea;i++){
			status=status+metodos.insertarOmodif("INSERT INTO `imprenta`.`tareaordtrabajo` (`idOrdTrabajo`, `idTarea`, `idProveedor`," +
		 " `Estado`) VALUES ("+numeroOrden+", "+metodos.dameNombreTareaTeDoySuId(tareas.getModel().getValueAt(i, 0).toString())+", "+metodos.dameProveedorTeDoyId(tareas.getModel().getValueAt(i, 1).toString())+", 'ACTIVA');");
			}
			status=status-(filasTarea-1);
			
			
				
			
			
		
		/*INSERT INTO `imprenta`.`tareaordtrabajo` (`idOrdTrabajo`, `idTarea`, `idProveedor`,
		 *  `Estado`) VALUES (ordenTrabajo, tarea, pproveedor, 'estado');*/
		//*************************************************************
		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getStackTrace());
		}		
		
		/*ArrayList<String>errores=null;
		ABM abms=new ABM();
		Control cont=new Control();
		
		errores=cont.controlarCargaDeOT(OT);
		if(errores.size()==0){//si no hay errores cargados
			abms.darAltaOT(OT);
			System.out.println("LlenarOrdenTrabajo se ha ejecutado correctamente");
		}else{
			//mostra los errores
			for(int i=0;i<errores.size();i++){
				System.out.println("Mostrando error numero "+(i+1));
				System.out.println(errores.get(i));
			}
			
		}
		*/
		
		return status;
		
	}	
	
	public static void llenarOrdenCompra(){
		//completar en base de datos
	}
	public static void verEstadoDeTrabajo(OrdenDeTrabajo ot){
		//consultar con la bd..
	}
	public static void modificarPrecioIva(double numero){
		
	}
	

}
