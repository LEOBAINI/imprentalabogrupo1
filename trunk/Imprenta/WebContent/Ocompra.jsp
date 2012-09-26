<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orden de Compra</title>
<link rel='stylesheet' type='text/css' href="Style.css">
<h1>Orden de Compra</h1>
</head>
<body>
	<input type="text" value="">
	<a>N° Identificatorio</a>
	<br>
	<input type="text" value="">
	<a>Fecha de confección</a>
	<br>
	<select name="Proveedor">
		<option value="Elige">Elige</option>
		<option value="Proveedor 1">Proveedor 1</option>
		<option value="Proveedor 2">Proveedor 2</option>
		<option value="Proveedor 3">Proveedor 3</option>
		<option value="Proveedor 4">Proveedor 4</option>
	</select>
	<a>Elija Proveedor</a>
	<br>
	<select name="Vendedor">
		<option value="Elige">Elige</option>
		<option value="Vendedor 1">Proveedor 1</option>
		<option value="Vendedor 2">Proveedor 2</option>
		<option value="Vendedor 3">Proveedor 3</option>
		<option value="Vendedor 4">Proveedor 4</option>
	</select>
	<a>Elija Vendedor</a>
	<br>

	<input type="text" value="">
	<a>N° de OT </a>
	<br>
	<a> Es para Stock (Deje vacio N° de OT) </a>
	<input type="checkbox" name="apaisado" value="apaisado">
	<br>

	<a>*****************************************************************************************************************************************************************</a>
	<br>

	<h1>Condiciónes De Entrega </h1>
	<br>
	<input type="text" name="LugarEntrega" value="">
	<a>Especifique lugar a retirar</a>
	<br>
	<input type="text" name="Fecha" value="">
	<a>Fecha De Entrega</a>
	<br>
	<a>Horario De Entrega : </a>
	<a> Mañana </a>
	<input type="checkbox" name="Maniana" value="Maniana">
	<a> Tarde </a>
	<input type="checkbox" name="Tarde" value="Tarde">
	<br>

	<a>Lo Entrega El Proveedor</a>
	<input type="checkbox" name="EntregaProveedor" value="SI">
	<br>
	<a>Si lo entrega el proveedor deje en blanco lugar a retirar</a>

	<a>*****************************************************************************************************************************************************************</a>
	<br>
	<h1>Detalle</h1>
	<br>
	<a>Materiales</a>
	<br>

	<select name="Calidad">
		<option value="Elige">Elige</option>
		<option value="Block">Block</option>
		<option value="Revista">Revista</option>
		<option value="Calendario">Calendario</option>
	</select>
	<a>Calidad</a>
	<br>
	<select name="Variante">
		<option value="Elige">Elige</option>
		<option value="Block">Block</option>
		<option value="Revista">Revista</option>
		<option value="Calendario">Calendario</option>
	</select>
	<a>Variante</a>
	<br>

	<select name="Calidad">
		<option value="Elige">Elige</option>
		<option value="Block">Block</option>
		<option value="Revista">Revista</option>
		<option value="Calendario">Calendario</option>
	</select>
	<a>Gramaje</a>
	<br>

	<select name="Calidad">
		<option value="Elige">Elige</option>
		<option value="Block">Block</option>
		<option value="Revista">Revista</option>
		<option value="Calendario">Calendario</option>
	</select>
	<a>Formato</a>
	<br>




	<select name="Hojas">
		<option value="100">100</option>
		<option value="200">200</option>
		<option value="300">300</option>
		<option value="1000">1000</option>
	</select>
	<a>Cantidad de Hojas</a>
	<br>

	<select name="Marca">
		<option value="papelucho">Papelucho</option>
		<option value="papelon">Papelón</option>
		<option value="papelito">Papelito</option>

	</select>
	<a>Cantidad de Hojas</a>
	<br>

	<input type="text" name="precio" readonly="readonly">
	<a>Precio Unitario X :</a>
	<select name="Hojas">
		<option value="Resma">Resma</option>
		<option value="KG">KG</option>
		<option value="Hoja">Hoja</option>
	</select>
	<br>

	<input type="text" name="total" readonly="readonly" value="$">
	<a>Total</a>
	<input type="text" name="Subtotal" readonly="readonly" value="$">
	<a>SubTotal</a>

</body>
</html>