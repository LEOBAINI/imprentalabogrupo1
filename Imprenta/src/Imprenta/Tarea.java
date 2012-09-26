package Imprenta;

public class Tarea {
	private String clase="Tarea";
	private String nombre;
	private String tiempoEstimado;
	private String proveedor;
	
	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public Tarea(String nombre, String tiempoEstimado) {
		super();
		this.nombre = nombre;
		this.tiempoEstimado = tiempoEstimado;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	
	
	
	
	

}
