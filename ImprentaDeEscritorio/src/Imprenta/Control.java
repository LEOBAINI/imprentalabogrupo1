package Imprenta;

import java.util.ArrayList;
import Formateador.Formato;

import Base.metodosSql;

@SuppressWarnings("unused")
public class Control {
/*Antes de crear una orden de trabajo en ordTrabajo se debe crear un cliente .
 * Antes de cargar en material debe estar creada la orden de trabajo en la tabla ordenDetrabajo							
Antes de cargar en tareaOrdTrabajo tiene que estar cargada una orden de trabajo en la tabla orden de trabajo							
En elementos de producto cargo sin problema, no deberia haber cargado nada.	En en segundo intento dio error de Pk duplicada.	

		
		
							
*/	public Control() {
	super();
	// TODO Auto-generated constructor stub
}
//Para la carga de la OT tiene que controlar
//que previamente haya datos en 
								//marcapapel,calidad,variante,formatopapel
//una vez controlado esto tiene que haber datos en:
								//cliente,tarea,proveedor,papel,tipoproducto.
//si esto está correcto y además los datos que entran están en el dominio de los datos previamente cargados, la base va a dar error.
	
	//va a devolver una lista de errores si es que los hay
	/*public ArrayList<String> controlarCargaDeOT(OrdenDeTrabajo OT){
		Formato format=new Formato();
		
		ArrayList<String >errores=new ArrayList<String>();
		metodosSql metodos=new metodosSql();
		Cliente cliente=OT.getCliente();
		
		ArrayList<Integer>marca=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idMarcaPapel FROM imprenta.marcapapel;"));
		ArrayList<Integer>calidad=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idCalidad FROM imprenta.calidad;;"));
		ArrayList<Integer>variante=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idVariante FROM imprenta.variante;"));
		ArrayList<Integer>formato=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idFormatoPapel FROM imprenta.formatopapel;"));
		ArrayList<Integer>tarea=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idTarea FROM imprenta.tarea;"));
		ArrayList<Integer>proveedor=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idProveedor FROM imprenta.proveedor;"));
		ArrayList<Integer>papel=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idpapel FROM imprenta.papel;"));
		ArrayList<Integer>tipoProducto=format.FormatStringAinteger(metodos.consultarUnaColumna("SELECT idTipoProducto FROM imprenta.elementosproducto;"));
		ArrayList<Integer>proveedoresDeTareasDeLaOT=new ArrayList<Integer>();for(int i=0;i<OT.getTareas().size();i++)proveedoresDeTareasDeLaOT.add(OT.getTareas().get(i).getIdProveedor());
		
		
		//como papel tiene FK marca,calidad,variante,formato
		//verificar que los datos entrantes están en el dominio cargado en la base
		if(!marca.contains(OT.getPapel().getMarca())){
			
			errores.add("El idmarca "+OT.getPapel().getMarca()+" no existe en la tabla marca, cárguelo primero");
		}
		if(!calidad.contains(OT.getPapel().getMarca())){
			
			errores.add("El idcalidad "+OT.getPapel().getMarca()+" no existe en la tabla calidad cárguelo primero");
		}
		if(!variante.contains(OT.getPapel().getVariante())){
			
			errores.add("El idVariante "+OT.getPapel().getVariante()+" no existe en la tabla variante cárguelo primero");
			
		}
		if(!formato.contains(OT.getPapel().getFormatoPapel())){
			errores.add("El idFormato "+OT.getPapel().getFormatoPapel()+" no existe en la tabla formatoPapel cárguelo primero");
		}
	
		
		//preguntar si existe el cliente
		if(metodos.consultarUnaColumna("Select idcliente from imprenta.cliente where `idcliente`= "+cliente.getId()).size()==0){
			errores.add("Error, el cliente no fué cargado, cárguelo e intente de nuevo...");
			
			
		}
		//chequear que no haya una orden con el mismo nro de orden
		if(metodos.consultarUnaColumna("Select * from imprenta.ordentrabajo where nroOrden = "+OT.getId()).size()>0){
			errores.add("Ya hay un número de orden con ese identificador "+OT.getId()+" cámbielo e intente cargarlo de nuevo...");
		}
		//chequear que haya una ot cargada antes de cargar en material
		for(int j=0;j<OT.getTareas().size();j++){
			if(!tarea.contains(OT.getTareas().get(j).getIdTarea())){
				errores.add("El idtarea "+OT.getTareas().get(j).getIdTarea()+" no existe en la tabla tareas cárguelo e intente de nuevo");
				
			}
			
		}
		
		if(!proveedor.containsAll(proveedoresDeTareasDeLaOT)){
			errores.add("Error, existe al menos un proveedor que figura en su orden de trabajo pero que no está en la base de datos... ");
			
		}
		if(!papel.contains(OT.getPapel().getId())){
			errores.add("El idPapel "+OT.getPapel().getId()+" no existe en la base cárguelo e intente de nuevo");
			
		}
		if(!tipoProducto.contains(OT.getTipoProducto().getIdProducto())){
			errores.add("El tipo de producto seleccionado "+OT.getTipoProducto().getIdProducto()+" no se encuentra en la base de datos, cárguelo e intente de nuevo");
		}
		
		
		
		
		
		return errores;
	}
	*/

	public boolean hayMasDeUnPunto(String caracteres){
		int cont=0;
		for(int i=0;i<caracteres.length();i++){
			if(caracteres.charAt(i)=='.'){
				cont++;
			}
		}
		if(cont>1){
			return true;
			
		}else{
			return false;
		}
	}
	
	
	public boolean esPunto(char caracter){
		return caracter=='.';
	}
	
	public boolean esNumero(char caracter){
		int maxError=0;
		char cara[] = new char[11];
		cara[0]='0';
		cara[1]='1';
		cara[2]='2';
		cara[3]='3';
		cara[4]='4';
		cara[5]='5';
		cara[6]='6';
		cara[7]='7';
		cara[8]='8';
		cara[9]='9';
		cara[10]='.';
		
		
		
		for(int i=0;i< cara.length;i++){
			
			if((caracter!=cara[i])){
				maxError++;
				
			}			
		}
		if(maxError==11){
			return false;
		}
		System.out.println(maxError);
		return true;
	}


}
