package Imprenta;
import java.util.ArrayList;

import Base.metodosSql;



public  class Imprenta {
	
	
	public static void llenarOrdenTrabajo(String fechaEntrega,TipoProducto tipoProducto,String medidaFinal,int nroOrden,String nombre,
			String descripcion,String tiempoEstimado,int cantidadPlanchas,ArrayList<Material> materiales,ArrayList<Tarea>tareas,Papel papel,boolean apaisado,Cliente cliente){
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
		
		
		
		abms.CargarMaterialesAOT(OT.getMateriales(),OT.getPapel().getId());//asociar la lista de materiales a la ot en MATERIAL +el Id de papel
		
		abms.CargarTareasAOT(OT.getTareas());
		
		abms.CargarTipoProducto(OT.getId());
		
		abms.CargarClienteAOT(OT.getCliente());
		
		abms.darAltaOT(OT);
		
		
		//cargar en la tabla MATERIAL los materiales de la ot indicando el numero de ot al que pertenece cada material.
		//en MATERIAL también hay un idpapel, asi que al cargar papel en PAPEL, también cargar su id en MATERIAL.
		//como tiene un cliente cargar solo el id de cliente en la OT, si este no existe, tambien en CLIENTE.
		// en TAREA cargar las tareas de la OT con el nro de ot con el proveedor que las hace.
		
		
		abms.darAltaOT(OT);
		
		
		//completar en base de datos
		
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
