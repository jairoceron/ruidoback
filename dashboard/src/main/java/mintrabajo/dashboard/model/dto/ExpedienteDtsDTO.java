package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class ExpedienteDtsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4945573619762721929L;
	private String territorialReparto;
	private int activo;
	private int finalizado;
	
	public ExpedienteDtsDTO() {}

	public String getTerritorialReparto() {
		return territorialReparto;
	}

	public void setTerritorialReparto(String territorialReparto) {
		this.territorialReparto = territorialReparto;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(int finalizado) {
		this.finalizado = finalizado;
	}
	
}
