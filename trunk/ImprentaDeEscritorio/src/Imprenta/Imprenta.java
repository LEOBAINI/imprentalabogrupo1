package Imprenta;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Base.metodosSql;





@SuppressWarnings("unused")
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
		Double alto=OT.getAlto();
		Double ancho=OT.getAncho();
																
		String cantAentregar=String.valueOf(OT.getProducto().getCantidad());
		String estado=OT.getEstado();
        String apaisado=OT.getApaisado();
        String descripcion=OT.getDescripcion();
		int cantPlanchas=OT.getCantidadPlanchas();
		String producto=OT.getProducto().getNombreProducto();
		
		
		
		status=metodos.insertarOmodif("INSERT INTO `imprenta`.`ordentrabajo` (`NroOrden`, `Cliente`, `FechaEntrPautada`, "+
		  " `Descripcion`, `Estado`, `EsApaisado`, `Producto`, `FechaConfeccion`, `Nombre`, "+
		  " `Ancho`, `Alto`, `CantidadAEntregar`, `CantPlanchas`) VALUES ("+numeroOrden+", '"+cliente+"', '"+fechaEntrega+"', "+
		   "  '"+descripcion+"', '"+estado+"', '"+apaisado+"', '"+producto+"', '"+fechaConfeccion+"', '"+nombreTrabajo+"', "+ancho+", "+alto+"," +
		   		" "+cantAentregar+", "+cantPlanchas+");");

		//***************************************Tabla ot***************************************************************		
	
		
		//*******************MateriaprimaDeLaOT***************************
		
		
			
		
		
		JTable materiales=OT.getProducto().getMateriales();
		
		int filas=materiales.getModel().getRowCount();
		for(int fila=0;fila<filas;fila++){
			
			
			
			
			
			
			int NroOrdenTrabajo=OT.getNumeroOrdenDeTrabajo();
			String ElementoDelProductoOT=OT.getProducto().getElementos().get(fila).getElemento();
			String CalidadDescripcion=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getCalidad();
			String VarianteDescripcion=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getVariante();
			String FormatoDescripcion=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getFormato();
			int posesXpliego=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getPosesXpliego();	
			int pliegosnetos=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getPliegosnetos();
			int pliegosEnDemasia=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getPliegosEnDemasia();
			int pliegosXhoja=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getPliegosXhoja();
			int hojas=OT.getProducto().getElementos().get(fila).getMateriales().get(0).getCantHojas();
			int  gramaje=Integer.parseInt(OT.getProducto().getElementos().get(fila).getMateriales().get(0).getGramaje());
			int CantidadXunidadTrabajo=OT.getProducto().getElementos().get(fila).getCantidad();
			
			status=status+metodos.insertarOmodif("INSERT INTO `imprenta`.`materiaprimadelaot` (`NroOrdenTrabajo`, `ElementoDelProducto`, " +
					"`CalidadDescripcion`, `VarianteDescripcion`, `FormatoDescripcion`, `posesXpliego`, `pliegosnetos`, `pliegosEnDemasia`," +
					" `pliegosXhoja`, `hojas`, `gramaje`, `CantidadXunidadTrabajo`) VALUES ("+NroOrdenTrabajo+", '"+ElementoDelProductoOT+"'," +
							" '"+CalidadDescripcion+"', '"+VarianteDescripcion+"', " +
					"'"+FormatoDescripcion+"', "+posesXpliego+", "+pliegosnetos+", "+pliegosEnDemasia+", "+pliegosXhoja+", "+hojas+", "+gramaje+"," +
							" "+CantidadXunidadTrabajo+");");
		
			
			
		}
		status=status-(filas-1);
		
	
			JTable tareas=OT.getTareas();
			int filasTarea=tareas.getModel().getRowCount();
			
			for(int i=0;i<filasTarea;i++){
			status=status+metodos.insertarOmodif("INSERT INTO `imprenta`.`tareaordtrabajo` (`idOrdTrabajo`, `idTarea`, `idProveedor`," +
		 " `Estado`) VALUES ("+numeroOrden+", "+metodos.dameNombreTareaTeDoySuId(tareas.getModel().getValueAt(i, 0).toString())+", "+metodos.dameProveedorTeDoyId(tareas.getModel().getValueAt(i, 1).toString())+", 'ACTIVA');");
			}
			status=status-(filasTarea-1);
			
			
		if(status!=3){
			try{
			metodos.insertarOmodif("DELETE FROM `imprenta`.`materiaprimadelaot` WHERE `NroOrdenTrabajo`='"+numeroOrden+"';");
			metodos.insertarOmodif("DELETE FROM `imprenta`.`ordentrabajo` WHERE `NroOrden`='"+numeroOrden+"';");
			metodos.insertarOmodif("DELETE FROM `imprenta`.`tareaordtrabajo` WHERE `idOrdTrabajo`='"+numeroOrden+"';");
			}catch(Exception sql){
				JOptionPane.showMessageDialog(null, "Hubo un error no se pudo hacer rollback, ud tiene dados inconsistentes en nro orden "+numeroOrden);
				
			}
		}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getStackTrace());
		}		
		
		
		
		return status;
		
	}	
	
	
	
	
	
	
	
	
	public static int llenarOrdenCompra(OrdenDeCompra OC){
		int status=0;
		metodosSql metodos=new metodosSql();
		
		
		
		
		int nroOc=OC.getNroOrdenCompra();
		String nombreOt=OC.getNombreDeLaOT();
		int nroOT=0;
		
		if(!nombreOt.equals("Para Stock"))
			nroOT=metodos.dameNombreOTteDoyNroOT(nombreOt); 
		
		String fechaConfeccion=OC.getFechaConfeccion();
		String fechaEntrega=OC.getFechaEntrega();
		String proveedor=OC.getProveedor();
		String vendedor=OC.getVendedor();
		String domicilioEntrega=OC.getDomicilioEntrega();
		String horario=OC.getHorarioEntrega();
		double total=OC.getTotal();
		double iva=OC.getIva();
		
		
		
		
		
		
		
		JTable materiales=OC.getMateriales();
		
		
		
		status=metodos.insertarOmodif("INSERT INTO `imprenta`.`solicitudcompra` "+
				 " (`idsolicitudCompra`, `idOrdTrabajo`, `FechaPedido`, `FechaEntrega`,"+
						 "  `proveedor`, `vendedor`, `lugarDeEntrega`, `horarioDeEntrega`, `total`,`iva`) VALUES "+
						 "  ("+nroOc+", "+nroOT+", '"+fechaConfeccion+"', '"+fechaEntrega+"', '"+proveedor+"', '"+vendedor+"', " +
						 "'"+domicilioEntrega+"', '"+horario+"'"+
						 "  , "+total+","+iva+");");
		
	/*INSERT INTO `imprenta`.`solicitudcompra` 
	 * (`idsolicitudCompra`, `idOrdTrabajo`, `Observacion`, `FechaPedido`, `FechaEntrega`,
	 *  `proveedor`, `vendedor`, `lugarDeEntrega`, `horarioDeEntrega`, `total`) VALUES 
	 *  (1, 1, 'observ', 'fechped', 'FechEntr', 'proveed', 'vendedor', 'lugarEntrega', 'horarioEntrega'
	 *  , total);*/	
		
		TableModel modelo; 
		modelo=materiales.getModel();
		int filas=modelo.getRowCount();
		
		for(int i=0;i<filas;i++){
		int cantidad=Integer.parseInt(modelo.getValueAt(i, 0).toString());
		String marca=modelo.getValueAt(i, 1).toString();
		String calidad=modelo.getValueAt(i, 2).toString();
		String variante=modelo.getValueAt(i,3).toString();
		String gramaje=modelo.getValueAt(i, 4).toString();
		double ancho=Double.parseDouble(modelo.getValueAt(i, 5).toString());
		double alto=Double.parseDouble(modelo.getValueAt(i, 6).toString());
		//double importe=Double.parseDouble(modelo.getValueAt(i, 7).toString());
		String unidadMedida=modelo.getValueAt(i, 8).toString();
		double importeTotal=Double.parseDouble(modelo.getValueAt(i, 9).toString());
		status=status+metodos.insertarOmodif("INSERT INTO `imprenta`.`MaterialesDeLaSolicitudDeCompra` "+
	 " (`nroSolicitudDeCompra`, `Cantidad`,`A_RECIBIR`, `Marca`, `Calidad`, `Variante`, `Gramaje`, `Alto`, `Ancho`,"+ 
	 " `Umedida`, `costoTotal`, `entregado`)" +
	 " VALUES  ("+OC.getNroOrdenCompra()+", "+cantidad+","+cantidad+", '"+marca+"', '"+calidad+"', '"+variante+"', '"+gramaje+"',  "+
	 " "+alto+", "+ancho+", '"+unidadMedida+"', "+importeTotal+", 'PENDIENTE');");
		}
		status=status-(filas-1);
		
	
		
	/*INSERT INTO `imprenta`.`MaterialesDeLaSolicitudDeCompra` 
	 * (`nroSolicitudDeCompra`, `Cantidad`, `Marca`, `Calidad`, `Variante`, `Gramaje`, `Alto`, `Ancho`, 
	 * `Umedida`, `costoTotal`, `entregado`) VALUES  (1, canti, 'marca', 'cali', 'varian', 'gramaje', 
	 * alto, ancho, 'umdida', costotal, 'entregado');*/
		if(status!=2){
			try{
			metodos.insertarOmodif("DELETE FROM `imprenta`.`solicitudcompra` WHERE `idOrdTrabajo`='"+nroOT+"';");
			metodos.insertarOmodif("DELETE FROM `imprenta`.`materialesdelasolicituddecompra` WHERE `nroSolicitudDeCompra`='"+nroOc+"' ;");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage()+" Error en rollBack, la base está inconsistente");
			}
		}
		
		
		//completar en base de datos
		return status;
	}
	public static void verEstadoDeTrabajo(OrdenDeTrabajo ot){
		//consultar con la bd..
	}
	public static void modificarPrecioIva(double numero){
		
	}
	

}
