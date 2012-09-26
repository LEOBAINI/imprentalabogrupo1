package Imprenta;


import java.io.*; 
import javax.servlet.*; import javax.servlet.http.*;
public class ServletPrueba extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
PrintWriter out = response.getWriter();
String id=request.getParameter("id");

switch(id){
case "OTrabajo": System.out.println("respondo a orden de trabajo");response.sendRedirect("Material.jsp");break;
case "Material": System.out.println("respondo a Material");
//request.setAttribute("Calidad","buana");
String hola=request.getParameter("Variante");
request.setAttribute("leo", hola);
//response.sendRedirect("Material.jsp");
getServletConfig().getServletContext().getRequestDispatcher("/Material.jsp").forward(request, response);
//response.sendRedirect("Material.jsp");break;

}


}






}
