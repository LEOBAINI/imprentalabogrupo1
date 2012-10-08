package Imprenta;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Base.metodosSql;
import Consulta.Consultas;
import Formateador.Formato;

public class Prueba {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		ABM abms = new ABM();
		// Tarea t=new Tarea("Plegadito", "1100");
		// abms.darAltaTarea(t);
		// abms.darBajaTarea(5);
		// abms.modificarTarea(2, t);
		// Iva iva=new Iva(1);
		// Cliente c=new Cliente("p", "yyyyyy", iva, "dir", "tel", "mail",
		// "nombreCon", "telefotacto", "maacto", "dtraga");
		// abms.darAltaCliente(c);
		// abms.darBajaCliente(3);
		// abms.modificarCliente(4, c);
		// abms.darAltAMarcaPapel("papel");
		// abms.darBajaMarcaPapel(1);
		// abms.modificarMarcaPapel(2, "papelucho");
		// abms.darAltaCalidad("alta calidad");
		// abms.darAltaCalidad("baja calidad");
		// abms.darAltaCalidad("mediana calidad");
		// abms.modificarCalidad(1, "masomenos");
		// abms.modificarCalidad(2, "ta gueno el pelpa");
		// abms.darBajaCalidad(1);
		// abms.darAltaFormatoPapel("24", "32");
		// abms.darAltaFormatoPapel("25", "52");
		// abms.darAltaFormatoPapel("34", "62");
		// abms.darBajaFormatoPapel(1);
		// abms.modificarFormatoPapel(3, 2000, 3000);
		/*
		 * abms.darAltaVariante("variante1"); abms.darAltaVariante("variante2");
		 * abms.darAltaVariante("variante3");
		 */
		// abms.modificarVariante(1, "v1");
		// abms.modificarVariante(2, "v2");
		// abms.modificarVariante(3, "v3");
		/*
		 * abms.darBajaVariante(1); abms.darBajaVariante(2);
		 * abms.darBajaVariante(3);
		 */
		//abms.darAltaGramaje(1, 1, 1, 50.5,1 );
		//abms.darBajaGramaje(3);
		//abms.modificarGramaje(4, 4, 4, 4, 40, 40);
		//abms.darAltaiva("prueba Alta", 26.5, "es un varchar");
		//abms.darBajaiva(4);
		//abms.modificariva(3, "iva modificado", 440.01, "es un varchar");
		//abms.darAltaProveedor("razo","cuitxxx", 1, "direccion", "telefono"," mail"," nombreContacto"," telefonoContacto"," mailContacto"," direccionRetiro");
		//abms.darBajaProveedor(3);
		//abms.modificarProveedor(2,"razona","cuityyxxx", 2, "direccionnnnnnnnnn", "telefonosss"," mails"," nombreContactossss"," telefonoContactossss"," mailContactosss"," direccionRetirossssss");
		// abms.darAltaTareaProveedor(2, 1, 23.40);
		//abms.darBajaTareaProveedor(1,1);
		//abms.modificarTareaProveedor(1, 2, 200,1 ,3);
		//abms.darAltaOT(4, "2012-06-03", "Revistas cómicas", "ACTIVO");
		//abms.modificarOT(1, 4, "2013-09-06", "comics", "FINALIZADO");
		//abms.darAltaTareaDeOT(2, 1, 2, "no", "Activa");
		//abms.modificarTareaDeOT(2, 1, 1, "si", "Terminado");
		//abms.darBajaTareaDeOT(2, 1);
		//abms.darAltaOC(2, "Observacion", "2012-06-06", "2012-06-28");
		//abms.modificarOC(1, 2, "obs", "2012-01-01", "2012-01-02");
		/*OrdenDeTrabajo OT=new OrdenDeTrabajo(1);
		OT.agregarTarea("hacerAlgo", "2500");
		OT.agregarMaterial("calidad", "variante", "gramaje", 25, 2,3, 2,1000);
		for(int i=0;i<OT.getTareas().size();i++){
			System.out.println(OT.getTareas().get(i).getNombre());
			System.out.println(OT.getTareas().get(i).getTiempoEstimado());*/
		/*metodosSql m=new metodosSql();
		ArrayList<String>vacio=new ArrayList<>();
		if(m.consultarUnaColumna("select razonSocial from `imprenta`.`cliente` where idcliente='6'").size()==0)
		System.out.println("es null");
		else
			System.out.println(m.consultarUnaColumna("select razonSocial from `imprenta`.`cliente` where idcliente='6'"));*/
		/*ArrayList<Material>numeros=new ArrayList<Material>();
		Material m=new Material(" 1", " 1", "1", 1, 1, 1, 1, 1);
		m.setIdPapel(1);
		numeros.add(m);*/
		
		//abms.CargarMaterialesAOT(numeros, 2);
		Imprenta imp=new Imprenta();
		ArrayList<Material>materiales=new ArrayList<Material>();
		ArrayList<Tarea>tareas=new ArrayList<Tarea>();
		Tarea tarea=new Tarea(3, 2, 1, "ACTIVA");
		tareas.add(tarea);
		Material material=new Material("requete buena", "variante", "un gramaje", 12, 136, 100, 90, 50);
		materiales.add(material);
		TipoProducto tipoProducto=new TipoProducto(1, "Sarazasasa", 1);
		String fechaEntrega="2012-06-06";
		String medidaFinal="10x20";
		int nroOrden=3;
		String nombre="Nombre de la ot";
		String descripcion="prueba con nro ot 8";
		String tiempoEstimado="1500";
		int cantidadPlanchas=6;		
		Papel papel=new Papel(2, 3, 4, "un gramaje", 3);
		papel.setId(2);
		String apaisado="Es apaisado";		
		Iva iva=new Iva(1);
		iva.setValor(21.00);
		Cliente cliente=new Cliente("Razo", "cXXXXXt", iva, "direclienteOrd8", "telefono", "mail", "nombreContacto", "telefonoContacto", "mailContacto", "direccionDeEntraga");
		cliente.setId(1);
        metodosSql metodos=new metodosSql();
        
		/*OrdenDeTrabajo OT=new OrdenDeTrabajo(8);
		
		OT.setCliente(cliente);
		
		OT.setEstado("ACTIVO");
		
		OT.setDescripcion(descripcion);
		
		OT.setFechaConfeccion(metodos.dameFechaDeHoy());
		
		OT.setFechaEntrega(fechaEntrega);
		
		OT.agregarMateriales(materiales);
		
		OT.agregarTareas(tareas);
		
		OT.setPapel(papel);
		
		OT.setApaisado(apaisado);
		
		OT.setMedidaFinal(medidaFinal);
		
		OT.setTipoProducto(tipoProducto);
		
		OT.setCantidadPlanchas(cantidadPlanchas);	
		Imprenta.llenarOrdenTrabajo(OT);*/
        /*Consultas cons=new Consultas();
        Cliente _cliente=new Cliente();
        _cliente=cons.dameClienteDeLaBase(1);
        _cliente.getIva();*/
      /*  Formato f=new Formato();
        String frase="(Barnizado,CMYK)(Plegadito,CMYK)(plegadon,CMYK)";
        ArrayList<Tarea>tareas2= f.ArmaTareasDelStringConParentesis(2, frase);*/
        
        ArrayList<ArrayList<String>>matriz= metodos.consultar("SELECT poseXpliego,plegosnetos,pliegosDemasia,pliegosXhoja,canthojas FROM imprenta.material where idPapel "+
				" in ( SELECT idpapel FROM imprenta.elementosproducto "+
				" where descripcion='tipo1');");
       
		
		
		
			
		}
		
		
	}


