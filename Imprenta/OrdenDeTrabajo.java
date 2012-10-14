package Imprenta;


import javax.swing.JTable;
public class OrdenDeTrabajo {
	private int numeroOrdenDeTrabajo;//
	private String cliente;//
	private String estado;//
	private JTable tareas;//
	private JTable materiales;
	private String fechaEntrega;
	private String fechaConfeccion;
	private String descripcion;
	private String nombreTrabajo;
	private String medidaFinal;
	private String apaisado;
	private String cantidadAentregar;
	private String producto;
	private String elementoDelProducto;//
	private int cantidadPlanchas;
	private int ancho;
	private int alto;
	
	public OrdenDeTrabajo(int numeroOrdenDeTrabajo) {
		super();
		this.numeroOrdenDeTrabajo = numeroOrdenDeTrabajo;
	}

	public int getNumeroOrdenDeTrabajo() {
		return numeroOrdenDeTrabajo;
	}

	public void setNumeroOrdenDeTrabajo(int numeroOrdenDeTrabajo) {
		this.numeroOrdenDeTrabajo = numeroOrdenDeTrabajo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public JTable getTareas() {
		return tareas;
	}

	public void setTareas(JTable tareas) {
		this.tareas = tareas;
	}

	public JTable getMateriales() {
		return materiales;
	}

	public void setMateriales(JTable materiales) {
		this.materiales = materiales;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getFechaConfeccion() {
		return fechaConfeccion;
	}

	public void setFechaConfeccion(String fechaConfeccion) {
		this.fechaConfeccion = fechaConfeccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	public String getMedidaFinal() {
		return medidaFinal;
	}

	public void setMedidaFinal(String medidaFinal) {
		this.medidaFinal = medidaFinal;
	}

	public String getApaisado() {
		return apaisado;
	}

	public void setApaisado(String apaisado) {
		this.apaisado = apaisado;
	}

	public String getCantidadAentregar() {
		return cantidadAentregar;
	}

	public void setCantidadAentregar(String cantidadAentregar) {
		this.cantidadAentregar = cantidadAentregar;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getTipoProducto() {
		return elementoDelProducto;
	}

	

	public int getCantidadPlanchas() {
		return cantidadPlanchas;
	}

	public void setCantidadPlanchas(int cantidadPlanchas) {
		this.cantidadPlanchas = cantidadPlanchas;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public void setElementoDelProducto( String elementoDelProducto) {
		this.elementoDelProducto = elementoDelProducto;
		
	}
	
	
	
	
	
	
	
	

	

	

	


	

}
