package Imprenta;
import java.util.ArrayList;
public class OrdenDeTrabajo {
	private int Id;//
	private Cliente cliente;//
	private String estado;//
	//private int nroOrden;//de mas!!
	//private double iva;
	private ArrayList<Tarea> tareas;//
	private ArrayList<Material> materiales;
	private String fechaEntrega;
	private String fechaConfeccion;
	private String descripcion;
	private String cantidadMatprima;
	private String nombreTrabajo;
	private String detalleTrabajo;
	private String medidaFinal;
	private String apaisado;
	private String cantidadAentregar;
	private TipoProducto tipoProducto;//
	private String detalleProducto;
	private int cantidadPlanchas;
	private Papel papel;
	
	
	
	public Papel getPapel() {
		return papel;
	}


	public void setPapel(Papel papel) {
		this.papel = papel;
	}


	public OrdenDeTrabajo(int nroOrden) {
		this.Id=nroOrden;
		
		
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public void agregarTareas(ArrayList <Tarea>tareas){
		this.tareas=tareas;
	}
	public void agregarMateriales(ArrayList<Material>materiales){
		this.materiales=materiales;
		
	}
	
	public ArrayList<Tarea>getTareas(){
		return this.tareas;
	}
	
	
	
	
	
	public ArrayList<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) {
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

	public String getCantidadMatprima() {
		return cantidadMatprima;
	}

	public void setCantidadMatprima(String cantidadMatprima) {
		this.cantidadMatprima = cantidadMatprima;
	}

	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	public String getDetalleTrabajo() {
		return detalleTrabajo;
	}

	public void setDetalleTrabajo(String detalleTrabajo) {
		this.detalleTrabajo = detalleTrabajo;
	}

	public String getMedidaFinal() {
		return medidaFinal;
	}

	public void setMedidaFinal(String medidaFinal) {
		this.medidaFinal = medidaFinal;
	}

	public String getEsApaisado() {
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

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDetalleProducto() {
		return detalleProducto;
	}

	public void setDetalleProducto(String detalleProducto) {
		this.detalleProducto = detalleProducto;
	}

	public int getCantidadPlanchas() {
		return cantidadPlanchas;
	}

	public void setCantidadPlanchas(int cantidadPlanchas) {
		this.cantidadPlanchas = cantidadPlanchas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	
	/*public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}*/
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}
	

}
