package Imprenta;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import Base.metodosSql;
import Consulta.Consultas;
import Formateador.Formato;

public class Prueba {
	
	public static void main(String[] args) {
		/*Formato f = new Formato();
		// System.out.println(f.dameFechaConFormatoX("yyyy'-'MM'-'dd"));

		System.out.println(f.enMascarar("0001-", "1")[1]);*/
		
		Calendar Hora= Calendar.getInstance();
		System.out.println("En estos momentos son las " + Hora.get(Calendar.HOUR_OF_DAY) +	":" + Hora.get(Calendar.MINUTE) + " horas.");


	}
		
		
	}

