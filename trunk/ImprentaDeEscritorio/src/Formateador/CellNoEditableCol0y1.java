package Formateador;
import javax.swing.table.DefaultTableModel;

public class CellNoEditableCol0y1 extends DefaultTableModel {
	


	
	   public boolean isCellEditable (int row, int column)
	   {
	       // Aquí devolvemos true o false según queramos que una celda
	       // identificada por fila,columna (row,column), sea o no editable
	       
	          return false;
	      
	   }
	

}
