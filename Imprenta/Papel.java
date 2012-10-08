package Imprenta;

public class Papel {
	private int marca;
	private int calidad;
	private int variante;
	private String gramaje;
	private int formatoPapel;
	int Id;
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Papel() {
		
	}
	
	public Papel(int marca, int calidad, int variante, String gramaje,
			int formatoPapel) {
		
		this.marca = marca;
		this.calidad = calidad;
		this.variante = variante;
		this.gramaje = gramaje;
		this.formatoPapel = formatoPapel;
	}

		public String getGramaje() {
		return gramaje;
	}
	public void setGramaje(String gramaje) {
		this.gramaje = gramaje;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public int getCalidad() {
		return calidad;
	}

	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}

	public int getVariante() {
		return variante;
	}

	public void setVariante(int variante) {
		this.variante = variante;
	}

	public int getFormatoPapel() {
		return formatoPapel;
	}

	public void setFormatoPapel(int formatoPapel) {
		this.formatoPapel = formatoPapel;
	}
	
	
	
	
	

}
