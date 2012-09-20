package Base;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import java.util.Locale;

public class metodosSql extends ConexionMySql {
	
	public metodosSql() {
	}
	
	public String dameHorasTrabajadas(String fecha,String usuario){
		String horas="0";
		String dni="0";
		dni=consultarUnaColumna("select dni from proyectoweb.userlogin where usuario='"+usuario+"'").get(0);
		horas=consultarUnaColumna("SELECT SUM(HORASTRABAJADAS) FROM proyectoweb.registrogral "+
        " WHERE DNIPERSONAL="+dni+" AND FECHA='"+fecha+"';").get(0);
		
		return horas;
	}
	
	public String damePeriodo(int periodo,int anio,String atributoTabla){
	
		
		String SQLperiodo = null;
		String anioString=String.valueOf(anio);
		switch(periodo){
			case 1:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"01-01' and "+atributoTabla+" < ' "+anioString+"-02-01'";break;
			case 2:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"02-01' and "+atributoTabla+" < ' "+anioString+"-03-01'";break;
			case 3:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"03-01' and "+atributoTabla+" < ' "+anioString+"-04-01'";break;
			case 4:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"04-01' and "+atributoTabla+"  < ' "+anioString+"-05-01'";break;
			case 5:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"05-01' and "+atributoTabla+"  < ' "+anioString+"-06-01'";break;
			case 6:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"06-01' and "+atributoTabla+"  < ' "+anioString+"-07-01'";break;
			case 7:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"07-01' and "+atributoTabla+"  < ' "+anioString+"-08-01'";break;
			case 8:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"08-01' and "+atributoTabla+"  < ' "+anioString+"-09-01'";break;
			case 9:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"09-01' and "+atributoTabla+"  < ' "+anioString+"-10-01'";break;
			case 10:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"10-01' and "+atributoTabla+"  < ' "+anioString+"-11-01'";break;
			case 11:SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"11-01' and "+atributoTabla+"  < ' "+anioString+"-12-01'";break;
			
			
			case 12:
				int anioMasUno=Integer.parseInt(anioString);
				anioMasUno=anioMasUno+1;
				SQLperiodo=atributoTabla+" >= '"+anioString+"-"+"12-01' and "+atributoTabla+"  < ' "+anioMasUno+"-01-01'";break;
		}
		
		
		return SQLperiodo;
		
	}
		
	public String dameFechaDeHoy(){
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy'-'MM'-'dd", new Locale("es_ES"));
		 Date fechaDate = new Date();
          String fecha=formateador.format(fechaDate);
	
	return fecha;
	}
	public String dameAnio(){
		 SimpleDateFormat formateador = new SimpleDateFormat("yyyy", new Locale("es_ES"));
		 Date fechaDate = new Date();
         String fecha=formateador.format(fechaDate);
	
	return fecha;
	}

	public int insertarOmodif(String sentenciaSql) {
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
	
	private boolean estaUsuarioEnMesesEstado(String usuario,int anio){
		ArrayList<String> usuarios=new ArrayList<String>(); 
		usuarios=consultarUnaColumna("select usuario from MesesEstado where ANIO ="+anio);
		if(usuarios.contains(usuario)){
			return true;
		}
		
		return false;
	}
	
	public int cerrarMes(String usuario,int mes,int anio) {
		int status=0;
		String auxdni=null;
		String periodo=damePeriodo(mes, anio, "fecha");
		
		
		int dni=0;
		//cerrar todos los registros que estén dentro del periodo "mes" o sea del 1 de este mes al 1 del otro mes y sean de usuario
		//y tambien actualizar el estado global del usuario en la tabla MesesEstado
		try{
		auxdni=consultarUnaColumna("select dni from userlogin where usuario = '"+usuario+"'").get(0).toString();//correcto
		
		dni=Integer.parseInt(auxdni);
		//
		insertarOmodif("update registrogral set estado = 'CERRADO' where dniPersonal = "+dni+" and "+periodo);//correcto
		
		if(estaUsuarioEnMesesEstado(usuario, anio)){
			
		insertarOmodif("update MesesEstado set "+dameNroTeDoyMes(mes)+" ='CERRADO' where usuario= '"+usuario+"' and ANIO= "+anio);
		
		}else{
			//CORRECTO
		insertarOmodif("insert into MesesEstado (usuario,anio)values ('"+usuario+"',"+Integer.parseInt(dameAnio())+")");
		
		insertarOmodif("update MesesEstado set "+dameNroTeDoyMes(mes)+" ='CERRADO' where usuario = '"+usuario+"' and ANIO= "+anio);
			
			
			
		}
		status=1;
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Problema en metodos.cerrarMes(String usuario,int mes)");
			status=-1;
		}
		return status;

	}
	
	
	public int abrirMes(String usuario,int mes,int anio) {
		int status=0;
		String auxdni=null;
		String periodo=damePeriodo(mes, anio, "fecha");
		
		
		int dni=0;
		//abrir todos los registros que estén dentro del periodo "mes" o sea del 1 de este mes al 1 del otro mes y sean de usuario
		//y tambien actualizar el estado global del usuario en la tabla MesesEstado
		try{
		auxdni=consultarUnaColumna("select dni from userlogin where usuario = '"+usuario+"'").get(0).toString();//correcto
		
		dni=Integer.parseInt(auxdni);
		//
		insertarOmodif("update registrogral set estado = 'ABIERTO' where dniPersonal = "+dni+" and "+periodo);//correcto
		if(estaUsuarioEnMesesEstado(usuario, anio)){
			
		insertarOmodif("update MesesEstado set "+dameNroTeDoyMes(mes)+" ='ABIERTO' where usuario= '"+usuario+"' and ANIO= "+anio);
		
		}else{
			//CORRECTO
		insertarOmodif("insert into MesesEstado (usuario,anio)values ('"+usuario+"',"+anio+")");
		
		insertarOmodif("update MesesEstado set "+dameNroTeDoyMes(mes)+" ='ABIERTO' where usuario = '"+usuario+"' and ANIO= "+anio);
			
			
			
		}
		status=1;
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Problema en metodos.abrirMes(String usuario,int mes,int anio)");
			status=-1;
		}
		return status;

	}
	

}
