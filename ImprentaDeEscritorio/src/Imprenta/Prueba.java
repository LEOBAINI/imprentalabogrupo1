package Imprenta;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Base.metodosSql;
import Consulta.Consultas;
import Formateador.Formato;

public class Prueba {
	
	public static void main(String[] args) {
		Formato f=new Formato();
		//System.out.println(f.dameFechaConFormatoX("yyyy'-'MM'-'dd"));
		
		System.out.println(f.enMascarar("0001-", "1")[1]);
	}
		
		
	}

