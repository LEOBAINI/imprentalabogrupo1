package Imprenta;

public class Material {
	private int IdPapel;
	public int getIdPapel() {
		return IdPapel;
	}

	public void setIdPapel(int idPapel) {
		IdPapel = idPapel;
	}

	private String calidad;
	private String variante;
	private String gramaje;
	private int posesXpliego;
	private int pliegosnetos;
	private int pliegosEnDemasia;
	private int pliegosXhoja;
	private int cantHojas;
	
	
	public Material(String calidad, String variante, String gramaje,
			int posesXpliego, int pliegosnetos, int pliegosEnDemasia,
			int pliegosXhoja, int cantHojas) {
		super();
		this.calidad = calidad;
		this.variante = variante;
		this.gramaje = gramaje;
		this.posesXpliego = posesXpliego;
		this.pliegosnetos = pliegosnetos;
		this.pliegosEnDemasia = pliegosEnDemasia;
		this.pliegosXhoja = pliegosXhoja;
		this.cantHojas = cantHojas;
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

	public int getPosesXpliego() {
		return posesXpliego;
	}

	public void setPosesXpliego(int posesXpliego) {
		this.posesXpliego = posesXpliego;
	}

	public int getPliegosnetos() {
		return pliegosnetos;
	}

	public void setPliegosnetos(int pliegosnetos) {
		this.pliegosnetos = pliegosnetos;
	}

	public int getPliegosEnDemasia() {
		return pliegosEnDemasia;
	}

	public void setPliegosEnDemasia(int pliegosEnDemasia) {
		this.pliegosEnDemasia = pliegosEnDemasia;
	}

	public int getPliegosXhoja() {
		return pliegosXhoja;
	}

	public void setPliegosXhoja(int pliegosXhoja) {
		this.pliegosXhoja = pliegosXhoja;
	}

	public int getCantHojas() {
		return cantHojas;
	}

	public void setCantHojas(int cantHojas) {
		this.cantHojas = cantHojas;
	}
	
	

}
