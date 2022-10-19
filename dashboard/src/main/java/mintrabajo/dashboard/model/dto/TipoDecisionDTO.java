package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class TipoDecisionDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4379557906700149375L;
	private Long ejecutoriadas;
	private Long noEjecutoriadas;
	private Long ejecutoriadasValor;
	private Long noEjecutoriadasValor;
	
	public TipoDecisionDTO() {
		
	}

	public Long getEjecutoriadas() {
		return ejecutoriadas;
	}

	public void setEjecutoriadas(Long ejecutoriadas) {
		this.ejecutoriadas = ejecutoriadas;
	}

	public Long getNoEjecutoriadas() {
		return noEjecutoriadas;
	}

	public void setNoEjecutoriadas(Long noEjecutoriadas) {
		this.noEjecutoriadas = noEjecutoriadas;
	}

	public Long getEjecutoriadasValor() {
		return ejecutoriadasValor;
	}

	public void setEjecutoriadasValor(Long ejecutoriadasValor) {
		this.ejecutoriadasValor = ejecutoriadasValor;
	}

	public Long getNoEjecutoriadasValor() {
		return noEjecutoriadasValor;
	}

	public void setNoEjecutoriadasValor(Long noEjecutoriadasValor) {
		this.noEjecutoriadasValor = noEjecutoriadasValor;
	}
	
}
