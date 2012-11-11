package Imprenta;

import java.util.ArrayList;

import javax.swing.JTable;

public class Producto {

	JTable materiales;//para su uso en ca llenarOT de imprenta, no borrar.
	private String nombreProducto;
	private int cantidad;
	ArrayList<ElementosDelProducto> elementos;
	/**
	 * @param nombreProducto
	 * @param cantidad
	 */
	public Producto(String nombreProducto, int cantidad,JTable tablaMateriales) {
		
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.elementos=new ArrayList<ElementosDelProducto>();
		this.materiales=tablaMateriales;
		agregarElementosDelProductoYSusMateriales(tablaMateriales);
	}
	
	public JTable getMateriales(){
		return this.materiales;
	}
	
	private void agregarElementosDelProductoYSusMateriales(JTable table){
		
		for(int i=0;i<table.getRowCount();i++){
		String elemento=(String) table.getValueAt(i, 0);
		String cantidadHojas= table.getValueAt(i, 1).toString();		
		String calidad=(String) table.getValueAt(i, 2);
		String variante=(String) table.getValueAt(i, 3);
		String gramaje=(String) table.getValueAt(i, 4);
		String formato=(String) table.getValueAt(i, 5);
		String posesXpliego= table.getValueAt(i, 6).toString();
		String pliegosNetos= table.getValueAt(i, 7).toString();
		String pliegosEnDemasia=(String) table.getValueAt(i, 8);
		String pliegosXhoja=(String) table.getValueAt(i, 9);
		
		int cantidadDeEseElemento=Integer.parseInt( table.getValueAt(i, 10).toString());
		
		ElementosDelProducto elementoDelProducto=new ElementosDelProducto(elemento,cantidadDeEseElemento);//de la tabla
		
		Material material=new Material(calidad, variante, gramaje,formato, Integer.parseInt(posesXpliego), Integer.parseInt(pliegosNetos),//de la tabla
		Integer.parseInt(pliegosEnDemasia), Integer.parseInt(pliegosXhoja), Integer.parseInt(cantidadHojas));	
		
		elementoDelProducto.agregarMaterial(material);
		this.elementos.add(elementoDelProducto);
		
		
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList<ElementosDelProducto> getElementos() {
		return elementos;
	}
	public void agregarElementos(ElementosDelProducto elementos) {
		this.elementos.add(elementos);
	}
	
	
	
	
	
}
