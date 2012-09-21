package Imprenta;

public class Papel {
	private String marca;
	private String calidad;
	private String variante;
	private String gramaje;
	private String formatoPapel;
	public Papel() {
		
	}
	
	public Papel(String marca, String calidad, String variante, String gramaje,
			String formatoPapel) {
		
		this.marca = marca;
		this.calidad = calidad;
		this.variante = variante;
		this.gramaje = gramaje;
		this.formatoPapel = formatoPapel;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCalidad() {
		return calidad;
	}
	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}
	public String getVariante() {
		return variante;
	}
	public void setVariante(String variante) {
		this.variante = variante;
	}
	public String getGramaje() {
		return gramaje;
	}
	public void setGramaje(String gramaje) {
		this.gramaje = gramaje;
	}
	public String getFormatoPapel() {
		return formatoPapel;
	}
	public void setFormatoPapel(String formatoPapel) {
		this.formatoPapel = formatoPapel;
	}
	
	
	
	

}
