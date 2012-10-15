package Imprenta;

public class Tarea {
	
	private int idOrdTrabajo;
	private int idTarea;
	private int idProveedor;
	private String Estado;
	public Tarea(int idOrdTrabajo, int idTarea, int idProveedor, String estado) {
		super();
		this.idOrdTrabajo = idOrdTrabajo;
		this.idTarea = idTarea;
		this.idProveedor = idProveedor;
		Estado = estado;
	}
	public int getIdOrdTrabajo() {
		return idOrdTrabajo;
	}
	public void setIdOrdTrabajo(int idOrdTrabajo) {
		this.idOrdTrabajo = idOrdTrabajo;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	
	
	
	
	

}
