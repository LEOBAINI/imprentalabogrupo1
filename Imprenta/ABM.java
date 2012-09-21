package Imprenta;

import Base.metodosSql;

public class ABM  {
	
	
	
	public ABM(){
		
	}
//*************************************TAREAS***************************************************************************
	public void darAltaTarea(Tarea c){
		metodosSql metodos=new metodosSql();
		
		String atr1=c.getNombre();
		String atr2=c.getTiempoEstimado();
		
		metodos.insertarOmodif("INSERT INTO `imprenta`.`tarea` (`Descripcion`, `tiempoEstimado`) VALUES ('"+atr1+"', '"+atr2+"');");
		
	}
	public void darBajaTarea(int id){
		metodosSql metodos=new metodosSql();
		metodos.insertarOmodif("DELETE FROM `imprenta`.`tarea` WHERE `idTarea`='"+id+"';");
		
	}
	public void modificarTarea(int idAmodificar,Tarea tareaModificada){
		metodosSql metodos=new metodosSql();
		metodos.insertarOmodif("UPDATE `imprenta`.`tarea` SET `Descripcion`='"+tareaModificada.getNombre()+"', `tiempoEstimado`='"+tareaModificada.getTiempoEstimado()+"' WHERE `idTarea`='"+idAmodificar+"';");
		
		
	}

//***********************************FIN ABM TAREAS*****************************************************************************

//***********************************ABM CLIENTES*******************************************************************************
	
	public void darAltaCliente(Cliente c){
	metodosSql metodos=new metodosSql();
	String razon=c.getRazonSocial();
	String cuit=c.getCuit();
	double iva=c.getIva().getValor();
	String direccion=c.getDireccion();
	String telefono=c.getTelefono();
	String mail=c.getMail();
	String nombre=c.getNombreContacto();
	String telefContacto=c.getTelefonoContacto();
	String mailcontacto=c.getMailContacto();
	String direntrega=c.getDireccionDeEntraga();
			
	
	
	metodos.insertarOmodif("INSERT INTO `imprenta`.`cliente`" +
	" (`razonSocial`, `cuit`, `idIva`, `direccion`, `telefono`, `mail`, `nombreContacto`, `telefonoContacto`," +
	" `mailContacto`, `direccionDeEntrega`) VALUES ('"+razon+"', '"+cuit+"', "+iva+", '"+direccion+"', '"+telefono+"'," +
	" '"+mail+"', '"+nombre+"', " +
	"'"+telefContacto+"', '"+mailcontacto+"', '"+direntrega+"');");
	
}
public void darBajaCliente(int PKcliente){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("DELETE FROM `imprenta`.`Cliente` WHERE `idcliente`='"+PKcliente+"';");
	
}
public void modificarCliente(int primaryKeyCliente,Cliente c){
	metodosSql metodos=new metodosSql();
	String razon=c.getRazonSocial();
	String cuit=c.getCuit();
	double iva=c.getIva().getValor();
	String direccion=c.getDireccion();
	String telefono=c.getTelefono();
	String mail=c.getMail();
	String nombre=c.getNombreContacto();
	String telefContacto=c.getTelefonoContacto();
	String mailcontacto=c.getMailContacto();
	String direntrega=c.getDireccionDeEntraga();
	metodos.insertarOmodif("UPDATE `imprenta`.`cliente` SET `razonSocial`='"+razon+"', `cuit`='"+cuit+"'," +
			" `idIva`="+iva+", `direccion`='"+direccion+"', `telefono`='"+telefono+"', `mail`='"+mail+"'," +
			" `nombreContacto`='"+nombre+"'," +
			" `telefonoContacto`='"+telefContacto+"', `mailContacto`='"+mailcontacto+"'," +
			" `direccionDeEntrega`='"+direntrega+"' WHERE `idcliente`='"+primaryKeyCliente+"';");
	
	
	
}
//*********************************************FIN ABM CLIENTES*******************************************************************
//*********************************************ABM MARCA PAPEL********************************************************************
public void darAltAMarcaPapel(String marca){
	metodosSql metodos=new metodosSql();
	
	metodos.insertarOmodif("INSERT INTO `imprenta`.`marcapapel` ( `Marca`) VALUES ('"+marca+"');");
	
}
public void darBajaMarcaPapel(int PkMarcaPapel){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("DELETE FROM `imprenta`.`marcapapel` WHERE `idMarcaPapel`='"+PkMarcaPapel+"';");
	
}
public void modificarMarcaPapel(int idAmodificar,String marcaModificada){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("UPDATE `imprenta`.`marcapapel` SET `Marca`='"+marcaModificada+"' WHERE `idMarcaPapel`='"+idAmodificar+"';");
	
	
}
//********************************************FIN ABM MARCA PAPEL****************************************************************
//********************************************ABM CALIDAD************************************************************************
public void darAltaCalidad(String descripcion){
	metodosSql metodos=new metodosSql();
	
	metodos.insertarOmodif("INSERT INTO `imprenta`.`calidad` ( `descripcion`) VALUES ('"+descripcion+"');");
	
}
public void darBajaCalidad(int PkCalidad){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("DELETE FROM `imprenta`.`calidad` WHERE `idCalidad`='"+PkCalidad+"';");
	
}
public void modificarCalidad(int idAmodificar,String calidadModificada){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("UPDATE `imprenta`.`calidad` SET `descripcion`='"+calidadModificada+"' WHERE `idCalidad`='"+idAmodificar+"';");
	
		
}

//**********************************************FIN ABM CALIDAD******************************************************************
//**********************************************ABM FORMATO PAPEL****************************************************************
public void darAltaFormatoPapel(String alto,String ancho){
	metodosSql metodos=new metodosSql();
	
	metodos.insertarOmodif("INSERT INTO `imprenta`.`formatopapel` ( `alto`,`ancho`) VALUES ('"+alto+"','"+ancho+"');");
	
}
public void darBajaFormatoPapel(int PkformatoPapel){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("DELETE FROM `imprenta`.`formatopapel` WHERE `idformatopapel`='"+PkformatoPapel+"';");
	
}
public void modificarFormatoPapel(int idAmodificar,int alto,int ancho){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("UPDATE `imprenta`.`formatopapel` SET `Ancho`="+ancho+", `Alto`="+alto+" WHERE `idFormatopapel`="+idAmodificar+";");
			
}
//***********************************************FIN ABM FORMATO PAPEL***********************************************************
//***********************************************ABM VARIANTE********************************************************************
public void darAltaVariante(String descripcionVariante){
	metodosSql metodos=new metodosSql();
	
	metodos.insertarOmodif("INSERT INTO `imprenta`.`variante` ( `descripcion`) VALUES ('"+descripcionVariante+"');");
	
}
public void darBajaVariante(int PkVariante){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("DELETE FROM `imprenta`.`variante` WHERE `idVariante`='"+PkVariante+"';");
	
}
public void modificarVariante(int idAmodificar,String nuevaDescripcion){
	metodosSql metodos=new metodosSql();
	metodos.insertarOmodif("UPDATE `imprenta`.`variante` SET  `descripcion`= '"+nuevaDescripcion+"' WHERE `idVariante`="+idAmodificar+";");
			
}



















}
