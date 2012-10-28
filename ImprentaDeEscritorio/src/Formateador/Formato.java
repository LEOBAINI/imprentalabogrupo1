package Formateador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


import Base.metodosSql;
import Imprenta.Tarea;


public class Formato {
	public Formato(){
		
	}
	
	public String formatearGetClass(Object o){// te da en un String a que clase pertenece
		
		String resultado=null;
		String preResultado="";
		resultado=o.getClass().toString();
		for(int i=0;i<resultado.length();i++){
			if(resultado.charAt(i)=='.'){
				for(int j=i+1;j<resultado.length();j++){
					preResultado=preResultado+resultado.charAt(j);
				}
			}
		}
	resultado=preResultado;
	
		return resultado;
	}
	public ArrayList<Integer>FormatStringAinteger(ArrayList<String>lista){
		ArrayList<Integer>resultado=new ArrayList<Integer>();
		for(int i=0;i<lista.size();i++){
			resultado.add(Integer.parseInt(lista.get(i)));
			
		}
		return resultado;
		
	}
	
	private  ArrayList<String >SepararTareaProveedor(String tareaProveedor){
		ArrayList<String>ambos=new ArrayList<String>();
		
		String aux="";
		for(int i=0;i!=tareaProveedor.length();++i){
			
			if(tareaProveedor.charAt(i)==','|| i==tareaProveedor.length()){
				ambos.add(aux);
				
				aux="";
					
			}else{
				aux=aux+tareaProveedor.charAt(i);
			}
			
		}
		ambos.add(aux);
		
		return ambos;
	}

	// String frase="(tarea1,proveedor1)(Tarea2,Proveedor2)(Tarea3,Proveedor3)";
      public  ArrayList<Tarea>ArmaTareasDelStringConParentesis(int nroOrden,String cadenaComplejaConParentesis){
    	  ArrayList<Tarea>tar=new ArrayList<Tarea>();
    	  metodosSql metodos=new metodosSql();
    	  String aux="";
    	  
         for (int i=0;i<cadenaComplejaConParentesis.length();i++){
        	 if(cadenaComplejaConParentesis.charAt(i)=='('){
        		 i++;
        		 while(cadenaComplejaConParentesis.charAt(i)!=')'){
        			 aux=aux+cadenaComplejaConParentesis.charAt(i);
        			 i++;
        		 }
        		 ArrayList<String>aux1=SepararTareaProveedor(aux);
        		
        		 int idTar= metodos.dameTareaTedoyElId(aux1.get(0));
        		 int idProv=metodos.dameProveedorTeDoyId(aux1.get(1));
        		 if(idProv!=0 && idProv!=0){
        		// Tarea t=new Tarea(nroOrden,idTar, idProv, "ACTIVA");
        	//	 tar.add(t);
        		 }else{
        			 System.out.println("error la tarea o el proveedor no tienen id, ingrese datos válidos!!!\n Formato lin 83");
        		 }
        		 aux="";
        	 }
         }
        	 
          return tar;
    	  
      }
      
      public String dameFechaConFormatoX(String formatoFechaseparadoXguionyGuionEntreComillas){//el MM va con mayuscula
 		 SimpleDateFormat formateador = new SimpleDateFormat(formatoFechaseparadoXguionyGuionEntreComillas, new Locale("es_ES"));
 		 Date fechaDate = new Date();
          String fecha=formateador.format(fechaDate);
          
 	
 	  return fecha;
 	}
      
      
     
      
      public String ParseaFechaDeInglesACastellano(String fechaInglesa){
    	  
    	String resultado=null;
    	
    	
    	
    	return resultado;
      }
      
      public String[] enMascarar(String mascaraSucursal,String enMascarable){
    	  String[] resultado=new String[2];
    	  String resultadoAux;
    	  int largoDeEnmascarable=enMascarable.length();
    	  int totalDeCerosPosibles=8;
    	  String aux="";
    	  for(int i=0;i<totalDeCerosPosibles-largoDeEnmascarable;i++){
    		  aux=aux+"0";
    	  }
    	  resultadoAux=mascaraSucursal+aux.concat(enMascarable); 
    	  resultado[0]=resultadoAux;
    	  resultado[1]=enMascarable;
    	  return resultado;
    	  
      }
       

}
