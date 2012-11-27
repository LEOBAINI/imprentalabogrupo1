package Imprenta;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import Base.metodosSql;
import Consulta.Consultas;
import Formateador.Formato;
import Pantallas.CierreDeLaOT;

@SuppressWarnings("unused")
public class Prueba {
	
	public static void main(String[] args) {
		/*metodosSql metodos=new metodosSql();
		ArrayList<String>nombreColumnas=null;
		ArrayList<ArrayList<String>>matriz=metodos.consultar("" +
				"SELECT * FROM imprenta.materialesdelasolicituddecompra;" +
				"");
		int filas=matriz.size();
		int columnas=matriz.get(0).size();
		nombreColumnas=metodos.consultarUnaColumna("SELECT COLUMN_NAME "+
" FROM information_schema.COLUMNS"+
" WHERE TABLE_SCHEMA  LIKE 'imprenta'" +
 "    AND TABLE_NAME = 'materialesdelasolicituddecompra' ;");
		for(int h=0;h<columnas;h++)
			System.out.print(nombreColumnas.get(h)+"\t");
			System.out.println("");
		for(int i=0;i<filas;i++){
			for(int j=0;j<columnas;j++){
				System.out.print(matriz.get(i).get(j)+" "+"\t");
				
			}
			System.out.println("");
		}

	
	CierreDeLaOT c=new CierreDeLaOT();
	c.setVisible(true);
	c.setLocationRelativeTo(null);
	
	*/
		Formato f=new Formato();
		System.out.println(f.darHoraBonita());
	}
		
		
	}

