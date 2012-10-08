package Consulta;

import java.util.ArrayList;

import Imprenta.Cliente;
import Imprenta.Iva;
import Base.metodosSql;

public class Consultas {
	

	public Consultas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente dameClienteDeLaBase(int idCliente){
		metodosSql metodos=new metodosSql();
		
		ArrayList<String> row=metodos.consultar("select * from imprenta.cliente where idcliente = "+idCliente).get(0);
		
		
		int indeXidcliente=0;
		int indeXrazonSocial=1;
		int indeXcuit=2;
		int indeXidIva=3;
		int indeXdireccion=4;
		int indeXtelefono=5;
		int indeXmail=6;
		int indeXnombreContacto=7;
		int indeXtelefonoContacto=8;
		int indeXmailContacto=9;
		int  indeXdireccionDeEntrega=10;
		
		 String razonSocial =row.get(indeXrazonSocial);
		 String cuit = row.get(indeXcuit);
		 int iva =	Integer.parseInt(row.get(indeXidIva));
		 Iva _iva=new Iva(iva);
		 _iva.setValor(Double.parseDouble(metodos.consultarUnaColumna("select descripcion from imprenta.iva " +
		 		"where idiva = "+iva).get(0)));
		 String direccion = row.get(indeXdireccion);
		 String telefono = row.get(indeXtelefono);
		 String mail = row.get(indeXmail);
		 String nombreContacto = row.get(indeXnombreContacto);
		 String telefonoContacto = row.get(indeXtelefonoContacto);
		 String mailContacto = row.get(indeXmailContacto);
		 String direccionDeEntraga = row.get(indeXdireccionDeEntrega);
		 
		 Cliente cliente=new Cliente(razonSocial, cuit, _iva,  direccion, telefono, mail, nombreContacto, telefonoContacto, mailContacto, direccionDeEntraga);
		 cliente.setId(Integer.parseInt(row.get(indeXidcliente)));
		 return cliente;
		
	}
}
