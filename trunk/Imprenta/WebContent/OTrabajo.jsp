<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orden de trabajo</title>


<link rel='stylesheet' type='text/css' href="Style.css">
</head>
<body >
<form action="leo" metod="get">

<input type="hidden" name="id" value="OTrabajo">

<input type="text"  name="OrdendeTrabajo" value="" /><a> N° identificatorio</a><br>

<input type="text"  name="Cliente" value="" /><a> Cliente</a><br>

<input type="text"  name="Fecha" value="" /><a> Fecha</a><br>

<input type="text"  name="FechaEntrega" value="" /><a> Fecha Estimada De Entrega</a><br>

<input type="text"  name="Nombre" value="" /><a> Nombre Del Trabajo</a><br>

<input type="text"  name="Detalle" value="" /><a> Detalle Del Trabajo</a><br>

<input type="text"  name="MedidaFinal" value="" /><a> Medida Final </a>

<input type="checkbox" name="apaisado" value="apaisado" ><a> Apaisado</a><br>

<input type="text"  name="MedidaFinal" value="" /><a> Medida Final </a>
<script language="javascript">function Combos(x) {
	ItDepend=document.getElementById('CombDependiente');
	if(!ItDepend){return;}  
	var mitems=new Array();
	mitems['Elige']=[''];
	mitems['Block']=['[Original,150]','[Duplicado,150]','[Triplicado,150]']; 
	mitems['Revista']=['[Tapa,1]','[Paginas Anteriores]'];
	mitems['Calendario']=['[Con Logo]','[Simple]','[Paisaje 3D]','Solo que muestre la fecha',];
	
	ItDepend.options.length=0;
	ItActual=mitems[x.options[x.selectedIndex].value]; 
	if(!ItActual){return;}
	ItDepend.options.length=ItActual.length;
	for(var i=0;i<ItActual.length;i++)
	{    ItDepend.options[i].text=ItActual[i]; 
	ItDepend.options[i].value=ItActual[i];  }}</script>

<input type="text"  name="Cantidad" value="" /><a> Cantidad a entregar </a><br>

<select name="TipoProducto"  onchange="Combos(this)">
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>Tipo de Producto  </a>

<select name="CombDependiente" id="CombDependiente"></select> <a>Tipo de Producto</a><br>
<a>*****************************************************************************************************************************************************************</a><br>
<a>Preimpresión</a><br>
<input type="text" name="CantidadPLanchas" value=""><a>Cantidad De Planchas</a> 
<br>
<a>*****************************************************************************************************************************************************************</a><br>
<a>Tareas</a><br>
<select name="Tareas"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select><a>Elija Tareas para adicionar al trabajo</a>
<br>

<input type="text" value="Tareas"><a>Acá se van agregando las tarea a medida que se seleccionan de arriba</a>


<input type="submit"><a >aceptar</a>


</form>




</body>
</html>