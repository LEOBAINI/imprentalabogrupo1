<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carga de materiales</title>
</head>
<body>
<a>*****************************************************************************************************************************************************************</a><br>
<form action="leo">
<a>Materiales</a><br>
<input type="hidden" name="id" value="Material">
<input type="text" name="leo">
<select name="Calidade"  >
 
</select><a>Calidade</a>
<br>
 <%out.println("-->"+request.getAttribute("leo")) ;%>
<select name="Variante"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select><a>Variante</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>Gramaje</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>Formato</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>Poses X Pliego</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select><a>Pliegos Netos</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>PLiegos En Demasía</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select> <a>Pliegos X Hoja</a>
<br>

<select name="Calidad"  >
  <option value="Elige">Elige</option>
  <option value="Block">Block</option>
  <option value="Revista">Revista</option>
  <option value="Calendario">Calendario</option>
</select><a>Hojas</a> <br>
<input type="submit">
</form>


</body>
</html>