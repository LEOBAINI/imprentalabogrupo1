package Formateador;


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

}
