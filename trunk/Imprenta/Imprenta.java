package Imprenta;
import java.util.ArrayList;





public  class Imprenta {
	
	
	public static void llenarOrdenTrabajo(OrdenDeTrabajo OT){
		
		ArrayList<String>errores=null;
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
