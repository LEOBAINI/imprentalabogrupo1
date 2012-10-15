package Imprenta;

public class TipoProducto {
	
	int idProducto;
	String descripcion;
	int cantXunidad;
	public TipoProducto(int idProducto, String descripcion, int cantXunidad) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.cantXunidad = cantXunidad;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantXunidad() {
		return cantXunidad;
	}
	public void setCantXunidad(int cantXunidad) {
		this.cantXunidad = cantXunidad;
	}
	

}
