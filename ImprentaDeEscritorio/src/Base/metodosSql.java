package Base;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Formateador.CellEditableSoloLa10;
import Formateador.MiModelo;

public class metodosSql extends ConexionMySql {
	
	public metodosSql() {
	}
	
	
		
	public String dameFechaDeHoy(){
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", new Locale("es_ES"));
		 Date fechaDate = new Date();
          String fecha=formateador.format(fechaDate);
          
	
	return fecha;
	}
	
	public String dameFechaDeHoyConFormatoX(String formatoFechaseparadoXguionyGuionEntreComillas){//el MM va con mayuscula
		 SimpleDateFormat formateador = new SimpleDateFormat(formatoFechaseparadoXguionyGuionEntreComillas, new Locale("es_ES"));
		 Date fechaDate = new Date();
         String fecha=formateador.format(fechaDate);
         
	
	return fecha;
	}
	public int dameTareaTedoyElId(String tarea){
		int idTarea=0;
		ArrayList<String> consulta=consultarUnaColumna("select idtarea from imprenta.tarea where Descripcion= '"+tarea+"';");
		if(consulta.size()>0){
			idTarea=Integer.parseInt(consulta.get(0));
			
		}
		return idTarea;
		
	}
	public int dameProveedorTeDoyId(String proveedor){
		if(proveedor.equals(null)||proveedor.equals("")){
			return 1000;
		}
		int idProveedor=0;
		ArrayList<String> consulta=consultarUnaColumna("select idproveedor from imprenta.proveedor where razonsocial= '"+proveedor+"';");
		
		if(consulta.size()>0){
		idProveedor=Integer.parseInt(consulta.get(0));
		}
		return idProveedor;
		
	}
	
	public String dameAnio(){
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy", new Locale("es_ES"));
		 Date fechaDate = new Date();
         String fecha=formateador.format(fechaDate);
	
	return fecha;
	}

	public int insertarOmodif(String sentenciaSql) {
		System.out.println(sentenciaSql);
		//System.out.println("Luego borrar este syso, solo es para mostrar los datos enviados a la base, (metodosSql linea 34 y 35)");
		int status=0;
		ConexionMySql con = new ConexionMySql();

		try {
			con.conectar();
			con.statemente.executeUpdate(sentenciaSql);

			con.desconectar();
			status=1;
			

		} catch (SQLException e) {
			System.out.println("Error en insertarOmodificar");
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			con.desconectar();
			status=-1;
		}
		return status;

	}

	public ArrayList<ArrayList<String>> consultar(String SentenciaSql) {
		ResultSet res =null;
		ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();//creo una matriz
		String aux=null;
		
		ConexionMySql con = new ConexionMySql();
		
		
		try {
			con.conectar();
			con.resulsete=con.statemente.executeQuery(SentenciaSql);
			res = con.resulsete;
			ResultSetMetaData rmd = res.getMetaData(); //guardo los datos referentes al resultset
			
			 
	            while ( res.next()){
	                    ArrayList<String> columnas = new ArrayList<String>();
	                     for (int i=1; i<=rmd.getColumnCount(); i++) {
	                         aux=res.getString(i);            
	                        	 
	                    	 columnas.add(aux);
	                     }
	                     matriz.add(columnas);
	            }
	        con.desconectar();

			

		} catch (Exception e) {
			System.out.println("Error en metodosSql.consultar"+e.getMessage());
			System.out.println(e.getLocalizedMessage());
			
		}

		return matriz;
		

	}
	
		
		
	
	public ArrayList<String>consultarUnaColumna(String SentenciaSql) {
		ResultSet res =null;
		ArrayList<String> arreglo = new ArrayList<String>();//creo una matriz
		
		
		ConexionMySql con = new ConexionMySql();
		System.out.println(SentenciaSql);
		
		try {
			con.conectar();
			con.resulsete=con.statemente.executeQuery(SentenciaSql);
			res = con.resulsete;
			
			
			 
	            while ( res.next()){
	            	
	                arreglo.add(res.getString(1));
	            }
	        con.desconectar();

			

		} catch (Exception e) {
			System.out.println("Error en metodosSql.consultarUnaColumna"+e.getMessage());
			con.desconectar();
			
		}

		return arreglo;
		

	}
	public String dameNroTeDoyMes(int numeroDeMes){
		String mes="NO EXISTE ESE MES";
		if(numeroDeMes >=1 && numeroDeMes <=12){
		switch(numeroDeMes){
		case 1:mes="ENERO";break;
		case 2:mes="FEBRERO";break;
		case 3:mes="MARZO";break;
		case 4:mes="ABRIL";break;
		case 5:mes="MAYO";break;
		case 6:mes="JUNIO";break;
		case 7:mes="JULIO";break;
		case 8:mes="AGOSTO";break;
		case 9:mes="SEPTIEMBRE";break;
		case 10:mes="OCTUBRE";break;
		case 11:mes="NOVIEMBRE";break;
		case 12:mes="DICIEMBRE";break;
		}
		}
		
		return mes; 
	}
	public  JTable llenarJtable(String sentencia ){
		ConexionMySql con = new ConexionMySql();
		//TableColumnModel modeloColumnas = null;
		java.sql.ResultSetMetaData metadatos;
		
		MiModelo modelo=new MiModelo();//voy a modelar mi jtable
		
		JTable tablaDatos=new JTable(modelo);
		
		try {
		
		con.conectar();
		con.resulsete = con.statemente.executeQuery(sentencia);
		metadatos=con.resulsete.getMetaData();//extraigo datos sobre el resulset
		
		int cantColumnas=metadatos.getColumnCount();// pido cant columnas
		//no se como modelar tamaño de las columnas
		//modeloColumnas.setSelectionModel((ListSelectionModel) tablaDatos);
		
		
		
		for(int i=1;i<=cantColumnas;i++){
		modelo.addColumn(metadatos.getColumnName(i));
		
		
		}
		//avanzo por el resulset para mostrar resultado de consultas
		  while(con.resulsete.next()){
			// Bucle para cada resultado en la consulta
			 
			     // Se crea un array que será una de las filas de la tabla. 
			     Object [] fila = new Object[cantColumnas]; // Hay tres columnas en la tabla

			     // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			     for (int i=0;i<cantColumnas;i++)
			        fila[i] = con.resulsete.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			     // Se añade al modelo la fila completa.
			     modelo.addRow(fila); 
			  }

		
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		con.desconectar();
		return tablaDatos;
		

	}
	public JTable llenarJtable2(String sentencia ){
		ConexionMySql con = new ConexionMySql();
		//TableColumnModel modeloColumnas = null;
		java.sql.ResultSetMetaData metadatos;
		
		CellEditableSoloLa10 modelo=new CellEditableSoloLa10();//voy a modelar mi jtable
		
		JTable tablaDatos=new JTable(modelo);
		
		try {
		
		con.conectar();
		con.resulsete = con.statemente.executeQuery(sentencia);
		metadatos=con.resulsete.getMetaData();//extraigo datos sobre el resulset
		
		int cantColumnas=metadatos.getColumnCount();// pido cant columnas
		//no se como modelar tamaño de las columnas
		//modeloColumnas.setSelectionModel((ListSelectionModel) tablaDatos);
		
		
		
		for(int i=1;i<=cantColumnas;i++){
		modelo.addColumn(metadatos.getColumnName(i));
		
		
		}
		//avanzo por el resulset para mostrar resultado de consultas
		  while(con.resulsete.next()){
			// Bucle para cada resultado en la consulta
			 
			     // Se crea un array que será una de las filas de la tabla. 
			     Object [] fila = new Object[cantColumnas]; // Hay tres columnas en la tabla

			     // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			     for (int i=0;i<cantColumnas;i++)
			        fila[i] = con.resulsete.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			     // Se añade al modelo la fila completa.
			     modelo.addRow(fila); 
			  }

		
		} 
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		con.desconectar();
		return tablaDatos;
		

	}
	public int teDoyNombreProductoDameNumeroID(String nombreProducto){
		int resultado=0;
		metodosSql metodos=new metodosSql();
		resultado=Integer.parseInt(metodos.consultarUnaColumna("SELECT idProducto  FROM imprenta.producto where nombreproducto= '"+nombreProducto+"';").get(0));
		return resultado;
	}



	public int dameQuePapelUsa(String descripcionElementoProducto) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int dameIdCalidadPapel(int idPapel) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int dameIdVariantePapel(int idPapel) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int dameIdFormatoPapel(int idPapel) {
		// TODO Auto-generated method stub
		return 0;
	}



	public int dameGramajePapel(int idPapel) {
		// TODO Auto-generated method stub
		return 0;
	}



	public ArrayList<String> dameCalidades() {
		ArrayList<String>calidadesPosibles=null;
		calidadesPosibles=consultarUnaColumna("select descripcion from imprenta.calidad");
		
		
		
		// TODO Auto-generated method stub
		return calidadesPosibles;
	}



	public ArrayList<String> dameVariantes() {
		ArrayList<String>variantesPosibles=null;
		variantesPosibles=consultarUnaColumna("select descripcion from imprenta.variante");
		
		return variantesPosibles;
	}



	public ArrayList<String> dameFormatos() {
		ArrayList<String>formatos=null;
		formatos=consultarUnaColumna("select descripcion from imprenta.formatopapel");
		
		return formatos;
	}
	
	public int dameNroProducto(String nombreProducto){
		int resultado=0;
		
		resultado=Integer.parseInt(consultarUnaColumna("SELECT idproducto FROM imprenta.producto where nombreproducto='"+nombreProducto+"';").get(0));
		return resultado;
	}



	public int dameNroElementoproducto(String tipoProducto) {
		int resultado=0;
		
		resultado=Integer.parseInt(consultarUnaColumna("SELECT  idElementoDelProducto FROM imprenta.elementosproducto where descripcion='"+tipoProducto+"';").get(0));
		return resultado;
	}
	public int dameNombreTareaTeDoySuId(String nombreTarea){
		int resultado=0;
		resultado=Integer.parseInt(consultarUnaColumna("SELECT idTarea FROM imprenta.tarea where descripcion='"+nombreTarea+"';").get(0));
		
		return resultado;
		
	}



	public int dameNombreOTteDoyNroOT(String nombreOT) {

		int resultado=0;
		resultado=Integer.parseInt(consultarUnaColumna("select nroorden from imprenta.ordentrabajo where nombre = '"+nombreOT+"';").get(0));

		return resultado;
	}
	

}
