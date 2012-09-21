package Imprenta;
import java.util.ArrayList;


public class Cliente {
	private String razonSocial;
	private String cuit;
	private Iva iva;
	private String direccion;
	private String telefono;
	private String mail;
	private String nombreContacto;
	private String telefonoContacto;
	private String mailContacto;
	private String direccionDeEntraga;
	public Cliente() {
		
		
		
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Iva getIva() {
		return iva;
	}
	public void setIva(Iva iva) {
		this.iva = iva;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getMailContacto() {
		return mailContacto;
	}
	public void setMailContacto(String mailContacto) {
		this.mailContacto = mailContacto;
	}
	public String getDireccionDeEntraga() {
		return direccionDeEntraga;
	}
	public void setDireccionDeEntraga(String direccionDeEntraga) {
		this.direccionDeEntraga = direccionDeEntraga;
	}
	public ArrayList<String> VerAtributos(){
		
		ArrayList<String> atributos=new ArrayList<String>();
		atributos.add("razonSocial");
		atributos.add("cuit");
		atributos.add("iva");
		atributos.add("direccion");
		atributos.add("telefono");
		atributos.add("mail");
		atributos.add("nombreContacto");
		atributos.add("telefonoContacto");
		atributos.add("mailContacto");
		atributos.add("direccionDeEntraga");
		
		return atributos;
	}
	
	
	

}
