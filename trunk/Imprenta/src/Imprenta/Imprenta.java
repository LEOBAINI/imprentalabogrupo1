package Imprenta;
import java.util.ArrayList;

import Base.metodosSql;



public  class Imprenta {
	
	
	public static void llenarOrdenTrabajo(String fechaEntrega,TipoProducto tipoProducto,String medidaFinal,int nroOrden,String nombre,
			String descripcion,String tiempoEstimado,int cantidadPlanchas,ArrayList<Material> materiales,ArrayList<Tarea>tareas,Papel papel,String apaisado,Cliente cliente){
		metodosSql metodos=new metodosSql();
		ABM abms=new ABM();
		OrdenDeTrabajo OT=new OrdenDeTrabajo(nroOrden);
		
		OT.setCliente(cliente);
		
		OT.setEstado("ACTIVO");
		
		OT.setDescripcion(descripcion);
		
		OT.setFechaConfeccion(metodos.dameFechaDeHoy());
		
		OT.setFechaEntrega(fechaEntrega);
		
		OT.agregarMateriales(materiales);
		
		OT.agregarTareas(tareas);
		
		OT.setPapel(papel);
		
		OT.setApaisado(apaisado);
		
		OT.setMedidaFinal(medidaFinal);
		
		OT.setTipoProducto(tipoProducto);
		
		OT.setCantidadPlanchas(cantidadPlanchas);	
		
		abms.darAltaOT(OT);
		
		
		
		
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
